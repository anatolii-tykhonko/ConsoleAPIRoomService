package anatolii.controller;

import anatolii.exception.NotFoundEntityForThisCriteria;
import anatolii.model.Hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RoomController {
    void addRoom(String hotelName, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria;
    void editRoomDetails(Long roomID, String hotelName, Integer person, BigDecimal price, String date) throws NotFoundEntityForThisCriteria;
    void deleteRoom(Long id);
    List<Hotel> findRoomByHotel(String hotelName) throws NotFoundEntityForThisCriteria;
}
