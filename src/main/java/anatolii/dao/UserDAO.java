package anatolii.dao;

import anatolii.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Integer> {
    @Override
    void save(User user);

    @Override
    User get(Integer id);

    @Override
    void remove(User user);

    @Override
    List<User> getAll();
}
