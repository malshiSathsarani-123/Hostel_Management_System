package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationDto {
    private String reservationId;
    private LocalDate StartDate;
    private LocalDate endDate;
    private String roomTypeId;

    private RoomDto roomDto;
    private StudentDto studentDto;

}
