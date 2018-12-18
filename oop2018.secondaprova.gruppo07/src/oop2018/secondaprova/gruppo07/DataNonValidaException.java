/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;

/**
 * Descrizione per segnalare l'inserimento di una data non valida:
 * date non autorizzate (es 30 Feb.)
 * date precedenti alla data di inserimento del promemeoria
 * @author gruppo07
 */
public class DataNonValidaException extends Exception {

    public DataNonValidaException() {
    }
    
}
