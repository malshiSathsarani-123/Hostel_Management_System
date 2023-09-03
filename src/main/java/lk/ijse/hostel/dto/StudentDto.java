package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class StudentDto {
    private String StudentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate date;
    private String gender;

}
