/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.secondaprova.gruppo07;

import java.io.*;

/**
 * La classe implementa due metodi che permettono il salvataggio su un file ed
 * il caricamenta da un file di un elendo di promemoria
 *
 * @author gruppo07
 */
public class Salvataggio {

    /**
     * Il metodo prova a salvare un elenco di promemoria su un file in modo
     * sincronizzato.
     *
     * @param nomeFile è il nome del file su cui si vuole salvare il mio elenco
     * di promemoria
     * @param e è l'elenco di promemoria che si vuole salvare sul file
     * @return restituisce vero se il salvataggio va a buon fine, falso
     * altrimenti
     */
    public static boolean salvaSuFile(String nomeFile, ElencoPromemoria e) {
        synchronized (e) {
            try (ObjectOutputStream i = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomeFile)))) {
                i.writeObject(e);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    /**
     * Il metodo permette il caricamento di un elenco promemoria da un file
     * passato come parametro
     *
     * @param nomeFile è il nome del file da cui effettuare il caricamento
     * @param elenco è l'elenco promemoria in cui caricare
     * @return restituisce true se il caricamento va a buon fine, false
     * altrimenti
     */
    public static boolean caricaDaFile(String nomeFile, ElencoPromemoria elenco) {
        try (ObjectInputStream i = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomeFile)))) {
            elenco = (ElencoPromemoria) i.readObject();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
