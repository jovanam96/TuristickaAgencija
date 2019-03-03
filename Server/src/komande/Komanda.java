/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komande;

import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author Jovana Mitrovic
 */
public interface Komanda {
    public Odgovor izvrsi(Zahtev z) throws Exception;
}
