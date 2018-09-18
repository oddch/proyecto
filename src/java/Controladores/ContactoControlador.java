/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Contacto;
import Facades.ContactoFacade;
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
@Named(value = "contactoControlador")
@SessionScoped
public class ContactoControlador implements Serializable {

    /**
     * Creates a new instance of ContactoControlador
     */
    public ContactoControlador() {
    }
    

    @PostConstruct
    public void init(){
        contacto = new Contacto();
     
    }
    @EJB
    ContactoFacade contactoFacade;
    private Contacto contacto;

    public void clearObj(){
        contacto = new Contacto();
    }
    public void create(){
        contacto.setFecha(new Date());
        contactoFacade.create(contacto);
        clearObj();
    }
    public void remove(Contacto objContacto){
        contacto = objContacto;
        contactoFacade.remove(contacto);
        clearObj();
    }
    public List<Contacto> listaContacto(){
        return contactoFacade.findAll();
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

}
