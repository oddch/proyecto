/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Registroasistencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL
 */
@Stateless
public class RegistroasistenciaFacade extends AbstractFacade<Registroasistencia> {

    @PersistenceContext(unitName = "MerkarutaOficialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroasistenciaFacade() {
        super(Registroasistencia.class);
    }
    
}
