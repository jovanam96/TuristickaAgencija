/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.Hotel;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.StatusOdgovora;

/**
 *
 * @author Jovana Mitrovic
 */
public class UnesiHotelKom implements Komanda {

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Hotel h = (Hotel) z.getPodaci();
        Kontroler.getInstanca().unesiHotel(h);
        odg.setStatus(StatusOdgovora.OK);
        return odg;
    }
    
}
