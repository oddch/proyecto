/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Pedido;
import Entidades.Ruta;
import Facades.PedidoFacade;
import Facades.RutaFacade;
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
@Named(value = "rutaControlador")
@SessionScoped
public class RutaControlador implements Serializable {

    /**
     * Creates a new instance of RutaControlador
     */
    public RutaControlador() {
    }

    @PostConstruct
    public void init() {
        ruta = new Ruta();
        pedido = new Pedido();
    }
    @EJB
    RutaFacade rutaFacade;
    private Ruta ruta;

    @EJB
    PedidoFacade pedidoFacde;
    private Pedido pedido;

    public void clearObj() {
        ruta = new Ruta();
        pedido = new Pedido();
    }

    public void create() {
        ruta.setPedidoIdpedido(pedido);
        rutaFacade.create(ruta);
        clearObj();
    }
    
    public void remove(Ruta ObjRuta){
        ruta = ObjRuta;
        rutaFacade.remove(ruta);
        clearObj();
        
    }

    public List<Ruta> listarRuta() {
        return rutaFacade.findAll();
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
