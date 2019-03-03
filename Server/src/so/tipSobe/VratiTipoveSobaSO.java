/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipSobe;

import domen.OpstiDomenskiObjekat;
import domen.TipSobe;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class VratiTipoveSobaSO extends OpstaSistemskaOperacija{

    private List<OpstiDomenskiObjekat> list;
    
    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof TipSobe)) {
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
