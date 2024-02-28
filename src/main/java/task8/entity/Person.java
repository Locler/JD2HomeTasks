package task8.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    @CreationTimestamp
    private LocalDateTime dateTimeCreate;
    @Column
    @CreationTimestamp
    private LocalTime timeToLunch;
    @Column
    private String letter;
}
