package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RemainKeyMoneyTM {
    private Object StudentId;
    private Object roomId;
    private Object type;
    private Object keyMoney;
    private Object balance;
    private Object StartDate;


}
