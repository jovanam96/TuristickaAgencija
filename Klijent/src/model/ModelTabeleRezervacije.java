/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Rezervacija;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Jovana Mitrovic
 */
public class ModelTabeleRezervacije extends AbstractTableModel{
    
    List<Rezervacija> rezervacije;
    String heder[] = {"Br. rez", "Klijent" , "Destinacija" , "Datum od", "Datum do", "Hotel", "Tip sobe" , "Cena"};

    public ModelTabeleRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    
    @Override
    public int getRowCount() {
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
        return heder.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija r = rezervacije.get(rowIndex);
        switch(columnIndex) {
            case 0: return r.getBrojRezervacije();
            case 1: return r.getKlijent();
            case 2: return r.getStavkaPonude().getPonuda().getGrad() + ", " + r.getStavkaPonude().getPonuda().getGrad().getDrzava();
            case 3: return r.getStavkaPonude().getPonuda().getDatumOd();
            case 4: return r.getStavkaPonude().getPonuda().getDatumDo();
            case 5: return r.getStavkaPonude().getPonuda().getHotel();
            case 6: return r.getStavkaPonude().getTipSobe();
            case 7: return r.getStavkaPonude().getCena();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return heder[column];
    }

    public Rezervacija obrisiRezervaciju(int red) {
        Rezervacija r = rezervacije.remove(red);
        fireTableDataChanged();
        return r;
    }

    public Rezervacija vratiRezervaciju(int red) {
        return rezervacije.get(red);
    }
    
    
}
