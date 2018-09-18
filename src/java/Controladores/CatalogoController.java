/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Factura;
import Entidades.FacturaHasProducto;
import Entidades.Pedido;
import Entidades.Producto;
import Facades.FacturaFacade;
import Facades.FacturaHasProductoFacade;
import Facades.PedidoFacade;
import Facades.ProductoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.Part;

/**
 *
 * @author familia yepes
 */
@Named(value = "catalogoControlador")
@SessionScoped
public class CatalogoController implements Serializable {

    @EJB
    private FacturaHasProductoFacade facturaHasProductoFacade;
    @EJB
    private PedidoFacade pedidoFacade;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private FacturaFacade facturaFacade;
    Producto producto = new Producto();
    Factura factura = new Factura();
    Part imagen;
    List<Producto> carrito = new ArrayList<>();
    FacturaHasProducto facturaHasProducto = new FacturaHasProducto();
    int total;

    /**
     * Creates a new instance of CatalogoController
     */
    public CatalogoController() {
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    public Part getImagen() {
        return imagen;
    }

    public void setImagen(Part imagen) {
        this.imagen = imagen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void registrar() {

        try {
            FileUploadController filep = new FileUploadController();

            producto.setImagen(filep.uploadFile(imagen));

        } catch (Exception e) {
            producto.setImagen("defecto.jpg");

        }
        producto.setCantidad(1);
        productoFacade.create(producto);

    }

    public List<Producto> listarProducto() {

        return productoFacade.findAll();
    }

    public int calcularS(int cantidad, int precio) {
        return cantidad * precio;
    }

    public int calcularT() {
        int total = 0;
        for (Producto pt : carrito) {
            total += pt.getCantidad() * pt.getPrecio();
        }
        this.total = total;
        return total;
    }

    public void actualizar() {
        try {
            FileUploadController filep = new FileUploadController();

            producto.setImagen(filep.uploadFile(imagen));

        } catch (Exception e) {

        }
        productoFacade.edit(producto);

    }

    public void eliminar() {

        productoFacade.remove(producto);
    }

    public void sumar() {
        if (producto.getCantidad() < 99) {
            int cantidad = producto.getCantidad();
            cantidad++;
            producto.setCantidad(cantidad);
        }
    }

    public void restar() {
        if (producto.getCantidad() > 1) {
            int cantidad = producto.getCantidad();
            cantidad--;
            producto.setCantidad(cantidad);
        }

    }

    public void agregar() {
        if (producto.getCantidad() > 0 && producto.getCantidad() < 99 && producto.getCantidad() != null) {
            carrito.add(producto);
            System.out.println(producto);
        }

    }

    public void quitarLista(Producto p) {
        carrito.remove(p);
        System.out.println(producto);
    }

    public void registrarFactura() {
        factura.setFecha(new Date());
        factura.setTotalFactura(total);
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        factura.setClienteId(usuarioControlador.getUsuarioesion());
        PedidoController pedidoController = new PedidoController();
        facturaFacade.create(factura);
        for (Producto p : carrito) {
            facturaHasProducto.setIdfactura(factura);
            facturaHasProducto.setIdproducto(p);
            facturaHasProducto.setCantidad(p.getCantidad());
            facturaHasProductoFacade.create(facturaHasProducto);
        }

        Pedido pedido = new Pedido();
        pedido.setClienteId(usuarioControlador.getUsuarioesion());
        pedido.setEstado("iniciado");
        pedido.setFacturaIdfactura(factura);
        pedido.setFechaPedido(new Date());
        pedidoFacade.create(pedido);
        carrito.clear();
        producto = new Producto();
    }
}
