/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.baza.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import podesavanja.PodesavanjaBaze;

/**
 *
 * @author Jovana Mitrovic
 */
public class KonekcijaNaBazu {
    private final Connection konekcija;
    private static KonekcijaNaBazu instanca;

    private KonekcijaNaBazu() throws SQLException {
        String url = PodesavanjaBaze.getInstance().getProperty("url");
        String dbuser = PodesavanjaBaze.getInstance().getProperty("user");
        String dbpassword = PodesavanjaBaze.getInstance().getProperty("password");
        konekcija = DriverManager.getConnection(url, dbuser, dbpassword);
        konekcija.setAutoCommit(false);
    }

    public static KonekcijaNaBazu getInstanca() throws SQLException {
        if (instanca == null) {
            instanca = new KonekcijaNaBazu();
        }
        return instanca;
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public void pokreniTransakciju() throws SQLException {
        konekcija.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        konekcija.commit();
    }

    public void rollback() throws SQLException {
        konekcija.rollback();
    }
}
