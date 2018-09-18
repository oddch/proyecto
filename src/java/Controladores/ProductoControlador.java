/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Producto;
import Facades.ProductoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Asus
 */

@Named(value = "productoControlador")
@SessionScoped
public class ProductoControlador implements Serializable {

    /**
     * Creates a new instance of ProductoControlador
     */
    public ProductoControlador() {
    }

    @PostConstruct
    public void init() {
        producto = new Producto();
    }
    @EJB
    ProductoFacade productoFacade;
    private Producto producto;

    
    public void clearObjc(){
        producto = new Producto();
    }
    
    public void create(){
        productoFacade.create(producto);
        clearObjc();
    }
    
    
    public void remove(Producto ObjProducto){
        producto = ObjProducto;
        productoFacade.remove(producto);
        clearObjc();
    }
    public List<Producto> listarProducto(){
        return  productoFacade.findAll();
    }

    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
