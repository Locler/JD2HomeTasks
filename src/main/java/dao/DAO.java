package dao;

public interface DAO<T> {
    void save(T t);
    void update(T t);
    void delete(int id);
    T find(int id);
}
