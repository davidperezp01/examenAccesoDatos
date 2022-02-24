package org.example.examen.model.entities;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idUsuario;
    @Column
    public String dni;
    @Column
    public String nombre;
    @Column
    public String tlf;
    @Column
    public String dir;
    @Column
    public String password;
    @Column
    public String correo;
    @Column
    public String tipo;
    @Column
    public double descuento;
    @JoinColumn(name = "codPoblacion")
    @ManyToOne
    public Poblacion poblacion;

    public Usuario(String dni, String nombre, String tlf, String dir, String correo, String tipo, double descuento, Poblacion poblacion, String password) {
        this.idUsuario = 0;
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
        this.dir = dir;
        this.correo = correo;
        this.tipo = tipo;
        this.password = password;
        this.descuento = descuento;
        this.poblacion = poblacion;
    }

    public Usuario(String dni, String nombre, String tlf, String dir, String password, String correo, Poblacion poblacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
        this.dir = dir;
        this.password = password;
        this.correo = correo;
        this.poblacion = poblacion;
    }

    public Usuario( String dni, String nombre, String tlf, String dir, String password, String correo, String tipo, double descuento) {
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
        this.dir = dir;
        this.password = password;
        this.correo = correo;
        this.tipo = tipo;
        this.descuento = descuento;
    }

    public Usuario(int idUsuario, String dni, String nombre, String tlf, String dir, String password, String correo, String tipo, double descuento, Poblacion poblacion) {
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
        this.dir = dir;
        this.password = password;
        this.correo = correo;
        this.tipo = tipo;
        this.descuento = descuento;
        this.poblacion = poblacion;
    }

    public Usuario() {
    }

    public Poblacion getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }


    @Override
    public String toString() {
        return "idUsuario: " + idUsuario +
                ", nombre: " + nombre;
    }
}

