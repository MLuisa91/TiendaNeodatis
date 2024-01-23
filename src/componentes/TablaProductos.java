package componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Producto;

public class TablaProductos extends AbstractTableModel {

    private List<Producto> lista;
    private String nombreColumnas[] = {"Id", "Nombre", "Precio", "Stock"};

    public TablaProductos(List<Producto> lista) {
        this.lista = lista;
    }

    public TablaProductos() {
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getId();
            case 1:
                return lista.get(rowIndex).getNombre();
            case 2:
                return lista.get(rowIndex).getPrecio();
            case 3: 
                return lista.get(rowIndex).getStock();
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
