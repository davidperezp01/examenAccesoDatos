package org.example.examen.model.idao;

import org.example.examen.model.entities.Usuario;

import java.util.List;

public interface IUsuarioDAO {

     boolean insert(Usuario usuario);
     boolean delete(Usuario usuario);
     boolean update(Usuario Usuario);
     List<Usuario> getUsuarios();
     Usuario buscar(int idUsuario);
     Usuario buscarUsuarioNombre(String nombre);


}
