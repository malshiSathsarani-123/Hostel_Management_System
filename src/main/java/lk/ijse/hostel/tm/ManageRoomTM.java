package lk.ijse.hostel.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManageRoomTM {
    private String roomId;
    private String type;
    private Double keyMoney;
    private int qty;
}
