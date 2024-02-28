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
    private int id;
    private int age;
    private float salary;
    private String passport;
    private String adress;
    private Date dateOfBirthday;
    private Timestamp dateTimeCreate;
    private Time timeToLunch;
    private String letter;

    public Person(int age, float salary, String passport, String adress, Date dateOfBirthday, Timestamp dateTimeCreate, Time timeToLunch, String letter) {
        this.age = age;
        this.salary = salary;
        this.passport = passport;
        this.adress = adress;
        this.dateOfBirthday = dateOfBirthday;
        this.dateTimeCreate = dateTimeCreate;
        this.timeToLunch = timeToLunch;
        this.letter = letter;
    }
}
