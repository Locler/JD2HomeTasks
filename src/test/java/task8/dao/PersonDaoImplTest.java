package task8.dao;

import org.junit.Test;
import task8.MockUtils;
import task8.entity.Person;
import static org.junit.Assert.*;

public class PersonDaoImplTest {
    private final PersonDaoImpl PERSON_DAO = new PersonDaoImpl();

    @Test
    public void save() {
        Person person = MockUtils.getPerson();
        int idBeforeSave = person.getId();
        PERSON_DAO.save(person);
        assertNotEquals("id before save = " + idBeforeSave + ",new id = " + person.getId(), idBeforeSave, person.getId());
    }

    @Test
    public void update() {
        Person person = MockUtils.getPerson();
        int age = person.getAge();
        person.setAge(29);
        PERSON_DAO.update(person);
        assertNotEquals(age, person.getAge());
    }

    @Test
    public void delete() {
        Person person = MockUtils.getPerson();
        PERSON_DAO.save(person);
        int id = person.getId();
        PERSON_DAO.delete(id);
        assertNull(PERSON_DAO.getById(id));
    }

    @Test
    public void getById() {
        Person person = MockUtils.getPerson();
        int age = person.getAge();
        PERSON_DAO.save(person);
        Person personFromDb = PERSON_DAO.getById(person.getId());
        assertEquals(age, personFromDb.getAge());
    }

    @Test
    public void findAndSortByAge() {
        Person person1 = MockUtils.getPerson();
        Person person2 = MockUtils.getPerson();
        Person person3 = MockUtils.getPerson();
        PERSON_DAO.save(person1);
        PERSON_DAO.save(person2);
        PERSON_DAO.save(person3);
        assertEquals(3, (PERSON_DAO.findAndSortByAge(15).size()));
    }
}