/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.OpstiDomenskiObjekat;
import domen.Ponuda;
import java.util.List;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.StatusOdgovora;
import transfer.Zahtev;

/**
 *
 * @author Jovana Mitrovic
 */
public class PretraziPonudeKom implements Komanda{

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Ponuda p = (Ponuda) z.getPodaci();
        List<OpstiDomenskiObjekat> list = Kontroler.getInstanca().pretraziPonude(p);
        odg.setStatus(StatusOdgovora.OK);
        odg.setPodaci(list);
        return odg;
    }
    
}
