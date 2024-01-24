/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cesta {

    private int id;
    private String nombre;
    private Cliente cliente;
    private List<Producto> cesta;
    private float total;

    public Cesta(int id, String nombre, Cliente cliente, List<Producto> cesta, float total) {
        this.id = id;
        this.nombre = nombre;
        this.cliente = cliente;
        this.cesta = new ArrayList();
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getCesta() {
        return cesta;
    }

    public float getTotal() {
        float total = 0;

        for (Producto producto : cesta) {
            total += producto.getPrecio();
        }
        return total;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCesta(List<Producto> cesta) {
        this.cesta = cesta;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    

 

}
