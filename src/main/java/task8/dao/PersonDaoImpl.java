package task8.dao;

import task8.hibernateConnection.HibernateUtil;
import task8.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDaoImpl implements PersonDAO {
    public static final String GET_ALL_PERSON = "SELECT * FROM Person where id!=0";
    public static final String SELECT_BY_AGE_AND_ORDER = "SELECT * FROM Person where age>? ORDER BY dateTimeCreate";
    private EntityManager entityManager;

    @Override
    public Person save(Person person) {
        startTransaction();
        if (entityManager.find(Person.class, person.getId()) == null) {
            entityManager.persist(person);
        } else {
            entityManager.merge(person);
        }
        commitAndCloseTransaction();
        return person;
    }

    @Override
    public void update(Person person) {
        startTransaction();
        entityManager.merge(person);
        commitAndCloseTransaction();
    }

    @Override
    public void delete(int id) {
        startTransaction();
        entityManager.remove(entityManager.find(Person.class, id));
        commitAndCloseTransaction();
    }

    @Override
    public Person getById(int id)  {
        startTransaction();
        Person person = entityManager.find(Person.class, id);
        commitAndCloseTransaction();
        return person;
    }

    @Override
    public List<Person> getAll() {
        startTransaction();
        Query query = entityManager.createNativeQuery(GET_ALL_PERSON, Person.class);
        List<Person> resultList = query.getResultList();
        commitAndCloseTransaction();
        return resultList;
    }

    @Override
    public List<Person> findAndSortByAge(int age) {
        startTransaction();
        Query query=entityManager.createNativeQuery(SELECT_BY_AGE_AND_ORDER, Person.class);
        query.setParameter(1,age);
        List<Person> resultList = query.getResultList();
        commitAndCloseTransaction();
        return resultList;
    }

    private void commitAndCloseTransaction() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void startTransaction() {
        entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
    }
}