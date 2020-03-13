package anatolii.dao;

import anatolii.model.Room;

import java.util.List;

public interface RoomDAO extends GenericDAO <Room, Integer> {
    @Override
    void save(Room room);

    @Override
    Room get(Integer id);

    @Override
    void remove(Room room);

    @Override
    List<Room> getAll();
}
