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
public class StavkaPonude implements Serializable,OpstiDomenskiObjekat{
    private int RB;
    private BigDecimal cena;
    private int kapacitet;
    private TipSobe tipSobe;
    private Ponuda ponuda;

    public StavkaPonude() {
    }

    public StavkaPonude(int RB, BigDecimal cena, int kapacitet, TipSobe tipSobe) {
        this.RB = RB;
        this.cena = cena;
        this.kapacitet = kapacitet;
        this.tipSobe = tipSobe;
    }

    public TipSobe getTipSobe() {
        return tipSobe;
    }

    public void setTipSobe(TipSobe tipSobe) {
        this.tipSobe = tipSobe;
    }

    public int getRB() {
        return RB;
    }

    public void setRB(int RB) {
        this.RB = RB;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Ponuda getPonuda() {
        return ponuda;
    }

    public void setPonuda(Ponuda ponuda) {
        this.ponuda = ponuda;
    }
    
    @Override
    public String vratiVrednostiAtributa() {
        return ponuda.getPonudaID() + ", " + RB + ", " + cena + ", " + kapacitet + ", " + tipSobe.getTipSobeID();
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "kapacitet="+kapacitet;
    }

    @Override
    public String vratiImeKlase() {
        return "stavkaponude";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "ponudaid="+ponuda.getPonudaID() + " and rb="+RB;
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
            list.add(s);
        }
        return list;
    }

    @Override
    public String vratiUslovZaVise() {
        return " where s.ponudaid="+ponuda.getPonudaID();
    }

    @Override
    public String vratiSpajanje() {
        return " s join tipsobe t on s.tipsobeid=t.tipsobeid join ponuda p on p.ponudaid=s.ponudaid join hotel h on p.hotelid=h.hotelid join grad g on g.gradid=p.gradid join drzava d on g.drzavaid=d.drzavaid";
    }

    
    
}
