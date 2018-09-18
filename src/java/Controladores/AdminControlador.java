/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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
@Named(value = "adminControlador")
@SessionScoped
public class AdminControlador implements Serializable {

    /**
     * Creates a new instance of AdminControlador
     */
    public AdminControlador() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        rol = new Rol();
    }
    @EJB
    UsuarioFacade usuarioFacde;
    private Usuario usuario;

    @EJB
    RolFacade rolFacade;
    private Rol rol;

    public void clearObj() {
        usuario = new Usuario();
        rol = new Rol();
    }

    public void create() {
        try {
            usuario.setRolIdRol(rol);
            usuarioFacde.create(usuario);
            clearObj();

        } catch (Exception e) {
        }
        System.out.println("no ingreso ala metodo");
    }

    public void remove(Usuario ObjUsuario) {
        try {

            usuarioFacde.remove(usuario);
            clearObj();
        } catch (Exception e) {
        }
        usuario = ObjUsuario;
    }

    public List<Usuario> listaUsuario() {
        return usuarioFacde.findAll();
    }

    public Usuario getUsuario() {
        return usuario;
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
