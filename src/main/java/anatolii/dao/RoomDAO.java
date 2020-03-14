package anatolii.dao;

import anatolii.model.Room;

import java.util.List;

public interface RoomDAO extends GenericDAO <Room, Long> {
    @Override
    void save(Room room);

    @Override
    Room get(Long id);

    @Override
    void remove(Room room);

    @Override
    List<Room> getAll();
}
