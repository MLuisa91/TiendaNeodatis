package modelo;

public class Cliente extends Usuario{

    public Cliente(Boolean administrador, String dni, String nombre, String apellidos, String direccion) {
        super(false, dni, nombre, apellidos, direccion);
    }

}
