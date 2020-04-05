package anatolii.controller;

import anatolii.dao.HotelDAO;
import anatolii.dao.RoomDAO;
import anatolii.exception.NotFoundEntityForThisCriteria;
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
    public void addRoom(Long hotelId, Integer person, BigDecimal price, LocalDate date) throws NotFoundEntityForThisCriteria {
        Room room = new Room();
        try {
            room.setHotel(hotelDAO.get(hotelId));
        } catch (IndexOutOfBoundsException e){
            throw new NotFoundEntityForThisCriteria("Отель отсутствует в списке.\n");
        }
        room.setPersons(person);
        room.setPrice(price);
        room.setAvailableFrom(date);
        roomDAO.save(room);
    }

    @Override
    public void editRoomDetails(Long roomId, Integer person, BigDecimal price, LocalDate date) throws NotFoundEntityForThisCriteria {
        Room room = roomDAO.get(roomId);
        if(room == null){
            throw new NotFoundEntityForThisCriteria("Комната с даным ID отсутствует в списке.\n");
        }
        room.setPersons(person);
        room.setPrice(price);
        room.setAvailableFrom(date);
        roomDAO.update(room);
    }

    @Override
    public void deleteRoom(Long id) throws NotFoundEntityForThisCriteria {
        try {
            Room room = roomDAO.get(id);
            if(room == null){
                throw new NotFoundEntityForThisCriteria("Комната с даным ID отсутствует в списке.\n");
            }
        } catch (Exception e){
            throw new NotFoundEntityForThisCriteria("Комната с даным ID отсутствует в списке.\n");
        }
        roomDAO.remove(id);
    }

    @Override
    public List<Hotel> findRoomByHotel(String hotelName) throws NotFoundEntityForThisCriteria {
        List<Hotel> hotelList;
        try {
            hotelList = hotelDAO.findHotelByName(hotelName);
        } catch (IndexOutOfBoundsException e){
            throw new NotFoundEntityForThisCriteria("Отель с таким названием отсутствует в списке.\n");
        }
        if(hotelList.isEmpty()){
            throw new NotFoundEntityForThisCriteria("В даном отеле свободные комнаты отсутствуют.\n");
        } else System.out.println("По Вашему запросу найдены следующие комнаты: ");
        return hotelList;
    }
}
