package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Entity
@Table(name = "Task_br3")
@ToString
@EqualsAndHashCode
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
}
