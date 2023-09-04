package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.entity.Room;

import java.util.List;

public interface RoomDAO {
    boolean save(Room room);

    boolean update(Room room);

    boolean delete(Room room);

    Room search(String id);

    List<Room> getAll();

    boolean updateStatus(Room room);

    List<Room> getAllAvailable();

    List<Room> getAllReserved();
}
