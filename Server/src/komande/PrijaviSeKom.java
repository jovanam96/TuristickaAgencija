/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.Korisnik;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.StatusOdgovora;

/**
 *
 * @author Jovana Mitrovic
 */
public class PrijaviSeKom implements Komanda {

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Korisnik k = (Korisnik) z.getPodaci();
        Korisnik korisnik = (Korisnik) Kontroler.getInstanca().prijaviSe(k);
        odg.setStatus(StatusOdgovora.OK);
        odg.setPodaci(korisnik);
        Kontroler.getInstanca().getForma().dodajKorisnika(k);
        return odg;
    }

}
