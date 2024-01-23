package modelo;

public class Usuario {


    private Boolean administrador;

    public Usuario() {
        super();
    }

    public Boolean getAdministrador() {
        return administrador == null ? false : administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }


}
