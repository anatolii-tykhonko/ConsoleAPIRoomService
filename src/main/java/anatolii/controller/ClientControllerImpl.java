package anatolii.controller;

import anatolii.dao.ClientDAO;
import anatolii.dao.RoomDAO;
import anatolii.exception.ClientAlreadyExist;
import anatolii.exception.IncorrectEmail;
import anatolii.exception.IncorrectPassword;
import anatolii.exception.InvalidRoomStatus;
import anatolii.model.Client;
import anatolii.model.Room;

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
    public void registerClient(String name, String surname, String email, String password) throws ClientAlreadyExist {
        if (!email.equals(clientDAO.getByEmail("email"))) {
            Client client = new Client();
            client.setName(name);
            client.setSurname(surname);
            client.setEmail(email);
            client.setPassword(password);
            clientDAO.save(client);
        } else throw new ClientAlreadyExist("Клиент с таким email уже существует! Повторите ввод!\n");
    }

    @Override
    public void editClientInfo(String oldEmail, String newSurname, String newName) throws IncorrectEmail {
        Client client;
        try {
            client = clientDAO.getByEmail(oldEmail);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectEmail("Клиента с таким email не существует! Повторите ввод!\n");
        }
        client.setSurname(newSurname);
        client.setName(newName);
        clientDAO.update(client);
    }

    @Override
    public void deleteClient(String email, String password) throws IncorrectEmail {
        Client client;
        try {
            client = clientDAO.getByEmail(email);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectEmail("Клиента с таким email не существует! Повторите ввод!\n");
        }
        if (password.equals(client.getPassword())) {
            Long id = client.getId();
            clientDAO.remove(id);
        }
    }

    @Override
    public void reserveRoom(Long idClient, Long idRoom, String reserveDate) throws InvalidRoomStatus {
        Room room = roomDAO.get(idRoom);
        //default value set false
        if(room.getStatus()){
            throw new InvalidRoomStatus("Эта комната сейчас занята.\n");
        }
        LocalDate reserve = room.getAvailableFrom();
        if(reserve.compareTo(LocalDate.parse(reserveDate)) <= 0){
            clientDAO.reserveRoom(idClient, idRoom, LocalDate.parse(reserveDate));
        } else throw new InvalidRoomStatus("На данную дату комната занята.\n");
    }

    @Override
    public void cancelReserveRoom(Long idRoom) {
        clientDAO.cancelReserveRoom(idRoom);
    }

    @Override
    public boolean loginClient(String email, String password) throws IncorrectEmail, IncorrectPassword {
        Client client;
        try {
            client = clientDAO.getByEmail(email);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectEmail("Клиента с таким email не существует! Повторите ввод!\n");
        }
        if (client.getPassword().equals(password)) {
            return true;
        } else throw new IncorrectPassword("Не верный пароль! Повторите ввод!\n");
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clients = clientDAO.getAll();
        return clients;
    }

    @Override
    public Client getCurrentClient(Long id) throws IncorrectEmail {
        Client client;
        try {
            client = clientDAO.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectEmail("Клиента с таким email не существует! Повторите ввод!\n");
        }
        return client;
    }
}
