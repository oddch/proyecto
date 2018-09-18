/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Asistencia;
import Entidades.Usuario;
import Facades.AsistenciaFacade;
import Facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Asus
 */
@Named(value = "asistenciaControlador")
@SessionScoped
public class AsistenciaControlador implements Serializable {

    /**
     * Creates a new instance of asistenciaControlador
     */
    public AsistenciaControlador() {
    }

    @PostConstruct
    public void init() {
        asistencia = new Asistencia();
        usuario = new Usuario();
    }
    @EJB
    AsistenciaFacade asistenciaFacade;
    private Asistencia asistencia;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public String create() {
        try {
            asistencia.setFecha(new Date());
            asistencia.setUsuarioIdUsuario(usuario);
            asistenciaFacade.create(asistencia);
            clearObj();
        } catch (Exception e) {

        }

        return "Error.xhtml?faces-redirect=true";
    }

    public void clearObj() {
        asistencia = new Asistencia();
        usuario = new Usuario();
    }

    public void remove(Asistencia objAsistencia) {
        try {
            asistencia = objAsistencia;
            asistenciaFacade.remove(asistencia);
            clearObj();
        } catch (Exception e) {
        }

    }

    public List<Asistencia> listarAsistencias() {
        return asistenciaFacade.findAll();
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
