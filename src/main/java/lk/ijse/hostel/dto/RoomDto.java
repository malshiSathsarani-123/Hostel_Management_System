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
    private String status;

    public RoomDto(String id) {
        this.roomId=id;
    }

    public RoomDto(String roomTypeId, String roomId, String type, Double keyMoney, int qty) {
        this.roomTypeId = roomTypeId;
        this.roomId = roomId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public RoomDto(String roomId, String reserved) {
        this.roomId=roomId;
        this.status=reserved;
    }
}
