/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * La classe crea oggetti di tipo Promemoria attraverso il costruttore, 
 * ogni Promemoria è formato da una piccola descrizone di una riga al massimo e da una data e ora di creazione
 * la quale serve a distinguerlo da altri promemoria, infatti, tutti i metodi di comparazione e di hashing
 * sono basati proprio su di essa.
 * @author gruppo07
 */
public class Promemoria implements Comparable<Promemoria>, Serializable {
    private final String descrizione;
    private final LocalDateTime data;
/**
 * Metodo costruttore di un promrmoria
 * @param descrizione Rappresenta la descrizione del nostro promemoria
 * @param data Rappresenta la data nella quale il nostro promemoria è stato creato
 * @throws DescrizioneNonValidaException, DateTimeException.
 */
    public Promemoria(String descrizione, LocalDateTime data) throws DescrizioneNonValidaException  {
        if(descrizione.equals(""))
        {
            throw new DescrizioneNonValidaException();
        }
        else
        { 
            this.descrizione = descrizione;
 
        }
        this.data = data;
    }
/**
 * 
 * @return Restituisce la descrizione del promemoria 
 */
    public String getDescrizione() {
        return descrizione;
    }
/**
 * 
 * @return Restituisce la data e l'ora di creazione del promemoria 
 */
    public LocalDateTime getData() {
        return data;
    }
/**
 * Il metodo toString che ci permette di stampare un promemoria
 * formattata come suggerito dalla traccia, ovvero:
 *   gg/mm/aaaa hh:mm – testo descrittivo
 * @return Restituisce una stringa formattata come suggerisce dalla traccia
 */
    @Override
    public String toString() {
        return data.getDayOfMonth()+ "/" + data.getMonth() + "/"+ data.getYear() + " " + data.getHour() + ":" + data.getMinute() + " - " + descrizione;
    }
/**
 * Sovrascrizione della compareTo fatta in modo da comparare due promemoria
 * sulla loro data di creazione, sfruttando la compareTo della classe LocalDateTime
 * @param o E' l'oggetto di tipo promemoria con cui comparare la data di creazione dell'entità promemoria in cui ci troviamo
 * @return Restituisce il valore del comparatore di LocalDateTime, negativo se inferiore, positivo se maggiore
 */
    @Override
    public int compareTo(Promemoria o) {
       return this.data.compareTo(o.data);
    }
/**
 * Il metodo fa un hashing dell'entità promemoria basto sulla data dello stesso
 * @return Restituisce il valore di hash dell'entità promemoria in cui ci troviamo
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.data);
        return hash;
    }
/**
 * Il metodo implementa il criterio di uguaglianza tra due entità di tipo promemoria basato sulla data degli stessi
 * @param obj è il promemoria con cui mettiamo a confronto l'entità di tipo promemoria in cui ci troviamo
 * @return Restituisce vero se i due promemoria sono uguali, falso altrimenti.
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Promemoria other = (Promemoria) obj;
        return Objects.equals(this.data, other.data);
    }


    
 
    
   
}
