package org.example.examen.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Ficheros {
    FileWriter fichero = null;
    File fileConfig = null;

    public void guardarRegistros() throws IOException {
        fileConfig = new File("C:\\clase\\cestaCompra\\configuracion.txt");
        if (!fileConfig.exists()) {
            fileConfig.createNewFile();
        }

    }

    public void crearFicheroErrores() throws IOException {
        guardarRegistros();
        File fileError = new File("C:\\clase\\cestaCompra\\ventas.log");
        if (!fileError.exists()) {
            fileError.createNewFile();
        }
        fichero = new FileWriter(fileError, true);
        String mensaje = "\nerror de conexión " + LocalDate.now();
        fichero.write(mensaje);
        fichero.close();

        FileWriter ficheroConfig = new FileWriter(fileConfig, true);
        ficheroConfig.write(fileError.toString() + " " + mensaje);
        ficheroConfig.close();
    }

    public void crearFicheroLog(String usuario) throws IOException {
        guardarRegistros();
        File fileRegistro = new File("C:\\clase\\cestaCompra\\registro.log");
        if (!fileRegistro.exists()) {
            fileRegistro.createNewFile();
        }
        String mensaje = "\n" + usuario + " registrado " + LocalDate.now();
        fichero = new FileWriter(fileRegistro, true);
        fichero.write(mensaje);
        fichero.close();

        FileWriter ficheroConfig = new FileWriter(fileConfig, true);
        ficheroConfig.write(fileRegistro.toString() + " " + mensaje);
        ficheroConfig.close();
    }
}
