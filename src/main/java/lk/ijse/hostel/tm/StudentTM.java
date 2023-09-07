package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentTM {
    private String StudentId;
    private String name;
    private String address;
    private String contact;
    private LocalDate date;
    private String gender;
}
