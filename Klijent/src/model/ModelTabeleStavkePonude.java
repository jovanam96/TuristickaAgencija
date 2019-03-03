/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.StavkaPonude;
import domen.TipSobe;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jovana Mitrovic
 */
public class ModelTabeleStavkePonude extends AbstractTableModel {

    List<StavkaPonude> stavke;
    String[] heder = {"RB","Tip sobe", "Cena", "Kapacitet"};

    public ModelTabeleStavkePonude(List<StavkaPonude> stavke) {
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return heder.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPonude s = stavke.get(rowIndex);
        switch(columnIndex) {
            case 0: return s.getRB();
            case 1: return s.getTipSobe();
            case 2: return s.getCena();
            case 3: return s.getKapacitet();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return heder[column];
    }

//    
//    
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        switch(columnIndex) {
//            case 0: return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        StavkaPonude s = stavke.get(rowIndex);
//        switch(columnIndex) {
//            case 1: s.setTipSobe((TipSobe) aValue); break;
//            case 2: s.setCena(new BigDecimal((String) aValue)); break;
//            case 3: s.setKapacitet(Integer.parseInt((String) aValue)); break;
//        }
//    }
    
    
    public void dodajStavku(StavkaPonude s) {
        stavke.add(s);
        dodeliRB();
        fireTableDataChanged();
    }
    
    public void obrisiStavku(int red) {
        stavke.remove(red);
        dodeliRB();
        fireTableDataChanged();
    }
    
    private void dodeliRB() {
        int rb = 1;
        for (StavkaPonude s : stavke) {
            s.setRB(rb);
            rb++;
        }
    }

    public List<StavkaPonude> vratiStavke() {
        return stavke;
    }

    public StavkaPonude vratiStavkuPonude(int red) {
        return stavke.get(red);
    }
    
    
    
}
