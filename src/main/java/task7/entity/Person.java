package task7.entity;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Person {
    private int age;
    private float salary;
    private String passport;
    private String adress;
    private Date dateOfBirthday;
    private Timestamp dateTimeCreate;
    private Time timeToLunch;
    private String letter;
}
