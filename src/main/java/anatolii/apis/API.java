package anatolii.apis;

import anatolii.exception.*;
import anatolii.model.Client;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.math.BigDecimal;
import java.util.List;

public interface API {

    Client getClientById(Long id) throws IncorrectEmail;

    void registerClient(String name, String surname, String email, String password) throws ClientAlreadyExist;

    void editClientInfo(String oldEmail, String newSurname, String newName) throws IncorrectEmail;

    void deleteClient(String email) throws IncorrectEmail;

    void reserveRoom(Long idClient, Long idRoom, String reserveDate) throws InvalidRoomStatus, DateParseException;

    boolean cancelReserveRoom(Long idRoom);

    boolean loginClient(String email, String password) throws IncorrectEmail, IncorrectPassword;

    List<Client> getAllClient();

    Client getCurrentClient();

    Hotel getHotelByID(Long id) throws NotFoundEntityForThisCriteria;

    void addHotel(String hotelName, String cityName) throws HotelAlreadyExist;

    void editHotelDetails(Long id, String hotelName, String cityName);

    void deleteHotel(Long id);

    List<Hotel> findHotelByName(String hotelName) throws NotFoundEntityForThisCriteria;

    List<Hotel> findHotelByCity(String cityName) throws NotFoundEntityForThisCriteria;

    List<Hotel> getHotels() throws NotFoundEntityForThisCriteria;

    boolean showHotelList() throws NotFoundEntityForThisCriteria;

    void addRoom(Long hotelID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria, DateParseException;

    void editRoomDetails(Long roomID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria, DateParseException;

    void deleteRoom(Long id) throws NotFoundEntityForThisCriteria;

    List<Hotel> findRoomByHotel(String hotelName) throws NotFoundEntityForThisCriteria;

    boolean showRoomList(Hotel hotel) throws NotFoundEntityForThisCriteria;

    void showCityNames() throws NotFoundEntityForThisCriteria;


}
