package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.dto.RoomDto;

import java.util.List;

public interface ManageRoomBO {
    boolean save(RoomDto roomDto);

    boolean update(RoomDto roomDto);

    boolean delete(RoomDto roomDto);

    RoomDto search(String text);

    List<RoomDto> getAll();
}
