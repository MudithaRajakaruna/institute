package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
@ToString(exclude = "batchList")
public class Course implements Serializable {
    @Id
    private String code;
    private String name;
    @OneToMany(mappedBy = "course", cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @Setter(AccessLevel.NONE)
    private List<Batch> batchList;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Course(String code, String name, List<Batch> batchList) {
        if (batchList != null && !batchList.isEmpty()) {
            batchList.stream().filter(batch -> batch.getCourse() == null).forEach(batch -> batch.setCourse(this));
            batchList.forEach(batch -> {
                if (batch.getCourse() != this)
                    throw new IllegalStateException("This batch is already associated with another course %s"
                            .formatted(batch.getCourse().getName()));
            });
        }
        this.code = code;
        this.name = name;
        this.batchList = batchList;
    }
}