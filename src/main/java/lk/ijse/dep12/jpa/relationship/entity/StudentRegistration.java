package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_registration")
@IdClass(StudentRegistrationPK.class)
public class StudentRegistration implements Serializable {
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "student_nic", referencedColumnName = "nic")
    private Student student;
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
    private Batch batch;
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
    private Date date;
}