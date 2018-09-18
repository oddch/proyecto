/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Entidades.Permisos;
import Entidades.Rol;
import Entidades.Usuario;
import Facades.RolFacade;
import Facades.UsuarioFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author juan
 */
@Named(value = "usuario")
@SessionScoped
public class UsuarioControlador implements Serializable {

    /**
     * Creates a new instance of CrearUsuario
     */
    public UsuarioControlador() {
    }

    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    @EJB
    RolFacade rolFacade;
    Rol rol = new Rol();

    private Part archivo;

    public Part getArchivo() {
        return archivo;
    }

    public void setArchivo(Part archivo) {
        this.archivo = archivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Rol> listarRoles() {
        return rolFacade.findAll();
    }

    public String crear() {

        usuarioFacade.create(usuario);

        return "/ingreso/usuario/ListarUsuario.xhtml?faces-redirect=true";

    }

    public List<Usuario> listaUsuariosDomiciliarios() {

        List<Usuario> usuariosDomiciliarios = new ArrayList<>();

        for (Usuario u : usuarioFacade.findAll()) {

            if (4 == u.getRolIdRol().getIdRol()) {
                System.out.println("entro en el if");
                usuariosDomiciliarios.add(u);
            } else {
                System.out.println("no entro ");
            }

        }
        return usuariosDomiciliarios;
    }

    public void cerrarSesion() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.invalidateSession();

        ec.redirect(ec.getRequestContextPath() + "/faces/Login.xhtml?faces-redirect=true");
    }

    public Usuario getUsuarioesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        return (Usuario) ec.getSessionMap().get("user");
    }

    public void validarSesion() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            if (getUsuarioesion() == null) {
                System.out.println(ec.getRequestContextPath() + "/Login.xhtml?faces-redirect=true");
                ec.redirect(ec.getRequestContextPath() + "/faces/Login.xhtml?faces-redirect=true");
            }

        } catch (IOException ex) {

            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String iniciarSesion() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        String url = "";

        try {
            Usuario u = usuarioFacade.iniciarSesion(usuario.getEmail(), usuario.getClave());
            if ("empleado".equals(u.getRolIdRol().getNombre())) {
                url = "empleado/homeAdmin.xhtml?faces-redirect=true";
            } else if ("administrador".equals(u.getRolIdRol().getNombre())) {
                url = "administrador/RegistrarUsuario.xhtml?faces-redirect=true";
            } else if ("cliente".equals(u.getRolIdRol().getNombre())) {
                url = "cliente/home.xhtml?faces-redirect=true";
            } else if ("domiciliario".equals(u.getRolIdRol().getNombre())) {
                url = "domiciliario/homeDomi.xhtml?faces-redirect=true";
            } else {
 
                url = "";
            }
            ec.getSessionMap().put("user", u);

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("lo sentimos:", "inicio de sesion insatisfactorio: " + "al parecer dicha cuenta no existe"));
            return url;
        }

        return url;

    }

    public List<Permisos> getMostrarRoles() {
        try {
            System.out.println("");
            return getUsuarioesion().getRolIdRol().getPermisosList();
        } catch (Exception e) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml?faces-redirect=true");
                return null;
            } catch (IOException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Usuario> getUsuarios() {

        return usuarioFacade.findAll();

    }

    public List<Usuario> listaUsuarioClientesYTecnicos() {

        List<Usuario> usuarioClientes = new ArrayList<>();

        for (Usuario u : usuarioFacade.findAll()) {

            if (2 == u.getRolIdRol().getIdRol() || 3 == u.getRolIdRol().getIdRol()) {
                System.out.println("entro en el if");
                usuarioClientes.add(u);
            } else {
                System.out.println("no entro ");
            }

        }
        return usuarioClientes;
    }

    public void activar(Usuario u) {
        u.setEstado(1);
        usuarioFacade.edit(u);

    }

    public void desactivar(Usuario u) {
        u.setEstado(2);
        usuarioFacade.edit(u);

    }

}
