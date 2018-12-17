/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;

import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Struttura dati per la gestione di promemoria. La struttura previene elementi
 * duplicati e si basa sull'ordine naturale dei promemoria, ovvero quello
 * cronologico in base alla data.
 *
 * @author gruppo07
 */
public class ElencoPromemoria extends TreeSet<Promemoria> {

    /**
     * Inserimento controllato di un promemoria nella struttura.Il metodo riceve
     * le informazioni sulla data (giorno, mese, anno, ora, minuti) e sulla
     * descrizione e inserisce un nuovo promemoria se non è già presente uno con
     * la stessa data.Il metodo è thread safe sulla struttura
     *
     * @param descrizione testo del promemoria
     * @param giorno giorno della data del promemoria
     * @param mese mese della data del promemoria
     * @param anno anno della data del promemoria
     * @param ora ora ( 0- 23 ) del promemoria
     * @param minuti minuti ( 0-59 ) del promemoria
     * @throws PromemoriaPresenteException se esiste già un promemoria con
     * quella data
     * @throws DataNonValidaException se la data passata non è valida
     * @throws DescrizineNonValidaException se la descrizione è una stringa
     * vuota
     */
    public synchronized void inserisciPromemoria(String descrizione, int giorno, int mese, int anno, int ora, int minuti) throws PromemoriaPresenteException, DataNonValidaException, DescrizineNonValidaException {
        Promemoria p;
        try {
            LocalDateTime data = LocalDateTime.of(anno, mese, giorno, ora, minuti);
            if (data.isBefore(LocalDateTime.now())) {
                throw new DataNonValidaException();
            }
            p = new Promemoria(descrizione, data);
        } catch (DateTimeException x) {
            throw new DataNonValidaException();
        }

        if (!this.add(p)) {
            throw new PromemoriaPresenteException();
        }
        this.notifyAll();
    }

    /**
     * Rimozione controllata di un promemoria dalla struttura dati, controllando
     * l'esistenza del promemoria da rimuovere. Il metodo è thread safe
     *
     * @param p promemoria da rimuovere
     * @throws PromemoriaNonEsistenteException se il promemoria non è presente
     * nella struttura dati
     */
    public synchronized void rimuoviPromemoria(Promemoria p) throws PromemoriaNonEsistenteException {
        if (!this.remove(p)) {
            throw new PromemoriaNonEsistenteException();
        }
        this.notifyAll();
    }
}
