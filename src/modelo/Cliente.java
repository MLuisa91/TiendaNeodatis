package modelo;

public class Cliente extends Usuario{

    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;

    public Cliente(String dni, String nombre, String apellidos, String direccion) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
                + "]";
    }

    public boolean containsNombre(Cliente cliente) {
        return this.getNombre().contains(cliente.getNombre());
    }
    
    public boolean containsApellidos(Cliente cliente) {
        return this.getApellidos().contains(cliente.getApellidos());
    }
    
    public boolean containsDireccion(Cliente cliente) {
        return this.getDireccion().contains(cliente.getDireccion());
    }
   

}
