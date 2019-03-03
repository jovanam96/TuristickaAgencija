/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.klijent;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class UnesiKlijentaSO extends OpstaSistemskaOperacija {

    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Klijent)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        bbp.sacuvaj((OpstiDomenskiObjekat) obj);
    }
    
}
