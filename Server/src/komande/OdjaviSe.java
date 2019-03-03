/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.Korisnik;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.StatusOdgovora;
import transfer.Zahtev;

/**
 *
 * @author Jovana Mitrovic
 */
public class OdjaviSe implements Komanda{

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Korisnik k = (Korisnik) z.getPodaci();
        Kontroler.getInstanca().odjaviKorisnika(k);
        odg.setStatus(StatusOdgovora.OK);
        return odg;
    }
    
}
