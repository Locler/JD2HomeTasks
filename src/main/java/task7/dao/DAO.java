package task7.dao;

import task7.entity.Person;

public interface DAO <T>{
    Person save(T t);
    void update(T t,int id);
    void delete(int id);

    T getById(int id);
}
