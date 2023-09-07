package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.ReservationDetailsBO;
import lk.ijse.hostel.dao.custom.ReservationDAO;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.hostel.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel.dto.ReservationDto;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.dto.StudentDto;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDetailsBOImpl implements ReservationDetailsBO {
    RoomDAO roomDAO = new RoomDAOImpl();
    ReservationDAO reservationDAO = new ReservationDAOImpl();
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

    @Override
    public ReservationDto searchStudent(String id) {
        Reservation reservation = reservationDAO.search(id);
        StudentDto studentDto = new StudentDto(reservation.getStudent().getStudentId(), reservation.getStudent().getName(), reservation.getStudent().getAddress(), reservation.getStudent().getContact(), reservation.getStudent().getDate(), reservation.getStudent().getGender(),reservation.getStudent().getStatus());
        return new ReservationDto(reservation.getStartDate(),reservation.getEndDate(),studentDto);
    }
}
