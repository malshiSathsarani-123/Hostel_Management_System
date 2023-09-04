package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.dto.RoomDto;

import java.util.List;

public interface ReservationDetailsBO {
    List<RoomDto> getAll();
    List<RoomDto> getAllReserved();
}
