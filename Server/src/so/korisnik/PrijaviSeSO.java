/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class PrijaviSeSO extends OpstaSistemskaOperacija{
    
    private OpstiDomenskiObjekat k;

    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Korisnik)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        k = bbp.vratiJednog((OpstiDomenskiObjekat) obj);
    }

    public OpstiDomenskiObjekat getK() {
        return k;
    }

   

    
    
}
