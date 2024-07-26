package lk.ijse.dep12.jpa.relationship;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Contact;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class DemoAddModuleToDatabase {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Module m001 = new Module("M001", "module1", 2, Module.Type .Mandatory);
                Module m002 = new Module("M002", "module2", 3, Module.Type.Mandatory);
                Module m003 = new Module("M003", "module3", 1, Module.Type.Mandatory);
                Module m004 = new Module("M004", "module4", 2, Module.Type.Optional);

                List.of(m001, m002, m003, m004).forEach(em::persist);
                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }


}
