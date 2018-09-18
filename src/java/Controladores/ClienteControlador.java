/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Pedido_;
import Entidades.Rol;
import Entidades.Usuario;
import Facades.RolFacade;
import Facades.UsuarioFacade;
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
@Named(value = "clienteControlador")
@SessionScoped
public class ClienteControlador implements Serializable {

    /**
     * Creates a new instance of ClienteControlador
     */
    public ClienteControlador() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        rol = new Rol();
    }
    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    @EJB
    RolFacade rolFacade;
    private Rol rol;

    public void create() {
        try {
            rol.setIdRol(3);
            usuario.setRolIdRol(rol);
            usuario.setEstado(1);
            usuarioFacade.create(usuario);
            clearObj();

        } catch (Exception e) {

        }
    }

    public void remove(Usuario ObjUsuario) {
        usuario = ObjUsuario;
        usuarioFacade.remove(usuario);
        clearObj();
    }

    public void clearObj() {
        usuario = new Usuario();
        rol = new Rol();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Usuario> listaUsuario() {
        return usuarioFacade.findAll();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
