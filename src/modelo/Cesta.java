/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cesta {

    private Integer id;
    private String nombre;
    private Cliente cliente;
    private List<Producto> cesta;
    private Float total;

    public Cesta(Integer id, String nombre, Cliente cliente, List<Producto> cesta, Float total) {
        this.id = id;
        this.nombre = nombre;
        this.cliente = cliente;
        this.cesta = new ArrayList();
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getCesta() {
        return cesta;
    }

    public void setCesta(List<Producto> cesta) {
        this.cesta = cesta;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    

}
