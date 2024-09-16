package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.flush();
            em.getTransaction().commit();
        }

        catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudieron grabar las clases");
        }

        em.close();
        emf.close();
    }
}
