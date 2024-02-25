package impl;

import dao.DAO;
import utils.HibernateUtil;

import javax.persistence.EntityManager;

public abstract class DaoImpl<T> implements DAO<T> {
    protected abstract Class<T> getCl();

    @Override
    public T save(T t) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t;
    }

    @Override
    public void update(T t) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(getCl(), id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T find(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T t = entityManager.find(getCl(), id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return t;
    }
}
