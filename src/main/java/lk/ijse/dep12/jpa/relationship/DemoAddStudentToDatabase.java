package lk.ijse.dep12.jpa.relationship;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Contact;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class DemoAddStudentToDatabase {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Student nipuna = new Student("931021796V", "Nipuna Heshan", "Panadura");
                Student praveen = new Student("991021796V", "Praveen Prashan", "Matara");

                Contact cn1 = new Contact(nipuna, "071-1234567");
                Contact cn2 = new Contact(nipuna, "072-1234567");
                Contact cs1 = new Contact(praveen, "077-1234567");

                nipuna.getContactList().add(cn1);
                praveen.getContactList().add(cn2);

                List.of(nipuna, praveen).forEach(em::persist);
                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                t.printStackTrace();
            }
        }

    }


}
