package lk.ijse.dep12.jpa.relationship;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.User;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class DemoAddUserToDatabase {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                User kusal = new User("kusalmendis", "Kusal Mendis", "12345");
                User charith = new User("charithAsalanka", "Charith Asalanka", "ka123");

                List.of(charith, kusal).forEach(em::persist);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }


}
