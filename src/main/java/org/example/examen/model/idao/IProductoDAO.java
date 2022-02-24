package org.example.examen.model.idao;

import org.example.examen.model.entities.Producto;

import java.util.List;

public interface IProductoDAO {

    boolean insert(Producto producto);
    boolean delete(Producto producto);
    boolean update(Producto producto);
    List<Producto> getProductos();
    Producto buscar(String nombre);
    int buscarClave(String nombre);

}
