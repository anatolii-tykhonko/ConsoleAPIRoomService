package anatolii.apis;

import anatolii.controller.ClientController;
import anatolii.controller.HotelController;
import anatolii.controller.RoomController;
import anatolii.exception.*;
import anatolii.model.Client;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.math.BigDecimal;
import java.util.List;

public class Application implements API {

    private ClientController clientController;
    private HotelController hotelController;
    private RoomController roomController;

    public Application(ClientController clientController, HotelController hotelController, RoomController roomController) {
        this.clientController = clientController;
        this.hotelController = hotelController;
        this.roomController = roomController;
    }

    @Override
    public void registerClient(String name, String surname, String email, String password) throws ClientAlreadyExist {
        clientController.registerClient(name, surname, email, password);
    }

    @Override
    public void editClientInfo(String oldEmail, String newSurname, String newName) throws IncorrectEmail {
        clientController.editClientInfo(oldEmail, newSurname, newName);
    }

    @Override
    public void deleteClient(String email, String password) throws IncorrectEmail {
        clientController.deleteClient(email,password);
    }

    @Override
    public void reserveRoom(Long idClient, Long idRoom, String reserveDate) throws InvalidRoomStatus {
        clientController.reserveRoom(idClient, idRoom, reserveDate);
    }

    @Override
    public void cancelReserveRoom(Long idRoom) {
        clientController.cancelReserveRoom(idRoom);
    }

    @Override
    public boolean loginClient(String email, String password) throws IncorrectEmail, IncorrectPassword {
        return clientController.loginClient(email, password);
    }

    @Override
    public List<Client> getAllClient() {
        return clientController.getAllClient();
    }

    @Override
    public Client getCurrentClient(String email) throws IncorrectEmail {
        return clientController.getCurrentClient(email);
    }

    @Override
    public void addHotel(String hotelName, String cityName) throws HotelAlreadyExist {
        hotelController.addHotel(hotelName, cityName);
    }

    @Override
    public void editHotelDetails(Long id, String hotelName, String cityName, Room... room) {
        hotelController.editHotelDetails(id, hotelName, cityName,room);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelController.deleteHotel(id);
    }

    @Override
    public List<Hotel> findHotelByName(String hotelName) throws NotFoundEntityForThisCriteria {
        return hotelController.findHotelByName(hotelName);
    }

    @Override
    public List<Hotel> findHotelByCity(String cityName) throws NotFoundEntityForThisCriteria {
        return hotelController.findHotelByCity(cityName);
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelController.getHotels();
    }

    @Override
    public void addRoom(Long hotelID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria {
        roomController.addRoom(hotelID, person, price, date);
    }

    @Override
    public void editRoomDetails(Long roomID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria {
        roomController.editRoomDetails(roomID, person, price, date);
    }

    @Override
    public void deleteRoom(Long id) {
        roomController.deleteRoom(id);
    }

    @Override
    public List<Hotel> findRoomByHotel(String hotelName) throws NotFoundEntityForThisCriteria {
        return roomController.findRoomByHotel(hotelName);
    }
}
