package task8.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Person {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int age;
    @Column
    private float salary;
    @Column
    private String passport;
    @Column
    private String adress;
    @Column
    private Date dateOfBirthday;
    @Column
    private Timestamp dateTimeCreate;
    @Column
    private Time timeToLunch;
    @Column
    private String letter;
}
