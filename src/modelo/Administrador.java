package modelo;

public class Administrador extends Usuario {

    public Administrador(Boolean administrador, String dni, String nombre, String apellidos, String direccion) {
        super(true, dni, nombre, apellidos, direccion);
    }

}
