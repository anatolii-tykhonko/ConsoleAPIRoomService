package anatolii.apis;

import anatolii.exception.*;
import anatolii.model.Client;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.math.BigDecimal;
import java.util.List;

public interface API {
    void registerClient(String name, String surname, String email, String password) throws ClientAlreadyExist;

    void editClientInfo(String oldEmail, String newSurname, String newName) throws IncorrectEmail;

    void deleteClient(String email, String password) throws IncorrectEmail;

    void reserveRoom(Long idClient, Long idRoom, String reserveDate) throws InvalidRoomStatus;

    void cancelReserveRoom(Long idRoom);

    boolean loginClient(String email, String password) throws IncorrectEmail, IncorrectPassword;

    List<Client> getAllClient();

    Client getCurrentClient(String email) throws IncorrectEmail;

    void addHotel(String hotelName, String cityName) throws HotelAlreadyExist;

    void editHotelDetails(Long id, String hotelName, String cityName, Room... room);

    void deleteHotel(Long id);

    List<Hotel> findHotelByName(String hotelName) throws NotFoundEntityForThisCriteria;

    List<Hotel> findHotelByCity(String cityName) throws NotFoundEntityForThisCriteria;

    List<Hotel> getHotels();

    void addRoom(Long hotelID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria;

    void editRoomDetails(Long roomID, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria;

    void deleteRoom(Long id);

    List<Hotel> findRoomByHotel(String hotelName) throws NotFoundEntityForThisCriteria;

}
