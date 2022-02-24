package org.example.examen.model.dao;

import org.example.examen.model.entities.Poblacion;
import org.example.examen.model.idao.IPoblacionDAO;
import org.example.examen.persistence.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PoblacionDAO implements IPoblacionDAO {
    private EntityManager em;

    public PoblacionDAO() {

    }


    @Override
    public boolean insert(Poblacion poblacion) {
        boolean insertado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(poblacion);
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
    public boolean delete(Poblacion poblacion) {
        boolean borrado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(poblacion));
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
    public boolean update(Poblacion poblacion) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        boolean actualizado = false;
        try {
            em.getTransaction().begin();
            em.merge(poblacion);
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
    public List<Poblacion> getPoblaciones() {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        String hql = "SELECT pb FROM Poblacion pb";
        Query query = em.createQuery(hql, Poblacion.class);
        List<Poblacion> poblaciones = query.getResultList();
        return poblaciones;
    }



    @Override
    public Poblacion buscar(String nombre) {
        Poblacion poblacion = null;
        return poblacion;
    }

    @Override
    public String buscarClave(String nombre) {
        return null;
    }
}
