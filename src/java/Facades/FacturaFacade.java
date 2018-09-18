/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Factura;
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
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "MerkarutaOficialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
     public List<Object[]> ventasRealizadasPorMes() {
        Query q = em.createNativeQuery("SELECT MonthName(factura.fecha) as 'Mes',\n"
                + "COUNT(factura.idfactura) AS 'Total Facturas',\n"
                + "SUM(factura.total_factura) AS 'Total Ventas'\n"
                + "FROM factura\n"
                + "GROUP BY MonthName(factura.fecha)");
        List<Object[]> lista = q.getResultList();
        return lista;
    }
}
