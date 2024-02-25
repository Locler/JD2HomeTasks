package dao;

public interface DAO<T> {
    T save(T t);
    void update(T t);
    void delete(int id);
    T find(int id);
}
