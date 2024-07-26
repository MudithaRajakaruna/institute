package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
@ToString(exclude = "contactList")
public class Student implements Serializable {
    @Id
    private String nic;
    private String name;
    private String address;
    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @Setter(AccessLevel.NONE)
    private List<Contact> contactList = new ArrayList<>();

    public Student(String nic, String name, String address) {
        this.nic = nic;
        this.name = name;
        this.address = address;
    }

    public Student(String nic, String name, String address, List<Contact> contactList) {
        if (contactList != null && !contactList.isEmpty()) {
            contactList.stream().filter(contact -> contact.getStudent() == null).forEach(contact -> contact.setStudent(this));
            contactList.forEach(contact -> {
                if (contact.getStudent() != this)
                    throw new IllegalStateException("This contact is already associated with another student %s"
                            .formatted(contact.getStudent().getNic()));
            });
        }
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contactList = contactList;
    }
}