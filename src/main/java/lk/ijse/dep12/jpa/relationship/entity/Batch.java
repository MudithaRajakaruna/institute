package lk.ijse.dep12.jpa.relationship.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "batch")
public class Batch implements Serializable {
    @Id
    @Column(name = "batch_id")
    private String batchId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "course_code", referencedColumnName = "code")
    private Course course;
    private String duration;
    private BigDecimal fee;
}