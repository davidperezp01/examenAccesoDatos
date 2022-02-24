package org.example.examen;

import org.example.examen.model.dao.UsuarioDAO;
import org.example.examen.model.entities.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {
    public static void menu() {
        System.out.println("1. Introducir ");
        System.out.println("2. Borrar");
        System.out.println("3. Actualizar");
        System.out.println("4. Listar");
    }


    public static void opciones() {
        int opcion = -1;
        UsuarioDAO UsuarioDAO = new UsuarioDAO();
        List<Usuario> Usuarios = new ArrayList<>();
        Usuarios = UsuarioDAO.getUsuarios();
        Usuario Usuario = new Usuario();
        Scanner sc = new Scanner(System.in);
        String nombre, ciudad;


        do {
            menu();
            System.out.println("introduce una opción");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("introduce un Usuario");
                    System.out.println("nombre:");
                    nombre = sc.nextLine();
                    if (!(comprobarExistencia(nombre))) {
                        Usuario.setNombre(nombre);
                        UsuarioDAO.insert(Usuario);
                        System.out.println("Usuario introducido");
                    } else {
                        System.out.println("ya existe ese Usuario");
                    }
                    break;
                case 2:
                    System.out.println("introduce el Usuario a borrar");
                    System.out.println("nombre");
                    nombre = sc.nextLine();
                    if (comprobarExistencia(nombre)) {
    //                    UsuarioDAO.delete(nombre);
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("introduce el Usuario a modificar");
                    System.out.println("nombre");
                    nombre = sc.nextLine();
                    if (comprobarExistencia(nombre)) {
                        Usuario.setNombre(nombre);
       //                 UsuarioDAO.delete(nombre);
                    }
                case 4:
                    System.out.println(Usuarios);
            }

        } while (opcion != 0);
    }

    public static boolean comprobarExistencia(String nombre) {
        UsuarioDAO UsuarioDAO = new UsuarioDAO();
        List<Usuario> Usuarios = new ArrayList<>();
        Usuarios = UsuarioDAO.getUsuarios();
        boolean existe = false;
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public static void main(String[] args) {
        menu();
        opciones();
    }
}
