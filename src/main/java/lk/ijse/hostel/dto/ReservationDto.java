package lk.ijse.hostel.dto;

import lk.ijse.hostel.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationDto {
    private String reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String roomTypeId;

    private RoomDto roomDto;
    private StudentDto studentDto;

    public ReservationDto(LocalDate startDate, LocalDate endDate, StudentDto studentDto) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentDto = studentDto;
    }
}
