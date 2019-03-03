/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.Ponuda;
import domen.Rezervacija;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.StatusOdgovora;
import transfer.Zahtev;

/**
 *
 * @author Jovana Mitrovic
 */
public class OtkaziRezervacijuKom implements Komanda {

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Rezervacija r = (Rezervacija) z.getPodaci();
        Kontroler.getInstanca().otkaziRezervaciju(r);
        odg.setStatus(StatusOdgovora.OK);
        return odg;
    }

}
