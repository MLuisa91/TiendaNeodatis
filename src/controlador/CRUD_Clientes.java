package controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import modelo.Cliente;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class CRUD_Clientes implements CRUD<Cliente> {

    static ODB odb = ODBFactory.open("Tienda.db");

    @Override
    public boolean add(Cliente element) {

        odb.store(element);

        return true;
    }

    @Override
    public List<Cliente> search(Cliente element) {
        ICriterion criterio = new Or().add(Where.equal("nombre", element.getNombre())).add(Where.equal("apellidos", element.getApellidos()))
                .add(Where.like("direccion", element.getDireccion())).add(Where.like("dni", element.getDni()));
        

        CriteriaQuery query = new CriteriaQuery(Cliente.class, criterio);

         Objects<Cliente> result = odb.getObjects(query);

         odb.close();

        return new ArrayList<>(result);
    }

    @Override
    public boolean update(Cliente element) {
        CriteriaQuery query = new CriteriaQuery(Cliente.class, Where.equal("dni", element.getDni()));

        Objects<Cliente> resultados = odb.getObjects(query);

        if (resultados.hasNext()) {
            Cliente clienteExistente = resultados.next();

            clienteExistente.setNombre(element.getNombre());
            clienteExistente.setApellidos(element.getApellidos());
            clienteExistente.setDireccion(element.getDireccion());

            odb.store(clienteExistente);
        } else {
            System.out.println("Cliente no encontrado en la base de datos.");
        }

        odb.close();
        return true;
    }

    @Override
    public boolean delete(Cliente element) {
        odb.delete(element);
        return true;
    }

    public List<Cliente> getClientes() {
        Objects<Cliente> lista = odb.getObjects(Cliente.class);
        return (List<Cliente>) lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Cliente> listAll() {
        return this.getClientes().iterator();
    }

}
