package org.example.examen.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Column
    public boolean confirmado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int codPedido;
    @Column
    public LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    public Usuario usuario;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<LineaPedido> pedidos = new ArrayList<>();


    public Pedido(boolean confirmado, Usuario usuario) {
        this.confirmado = confirmado;
        this.usuario = usuario;
        this.fecha = LocalDate.now();
    }




    public Pedido() {
    }


    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<LineaPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<LineaPedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "confirmado=" + confirmado +
                ", codPedido=" + codPedido +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                ", pedidos=" + pedidos +
                '}';
    }
}


