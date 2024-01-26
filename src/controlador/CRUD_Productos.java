package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.Producto;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class CRUD_Productos implements CRUD<Producto> {

    @Override
    public boolean add(Producto element) {
        ODB odb = ODBFactory.open("Tienda.db");
        odb.store(new Producto(element.getId(), element.getNombre(), element.getPrecio(), element.getStock()));

        odb.close();

        return true;
    }

    @Override
    public List<Producto> search(Producto element) {
        ODB odb = ODBFactory.open("Tienda.db");
        Or where = Where.or();

        if (element.getId() != null && !"".equals(element.getId())) {
            where.add(Where.equal("id", element.getId()));
        }

        if (element.getNombre() != null && !"".equals(element.getNombre())) {
            where.add(Where.like("nombre", element.getNombre()));
        }

        if (element.getPrecio() != null && !"".equals(element.getPrecio())) {
            where.add(Where.equal("precio", element.getPrecio()));
        }

        if (element.getStock() != null && !"".equals(element.getStock())) {
            where.add(Where.equal("stock", element.getStock()));
        }

        CriteriaQuery query = new CriteriaQuery(Producto.class, where);

        Objects<Producto> result = odb.getObjects(query);

        odb.close();

        return new ArrayList<>(result);
    }

    @Override
    public boolean update(Producto element) {
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Producto.class, Where.equal("id", element.getId()));

        Objects<Producto> resultado = odb.getObjects(query);
        if (resultado != null) {
            Producto producto = resultado.getFirst();
            producto.setNombre(element.getNombre());
            producto.setPrecio(element.getPrecio());
            producto.setStock(element.getStock());

            odb.store(producto);
            odb.commit();
            odb.close();
        } else {
            odb.close();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Producto element) {
       
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Producto.class, Where.equal("id", element.getId()));
        Objects<Producto> resultado = odb.getObjects(query);
        if (resultado != null)
            odb.delete(resultado.getFirst());
        
        odb.close();
        return true;
    }

    public List<Producto> getProductos() {
        ODB odb = ODBFactory.open("Tienda.db");
        Objects<Producto> lista = odb.getObjects(Producto.class);
        odb.close();
        return (List<Producto>) lista;
    }

    @Override
    public Iterator<Producto> listAll() {
    return null;
    }

}
