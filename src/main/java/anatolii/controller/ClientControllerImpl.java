package anatolii.controller;

import anatolii.dao.ClientDAO;
import anatolii.dao.RoomDAO;
import anatolii.model.Client;

import java.time.LocalDate;
import java.util.List;

public class ClientControllerImpl implements ClientController {
    private ClientDAO clientDAO;
    private RoomDAO roomDAO;

    public ClientControllerImpl(ClientDAO clientDAO, RoomDAO roomDAO) {
        this.clientDAO = clientDAO;
        this.roomDAO = roomDAO;
    }

    @Override
    public void registerClient(String name, String surname, String email, String password) {
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPassword(password);
        clientDAO.save(client);
    }

    @Override
    public void editClientInfo(String oldEmail, String newSurname, String newName) {
        Client client = clientDAO.getByEmail(oldEmail);
        client.setName(newName);
        client.setSurname(newSurname);
        clientDAO.update(client);
    }

    @Override
    public void deleteClient(String email, String password) {
        Client client = clientDAO.getByEmail(email);
        if(password.equals(client.getPassword())) {
            Long id = client.getId();
            clientDAO.remove(id);
        }
    }

    @Override
    public void reserveRoom(Long idClient, Long idRoom, String reserveDate) {
        String[] dataString = reserveDate.split(".");
        LocalDate date = LocalDate.of(Integer.parseInt(dataString[2]),
                                        Integer.parseInt(dataString[1]),
                                        Integer.parseInt(dataString[0]));
        clientDAO.reserveRoom(idClient, idRoom, date);
    }

    @Override
    public void cancelReserveRoom(Long idRoom) {
        clientDAO.cancelReserveRoom(idRoom);
    }

    @Override
    public boolean loginClient(String email, String password) {
        Client client = clientDAO.getByEmail(email);
        return password.equals(client.getPassword());
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clients = clientDAO.getAll();
        return clients;
    }

    @Override
    public Client getCurrentClient(String email) {
        Client client = clientDAO.getByEmail(email);
        return client;
    }
}
