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
@Named(value = "pedidoControlador")
@SessionScoped
public class PedidoControlador implements Serializable {

    /**
     * Creates a new instance of PedidoControlador
     */
    public PedidoControlador() {
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
    
    public List<Pedido> listarPedidos(){
        return pedidoFacade.findAll();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
