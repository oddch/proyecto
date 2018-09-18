/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Usuario;
import java.util.ArrayList;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "MerkarutaOficialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
   public Usuario iniciarSesion(String correo, String pass) {
        Query qNative = getEntityManager().createNativeQuery("SELECT * FROM usuario WHERE Email = ?1 and clave =?2 ", Usuario.class);
        qNative.setParameter(1, correo);
        qNative.setParameter(2, pass);
        Usuario user = (Usuario) qNative.getSingleResult();
        return user;
    }

    public List<Usuario> leerTodos() {
        List<Usuario> todosUsuarios = new ArrayList<>();
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createQuery("SELECT c FROM Usuario c");
            todosUsuarios = q.getResultList();
            return todosUsuarios;
        } catch (Exception e) {
        }
        return todosUsuarios;
    }

    public Usuario leerUno(int PKusu) {
        Usuario salida = new Usuario();
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createQuery("SELECT c FROM usuario c WHERE c.Id_Usuario = :PKusu");
            q.setParameter("PKusu", PKusu);
            salida = (Usuario) q.getSingleResult();

            return salida;
        } catch (Exception e) {
        }
        return salida;
    }

    public List<Object[]> reporteUsuarios() {
        Query q = em.createNativeQuery("SELECT usuario.Id_Usuario, usuario.Documento, usuario.Nombres, usuario.Apellidos, usuario.Direccion, usuario.Telefono, usuario.Estado, usuario.Email, usuario.clave FROM usuario");
        List<Object[]> lista = q.getResultList();
        return lista;
    }  
}
