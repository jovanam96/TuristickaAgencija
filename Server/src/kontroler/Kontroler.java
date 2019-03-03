/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Drzava;
import domen.Grad;
import domen.Hotel;
import domen.Klijent;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Ponuda;
import domen.Rezervacija;
import domen.TipSobe;
import forme.FrmServer;
import java.util.List;
import so.OpstaSistemskaOperacija;
import so.drzava.VratiDrzaveSO;
import so.hotel.UnesiHotelSO;
import so.grad.VratiGradoveSO;
import so.hotel.VratiHoteleSO;
import so.klijent.IzmeniKlijentaSO;
import so.klijent.PretraziKlijenteSO;
import so.klijent.UnesiKlijentaSO;
import so.korisnik.PrijaviSeSO;
import so.ponuda.KreirajPonuduSO;
import so.ponuda.PretraziPonudeSO;
import so.rezervacija.KreirajRezervacijuSO;
import so.rezervacija.OtkaziRezervacijuSO;
import so.rezervacija.PretraziRezervacijeSO;
import so.tipSobe.VratiTipoveSobaSO;

/**
 *
 * @author Jovana Mitrovic
 */
public class Kontroler {

    private static Kontroler instanca;
    private FrmServer forma;

    public Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public FrmServer getForma() {
        return forma;
    }

    public void setForma(FrmServer forma) {
        this.forma = forma;
    }
    
//    public void odjaviKorisnika(KlijentNit k) {
//        prijavljeniKorisnici.remove(k);
//        Odgovor odg = new Odgovor();
//        odg.setStatus(StatusOdgovora.KRAJ_RADA);
//        odg.setGreska("Odjavljeni ste sa sistema!");
//        k.posaljiOdgovor(odg);
//        k.setKraj(true);
//    }

    public OpstiDomenskiObjekat prijaviSe(Korisnik k) throws Exception {
    
        List<Korisnik> korisnici = forma.vratiKorisnike();
        for (Korisnik korisnik : korisnici) {
            if(korisnik.getKorisnickoIme().equals(k.getKorisnickoIme()) && korisnik.getLozinka().equals(k.getLozinka())) {
                throw new Exception("Korisnik sa ovim nalogom je vec ulogovan!");
            }
        }
        OpstaSistemskaOperacija so = new PrijaviSeSO();
        so.izvrsenjeSO(k);
        return ((PrijaviSeSO) so).getK();
    }

    public void unesiKlijenta(Klijent k) throws Exception {
        OpstaSistemskaOperacija so = new UnesiKlijentaSO();
        so.izvrsenjeSO(k);
    }

    
    public List<OpstiDomenskiObjekat> vratiGradove(Grad g) throws Exception {
        OpstaSistemskaOperacija so = new VratiGradoveSO();
        so.izvrsenjeSO(g);
        return ((VratiGradoveSO) so).getList();
    }

    public void unesiHotel(Hotel h) throws Exception {
        OpstaSistemskaOperacija so = new UnesiHotelSO();
        so.izvrsenjeSO(h);
    }

    public List<OpstiDomenskiObjekat> vratiTipoveSoba() throws Exception {
        OpstaSistemskaOperacija so = new VratiTipoveSobaSO();
        so.izvrsenjeSO(new TipSobe());
        return ((VratiTipoveSobaSO) so).getList();
    }

    public List<OpstiDomenskiObjekat> vratiDrzave() throws Exception {
        OpstaSistemskaOperacija so = new VratiDrzaveSO();
        so.izvrsenjeSO(new Drzava());
        return ((VratiDrzaveSO) so).getList();
    }

    public List<OpstiDomenskiObjekat> vratiHotele(Hotel h) throws Exception {
        OpstaSistemskaOperacija so = new VratiHoteleSO();
        so.izvrsenjeSO(h);
        return ((VratiHoteleSO) so).getList();
    }

    public void kreirajPonudu(Ponuda p) throws Exception {
        OpstaSistemskaOperacija so = new KreirajPonuduSO();
        so.izvrsenjeSO(p);
    }

    public List<OpstiDomenskiObjekat> pretraziPonude(Ponuda p) throws Exception {
        OpstaSistemskaOperacija so = new PretraziPonudeSO();
        so.izvrsenjeSO(p);
        return ((PretraziPonudeSO) so).getList();
    }

    public List<OpstiDomenskiObjekat> pretraziKlijente(Klijent k) throws Exception {
        OpstaSistemskaOperacija so = new PretraziKlijenteSO();
        so.izvrsenjeSO(k);
        return ((PretraziKlijenteSO) so).getList();
    }

    public void kreirajRezervaciju(Rezervacija r) throws Exception {
        OpstaSistemskaOperacija so = new KreirajRezervacijuSO();
        so.izvrsenjeSO(r);
    }

    public List<OpstiDomenskiObjekat> pretraziRezervacije(Rezervacija r) throws Exception {
        OpstaSistemskaOperacija so = new PretraziRezervacijeSO();
        so.izvrsenjeSO(r);
        return ((PretraziRezervacijeSO) so).getList();
    }

    public void otkaziRezervaciju(Rezervacija r) throws Exception {
        OpstaSistemskaOperacija so = new OtkaziRezervacijuSO();
        so.izvrsenjeSO(r);
    }

    public void izmeniKlijenta(Klijent k) throws Exception {
        OpstaSistemskaOperacija so = new IzmeniKlijentaSO();
        so.izvrsenjeSO(k);
    }

    public void odjaviKorisnika(Korisnik k) {
        forma.odjaviKorisnika(k);
    }



}
