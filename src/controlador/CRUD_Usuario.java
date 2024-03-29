package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Usuario;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class CRUD_Usuario implements CRUD<Usuario> {

    @Override
    //Método para añadir un Usuario a la base de datos
    public boolean add(Usuario element) {
        ODB odb = ODBFactory.open("Tienda.db");
        odb.store(new Usuario(element.getAdministrador(), element.getDni(), element.getNombre(), element.getApellidos(), element.getDireccion()));

        odb.close();

        return true;
    }

    @Override
    //Método que busca un usuario por uno o varios campos
    public List<Usuario> search(Usuario element) {
        ODB odb = ODBFactory.open("Tienda.db");
        Or where = Where.or();

        if (element.getNombre() != null && !"".equals(element.getNombre())) {
            where.add(Where.like("nombre", element.getNombre()));
        }

        if (element.getApellidos() != null && !"".equals(element.getApellidos())) {
            where.add(Where.like("apellidos", element.getApellidos()));
        }

        if (element.getDireccion() != null && !"".equals(element.getDireccion())) {
            where.add(Where.like("direccion", element.getDireccion()));
        }

        if (element.getDni() != null && !"".equals(element.getDni())) {
            where.add(Where.equal("dni", element.getDni()));
        }

        CriteriaQuery query = new CriteriaQuery(Usuario.class, where);

        Objects<Usuario> result = odb.getObjects(query);

        odb.close();

        return new ArrayList<>(result);
    }

    @Override
    //Método que actualiza uno o varios campos de un usuario
    public boolean update(Usuario element) {
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Usuario.class, Where.equal("dni", element.getDni()));
        Objects<Usuario> resultado = odb.getObjects(query);
        if (resultado != null) {
            Usuario usuario = resultado.getFirst();
            usuario.setNombre(element.getNombre());
            usuario.setApellidos(element.getApellidos());
            usuario.setDireccion(element.getDireccion());

            odb.store(usuario);
            odb.commit();
            odb.close();
        } else {
            odb.close();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Usuario element) {
        /* tenemos dados de alta en base de datos Usuarios, que serán o clientes o Administradores
         Para borrar este cliente, primero tendremos que buscarlo como usuario y borrar el usuario no el cliente
         */
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Usuario.class, Where.equal("dni", element.getDni()));
        Objects<Usuario> resultado = odb.getObjects(query);
        if (resultado != null)
            odb.delete(resultado.getFirst());
        
        odb.close();
        return true;
    }

    //Método que devuelve una lista solamente con los Usuarios de tipo Cliente
    public List<Usuario> getClientes() {
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Usuario.class, Where.equal("administrador", false));
        Objects<Usuario> lista = odb.getObjects(query);
        odb.close();
        return (List<Usuario>) lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Usuario> listAll() {
        return null;
    }

    //Método que busca un usuario por su id, en este caso el id es el dni
    public Usuario searchByDni(Usuario u) {
        ODB odb = ODBFactory.open("Tienda.db");
        CriteriaQuery query = new CriteriaQuery(Usuario.class, Where.equal("dni", u.getDni()));
        Objects<Usuario> usuarios = odb.getObjects(query);
        odb.close();
        if (!usuarios.isEmpty()) {
            Usuario user = usuarios.getFirst();
            return user.getAdministrador() == true ? new Administrador(user.getAdministrador(), user.getDni(), user.getNombre(), user.getApellidos(), user.getDireccion())
                    : new Cliente(user.getAdministrador(), user.getDni(), user.getNombre(), user.getApellidos(), user.getDireccion());
        }

        return null;
    }

}
