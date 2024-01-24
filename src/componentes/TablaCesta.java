/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cesta;

public class TablaCesta extends AbstractTableModel {
    
    private List<Cesta> lista;
    private String nombreColumnas[] = {"Nombre", "Total"};

    public TablaCesta(List<Cesta> lista) {
        this.lista = lista;
    }

    public TablaCesta() {
        this.lista = new ArrayList<Cesta>();
    }

    public List<Cesta> getLista() {
        return lista;
    }

    public void setLista(List<Cesta> lista) {
        this.lista = lista;
    }

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public void setNombreColumnas(String[] nombreColumnas) {
        this.nombreColumnas = nombreColumnas;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getNombre();
            case 1:
                return lista.get(rowIndex).getTotal();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public Cesta remove (int index){
        try{
            return lista.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);
        }
    }
    
    public boolean add(Cesta u){
        try{
            return lista.add(u);
        }finally{
            this.fireTableRowsInserted(this.lista.size(), this.lista.size() + 1);
        }
    }
    
}
