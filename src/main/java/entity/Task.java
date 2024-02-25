package entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TASK_TYPE",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("T")
public class Task {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
}
