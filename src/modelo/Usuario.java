package modelo;

public class Usuario {

    private Boolean administrador;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;

    public Usuario(Boolean administrador, String dni, String nombre, String apellidos, String direccion) {
        this.administrador = administrador;
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

    public Boolean getAdministrador() {
        return administrador == null ? false : administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }


}
