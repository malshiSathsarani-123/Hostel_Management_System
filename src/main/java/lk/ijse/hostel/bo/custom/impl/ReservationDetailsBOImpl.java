package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.ReservationDetailsBO;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ReservationDetailsBOImpl implements ReservationDetailsBO {
    RoomDAO roomDAO = new RoomDAOImpl();
    @Override
    public List<RoomDto> getAll() {
        List<RoomDto>roomDtoList = new ArrayList<>();
        List<Room>roomList = roomDAO.getAllAvailable();
        for (Room room : roomList){
            roomDtoList.add(new RoomDto(room.getRoomTypeId(),room.getRoomId(),room.getType(),room.getKeyMoney(),room.getQty(),room.getStatus()));
        }
        return roomDtoList;
    }

    @Override
    public List<RoomDto> getAllReserved() {
        List<RoomDto>roomDtoList = new ArrayList<>();
        List<Room>roomList = roomDAO.getAllReserved();
        for (Room room : roomList){
            roomDtoList.add(new RoomDto(room.getRoomTypeId(),room.getRoomId(),room.getType(),room.getKeyMoney(),room.getQty(),room.getStatus()));
        }
        return roomDtoList;
    }
}
