package componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;

public class TablaClientes extends AbstractTableModel {

    private List<Cliente> lista;
    private String nombreColumnas[] = {"Nombre", "Apellidos", "Direccion", "DNI"};

    public TablaClientes(List<Cliente> lista) {
        this.lista = lista;
    }

    public TablaClientes() {
        this.lista = new ArrayList<Cliente>();
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
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
                return lista.get(rowIndex).getApellidos();
            case 2:
                return lista.get(rowIndex).getDireccion();
            case 3: 
                return lista.get(rowIndex).getDni();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public Cliente remove (int index){
        try{
            return lista.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);
        }
    }
    
    public boolean add(Cliente u){
        try{
            return lista.add(u);
        }finally{
            this.fireTableRowsInserted(this.lista.size(), this.lista.size() + 1);
        }
    }

}
