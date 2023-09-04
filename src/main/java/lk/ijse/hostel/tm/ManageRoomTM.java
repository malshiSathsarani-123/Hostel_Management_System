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

    public ManageRoomTM(String roomId, String type, int qty) {
        this.roomId = roomId;
        this.type = type;
        this.qty = qty;
    }
}
