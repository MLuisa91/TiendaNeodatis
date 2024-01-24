package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.Producto;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class CRUD_Productos implements CRUD<Producto> {

    @Override
    public boolean add(Producto element) {
        ODB odb = ODBFactory.open("Tienda.db");
        odb.store(element);

        odb.close();

        return true;
    }

    @Override
    public List<Producto> search(Producto element) {
        ODB odb = ODBFactory.open("Tienda.db");
        ICriterion criterio = new Or().add(Where.equal("nombre", element.getNombre())).add(Where.equal("id", element.getId()))
                .add(Where.like("precio", String.valueOf(element.getPrecio()))).add(Where.like("stock", String.valueOf(element.getStock())));

        CriteriaQuery query = new CriteriaQuery(Producto.class, criterio);

        Objects<Producto> result = odb.getObjects(query);

        odb.close();

        return new ArrayList<>(result);
    }

    @Override
    public boolean update(Producto element) {
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Producto.class, Where.equal("id", element.getId()));

        Objects<Producto> resultados = odb.getObjects(query);

        if (resultados.hasNext()) {
            Producto productoExistente = resultados.next();

            productoExistente.setNombre(element.getNombre());
            productoExistente.setPrecio(element.getPrecio());
            productoExistente.setStock(element.getStock());

            odb.store(productoExistente);
        } else {
            System.out.println("Producto no encontrado en la base de datos.");
        }

        odb.close();
        return true;
    }

    @Override
    public boolean delete(Producto element) {
        ODB odb = ODBFactory.open("Tienda.db");
        odb.delete(element);
        odb.close();
        return true;
    }

    public List<Producto> getUsuarios() {
        ODB odb = ODBFactory.open("Tienda.db");
        Objects<Producto> lista = odb.getObjects(Producto.class);
        odb.close();
        return (List<Producto>) lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Producto> listAll() {
        return this.getUsuarios().iterator();
    }

}
