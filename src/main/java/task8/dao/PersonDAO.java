package task8.dao;

import task8.entity.Person;

import java.util.List;

public interface PersonDAO extends DAO<Person> {
    List<Person> getAll();
    List<Person> findAndSortByAge(int age);
}
