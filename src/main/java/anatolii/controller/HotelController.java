package anatolii.controller;

import anatolii.model.Hotel;
import anatolii.model.Room;

import java.util.List;

public interface HotelController {
    void addHotel(String hotelName, String cityName);
    void editHotelDetails(Long id, String hotelName, String cityName, Room ... room);
    void deleteHotel(Long id);
    List<Hotel> findHotelByName(String hotelName);
    List<Hotel> findHotelByCity(String citylName);
    List<Hotel> getHotels();

}
