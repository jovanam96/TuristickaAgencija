/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import domen.Klijent;
import kontroler.Kontroler;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.StatusOdgovora;

/**
 *
 * @author Jovana Mitrovic
 */
public class UnesiKlijentaKom implements Komanda{

    @Override
    public Odgovor izvrsi(Zahtev z) throws Exception {
        Odgovor odg = new Odgovor();
        Klijent k = (Klijent) z.getPodaci();
        Kontroler.getInstanca().unesiKlijenta(k);
        odg.setStatus(StatusOdgovora.OK);
        return odg;
    }
    
}
