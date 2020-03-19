package anatolii.controller;

import anatolii.model.Client;

import java.util.List;

public interface ClientController {
    void registerClient(String name, String surname, String email, String password);
    void editClientInfo(String oldEmail, String newSurname, String newName);
    void deleteClient(String email, String password);
    void reserveRoom(Long idClient, Long idRoom, String reserveDate);
    void cancelReserveRoom(Long idRoom);
    boolean loginClient(String email, String password);
    List<Client> getAllClient();
    Client getCurrentClient(String email);


}
