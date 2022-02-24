package org.example.examen.model.dao;

import org.example.examen.model.entities.Producto;
import org.example.examen.model.idao.IProductoDAO;
import org.example.examen.persistence.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductoDAO implements IProductoDAO {
    private EntityManager em;

    public ProductoDAO() {

    }


    public boolean insert(Producto producto) {
        boolean insertado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(producto);
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


    public boolean delete(Producto producto) {
        boolean borrado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(producto));
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

    public boolean update(Producto producto) {
        boolean actualizado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(producto);
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

    public List<Producto> getProductos() {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        String hql = "SELECT p FROM Producto p";
        Query query = em.createQuery(hql, Producto.class);
        List<Producto> productos = query.getResultList();
        return productos;
    }


    public Producto buscar(String nombre) {

        return null;
    }

    public int buscarClave(String nombre) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        String hql = "SELECT p FROM Producto p WHERE p.nombre = :nombre";
        Query query = em.createQuery(hql)
                .setParameter("nombre", nombre);
        Producto producto = (Producto) query.getSingleResult();
        return producto.getCodProducto();
    }
}
