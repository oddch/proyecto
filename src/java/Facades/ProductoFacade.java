/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Producto;
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
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "MerkarutaOficialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
  public List<Object[]> reporteProducto() {
        List<Object[]> lista;
        Query Sql = em.createNativeQuery("SELECT nombre,precio from producto WHERE precio < 50000");
        lista = Sql.getResultList();
        return lista;
    }
    
     public List<Object[]> reporteProductos() {
        Query q = em.createNativeQuery("SELECT\n"
                + "producto.idproducto,\n"
                + "producto.nombre,\n"
                + "producto.tipo_producto,\n"
                + "producto.precio,\n"
                + "producto.cantidad\n"
                + "FROM producto");
        List<Object[]> lista = q.getResultList();
        return lista;
    }

   
}
