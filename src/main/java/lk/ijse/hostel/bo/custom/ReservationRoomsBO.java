package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.dto.PaymentDetailsDto;
import lk.ijse.hostel.dto.ReservationDto;
import lk.ijse.hostel.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface ReservationRoomsBO {
    List<String> getRoomId(String selectedItem);

    String getNextId();

    String getNextPaymentId();

    boolean reservedRoomWithPayment(StudentDto studentDto, ReservationDto reservationDto, PaymentDetailsDto paymentDetailsDto);
}
