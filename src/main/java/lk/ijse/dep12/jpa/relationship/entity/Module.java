package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "module")
public class Module implements Serializable {
    @Id
    private String code;
    private String name;
    private int credits;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        Mandatory, Optional
    }
}
