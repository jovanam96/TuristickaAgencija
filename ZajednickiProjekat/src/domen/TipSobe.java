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
public class TipSobe implements Serializable, OpstiDomenskiObjekat {
    private int tipSobeID;
    private String naziv;

    public TipSobe() {
    }

    public TipSobe(int tipSobeID, String naziv) {
        this.tipSobeID = tipSobeID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTipSobeID() {
        return tipSobeID;
    }

    public void setTipSobeID(int tipSobeID) {
        this.tipSobeID = tipSobeID;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "tipsobe";
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
            int tipsobeid = rs.getInt("tipsobeid");
            String naziv = rs.getString("naziv");
            TipSobe ts = new TipSobe(tipsobeid, naziv);
            list.add(ts);
        }
        return list;
    }

}
