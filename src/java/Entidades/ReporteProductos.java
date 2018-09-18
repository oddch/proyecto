/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Asus
 */
public class ReporteProductos {

    int id;
    String nombre;
    String tipoProducto;
    int precio;
    int cantidad;

    public ReporteProductos() {
    }

    public ReporteProductos(int id, String nombre, String tipoProducto, int precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ReporteProductos{" + "id=" + id + ", nombre=" + nombre + ", tipoProducto=" + tipoProducto + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

}
