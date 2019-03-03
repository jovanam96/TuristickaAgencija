/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Klijent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jovana Mitrovic
 */
public class ModelTabeleKlijenti extends AbstractTableModel{
    
    List<Klijent> klijenti;
    String heder[] = {"JMBG","Ime","Prezime","E-mail","Telefon","Broj pasosa"};

    public ModelTabeleKlijenti(List<Klijent> klijenti) {
        this.klijenti = klijenti;
    }
    

    @Override
    public int getRowCount() {
        return klijenti.size();
    }

    @Override
    public int getColumnCount() {
        return heder.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k = klijenti.get(rowIndex);
        switch(columnIndex) {
            case 0: return k.getJmbg();
            case 1: return k.getIme();
            case 2: return k.getPrezime();
            case 3: return k.getEmail();
            case 4: return k.getTelefon();
            case 5: return k.getBrojPasosa();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return heder[column];
    }

    public Klijent vratiKlijenta(int red) {
        return klijenti.get(red);
    }
    
    
    
}
