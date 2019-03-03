 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Korisnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komande.FabrikaKomandi;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.StatusOdgovora;

/**
 *
 * @author Jovana Mitrovic
 */
public class KlijentNit extends Thread {

    private Socket socket;
    private boolean kraj = false;
    private Korisnik korisnik;

    public KlijentNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!kraj) {
            Zahtev z = primiZahtev();
            Odgovor odg = new Odgovor();
            try {
                odg = FabrikaKomandi.getInstanca().obradaZahteva(z);
            } catch (Exception ex) {
                odg.setStatus(StatusOdgovora.GRESKA);
                odg.setGreska(ex);
                //Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
            }
            posaljiOdgovor(odg);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public Zahtev primiZahtev() {
        Zahtev z = new Zahtev();
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            z = (Zahtev) in.readObject();
        } catch (IOException ex) {
           // Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return z;
    }

    public void posaljiOdgovor(Odgovor odg) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(odg);
        } catch (IOException ex) {
          //  Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

}
