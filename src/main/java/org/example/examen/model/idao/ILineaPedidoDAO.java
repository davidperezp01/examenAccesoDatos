package org.example.examen.model.idao;

import org.example.examen.model.entities.LineaPedido;

import java.util.List;

public interface ILineaPedidoDAO {

    boolean insert(LineaPedido lineaPedido);
    boolean delete(LineaPedido lineaPedido);
    boolean update(LineaPedido lineaPedido);
    List<LineaPedido> getLineaPedido();
    List<LineaPedido> buscar(int codPedido);

}

