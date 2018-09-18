/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Entidades.Calificacion;
import Entidades.Factura;
import Entidades.Pedido;
import Entidades.Usuario;
import Facades.CalificacionFacade;
import Facades.PedidoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author familia yepes
 */
@Named(value = "pedidoController")
@SessionScoped
public class PedidoController implements Serializable {

    @EJB
    private CalificacionFacade calificacionFacade;

    @EJB
    private PedidoFacade pedidoFacade;
    Pedido pedido = new Pedido();
    Usuario usuario = new Usuario();
    Calificacion calificacion = new Calificacion();

    /**
     * Creates a new instance of PedidoController
     */
    public PedidoController() {
    }

    public void registrar(Usuario u, Factura f) {
        pedido.setClienteId(u);
        pedido.setEstado("iniciado");
        pedido.setFacturaIdfactura(f);
        pedido.setFechaPedido(new Date());
        pedidoFacade.create(pedido);

    }

    public void asignar(Pedido p) {
        List<Usuario> usuariosD = new ArrayList<>();
        usuariosD.add(usuario);
        p.setUsuarioList(usuariosD);
        p.setEstado("asignado");
        pedidoFacade.edit(p);

    }

    public void terminar(Pedido p) {

        p.setEstado("entregado");
        pedidoFacade.edit(p);

    }

    public void calificar() {
        calificacion.setCalificado("calificado");

        pedido.setEstado("calificado");
        pedidoFacade.edit(pedido);
        calificacion.setPedidoId(pedido);
        calificacionFacade.create(calificacion);
    }

    public List<Calificacion> calificaciones() {
        return calificacionFacade.findAll();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Pedido> listarPedidos() {

        return pedidoFacade.ListarPedidosIniciales();
    }

    public List<Pedido> listarPedidosAsignados() {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        return pedidoFacade.ListarPedidosAsignados(usuarioControlador.getUsuarioesion().getIdUsuario());

    }

    public List<Pedido> listarPedidosEntregados() {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        return pedidoFacade.ListarPedidosEntregados(usuarioControlador.getUsuarioesion().getIdUsuario());

    }

    public List<Pedido> listarPedidosUsuarios() {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        return pedidoFacade.ListarPedidosUsuarios(usuarioControlador.getUsuarioesion().getIdUsuario());

    }

    public List<Pedido> listarPedidosUsuariosHechos() {
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        return pedidoFacade.ListarPedidosUsuariosHechos(usuarioControlador.getUsuarioesion().getIdUsuario());

    }
    public void remove(Pedido ObjpePedido){
        pedido = ObjpePedido;
        pedidoFacade.remove(pedido);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
