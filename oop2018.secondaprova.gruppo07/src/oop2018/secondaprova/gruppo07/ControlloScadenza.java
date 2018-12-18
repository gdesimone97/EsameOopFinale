/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;

import java.awt.EventQueue;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gruppo07
 */
public class ControlloScadenza extends Thread {

    private ElencoPromemoria ep;
    private int secondi;
    private JFrame frame;

    public ControlloScadenza(ElencoPromemoria ep, int secondi, JFrame frame) {
        this.ep = ep;
        this.secondi = secondi;
        this.frame = frame;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(secondi * 1000);
            } catch (InterruptedException ex) {
            }
            Promemoria p = ep.ricercaPromemoria(LocalDateTime.now());
            if (p != null) {
                EventQueue.invokeLater(() -> JOptionPane.showMessageDialog(frame, p.toString()));
                try {
                    ep.rimuoviPromemoria(p);
                } catch (PromemoriaNonEsistenteException ex) {
                }
            } else {
                System.out.println("Nessun promemoria trovato");
            }
        }
    }

}