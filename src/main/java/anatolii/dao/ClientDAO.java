package anatolii.dao;

import anatolii.model.Client;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ClientDAO extends GenericDAO<Client, Long> {
    @Override
    void save(Client client);

    @Override
    Client get(Long id);

    Client getByEmail(String email);

    @Override
    void remove(Long id);

    @Override
    void update(Client client);

    @Override
    List<Client> getAll();

    void reserveRoom(Long idClient, Long idRoom, LocalDate dateReserve);

    void cancelReserveRoom(Long idRoom);
}
