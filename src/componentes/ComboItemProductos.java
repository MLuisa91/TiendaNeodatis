package componentes;

import modelo.Producto;

public class ComboItemProductos {
    
    private String clave;
    private String valor;
    private Producto producto;

    public ComboItemProductos(Producto producto) {
        this.clave = producto.getId();
        this.valor = producto.getNombre().concat(" (").concat(String.valueOf(producto.getPrecio())).concat("€)");
        this.producto = producto;
    }

    public String getClave() {
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
