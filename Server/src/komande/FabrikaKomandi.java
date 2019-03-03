/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import java.util.HashMap;
import java.util.Map;
import transfer.Odgovor;
import transfer.Zahtev;
import konstante.Operacija;

/**
 *
 * @author Jovana Mitrovic
 */
public class FabrikaKomandi {
    
    private static FabrikaKomandi instanca;
    Map<Integer, Komanda> mapaKomandi = new HashMap<>();

    private FabrikaKomandi() {
        mapaKomandi.put(Operacija.PRIJAVI_SE, new PrijaviSeKom());
        mapaKomandi.put(Operacija.UNESI_KLIJENTA, new UnesiKlijentaKom());
        mapaKomandi.put(Operacija.VRATI_GRADOVE, new VratiGradoveKom());
        mapaKomandi.put(Operacija.UNESI_HOTEL, new UnesiHotelKom());
        mapaKomandi.put(Operacija.VRATI_TIPOVE_SOBA, new VratiTipoveSobaKom());
        mapaKomandi.put(Operacija.VRATI_DRZAVE, new VratiDrzaveKom());
        mapaKomandi.put(Operacija.VRATI_HOTELE, new VratiHoteleKom());
        mapaKomandi.put(Operacija.KREIRAJ_PONUDU, new KreirajPonuduKom());
        mapaKomandi.put(Operacija.PRETRAZI_PONUDE, new PretraziPonudeKom());
        mapaKomandi.put(Operacija.PRETRAZI_KLIJENTE, new PretraziKlijenteKom());
        mapaKomandi.put(Operacija.KREIRAJ_REZERVACIJU, new KreirajRezervacijuKom());
        mapaKomandi.put(Operacija.PRETRAZI_REZERVACIJE, new PretraziRezervacijeKom());
        mapaKomandi.put(Operacija.OTKAZI_REZERVACIJU, new OtkaziRezervacijuKom());
        mapaKomandi.put(Operacija.IZMENI_KLIJENTA, new IzmeniKlijentaKom());
        mapaKomandi.put(Operacija.ODJAVI_SE, new OdjaviSe());
    }
    
    public static FabrikaKomandi getInstanca() {
        if(instanca == null) {
            instanca = new FabrikaKomandi();
        }
        return instanca;
    }
    
    public Odgovor obradaZahteva(Zahtev z) throws Exception {
        Komanda kom = mapaKomandi.get(z.getOperacija());
        return kom.izvrsi(z);
    }
    
}
