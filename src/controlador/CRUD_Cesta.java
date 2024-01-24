/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.Iterator;
import java.util.List;
import modelo.Cesta;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/**
 *
 * @author MRGOMAAL
 */
public class CRUD_Cesta implements CRUD<Cesta>{
    
    static ODB odb = ODBFactory.open("Tienda.db");

    @Override
    public boolean add(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
        odb.store(element);
        odb.close();
        return true;
    }

    @Override
    public List<Cesta> search(Cesta element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Cesta element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
         odb.delete(element);
         odb.close();
        return true;
    }

    public List<Cesta> getClientes() {
        ODB odb = ODBFactory.open("Tienda.db");
        Objects<Cesta> lista = odb.getObjects(Cesta.class);
        odb.close();
        return (List<Cesta>) lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Cesta> listAll() {
        return this.getClientes().iterator();
    }
 
}
