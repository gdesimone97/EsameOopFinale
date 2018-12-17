/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;

import java.time.*;
import java.util.*;

/**
 * Struttura dati per la gestione di promemoria.
 * La struttura previene 
 * @author gruppo07
 */
public class ElencoPromemoria extends TreeSet<Promemoria> {

    public synchronized void inserisciPromemoria(String descrizione, int giorno, int mese, int anno, int ora, int minuti) throws PromemoriaPresenteException, DateTimeException {
        Promemoria p = new Promemoria(descrizione, LocalDateTime.of(anno, mese, giorno, ora, minuti));
        if(!this.add(p))
            throw new PromemoriaPresenteException();
        this.notifyAll();
    }

    public synchronized void rimuoviPromemoria(Promemoria p) throws PromemoriaNonEsistenteException {
        if (!this.remove(p)) 
            throw new PromemoriaNonEsistenteException();
        this.notifyAll();
    }
}
