package org.example.examen.model.idao;


import org.example.examen.model.entities.Poblacion;

import java.util.List;

public interface IPoblacionDAO {

    boolean insert(Poblacion poblacion);
    boolean delete(Poblacion poblacion);
    boolean update(Poblacion poblacion);
    List<Poblacion> getPoblaciones();
    Poblacion buscar(String nombre);
    String buscarClave(String nombre);
}
