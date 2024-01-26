package componentes;

import modelo.Producto;

public class ComboItemProductos {
    
    private Integer clave;
    private String valor;
    private Producto producto;

    public ComboItemProductos(Integer clave, String valor, Producto producto) {
        this.clave = clave;
        this.valor = valor;
        this.producto = producto;
    }

    public Integer getClave() {
        return clave;
    }

    public String getValor() {
        return valor;
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return valor;
    }

}
