package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class StudentDto {
    private String StudentId;
    private String name;
    private String address;
    private String contact;
    private Date date;
    private String gender;
}
