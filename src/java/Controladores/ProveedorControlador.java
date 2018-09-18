/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Producto;
import Entidades.Proveedor;
import Facades.ProductoFacade;
import Facades.ProveedorFacade;
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
@Named(value = "proveedorControlador")
@SessionScoped
public class ProveedorControlador implements Serializable {

    /**
     * Creates a new instance of Proveedor
     */
    public ProveedorControlador() {
    }

    @PostConstruct
    public void init() {
        proveedor = new Proveedor();
        producto = new Producto();
    }
    @EJB
    ProveedorFacade proveedorFacade;
    private Proveedor proveedor;

    @EJB
    ProductoFacade productoFacade;
    private Producto producto;

    public void clearObj() {
        proveedor = new Proveedor();
        producto = new Producto();

    }

    public void create() {
        proveedor.setProductoIdproducto(producto);
        proveedorFacade.create(proveedor);
        clearObj();
    }

    public void remove(Proveedor objProveedor) {
        try {
            proveedor = objProveedor;
            productoFacade.remove(producto);
            clearObj();

        } catch (Exception e) {
        }
    }

    public List<Proveedor> listarProveedor() {
        return proveedorFacade.findAll();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
