package dao.impl;

import dao.Dao;
import connection.HibernateUtils;

import javax.persistence.EntityManager;

public class DaoImpl<T> implements Dao<T> {
    @Override
    public T update(T t) {
        EntityManager entityManager = HibernateUtils.getEntityManger();
        entityManager.getTransaction().begin();
        T t1 = entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t1;
    }

    @Override
    public void create(T t) {
        EntityManager entityManager = HibernateUtils.getEntityManger();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id, Class<T> tClass) {
        EntityManager entityManager = HibernateUtils.getEntityManger();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(tClass, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T getById(int id, Class<T> tClass) {
        EntityManager entityManager = HibernateUtils.getEntityManger();
        entityManager.getTransaction().begin();
        T t1 = entityManager.find(tClass, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t1;
    }
}
