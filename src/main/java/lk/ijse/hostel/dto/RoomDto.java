package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDto {
    private String roomTypeId;
    private String roomId;
    private String type;
    private Double keyMoney;
    private int qty;
}
