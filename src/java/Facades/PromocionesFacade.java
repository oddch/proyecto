/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Promociones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
@Stateless
public class PromocionesFacade extends AbstractFacade<Promociones> {

    @PersistenceContext(unitName = "MerkarutaOficialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromocionesFacade() {
        super(Promociones.class);
    }
     public List<Object[]> reportePromociones() {
        Query q = em.createNativeQuery("SELECT"
                + "promociones.Titulo,\n"
                + "promociones.Descripcion\n"
                + " FROM promociones;");
        List<Object[]> lista = q.getResultList();
        return lista;
    } 
}
