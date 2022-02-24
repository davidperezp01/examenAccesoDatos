package org.example.examen.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Poblacion {
    @Id
    public String codPoblacion;
    @Column
    public String nombre;

    public Poblacion(String nombre, String codPoblacion) {
        this.codPoblacion = codPoblacion;
        this.nombre = nombre;
    }

    public Poblacion(String nombre) {
        this.nombre = nombre;
    }


    public Poblacion() {
    }

    public String getCodPoblacion() {
        return codPoblacion;
    }

    public void setCodPoblacion(String codPoblacion) {
        this.codPoblacion = codPoblacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

