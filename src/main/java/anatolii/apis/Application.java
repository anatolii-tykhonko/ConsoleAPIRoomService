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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application implements API {
    private Client currentClient;
    private ClientController clientController;
    private HotelController hotelController;
    private RoomController roomController;

    public Application(ClientController clientController, HotelController hotelController, RoomController roomController) {
        this.clientController = clientController;
        this.hotelController = hotelController;
        this.roomController = roomController;
    }

    @Override
    public Client getClientById(Long id) throws IncorrectEmail {
        return clientController.getClientById(id);
    }

    @Override
    public void registerClient(String name, String surname, String email, String password) throws ClientAlreadyExist {
        clientController.registerClient(name, surname, email, password);
        currentClient = clientController.getAllClient().stream().filter(email::equals).findFirst().get();
    }

    @Override
    public void editClientInfo(String oldEmail, String newSurname, String newName) throws IncorrectEmail {
        clientController.editClientInfo(oldEmail, newSurname, newName);
    }

    @Override
    public void deleteClient(String email) throws IncorrectEmail {
        clientController.deleteClient(email);
    }

    @Override
    public void reserveRoom(Long idClient, Long idRoom, String reserveDate) throws InvalidRoomStatus, DateParseException {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(reserveDate);
        }catch (Exception e){
            throw new DateParseException("Неверный формат ввода даты.\n");
        }
        clientController.reserveRoom(idClient, idRoom, localDate);
    }

    @Override
    public boolean cancelReserveRoom(Long idRoom) {
        clientController.cancelReserveRoom(idRoom);
        return true;
    }

    @Override
    public boolean loginClient(String email, String password) throws IncorrectEmail, IncorrectPassword {
        boolean resultLogin = clientController.loginClient(email, password);
        currentClient = clientController.getAllClient().stream().filter(email::equals).findFirst().get();
        return resultLogin;
    }

    @Override
    public List<Client> getAllClient() {
        return clientController.getAllClient();
    }

    @Override
    public Client getCurrentClient() {
        return currentClient;
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

    @Override
    public void showCityNames() throws NotFoundEntityForThisCriteria {
        Set<String> allCity = new HashSet<>();
        hotelController.getHotels().stream().forEach(hotel -> allCity.add(hotel.getCityName()));
        allCity.forEach(System.out::println);
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
