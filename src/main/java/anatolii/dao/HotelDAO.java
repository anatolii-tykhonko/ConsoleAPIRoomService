package anatolii.dao;

import anatolii.model.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Long> {
    @Override
    void save(Hotel hotel);

    @Override
    Hotel get(Long id);

    @Override
    void remove(Long idl);

    @Override
    void update(Hotel hotel);

    @Override
    List<Hotel> getAll();

    List<Hotel> findHotelByName(String hotelName);

    List<Hotel> findHotelByCity(String cityName);
}
