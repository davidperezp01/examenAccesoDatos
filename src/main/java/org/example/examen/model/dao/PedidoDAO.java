package org.example.examen.model.dao;



import org.example.examen.model.entities.Pedido;
import org.example.examen.model.idao.IPedidoDAO;
import org.example.examen.persistence.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PedidoDAO implements IPedidoDAO {
    private EntityManager em;

    public PedidoDAO() {

    }

    @Override
    public boolean insert(Pedido pedido) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        boolean insertado = false;
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            insertado = true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return insertado;
    }

    @Override
    public boolean delete(Pedido pedido) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        boolean borrado = false;
        try {
            em.getTransaction().begin();
            em.remove(em.merge(pedido));
            em.getTransaction().commit();
            borrado = true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return borrado;
    }

    @Override
    public boolean update(Pedido pedido) {
        boolean actualizado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
            actualizado = true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return actualizado;
    }

    @Override
    public List<Pedido> getPedidos() {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        String hql = "SELECT p FROM Pedido p";
        Query query = em.createQuery(hql, Pedido.class);
        List<Pedido> pedidos = query.getResultList();
        return pedidos;
    }


    @Override
    public Pedido buscar(String codLineaPedido) {
        Pedido pedido = null;
        return pedido;
    }

    @Override
    public int buscarClave(String nombre) {
        return 0;
    }
}
