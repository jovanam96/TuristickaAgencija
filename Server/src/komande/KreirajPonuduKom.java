/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.Hotel;
import domen.Ponuda;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.StatusOdgovora;
import transfer.Zahtev;

/**
 *
 * @author Jovana Mitrovic
 */
public class KreirajPonuduKom implements Komanda {

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Ponuda p = (Ponuda) z.getPodaci();
        Kontroler.getInstanca().kreirajPonudu(p);
        odg.setStatus(StatusOdgovora.OK);
        return odg;
    }
    
}
