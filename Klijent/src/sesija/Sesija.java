/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jovana Mitrovic
 */
public class Sesija {
    private static Sesija instanca;
    private Korisnik korisnik;
    private final Map<String, OpstiDomenskiObjekat> mapa;

    private Sesija() {
        mapa = new HashMap<>();
    }
    
    public static Sesija getInstanca() {
        if(instanca == null) {
            instanca = new Sesija();
        }
        return instanca;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Map<String, OpstiDomenskiObjekat> getMapa() {
        return mapa;
    }
    
    
    
}
