/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ponuda;

import domen.OpstiDomenskiObjekat;
import domen.Ponuda;
import domen.StavkaPonude;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class PretraziPonudeSO extends OpstaSistemskaOperacija{
    
    private List<OpstiDomenskiObjekat> list;

    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Ponuda)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        list = bbp.vratiVise((OpstiDomenskiObjekat) obj);
        for (OpstiDomenskiObjekat odo : list) {
            Ponuda p = (Ponuda) odo;
          //  int id = p.getPonudaID();
            StavkaPonude s = new StavkaPonude();
            s.setPonuda(p);
            List<OpstiDomenskiObjekat> list1 = bbp.vratiVise(s);
            List<StavkaPonude> stavke = new ArrayList<>();
            for (OpstiDomenskiObjekat o : list1) {
                s = (StavkaPonude) o;
                stavke.add(s);
            }
            p.setStavke(stavke);
        }
    }

    public List<OpstiDomenskiObjekat> getList() {
        return list;
    }
    
    
    
}
