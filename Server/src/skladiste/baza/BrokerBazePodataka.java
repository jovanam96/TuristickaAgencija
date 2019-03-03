/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.baza;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladiste.IBrokerBazePodataka;
import skladiste.baza.konekcija.KonekcijaNaBazu;

/**
 *
 * @author Jovana Mitrovic
 */
public class BrokerBazePodataka implements IBrokerBazePodataka {

    @Override
    public OpstiDomenskiObjekat vratiJednog(OpstiDomenskiObjekat obj) throws Exception {
        try {
            Connection konekcija = KonekcijaNaBazu.getInstanca().getKonekcija();
            String upit = "select * from " + obj.vratiImeKlase() + " where " + obj.vratiUslovZaJednog();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            OpstiDomenskiObjekat o = (Korisnik) obj.napuni(rs);
            rs.close();
            s.close();
            return o;
        } catch (SQLException ex) {
            //  Logger.getLogger(BrokerBazePodataka.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiVise(OpstiDomenskiObjekat obj) throws Exception{
        List<OpstiDomenskiObjekat> list = new ArrayList<>();
        try {
            Connection konekcija = KonekcijaNaBazu.getInstanca().getKonekcija();
            String upit = "select * from " + obj.vratiImeKlase() + obj.vratiSpajanje() + obj.vratiUslovZaVise() + obj.vratiSortiranje();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            list = (List<OpstiDomenskiObjekat>) obj.vratiListu(rs);
            rs.close();
            s.close();
            return list; 
        } catch (SQLException ex) {
            throw ex;
        }
    }
    

    @Override
    public int sacuvaj(OpstiDomenskiObjekat obj) throws Exception {
        try {
            Connection konekcija = KonekcijaNaBazu.getInstanca().getKonekcija();
            String upit = "insert into " + obj.vratiImeKlase() + " values (" + obj.vratiVrednostiAtributa() + ")";
            System.out.println(upit);
            PreparedStatement ps = konekcija.prepareStatement(upit,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            int id = 0;
            if(rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePodataka.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno cuvanje!");
        }
    }


    @Override
    public void izmeni(OpstiDomenskiObjekat obj) throws Exception {
        try {
            Connection konekcija = KonekcijaNaBazu.getInstanca().getKonekcija();
            String upit = "update " + obj.vratiImeKlase() + " set " + obj.postaviVrednostiAtributa() + " where " + obj.vratiUslovZaJednog();
            System.out.println(upit);
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Neuspesna izmena!");
        }
    }

    @Override
    public void obrisi(OpstiDomenskiObjekat obj) throws Exception{
        try {
            Connection konekcija = KonekcijaNaBazu.getInstanca().getKonekcija();
            String upit = "delete from " + obj.vratiImeKlase() + " where " + obj.vratiUslovZaJednog();
            System.out.println(upit);
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno brisanje!");
        }
    }
    
}
