package anatolii.dao;

import anatolii.model.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Integer> {
    @Override
    void save(Hotel hotel);

    @Override
    Hotel get(Integer id);

    @Override
    void remove(Hotel hotel);

    @Override
    List<Hotel> getAll();
}
