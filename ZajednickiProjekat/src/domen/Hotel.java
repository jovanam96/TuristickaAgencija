/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovana Mitrovic
 */
public class Hotel implements Serializable, OpstiDomenskiObjekat {
    private int hotelID;
    private String naziv;
    private String adresa;
    private String telefon;
    private String email;
    private Grad grad;

    public Hotel() {
    }

    public Hotel(int hotelID, String naziv, String adresa, String telefon, String email, Grad grad) {
        this.hotelID = hotelID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.grad = grad;
    }
    
    

    @Override
    public String toString() {
        return naziv;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return hotelID + ",'" + naziv + "', " + "'" + adresa + "', " + "'" + telefon + "', " + "'" + email + "', " + grad.getGradID();
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "hotel ";
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
        return " where h.gradid="+grad.getGradID();
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
        try {
            while (rs.next()) {
                int hotelid = rs.getInt("h.hotelid");
                String naziv = rs.getString("h.naziv");
                String adresa = rs.getString("h.adresa");
                String telefon = rs.getString("h.telefon");
                String email = rs.getString("h.email");
                int gradid = rs.getInt("g.gradid");
                String nazivGrada = rs.getString("g.naziv");
                int drzavaid = rs.getInt("d.drzavaid");
                String nazivDrzave = rs.getString("d.naziv");
                Drzava d = new Drzava(drzavaid, nazivDrzave);
                Grad g = new Grad(gradid, nazivGrada, d);
                Hotel h = new Hotel(hotelid, naziv, adresa, telefon, email, g);
                list.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Grad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public String vratiSpajanje() {
        return " h join grad g on h.gradid=g.gradid join drzava d on g.drzavaid=d.drzavaid";
    }

    @Override
    public String vratiSortiranje() {
        return " order by h.naziv";
    }

    
    
}