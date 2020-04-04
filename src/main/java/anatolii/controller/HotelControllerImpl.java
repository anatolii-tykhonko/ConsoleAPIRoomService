package anatolii.controller;

import anatolii.dao.HotelDAO;
import anatolii.exception.HotelAlreadyExist;
import anatolii.exception.NotFoundEntityForThisCriteria;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HotelControllerImpl implements HotelController {

    private HotelDAO hotelDAO;

    public HotelControllerImpl(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Override
    public Hotel getHotelByID(Long id) throws NotFoundEntityForThisCriteria {
        Hotel hotel = hotelDAO.get(id);
        if(hotel == null){
            throw new NotFoundEntityForThisCriteria("Вы ввели неверный номер отеля.\n");
        }
        return hotel;
    }

    @Override
    public void addHotel(String hotelName, String cityName) throws HotelAlreadyExist {
        List<Hotel> hotels = hotelDAO.findHotelByName(hotelName).stream().
                filter(hotel -> hotel.getCityName().equals(cityName)).collect(Collectors.toList());
        if(!hotels.isEmpty()){
            throw new HotelAlreadyExist("Отель с таким названием отствует в даном городе.\n");
        }
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
    public List<Hotel> findHotelByName(String hotelName) throws NotFoundEntityForThisCriteria {
        List<Hotel> hotels = hotelDAO.findHotelByName(hotelName);
        if(hotels.isEmpty()){
            throw new NotFoundEntityForThisCriteria("По Вашему запросу найдены отели не найдены.\n");
        } else System.out.println("По Вашему запросу найдены следующие отели: ");
        return hotels;
    }

    @Override
    public List<Hotel> findHotelByCity(String cityName) throws NotFoundEntityForThisCriteria {
        List<Hotel> hotels = hotelDAO.findHotelByCity(cityName);
        if(hotels.isEmpty()){
            throw new NotFoundEntityForThisCriteria("По Вашему запросу найдены отели не найдены.\n");
        } else System.out.println("По Вашему запросу найдены следующие отели: ");
        return hotels;
    }

    @Override
    public List<Hotel> getHotels() throws NotFoundEntityForThisCriteria {
        List<Hotel> hotels = hotelDAO.getAll();
        if(hotels.isEmpty()){
            throw new NotFoundEntityForThisCriteria("Отели отсутствуют в базе.\n");
        }
        return hotels;
    }
}
