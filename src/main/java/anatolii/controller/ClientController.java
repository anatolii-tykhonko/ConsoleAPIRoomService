package anatolii.controller;

import anatolii.exception.ClientAlreadyExist;
import anatolii.exception.IncorrectEmail;
import anatolii.exception.IncorrectPassword;
import anatolii.exception.InvalidRoomStatus;
import anatolii.model.Client;

import java.time.LocalDate;
import java.util.List;

public interface ClientController {
    void registerClient(String name, String surname, String email, String password) throws ClientAlreadyExist;
    void editClientInfo(String oldEmail, String newSurname, String newName) throws IncorrectEmail;
    void deleteClient(String email) throws IncorrectEmail;
    void reserveRoom(Long idClient, Long idRoom, LocalDate reserveDate) throws InvalidRoomStatus;
    void cancelReserveRoom(Long idRoom);
    boolean loginClient(String email, String password) throws IncorrectEmail, IncorrectPassword;
    List<Client> getAllClient();
    Client getClientById(Long id) throws IncorrectEmail;


}
