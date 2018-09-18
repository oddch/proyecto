/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Factura;
import Entidades.Usuario;
import Facades.FacturaFacade;
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
@Named(value = "facturaControlador")
@SessionScoped
public class FacturaControlador implements Serializable {

    /**
     * Creates a new instance of FacturaControlador
     */
    public FacturaControlador() {
    }

    @PostConstruct
    public void init() {
        factura = new Factura();
        usuario = new Usuario();
    }

    @EJB
    FacturaFacade facturaFacade;
    private Factura factura;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public void clearObj() {
        factura = new Factura();
        usuario = new Usuario();
    }

    public String create() {
        try {
            factura.getClienteId();
            facturaFacade.create(factura);
            clearObj();
        } catch (Exception e) {
        }
        return "Error.xhtml?faces-redirect=true";
    }
    public void remove(Factura ObjFactura){
        factura = ObjFactura;
        facturaFacade.remove(factura);
        clearObj();
    }
    
    public List<Factura> listarFactura(){
        return facturaFacade.findAll();
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
