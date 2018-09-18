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
import Modelo.Mailer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Josarta
 */
@Named(value = "administradorView")
@ViewScoped
public class EnvioMasivo implements Serializable {

    private Usuario usurioTemporal = new Usuario();
    private List<Rol> misRoles = new ArrayList<>();
    private List<Rol> rolesDisponibles = new ArrayList<>();
    private String asuntoM;
    private String cuerpoM;

    /**
     * Creates a new instance of AdministradorView
     */
    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    RolFacade rolFacade;

    public EnvioMasivo() {
    }

    public List<Usuario> leerUsuario() {
        List<Usuario> miLista = new ArrayList<>();
        try {
            return usuarioFacade.leerTodos();
        } catch (Exception e) {
            return miLista;
        }
    }

    public void envioMasivo() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.asuntoM = params.get("asuntoM");
        this.cuerpoM = params.get("cuerpoM");
        
        
        Mailer correoMasivo = new Mailer();
        RequestContext rc = RequestContext.getCurrentInstance();
        
        for (Usuario usuIter : usuarioFacade.findAll()) {
            try {
                correoMasivo.send(usuIter.getEmail(), asuntoM, cuerpoM);
            } catch (Exception e) {
                rc.execute("swal('Problemas enviando a : !'," + usuIter.getEmail() + ", 'warning');");

            }

        }
        rc.execute("swal('Correos !','Enviados terminado', 'success');");

    }

 

    public String getAsuntoM() {
        return asuntoM;
    }

    public void setAsuntoM(String asuntoM) {
        this.asuntoM = asuntoM;
    }

    public String getCuerpoM() {
        return cuerpoM;
    }

    public void setCuerpoM(String cuerpoM) {
        this.cuerpoM = cuerpoM;
    }

}
