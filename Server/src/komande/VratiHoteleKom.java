/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.Grad;
import domen.Hotel;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.StatusOdgovora;
import transfer.Zahtev;

/**
 *
 * @author Jovana Mitrovic
 */
public class VratiHoteleKom implements Komanda{

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Hotel h = (Hotel) z.getPodaci();
        List<OpstiDomenskiObjekat> list = Kontroler.getInstanca().vratiHotele(h);
        odg.setStatus(StatusOdgovora.OK);
        odg.setPodaci(list);
        return odg;
    }
    
}
