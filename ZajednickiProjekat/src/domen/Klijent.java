/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jovana Mitrovic
 */
public class Klijent implements Serializable, OpstiDomenskiObjekat {
    private int klijentID;
    private String jmbg;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private String brojPasosa;

    public Klijent() {
    }

    public Klijent(int klijentID, String jmbg, String ime, String prezime, String email, String telefon, String brojPasosa) {
        this.klijentID = klijentID;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.brojPasosa = brojPasosa;
    }

    public String getBrojPasosa() {
        return brojPasosa;
    }

    public void setBrojPasosa(String brojPasosa) {
        this.brojPasosa = brojPasosa;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    

    @Override
    public String vratiVrednostiAtributa() {
        return klijentID + ", '" + jmbg + "', " + "'" + ime + "', " + "'" + prezime + "', " + "'" + email + "', " + "'" + telefon + "', " + "'" + brojPasosa + "'";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "jmbg = '" + jmbg + "', " + "ime = '" + ime + "', " + "prezime = '" + prezime + "', " + "email = '" + email + "', " + "telefon = '" + telefon + "', " + "brojpasosa = '" + brojPasosa + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "klijent";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "klijentid="+klijentID;
    }

    @Override
    public String vratiUslovZaVise() {
        String rez = " where";
        if(ime!=null){
            rez += " ime like '"+ime+"%' and";
        }
        if(prezime!=null) {
            rez += " prezime like '"+prezime + "%' and";
        }
        if(rez.equals(" where")) {
            return "";
        }
        return rez.substring(0, rez.length()-4);
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) {
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
            int klijentid = rs.getInt("klijentid");
            String jmbg = rs.getString("jmbg");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String telefon = rs.getString("telefon");
            String email = rs.getString("email");
            String brojPasosa = rs.getString("brojpasosa");
            Klijent k = new Klijent(klijentid, jmbg, ime, prezime, email, telefon, brojPasosa);
            list.add(k);
        }
        return list;
    }

    @Override
    public String vratiSortiranje() {
        return " order by prezime";
    }
    
    
    
}
