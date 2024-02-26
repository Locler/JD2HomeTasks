package dao;

import entity.People;

public interface PeopleDao extends Dao<People> {
    void increaseAge();
}
