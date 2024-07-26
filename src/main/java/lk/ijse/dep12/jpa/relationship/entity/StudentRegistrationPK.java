package lk.ijse.dep12.jpa.relationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationPK implements Serializable {
    private Student student;
    private Batch batch;
    private User user;
}