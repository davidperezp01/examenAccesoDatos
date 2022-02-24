package org.example.examen.model.dao;


import org.example.examen.model.entities.LineaPedido;
import org.example.examen.model.idao.ILineaPedidoDAO;
import org.example.examen.persistence.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoDAO implements ILineaPedidoDAO {
    private EntityManager em;

    public LineaPedidoDAO() {

    }


    @Override
    public boolean insert(LineaPedido lineaPedido) {
        boolean insertado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(lineaPedido);
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
    public boolean delete(LineaPedido lineaPedido) {
        boolean borrado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(lineaPedido));
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

    public boolean update(LineaPedido lineaPedido) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        boolean actualizado = false;
        try {
            em.getTransaction().begin();
            em.merge(lineaPedido);
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
    public List<LineaPedido> getLineaPedido() {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        String hql = "SELECT lp FROM LineaPedido lp";
        Query query = em.createQuery(hql, LineaPedido.class);
        List<LineaPedido> lineaPedidos = query.getResultList();
        return lineaPedidos;
    }

    @Override
    public List<LineaPedido> buscar(int codPedido) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        List<LineaPedido> lineas = new ArrayList<>();
        String hql = "SELECT lp FROM LineaPedido lp WHERE lp.pedido = :pedido";
        Query query = em.createQuery(hql).setParameter("pedido", codPedido);
        lineas = query.getResultList();
        return lineas;
    }



}
