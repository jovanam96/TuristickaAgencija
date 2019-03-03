 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import podesavanja.PodesavanjaKonekcije;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author Jovana Mitrovic
 */
public class Komunikacija {

    Socket s;
    private static Komunikacija instanca;

    private Komunikacija() throws IOException {
        String adresa = PodesavanjaKonekcije.getInstanca().getProperty("adresa");
        int port = Integer.parseInt(PodesavanjaKonekcije.getInstanca().getProperty("port"));

        s = new Socket(adresa, port);

    }

    public static Komunikacija getInstanca() throws IOException {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    public void posaljiZahtev(Zahtev z) {
       try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(z);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Odgovor primiOdgovor() {
        Odgovor odg = new Odgovor();
        try {
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            odg = (Odgovor) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return odg;
    }

}
