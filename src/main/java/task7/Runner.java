package task7;

import task7.dao.PersonDaoImpl;
import task7.entity.Person;

import java.sql.*;
import java.util.List;


public class Runner {
    public static void main(String[] args) {
        Person person = new Person(25, 212312f, "MPNNP", "GHGHF", Date.valueOf("1994-12-12"), Timestamp.valueOf("2022-01-01 19:19:22"), Time.valueOf("22:10:10"), "i love java");
        PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.save(person);
        List<Person> personList = personDao.getAll();
        personList.forEach(System.out::println);
        System.out.println(personDao.getById(26));
        personDao.delete(26);
        personDao.update(person, 27);
    }
}
