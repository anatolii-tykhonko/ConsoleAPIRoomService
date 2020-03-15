package anatolii.dao;

import anatolii.model.Client;

import java.util.List;

public interface ClientDAO extends GenericDAO<Client, Long> {
    @Override
    void save(Client client);

    @Override
    Client get(Long id);

    @Override
    void remove(Long id);

    @Override
    void update(Client client);

    @Override
    List<Client> getAll();
}
