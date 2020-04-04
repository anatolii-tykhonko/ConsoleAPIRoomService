package anatolii.apis;

import anatolii.controller.ClientController;
import anatolii.controller.HotelController;
import anatolii.controller.RoomController;
import anatolii.exception.*;
import anatolii.model.Client;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        clientController.deleteClient(email, password);
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
    public Client getCurrentClient(Long id) throws IncorrectEmail {
        return clientController.getCurrentClient(id);
    }

    @Override
    public Hotel getHotelByID(Long id) throws NotFoundEntityForThisCriteria {
        return hotelController.getHotelByID(id);
    }

    @Override
    public void addHotel(String hotelName, String cityName) throws HotelAlreadyExist {
        hotelController.addHotel(hotelName, cityName);
    }

    @Override
    public void editHotelDetails(Long id, String hotelName, String cityName, Room... room) {
        hotelController.editHotelDetails(id, hotelName, cityName, room);
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
    public List<Hotel> getHotels() throws NotFoundEntityForThisCriteria {
        return hotelController.getHotels();
    }

    @Override
    public boolean showHotelList() throws NotFoundEntityForThisCriteria {
        hotelController.getHotels().stream().forEach(System.out::println);
        return true;
    }

    @Override
    public void addRoom(Long hotelID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria, DateParseException {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date);
        }catch (Exception e){
            throw new DateParseException("Неверный формат ввода даты.\n");
        }
        roomController.addRoom(hotelID, person, price, localDate);
    }

    @Override
    public void editRoomDetails(Long roomID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria, DateParseException {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date);
        }catch (Exception e){
            throw new DateParseException("Неверный формат ввода даты.\n");
        }
        roomController.editRoomDetails(roomID, person, price, localDate);
    }

    @Override
    public void deleteRoom(Long id) {
        roomController.deleteRoom(id);
    }

    @Override
    public List<Hotel> findRoomByHotel(String hotelName) throws NotFoundEntityForThisCriteria {
        return roomController.findRoomByHotel(hotelName);
    }

    @Override
    public boolean showRoomList(Hotel hotel) throws NotFoundEntityForThisCriteria {
        if(hotel.getRoomList().isEmpty()){
            throw new NotFoundEntityForThisCriteria("В отеле отсутствуют комнаты.\n");
        }
        hotel.getRoomList().stream().forEach(System.out::println);
        return true;
    }

    public void validLine(String line) throws ValidStringNameException {
        String param = "\\W";
        Pattern pattern = Pattern.compile(param);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            throw new ValidStringNameException("Название не должно включать цифры или символы!!!\nВведите данные заново!\n");
        }
    }
}
