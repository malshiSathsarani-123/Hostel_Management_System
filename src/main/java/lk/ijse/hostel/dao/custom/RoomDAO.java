package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SuperDAO;
import lk.ijse.hostel.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends SuperDAO {
    boolean save(Room room);

    boolean update(Room room);

    boolean delete(String id) throws SQLException;

    Room search(String id);

    List<Room> getAll();

    boolean updateStatus(Room room);

    List<Room> getAllAvailable();

    List<Room> getAllReserved();
}
