/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.grad;

import domen.Grad;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class VratiGradoveSO extends OpstaSistemskaOperacija {
    
    private List<OpstiDomenskiObjekat> list;

    @Override
    protected void validiraj(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        list = bbp.vratiVise((Grad) obj);
    }

    public List<OpstiDomenskiObjekat> getList() {
        return list;
    }
    
    
    
}
