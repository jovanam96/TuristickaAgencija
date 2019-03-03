/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jovana Mitrovic
 */
public class Ponuda implements Serializable,OpstiDomenskiObjekat {
    private int ponudaID;
    private Date datumOd;
    private Date datumDo;
    private Hotel hotel;
    private Grad grad;
    private List<StavkaPonude> stavke;

    public Ponuda() {
        stavke = new ArrayList<>();
    }

    public Ponuda(int ponudaID, Date datumOd, Date datumDo, Hotel hotel, Grad grad, List<StavkaPonude> stavke) {
        this.ponudaID = ponudaID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.hotel = hotel;
        this.grad = grad;
        this.stavke = stavke;
    }

    public List<StavkaPonude> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaPonude> stavke) {
        this.stavke = stavke;
    }

    public int getPonudaID() {
        return ponudaID;
    }

    public void setPonudaID(int ponudaID) {
        this.ponudaID = ponudaID;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return ponudaID + ", " + "'" + new java.sql.Date(datumOd.getTime()) + "', " + "'" + new java.sql.Date(datumDo.getTime()) + "', " + hotel.getHotelID() + ", " + grad.getGradID();
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "ponuda";
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            int id = rs.getInt("p.ponudaid");
            Date datOd = rs.getDate("p.datumOd");
            Date datDo = rs.getDate("p.datumDo");
            
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
            Ponuda p = new Ponuda(id, datOd, datDo, h, g, null);
            list.add(p);
        }
        return list;
    }

    @Override
    public String vratiSpajanje() {
        return " p join grad g on p.gradid=g.gradid join hotel h on p.hotelid=h.hotelid join drzava d on d.drzavaid=g.drzavaid";
    }

    @Override
    public String vratiSortiranje() {
        return " order by g.naziv,p.datumod";
    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where p.datumod>='"+new java.sql.Date(datumOd.getTime()) + "' and p.datumdo<='" + new java.sql.Date(datumDo.getTime()) + "'";
        if(grad!=null) {
            rez += " and g.naziv='"+grad.getNaziv()+"'";
        }
        return rez;
    }
    
    
}
