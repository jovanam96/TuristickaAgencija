/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ponuda;

import domen.OpstiDomenskiObjekat;
import domen.Ponuda;
import domen.StavkaPonude;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class KreirajPonuduSO extends OpstaSistemskaOperacija {

    @Override
    protected void validiraj(Object obj) throws Exception {
        if(!(obj instanceof Ponuda)) {
            throw new Exception("Neodgovarajuci tip parametra");
        }
    }

    @Override
    protected void izvrsi(Object obj) throws Exception {
        int id = bbp.sacuvaj((OpstiDomenskiObjekat) obj);
        Ponuda p = (Ponuda) obj;
        p.setPonudaID(id);
        List<StavkaPonude> stavke = p.getStavke();
        for (StavkaPonude s : stavke) {
            s.setPonuda(p);
            bbp.sacuvaj(s);
        }
    }
    
}
