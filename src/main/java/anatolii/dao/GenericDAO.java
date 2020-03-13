package anatolii.dao;

import java.util.List;

public interface GenericDAO <T, ID> {

    void save(T t);
    T get(ID id);
    void remove(T t);
    List<T> getAll();
}
