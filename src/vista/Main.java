package vista;

import modelo.Administrador;
import modelo.Usuario;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;

public class Main {

    public static void main(String[] args) {

        ODB odb = null;
        try {
            odb = ODBFactory.open("Tienda.db");
            Usuario admin = new Administrador(Boolean.TRUE, "123456", "Maria", "Perez Perez", "Don Benito");

            odb.store(admin);

        } catch (ODBRuntimeException e) {
            e.printStackTrace();
        } finally {
            if (odb != null && !odb.isClosed()) {
                odb.close();
            }
        }

        Login log = new Login();
        log.setVisible(true);

    }

}
