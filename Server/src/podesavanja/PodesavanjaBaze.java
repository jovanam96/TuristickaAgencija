/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podesavanja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovana Mitrovic
 */
public class PodesavanjaBaze {

    private static PodesavanjaBaze instanca;
    private Properties props;

    private PodesavanjaBaze() {
        try {
            props = new Properties();
            props.load(new FileInputStream("podesavanja_baze.properties"));
        } catch (Exception ex) {
            Logger.getLogger(PodesavanjaBaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PodesavanjaBaze getInstance() {
        if (instanca == null) {
            instanca = new PodesavanjaBaze();
        }
        return instanca;
    }

    public String getProperty(String key) {
        return props.getProperty(key, "n/a");
    }
    
        public void setUrl(String url) {
        try {
            props.setProperty("url", url);
            props.store(new FileOutputStream(new File("podesavanja_baze.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PodesavanjaBaze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PodesavanjaBaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setUsername(String user){
        try {
            props.setProperty("user", user);
            props.store(new FileOutputStream(new File("podesavanja_baze.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PodesavanjaBaze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PodesavanjaBaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setPassword(String password) {
        try {
            props.setProperty("password", password);
            props.store(new FileOutputStream(new File("podesavanja_baze.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PodesavanjaBaze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PodesavanjaBaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
