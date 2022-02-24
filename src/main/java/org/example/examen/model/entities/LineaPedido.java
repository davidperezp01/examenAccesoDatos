package org.example.examen.model.entities;

import javax.persistence.*;

@Entity
public class LineaPedido {
    @Column
    public double pvp;
    @Column
    public int cantidad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int codLineaPedido;
    @ManyToOne
    @JoinColumn(name = "codProducto") //puede que venga de aqui el fallo de no mostrar producto
    public Producto producto;
    @ManyToOne
    @JoinColumn(name = "codPedido")
    public Pedido pedido;



    public LineaPedido(double pvp, int cantidad, Producto producto) {
        this.pvp = pvp;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public LineaPedido(double pvp, int cantidad, Pedido pedido, Producto producto) {
        this.pvp = pvp;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.producto = producto;
    }

    public LineaPedido() {
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodLineaPedido() {
        return codLineaPedido;
    }

    public void setCodLineaPedido(int codLineaPedido) {
        this.codLineaPedido = codLineaPedido;
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "pvp=" + pvp +
                ", cantidad=" + cantidad +
                ", codLineaPedido=" + codLineaPedido +
                '}';
    }
}
