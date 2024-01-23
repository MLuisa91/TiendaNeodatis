/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Set;

class Cesta {

    private int cantidad;
    private Cliente cliente;
    private Set<Producto> cesta;
    private float total;

    public Cesta(int cantidad, Cliente cliente, Set<Producto> cesta, float total) {
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.cesta = cesta;
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Producto> getCesta() {
        return cesta;
    }

    public void setCesta(Set<Producto> cesta) {
        this.cesta = cesta;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cesta{" + "cantidad=" + cantidad + ", cliente=" + cliente + ", cesta=" + cesta + ", total=" + total + '}';
    }
    
}
