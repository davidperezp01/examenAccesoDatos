package org.example.examen.model.dao;


import org.example.examen.model.entities.Usuario;
import org.example.examen.model.idao.IUsuarioDAO;
import org.example.examen.persistence.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

//implementa la inferfaz con los métodos crud
public class UsuarioDAO implements IUsuarioDAO {
    private EntityManager em;

    //es necesario un constructor vacío
    public UsuarioDAO() {
    }

    public boolean insert(Usuario usuario) {
        boolean insertado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            insertado = true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                //si todo va bien cerramos la transacción
                em.close();
            }
        }
        return insertado;
    }

    public boolean delete(Usuario usuario) {
        boolean borrado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(usuario));
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

    //el update es exactamente igual que el insert pero usamos merge en vez de persist
    public boolean update(Usuario usuario) {
        boolean actualizado = false;
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
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

    //te trae todos los usuarios
    public List<Usuario> getUsuarios() {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        //string sql estandar
        String hql = "SELECT u FROM Usuario u";
        //createQuery es la sentencia,
        Query query = em.createQuery(hql, Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

    public Usuario buscar(int idUsuario) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<>();
        String hql = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario";
        Query query = em.createQuery(hql).setParameter("idUsuario", idUsuario);
        usuarios = query.getResultList();
        if (!usuarios.isEmpty()) {
            usuario = usuarios.get(0);
        }
        return usuario;
    }

    public Usuario buscarUsuarioNombre(String nombre) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<>();
        String hql = "SELECT u FROM Usuario u WHERE u.nombre = :nombre";
        Query query = em.createQuery(hql).setParameter("nombre", nombre);
        usuarios = query.getResultList();
        if (!usuarios.isEmpty()) {
            usuario = usuarios.get(0);
        }
        return usuario;
    }

    public Usuario buscarUsuarioId(int idUsuario) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<>();
        String hql = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario";
        Query query = em.createQuery(hql).setParameter("idUsuario", idUsuario);
        usuarios = query.getResultList();
        if (!usuarios.isEmpty()) {
            usuario = usuarios.get(0);
        }
        return usuario;
    }



    /**
     * List results = query.getResultList();
     * Entity foundEntity = null;
     * if(!results.isEmpty()){
     * // ignores multiple results
     * foundEntity = results.get(0);
     */


    public String buscarTipoUsuario(String nombre) {
        EntityManager em = null;
        em = JPAUtils.getEMF().createEntityManager();
        List<Usuario> usuarios = new ArrayList<>();
        String hql = "SELECT u.tipo FROM Usuario u WHERE u.nombre = :nombre";
        Query query = em.createQuery(hql).setParameter("nombre", nombre);
        usuarios = query.getResultList();
        String tipoUsuario = String.valueOf(usuarios.get(0));
        return tipoUsuario;
    }

    //para registrarse como usu
    public boolean registrarse(Usuario usuario) {
        int insertado = 0;
        boolean aceptado = false;

        return aceptado;
    }
}
