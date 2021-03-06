/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.hotel;

import domen.Hotel;
import domen.OpstiDomenskiObjekat;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class UnesiHotelSO extends OpstaSistemskaOperacija {

    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Hotel)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        bbp.sacuvaj((OpstiDomenskiObjekat) obj);
    }
    
}
