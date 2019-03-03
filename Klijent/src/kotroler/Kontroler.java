/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotroler;

import domen.Drzava;
import domen.Grad;
import domen.Hotel;
import domen.Klijent;
import domen.Korisnik;
import domen.Ponuda;
import domen.Rezervacija;
import domen.TipSobe;
import java.util.Calendar;
import java.util.List;
import komunikacija.Komunikacija;
import transfer.Odgovor;
import transfer.Zahtev;
import konstante.Operacija;
import sesija.Sesija;
import transfer.StatusOdgovora;

/**
 *
 * @author Jovana Mitrovic
 */
public class Kontroler {

    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Korisnik ulogujSe(String korisnickoIme, String lozinka) throws Exception {
        Korisnik k = new Korisnik();
        k.setKorisnickoIme(korisnickoIme);
        k.setLozinka(lozinka);
        Zahtev z = new Zahtev(Operacija.PRIJAVI_SE, k);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (Korisnik) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public void unesiKlijenta(Klijent k) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_KLIJENTA, k);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public List<Grad> vratiGradove() throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_GRADOVE, new Grad());
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<Grad>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public void unesiHotel(Hotel hotel) throws Exception {
        Zahtev z = new Zahtev(Operacija.UNESI_HOTEL, hotel);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public List<TipSobe> vratiTipoveSoba() throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_TIPOVE_SOBA, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<TipSobe>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public List<Drzava> vratiDrzave() throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_DRZAVE, null);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<Drzava>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public List<Grad> vratiGradoveZaDrzavu(Grad g) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_GRADOVE, g);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<Grad>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;

    }

    public List<Hotel> vratiHoteleZaGrad(Hotel h) throws Exception {
        Zahtev z = new Zahtev(Operacija.VRATI_HOTELE, h);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<Hotel>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public void kreirajPonudu(Ponuda p) throws Exception {
        Zahtev z = new Zahtev(Operacija.KREIRAJ_PONUDU, p);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public List<Ponuda> pretraziPonude(Ponuda p) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_PONUDE, p);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<Ponuda>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public List<Klijent> pretraziKlijente(Klijent k) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_KLIJENTE, k);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<Klijent>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public void kreirajRezervaciju(Rezervacija r) throws Exception {
        Zahtev z = new Zahtev(Operacija.KREIRAJ_REZERVACIJU, r);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public List<Rezervacija> pretraziRezervacije(Rezervacija rezervacija) throws Exception {
        Zahtev z = new Zahtev(Operacija.PRETRAZI_REZERVACIJE, rezervacija);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return (List<Rezervacija>) odg.getPodaci();
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public void otkaziRezervaciju(Rezervacija r) throws Exception {
        Zahtev z = new Zahtev(Operacija.OTKAZI_REZERVACIJU, r);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public void izmeniKlijenta(Klijent k) throws Exception {
        Zahtev z = new Zahtev(Operacija.IZMENI_KLIJENTA, k);
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if (odg.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) odg.getGreska();
        throw ex;
    }

    public void odjaviSe() throws Exception {
        Zahtev z = new Zahtev();
        z.setOperacija(Operacija.ODJAVI_SE);
        z.setPodaci(Sesija.getInstanca().getKorisnik());
        Komunikacija.getInstanca().posaljiZahtev(z);
        Odgovor odg = Komunikacija.getInstanca().primiOdgovor();
        if(odg.getStatus() == StatusOdgovora.OK) {
            return;
        }
        Exception ex = (Exception) odg.getGreska(); 
        throw ex; 
        
        
    }
    
    

}
