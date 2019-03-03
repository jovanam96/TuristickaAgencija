/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Mitrovic
 */
public class Rezervacija implements Serializable, OpstiDomenskiObjekat {

    private int brojRezervacije;
    private Klijent klijent;
    private StavkaPonude stavkaPonude;
    private Date datumKreiranja;

    public Rezervacija() {
    }

    public Rezervacija(int brojRezervacije, Klijent klijent, StavkaPonude stavkaPonude, Date datumKreiranja) {
        this.brojRezervacije = brojRezervacije;
        this.klijent = klijent;
        this.stavkaPonude = stavkaPonude;
        this.datumKreiranja = datumKreiranja;
    }

    public StavkaPonude getStavkaPonude() {
        return stavkaPonude;
    }

    public void setStavkaPonude(StavkaPonude stavkaPonude) {
        this.stavkaPonude = stavkaPonude;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public int getBrojRezervacije() {
        return brojRezervacije;
    }

    public void setBrojRezervacije(int brojRezervacije) {
        this.brojRezervacije = brojRezervacije;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return brojRezervacije + ", " + klijent.getKlijentID() + ", " + stavkaPonude.getRB() + ", " + stavkaPonude.getPonuda().getPonudaID() + ", '" + new java.sql.Date(datumKreiranja.getTime()) + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "rezervacija";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "brojrezervacije="+brojRezervacije+" and klijentid="+klijent.getKlijentID()+" and stavkaponudeid="+stavkaPonude.getRB() + " and ponudaid=" + stavkaPonude.getPonuda().getPonudaID();
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> list = new ArrayList<>();
        while(rs.next()) {
            int rezid = rs.getInt("r.brojrezervacije");
            Date datumkreiranja = rs.getDate("r.datumkreiranja");
            int klijentid = rs.getInt("k.klijentid");
            String jmbg = rs.getString("k.jmbg");
            String ime = rs.getString("k.ime");
            String prezime = rs.getString("k.prezime");
            String brojpasosa = rs.getString("k.brojpasosa");
            String telefonKl = rs.getString("k.telefon");
            String emailKl = rs.getString("k.email");
            Klijent k = new Klijent(klijentid, jmbg, ime, prezime, emailKl, telefonKl, brojpasosa);
            int ponudaid = rs.getInt("s.ponudaid");
            Date datumOd = rs.getDate("p.datumod");
            Date datumDo = rs.getDate("p.datumdo");
            int hotelid = rs.getInt("h.hotelid");
            String nazivHotela = rs.getString("h.naziv");
            String adresa = rs.getString("h.adresa");
            String telefon = rs.getString("h.telefon");
            String email = rs.getString("h.email");
            int gradid = rs.getInt("g.gradid");
            String nazivGrada = rs.getString("g.naziv");
            int drzavaid = rs.getInt("d.drzavaid");
            String nazivDrzave = rs.getString("d.naziv");
            Drzava d = new Drzava(drzavaid, nazivDrzave);
            Grad g = new Grad(gradid, nazivGrada, d);
            Hotel h = new Hotel(hotelid, nazivHotela, adresa, telefon, email, g);
            Ponuda p = new Ponuda(ponudaid, datumOd, datumDo, h, g, null);
            int rb = rs.getInt("s.rb");
            BigDecimal cena = rs.getBigDecimal("s.cena");
            int kapacitet = rs.getInt("s.kapacitet");
            int tipsobeid = rs.getInt("s.tipsobeid");
            String nazivTS = rs.getString("t.naziv");
            TipSobe t = new TipSobe(tipsobeid, nazivTS);
            StavkaPonude s = new StavkaPonude(rb, cena, kapacitet, t);
            s.setPonuda(p);
            Rezervacija r = new Rezervacija(rezid, k, s, datumkreiranja);
            list.add(r);
        }
        return list;
    }

    @Override
    public String vratiSpajanje() {
        return " r join stavkaponude s on (r.ponudaid=s.ponudaid and r.stavkaponudeid=s.rb) join klijent k on r.klijentid=k.klijentid join tipsobe t on s.tipsobeid=t.tipsobeid join ponuda p on p.ponudaid=s.ponudaid join hotel h on p.hotelid=h.hotelid join grad g on g.gradid=p.gradid join drzava d on g.drzavaid=d.drzavaid";
    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where";
        if(klijent!=null && klijent.getIme()!=null) {
            rez += " k.ime like '"+klijent.getIme()+"%' and";
        }
        if(klijent!=null && klijent.getPrezime()!=null) {
            rez += " k.prezime like'"+klijent.getPrezime()+"%' and";
        }
        if(stavkaPonude!=null && stavkaPonude.getPonuda().getGrad()!=null) {
            rez += " g.naziv = '" +stavkaPonude.getPonuda().getGrad() + "' and";
        }
        if(rez.equals(" where")) {
            return "";
        }
        return rez.substring(0,rez.length()-4);
        
    }
    
    

}
