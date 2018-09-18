/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Pedido;
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
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "MerkarutaOficialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }
       public List<Pedido> ListarPedidosIniciales() {
        Query q = getEntityManager().createNativeQuery("select * from pedido where estado='iniciado'", Pedido.class);
        return q.getResultList();
    }

    public List<Pedido> ListarPedidosAsignados(int id) {
        Query q = getEntityManager().createNativeQuery("select * from pedido inner join asignaciones on asignaciones.pedido_id=pedido.idpedido where estado='asignado' and usuario_id=?1", Pedido.class);
        q.setParameter(1, id);
        return q.getResultList();
    }

    public List<Pedido> ListarPedidosEntregados(int id) {
        Query q = getEntityManager().createNativeQuery("select * from pedido inner join asignaciones on asignaciones.pedido_id=pedido.idpedido where estado='entregado' or estado='calificado' and usuario_id=?1", Pedido.class);
        q.setParameter(1, id);
        return q.getResultList();
    }

    public List<Pedido> ListarPedidosUsuarios(int id) {
        Query q = getEntityManager().createNativeQuery("select * from pedido where estado='entregado' and cliente_id=?1", Pedido.class);
        q.setParameter(1, id);
        return q.getResultList();
    }

    public List<Pedido> ListarPedidosUsuariosHechos(int id) {
        Query q = getEntityManager().createNativeQuery("select * from pedido where estado='entregado' or estado='calificado' and cliente_id=?1", Pedido.class);
        q.setParameter(1, id);
        return q.getResultList();
    }
}
