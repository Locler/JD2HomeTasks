package task7.dao;

public interface DAO <T>{
    void save(T t);
    void update(T t,int id);
    void delete(int id);
    T getById(int id);
}
