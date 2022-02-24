package org.example.examen.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManagerFactory emf;

    public JPAUtils() {

    }

    public static void buildEntityManagerFactory() {
        if (emf == null) {
            try {
                //Configuramos el EMF a través de la unidad de persistencia
                emf = Persistence.createEntityManagerFactory("examen");
                //Generamos un EntityManager
                //em = emf.createEntityManager();
            } catch (Throwable th) {
                System.err.println("Fallo al iniciar el EntityManagerFactory" + th);
                throw new ExceptionInInitializerError(th);
            }
        }
    }

    public static EntityManagerFactory getEMF() {
        if (emf == null) {
            buildEntityManagerFactory();
        }
        return emf;
    }
}
