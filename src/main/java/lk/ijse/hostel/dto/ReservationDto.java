package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ReservationDto {
    private String reservationId;
    private Date date;
    private String studentId;
    private String roomTypeId;
    private String roomId;
    private String status;
}
