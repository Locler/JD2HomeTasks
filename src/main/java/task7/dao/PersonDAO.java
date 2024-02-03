package task7.dao;

import task7.entity.Person;

import java.util.List;

public interface PersonDAO extends DAO<Person> {
    List<Person> getAll();
}
