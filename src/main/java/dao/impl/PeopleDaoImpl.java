package dao.impl;

import dao.PeopleDao;
import connection.HibernateUtils;
import entity.People;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PeopleDaoImpl extends DaoImpl<People> implements PeopleDao {
    private static final String COUNT_ALL = "SELECT * FROM People ORDER BY id DESC LIMIT 2";
    @Override
    public void increaseAge() {
        EntityManager entityManager = HibernateUtils.getEntityManger();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery(COUNT_ALL, People.class);
        List<People> resultList = query.getResultList();
        if (resultList.size() > 1) {
            People person = resultList.get(0);
            People person2 = resultList.get(1);
            person.setAge(person.getAge() + 2);
            person2.setAge(person2.getAge() + 2);
            entityManager.merge(person);
            entityManager.merge(person2);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
