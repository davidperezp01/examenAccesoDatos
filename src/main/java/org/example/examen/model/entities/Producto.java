package org.example.examen.model.entities;

import javax.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int codProducto;
    @Column
    public double precioEntrada;
    @Column
    public int stock;
    @Column
    public String nombre;
    @Column
    public String descripcion;


    public Producto( double precioEntrada, int stock, String nombre, String descripcion) {
        this.precioEntrada = precioEntrada;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    public Producto() {
    }


    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getcodProducto() {
        return codProducto;
    }

    public void setcodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre + " pvp: " + precioEntrada;
    }
}
