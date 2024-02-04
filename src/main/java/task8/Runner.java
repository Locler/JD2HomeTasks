package task8;

import task8.dao.PersonDaoImpl;
import task8.entity.Person;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Person person = Person.builder()
                .age(25)
                .passport("sadads")
                .salary(12323f)
                .letter("sadasd")
                .adress("gfgfgf")
                .timeToLunch(Time.valueOf("12:12:12"))
                .dateOfBirthday(Date.valueOf("1993-12-12"))
                .dateTimeCreate(Timestamp.valueOf("2004-05-05 19:19:19"))
                .build();
        PersonDaoImpl personDaoImpl = new PersonDaoImpl();
        personDaoImpl.save(person);
        person.setAge(26);
        personDaoImpl.update(person);
        List<Person> personList = personDaoImpl.getAll();
        personList.forEach(System.out::println);
//        System.out.println(person.getId());
//        personDaoImpl.save(person);
//        System.out.println(person.getId());
//        personDaoImpl.save(person);
//        System.out.println(person.getId());
//        personDaoImpl.save(person);
//        System.out.println(person.getId());

    }
}
