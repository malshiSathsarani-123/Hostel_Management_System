package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.entity.Reservation;

import java.util.List;

public interface ReservationDAO {
    List<String> getRoomId(String typeId);

    boolean save(Reservation reservation);

    String getNextId();

}
