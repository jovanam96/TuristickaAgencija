/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konstante;

import java.io.Serializable;

/**
 *
 * @author Jovana Mitrovic
 */
public interface Operacija{
    public static final int PRIJAVI_SE = 1;
    public static final int UNESI_KLIJENTA = 2;
    public static final int VRATI_GRADOVE = 3;
    public static final int UNESI_HOTEL = 4;
    public static final int VRATI_TIPOVE_SOBA = 5;
    public static final int VRATI_DRZAVE = 6;
    public static final int VRATI_HOTELE = 7;
    public static final int KREIRAJ_PONUDU = 8;
    public static final int PRETRAZI_PONUDE = 9;
    public static final int PRETRAZI_KLIJENTE = 10;
    public static final int KREIRAJ_REZERVACIJU = 11;
    public static final int PRETRAZI_REZERVACIJE = 12;
    public static final int OTKAZI_REZERVACIJU = 13;
    public static final int IZMENI_KLIJENTA = 14;
    public static final int ODJAVI_SE = -1;
}
