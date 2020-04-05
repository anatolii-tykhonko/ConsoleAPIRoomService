package anatolii.controller;

import anatolii.exception.NotFoundEntityForThisCriteria;
import anatolii.model.Hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RoomController {
    void addRoom(Long hotelID, Integer person, BigDecimal price, LocalDate date) throws NotFoundEntityForThisCriteria;
    void editRoomDetails(Long roomID, Integer person, BigDecimal price, LocalDate date) throws NotFoundEntityForThisCriteria;
    void deleteRoom(Long id) throws NotFoundEntityForThisCriteria;
    List<Hotel> findRoomByHotel(String hotelName) throws NotFoundEntityForThisCriteria;
}
