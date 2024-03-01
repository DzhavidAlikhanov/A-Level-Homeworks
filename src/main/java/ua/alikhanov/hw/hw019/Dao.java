package ua.alikhanov.hw.hw019;

import java.util.List;

public interface Dao<T> {
    void create(T entity);
    T read(long id);
    List<T> readAll();
    void update(T entity);
    void delete(T entity);
}
