/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class PretraziRezervacijeSO extends OpstaSistemskaOperacija{

    List<OpstiDomenskiObjekat> list;
    
    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Rezervacija)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        list = bbp.vratiVise((OpstiDomenskiObjekat) obj);
    }

    public List<OpstiDomenskiObjekat> getList() {
        return list;
    }
    
}
