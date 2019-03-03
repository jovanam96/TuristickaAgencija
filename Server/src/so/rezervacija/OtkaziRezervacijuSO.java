/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class OtkaziRezervacijuSO extends OpstaSistemskaOperacija{

    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Rezervacija)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        bbp.obrisi((OpstiDomenskiObjekat) obj);
    }
    
}
