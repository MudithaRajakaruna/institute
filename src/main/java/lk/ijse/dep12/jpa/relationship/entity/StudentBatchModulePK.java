package lk.ijse.dep12.jpa.relationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBatchModulePK implements Serializable {
    private Student student;
    private Batch batch;
    private Module module;
}