package org.example.examen.model.idao;

import org.example.examen.model.entities.Pedido;

import java.util.List;

public interface IPedidoDAO {

    boolean insert(Pedido pedido);
    boolean delete(Pedido pedido);
    boolean update(Pedido pedido);
    List<Pedido> getPedidos();
    Pedido buscar(String idUsuario);
    int buscarClave(String nombre);
}
