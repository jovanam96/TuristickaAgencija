/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.StatusOdgovora;

/**
 *
 * @author Jovana Mitrovic
 */
public class VratiDrzaveKom implements Komanda{

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        List<OpstiDomenskiObjekat> list = Kontroler.getInstanca().vratiDrzave();
        odg.setStatus(StatusOdgovora.OK);
        odg.setPodaci(list);
        return odg;
    }
    
}
