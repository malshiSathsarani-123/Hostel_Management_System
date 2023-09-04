package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RemainKeyMoneyDto {
    private Object StudentId;
    private String roomId;
    private String type;
    private Double keyMoney;
    private Double balance;
    private LocalDate StartDate;
}
