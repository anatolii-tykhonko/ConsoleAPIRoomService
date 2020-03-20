package anatolii.controller;

import anatolii.dao.HotelDAO;
import anatolii.dao.RoomDAO;
import anatolii.dao.hibernate.HibernateHotelDAOImpl;
import anatolii.dao.hibernate.HibernateRoomDAOImpl;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RoomControllerImpl implements RoomController {
    private RoomDAO roomDAO;
    private HotelDAO hotelDAO;

    public RoomControllerImpl(RoomDAO roomDAo, HotelDAO hotelDAO){
        this.roomDAO = roomDAo;
        this.hotelDAO = hotelDAO;
    }
    @Override
    public void addRoom(String hotelName, Integer person, BigDecimal price, String date) {
        Room room = new Room();
        room.setHotel(hotelDAO.findHotelByName(hotelName).get(0));
        room.setPersons(person);
        room.setPrice(price);
        room.setAvailableFrom(LocalDate.parse(date));
        roomDAO.save(room);

    }

    @Override
    public void editRoomDetails(Long roomId, String hotelName, Integer person, BigDecimal price, String date) {
        Room room = roomDAO.get(roomId);
        room.setHotel(hotelDAO.findHotelByName(hotelName).get(0));
        room.setPersons(person);
        room.setPrice(price);
        room.setAvailableFrom(LocalDate.parse(date));
        roomDAO.update(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomDAO.remove(id);
    }

    @Override
    public List<Hotel> findRoomByHotel(String hotelName) {
        List<Hotel> hotelList = hotelDAO.findHotelByName(hotelName);
        return hotelList;
    }
}
