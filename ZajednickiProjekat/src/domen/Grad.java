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
public class Grad implements Serializable, OpstiDomenskiObjekat {

    private int gradID;
    private String naziv;
    private Drzava drzava;

    public Grad() {
    }

    public Grad(int gradID, String naziv, Drzava drzava) {
        this.gradID = gradID;
        this.naziv = naziv;
        this.drzava = drzava;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    public int getGradID() {
        return gradID;
    }

    public void setGradID(int gradID) {
        this.gradID = gradID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        return "grad g";
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
        if(drzava == null) {
            return "";
        }
        return " where g.drzavaid="+drzava.getDrzavaID();
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
        try {
            while (rs.next()) {
                int gradID = rs.getInt("g.gradid");
                String naziv = rs.getString("g.naziv");
                int drzavaid = rs.getInt("d.drzavaid");
                String drzavaNaziv = rs.getString("d.naziv");
                Drzava d = new Drzava(drzavaid, drzavaNaziv);
                Grad g = new Grad(gradID, naziv, d);
                list.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Grad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public String vratiSpajanje() {
        return " join drzava d on g.drzavaid=d.drzavaid";
    }

    @Override
    public String vratiSortiranje() {
        return " order by g.naziv";
    }
    
    
    
    

}
