package anatolii.controller;

import anatolii.dao.HotelDAO;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HotelControllerImpl implements HotelController {

    private HotelDAO hotelDAO;

    public HotelControllerImpl(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Override
    public void addHotel(String hotelName, String cityName) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setCityName(cityName);
        hotelDAO.save(hotel);
    }

    @Override
    public void editHotelDetails(Long id, String hotelName, String cityName, Room ... room) {
        Hotel hotel = hotelDAO.get(id);
        if (room.length != 0) {
            Set<Room> rooms = new HashSet<>();
            for (int i = 0; i < room.length; i++) {
                rooms.add(room[i]);
            }
            hotel.setRoomList(rooms);
        }
        hotel.setHotelName(hotelName);
        hotel.setCityName(cityName);
        hotelDAO.update(hotel);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelDAO.remove(id);
    }

    @Override
    public List<Hotel> findHotelByName(String hotelName) {
        List<Hotel> hotels = hotelDAO.findHotelByName(hotelName);
        return hotels;
    }

    @Override
    public List<Hotel> findHotelByCity(String cityName) {
        List<Hotel> hotels = hotelDAO.findHotelByCity(cityName);
        return hotels;
    }

    @Override
    public List<Hotel> getHotels() {
        List<Hotel> hotels = hotelDAO.getAll();
        return hotels;
    }
}
