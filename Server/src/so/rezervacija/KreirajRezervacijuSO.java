/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import domen.StavkaPonude;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class KreirajRezervacijuSO extends OpstaSistemskaOperacija {

    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Rezervacija)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        bbp.sacuvaj((OpstiDomenskiObjekat) obj);
        Rezervacija r = (Rezervacija) obj;
        StavkaPonude sp = r.getStavkaPonude();
        bbp.izmeni(sp);
    }
    
}
