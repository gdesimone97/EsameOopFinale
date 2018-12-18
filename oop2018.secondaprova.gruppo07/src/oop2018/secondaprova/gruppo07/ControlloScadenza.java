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
 * La classe è un thread che si occupa di controllare se i promemoria sono scaduti
 * @author gruppo07
 */
public class ControlloScadenza extends Thread {

    private ElencoPromemoria ep;
    private int secondi;
    private JFrame frame;
/**
 * Crea un thread ControllaScadenza
 * @param ep Elenco su cui effettuare il controllo
 * @param secondi Intervallo di tempo tra due controlli consecutivi
 * @param frame Frame rispetto al quale far comparire il messaggio di notifica
 */
    public ControlloScadenza(ElencoPromemoria ep, int secondi, JFrame frame) {
        this.ep = ep;
        this.secondi = secondi;
        this.frame = frame;
    }

    /**
     * Il thread esegue una sleep di un tempo pari a quello passatto come parametro al costruttore in secondi<br>
     * Controlla se sono scaduti promemoria ed eventualemente li elimina facendo comparire una finestra informativa
     */
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(secondi * 1000);
            } catch (InterruptedException ex) {
            }
            Promemoria p = ep.ricercaPromemoria(LocalDateTime.now());
            if (p != null) {
                EventQueue.invokeLater(() -> JOptionPane.showMessageDialog(frame, p.toString()+"\nPromemoria cancellato"));
                try {
                    ep.rimuoviPromemoria(p);
                } catch (PromemoriaNonEsistenteException ex) {
                }
            }
        }
    }
}
