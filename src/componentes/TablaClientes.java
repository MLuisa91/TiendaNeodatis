package componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;
import modelo.Usuario;

public class TablaClientes extends AbstractTableModel {

    private List<Usuario> lista;
    private String nombreColumnas[] = {"Nombre", "Apellidos", "Direccion", "DNI"};

    public TablaClientes(List<Usuario> lista) {
        this.lista = lista;
    }

    public TablaClientes() {
        this.lista = new ArrayList<Usuario>();
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
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
    
    public Usuario remove (int index){
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
