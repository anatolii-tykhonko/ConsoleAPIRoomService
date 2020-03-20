package anatolii.controller;

import anatolii.exception.HotelAlreadyExist;
import anatolii.exception.NotFoundEntityForThisCriteria;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.util.List;

public interface HotelController {
    void addHotel(String hotelName, String cityName) throws HotelAlreadyExist;
    void editHotelDetails(Long id, String hotelName, String cityName, Room ... room);
    void deleteHotel(Long id);
    List<Hotel> findHotelByName(String hotelName) throws NotFoundEntityForThisCriteria;
    List<Hotel> findHotelByCity(String cityName) throws NotFoundEntityForThisCriteria;
    List<Hotel> getHotels();

}
