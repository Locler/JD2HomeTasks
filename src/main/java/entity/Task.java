package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Entity
@Table(name = "tasks_br_1")
@ToString
@EqualsAndHashCode
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TASK_TYPE",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("T")
public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
}
