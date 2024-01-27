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
import modelo.Cliente;
import modelo.Producto;
import modelo.Usuario;
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
public class CRUD_Cesta implements CRUD<Cesta> {
    
    private List<Producto> listaProductos;
    private Usuario cliente;

    public CRUD_Cesta() {
    }

    public CRUD_Cesta(List<Producto> listaProductos, Cliente cliente) {
        this.listaProductos = new ArrayList();
        this.cliente = cliente;
    }

    @Override
    public boolean add(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
        odb.store(new Cesta(element.getId(), element.getNombre(), element.getCliente(), element.getProductos(), element.getTotal()));
        odb.close();
        return true;
    }

    @Override
    public List<Cesta> search(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
        Or where = Where.or();

        if (element.getId() != null && !"".equals(element.getId())) {
            where.add(Where.equal("id", element.getId()));
        }

        if (element.getNombre() != null && !"".equals(element.getNombre())) {
            where.add(Where.like("nombre", element.getNombre()));
        }

        if (element.getTotal() != null && !"".equals(element.getTotal())) {
            where.add(Where.equal("total", element.getTotal()));
        }

        CriteriaQuery query = new CriteriaQuery(Cesta.class, where);

        Objects<Cesta> result = odb.getObjects(query);

        odb.close();

        return new ArrayList<>(result);

    }

    @Override
    public boolean update(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Cesta.class, Where.equal("id", element.getId()));

        Objects<Cesta> resultado = odb.getObjects(query);
        if (resultado != null) {
            Cesta cesta = resultado.getFirst();

            cesta.setNombre(element.getNombre());
            cesta.setProductos(element.getProductos());

            odb.store(cesta);
            odb.commit();
            odb.close();
        } else {
            odb.close();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Cesta element) {
        ODB odb = ODBFactory.open("Tienda.db");
         CriteriaQuery query = new CriteriaQuery(Cesta.class, Where.equal("id", element.getId()));
        Objects<Cesta> resultado = odb.getObjects(query);
        if (resultado != null)
            odb.delete(resultado.getFirst());
        odb.close();
        return true;
    }

    public List<Cesta> getCestas(Usuario usuario) {
        
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Cesta.class, Where.equal("cliente.dni", usuario.getDni()));
        Objects<Cesta> lista = odb.getObjects(query);
        odb.close();
        return (List<Cesta>) lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Cesta> listAll() {
        return null;
    }
    
    public Cesta searchById(Cesta cesta){
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Cesta.class, Where.equal("id", cesta.getId()));
        
        Objects<Cesta> resultado = odb.getObjects(query);
        odb.close();
        
        if(resultado.isEmpty())
            return null;
        
        return resultado.getFirst();
    }

}
