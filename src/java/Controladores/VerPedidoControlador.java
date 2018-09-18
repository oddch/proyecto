/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Pedido;
import Facades.PedidoFacade;
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
@Named(value = "verPedidoControlador")
@SessionScoped
public class VerPedidoControlador implements Serializable {

    /**
     * Creates a new instance of VerPedidoControlador
     */
    public VerPedidoControlador() {
    }
    @PostConstruct
    public void init(){
        pedido = new Pedido();
    }
    @EJB
    PedidoFacade pedidoFacade;
    private Pedido pedido;
    
    public void clearObj(){
        pedido = new Pedido();
    }
    
    public void remove(Pedido ObjPedido){
        pedido = ObjPedido;
        pedidoFacade.remove(pedido);
        clearObj();
    }
    public List<Pedido> listarPedido(){
        return  pedidoFacade.findAll();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}
