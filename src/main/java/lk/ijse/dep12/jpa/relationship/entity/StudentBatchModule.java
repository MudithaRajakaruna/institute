package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StudentBatchModulePK.class)
@Entity
@Table(name = "student_batch_module")
public class StudentBatchModule implements Serializable {
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "student_id", referencedColumnName = "nic")
    private Student student;
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
    private Batch batch;
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "module_code", referencedColumnName = "code")
    private Module module;
}