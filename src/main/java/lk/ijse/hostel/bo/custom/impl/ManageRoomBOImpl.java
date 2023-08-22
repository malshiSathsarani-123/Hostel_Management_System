package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.ManageRoomBO;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ManageRoomBOImpl implements ManageRoomBO {
    RoomDAO roomDAO = new RoomDAOImpl();
    @Override
    public boolean save(RoomDto roomDto) {
        return roomDAO.save(new Room(roomDto.getRoomTypeId(),roomDto.getRoomId(),roomDto.getType(),roomDto.getKeyMoney(),roomDto.getQty()));
    }

    @Override
    public boolean update(RoomDto roomDto) {
        return roomDAO.update(new Room(roomDto.getRoomTypeId(),roomDto.getRoomId(),roomDto.getType(),roomDto.getKeyMoney(),roomDto.getQty()));
    }

    @Override
    public boolean delete(RoomDto roomDto) {
        return roomDAO.delete(new Room(roomDto.getRoomTypeId(),roomDto.getRoomId(),roomDto.getType(),roomDto.getKeyMoney(),roomDto.getQty()));
    }

    @Override
    public RoomDto search(String id) {
        Room room = roomDAO.search(id);
        return new RoomDto(room.getRoomTypeId(),room.getRoomId(),room.getType(),room.getKeyMoney(),room.getQty());
    }

    @Override
    public List<RoomDto> getAll() {
        List<RoomDto>roomDtoList = new ArrayList<>();
        List<Room>roomList = roomDAO.getAll();
        for (Room room : roomList){
            roomDtoList.add(new RoomDto(room.getRoomTypeId(),room.getRoomId(),room.getType(),room.getKeyMoney(),room.getQty()));
        }
        return roomDtoList;
    }
}
