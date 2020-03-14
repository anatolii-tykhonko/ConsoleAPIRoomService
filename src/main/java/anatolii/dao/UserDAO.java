package anatolii.dao;

import anatolii.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    @Override
    void save(User user);

    @Override
    User get(Long id);

    @Override
    void remove(User user);

    @Override
    List<User> getAll();
}
