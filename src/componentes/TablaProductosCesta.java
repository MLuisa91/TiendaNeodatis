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
import modelo.Producto;

public class TablaProductosCesta extends AbstractTableModel {

    private List<Producto> lista;
    private String nombreColumnas[] = {"Nombre", "Precio", "Cantidad"};

    public TablaProductosCesta(List<Producto> lista) {
        this.lista = lista;
    }

    public TablaProductosCesta() {
        this.lista = new ArrayList<Producto>();
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
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

    //Falta concretar la cantidad
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getNombre();
            case 1:
                return lista.get(rowIndex).getPrecio();
            case 2:
                return lista.get(rowIndex).getPrecio();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public Producto remove (int index){
        try{
            return lista.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);
        }
    }
    
    public boolean add(Producto u){
        try{
            return lista.add(u);
        }finally{
            this.fireTableRowsInserted(this.lista.size(), this.lista.size() + 1);
        }
    }
}
