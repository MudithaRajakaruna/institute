package lk.ijse.dep12.jpa.relationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModulePK implements Serializable {
    private Course course;
    private Module module;
}