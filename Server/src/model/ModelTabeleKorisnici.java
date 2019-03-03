/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Korisnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jovana Mitrovic
 */
public class ModelTabeleKorisnici extends AbstractTableModel {
    
    List<Korisnik> korisnici;
    String[] heder = {"Ime","Prezime","Korisnicko ime"};

    public ModelTabeleKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
    
    

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return heder.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k = korisnici.get(rowIndex);
        switch(columnIndex) {
            case 0: return k.getIme();
            case 1: return k.getPrezime();
            case 2: return k.getLozinka();
            default: return "hgoi";
        }
    }

    @Override
    public String getColumnName(int column) {
        return heder[column];
    }

    public void odjaviKorisnika(Korisnik k) {
        korisnici.remove(k);
        fireTableDataChanged();
    }

    public void dodajKorisnika(Korisnik k) {
        korisnici.add(k);
        fireTableDataChanged();
    }
    
    public List<Korisnik> vratiKorisnike() {
        return korisnici;
    }
    
    
}
