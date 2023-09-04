package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dto.RemainKeyMoneyDto;
import lk.ijse.hostel.entity.Reservation;

import java.util.List;

public interface QueryDAO {
    List<Object[]> getKeyMoneyDetails();

    List<Object[]> getReservationData(String id);
}
