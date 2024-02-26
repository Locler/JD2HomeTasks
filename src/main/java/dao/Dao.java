package dao;

public interface Dao<T> {
    T update(T t);

    void create(T t);

    void delete(int id,Class<T> tClass);

    T getById(int id,Class<T> tClass);
}
