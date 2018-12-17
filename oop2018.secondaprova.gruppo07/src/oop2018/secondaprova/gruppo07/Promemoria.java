/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;


import java.time.LocalDateTime;

/**
 *
 * @author gruppo07
 */
public class Promemoria {
    private final String descrizione;
    private final LocalDateTime data;

    public Promemoria(String descrizione, LocalDateTime data) {
        this.descrizione = descrizione;
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return data + "-" + descrizione;
    }

    
 
    
   
}
