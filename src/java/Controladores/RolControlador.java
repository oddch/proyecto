/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Facades.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Asus
 */
@Named(value = "rolControlador")
@SessionScoped
public class RolControlador implements Serializable {

    /**
     * Creates a new instance of RolControlador
     */
    public RolControlador() {
    }

    @PostConstruct
    public void init() {
        rol = new Rol();
    }
    @EJB
    RolFacade rolFacade;
    private Rol rol;

    public void clearObj() {
        rol = new Rol();
        
    }
     RequestContext rc = RequestContext.getCurrentInstance();
    public void ceate() {
    
        try {           
        rolFacade.create(rol);
         rc.execute("swal('el archivo !','Se carga sin error', 'success');");
        clearObj();
        } catch (Exception e) {
        }
    }

    public void remove(Rol ObjRol) {
        rol = ObjRol;
        rolFacade.remove(ObjRol);
        clearObj();
    }

    public List<Rol> listaRol() {
        return rolFacade.findAll();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
