/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Ponuda;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jovana Mitrovic
 */
public class ModelTabelePonude extends AbstractTableModel{
    
    List<Ponuda> ponude;
    String[] heder = {"Datum od", "Datum do", "Grad", "Hotel"};

    public ModelTabelePonude(List<Ponuda> ponude) {
        this.ponude = ponude;
    }
    

    @Override
    public int getRowCount() {
        return ponude.size();
    }

    @Override
    public int getColumnCount() {
        return heder.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ponuda p = ponude.get(rowIndex);
        SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex) {
            case 0: return sf.format(p.getDatumOd());
            case 1: return sf.format(p.getDatumDo());
            case 2: return p.getGrad();
            case 3: return p.getHotel();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return heder[column];
    }

    public Ponuda vratiPonudu(int red) {
        return ponude.get(red);
    }

    public List<Ponuda> vratiPonude() {
        return ponude;
    }
    
    
    
}
