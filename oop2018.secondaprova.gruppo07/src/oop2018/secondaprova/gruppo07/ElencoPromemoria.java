/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;

import java.io.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

/**
 * Struttura dati per la gestione di promemoria. La struttura previene elementi
 * duplicati e si basa sull'ordine naturale dei promemoria, ovvero quello
 * cronologico in base alla data.
 *
 * @author gruppo07
 */
public class ElencoPromemoria implements Serializable, Iterable<Promemoria> {

    private TreeMap<LocalDateTime, Promemoria> elenco;

    /**
     * Costruttore che inizializza la classe a una struttura inizialmente vuota.
     */
    public ElencoPromemoria() {
        this.elenco = new TreeMap<>();
    }

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
     * @throws DescrizioneNonValidaException se la descrizione è una stringa
     * vuota
     */
    public synchronized void inserisciPromemoria(String descrizione, int giorno, int mese, int anno, int ora, int minuti) throws PromemoriaPresenteException, DataNonValidaException, DescrizioneNonValidaException {

        try {
            LocalDateTime data = LocalDateTime.of(anno, mese, giorno, ora, minuti);
            if (data.isBefore(LocalDateTime.now())) {
                throw new DataNonValidaException();
            }
            Promemoria p = new Promemoria(descrizione, data);
            if (elenco.putIfAbsent(data, p) != null) {
                throw new PromemoriaPresenteException();
            }
        } catch (DateTimeException x) {
            throw new DataNonValidaException();
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
        if (!elenco.remove(p.getData(), p)) {
            throw new PromemoriaNonEsistenteException();
        }
        this.notifyAll();
    }

    /**
     * Iteratore sulla collezione di promemoria
     *
     * @return un iteratore di promemoria
     */
    @Override
    public Iterator<Promemoria> iterator() {
        return elenco.values().iterator();
    }

    /**
     * Metodo thread safe per la rimozione di tutti gli elementi della
     * struttura.
     *
     */
    public synchronized void svuotaElenco() {

        elenco.entrySet().removeAll(elenco.entrySet());
        this.notifyAll();
    }

    /**
     * Metodo per la ricerca di un promemoria in base alla data/ora
     *
     * @param data data/ora di cui cercare il promemoria
     * @return il promemoria trovato o null se non c'è nessun promemoria
     * corrispondente
     */
    public synchronized Promemoria ricercaPromemoria(LocalDateTime data) {
        return elenco.get(data.withSecond(0).withNano(0));
    }

    /**
     * Metodo thread-safe per controllare se la struttura dati è vuota
     *
     * @return Restituisce true se la struttura dati è vuota, false altrimenti
     */
    public synchronized boolean isEmpty() {
        return elenco.isEmpty();
    }

    /**
     * Metodo thread safe che rimuove tutti i promemoria con data precedente
     * alla data attuale.Ideata per pulire un elenco dopo un caricamento da
     * file.
     *
     * @return il numero di elementi rimossi
     */
    public synchronized int rimuoviPromemoriaScaduti() {
        int initialCount = elenco.size();
        elenco.entrySet().removeAll(
                Arrays.asList(
                        elenco.entrySet().stream().
                                filter(x -> x.getKey().isBefore(LocalDateTime.now())).
                                toArray()));
        return initialCount - elenco.size();

    }

    /**
     * stringa formattata per la stampa della struttura
     *
     * @return stringa di rappresentazione della struttura
     */
    @Override
    public String toString() {
        String returnString = "";
        for (Promemoria x : this) {
            returnString += x.toString() + "\n";
        }
        return returnString;
    }

}
