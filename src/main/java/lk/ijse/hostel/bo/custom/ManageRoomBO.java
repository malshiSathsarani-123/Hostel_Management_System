package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.dto.RoomDto;

import java.sql.SQLException;
import java.util.List;

public interface ManageRoomBO {
    boolean save(RoomDto roomDto);

    boolean update(RoomDto roomDto);

    boolean delete(String id) throws SQLException;

    RoomDto search(String text);

    List<RoomDto> getAll();
}
