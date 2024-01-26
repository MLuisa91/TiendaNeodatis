/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Cesta;
import modelo.Producto;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author MRGOMAAL
 */
public class CRUD_Cesta implements CRUD<Cesta>{
    
    static ODB odb = ODBFactory.open("Tienda.db");
    private List<Producto> listaProductos;

    public CRUD_Cesta() {
    }

    public CRUD_Cesta(List<Producto> listaProductos) {
        this.listaProductos = new ArrayList();
    }
    
    @Override
    public boolean add(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
        odb.store(element);
        odb.close();
        return true;
    }
    
    /*public boolean addProduct(Cesta element){
        listaProductos.add(element.);
        
        ODB odb = ODBFactory.open("Tienda.db");
        odb.store(element.)
    }*/

    @Override
    public List<Cesta> search(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
        ICriterion criterio = new Or().add(Where.equal("nombre", element.getNombre())).add(Where.equal("id", element.getId()));

        CriteriaQuery query = new CriteriaQuery(Cesta.class, criterio);

        Objects<Cesta> result = odb.getObjects(query);

        odb.close();

        return new ArrayList<>(result);
    
    }

    @Override
    public boolean update(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Cesta.class, Where.equal("id", element.getId()));

       Cesta resultado = (Cesta) odb.getObjects(query).getFirst();

        if (resultado != null) {

            resultado.setNombre(element.getNombre());
            resultado.setCesta(element.getCesta());
            
            odb.store(resultado);
        } else {
            System.out.println("Cesta no encontrado en la base de datos.");
        }

        odb.close();
        return true;    }

    @Override
    public boolean delete(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
         odb.delete(element);
         odb.close();
        return true;
    }

    public List<Cesta> getCestas() {
        ODB odb = ODBFactory.open("Tienda.db");
        Objects<Cesta> lista = odb.getObjects(Cesta.class);
        odb.close();
        return (List<Cesta>) lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Cesta> listAll() {
        return this.getCestas().iterator();
    }
 
}
