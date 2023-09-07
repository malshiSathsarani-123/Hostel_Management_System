package lk.ijse.hostel.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Room {
    @Id
    private String roomId;
    private String roomTypeId;
    private String type;
    private Double keyMoney;
    private int qty;
    private String  status;

    @OneToMany(targetEntity = Reservation.class, mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> resList = new ArrayList<>();
    public Room() {

    }

    public Room(String roomTypeId, String roomId, String type, Double keyMoney, int qty,String status) {
        this.roomTypeId = roomTypeId;
        this.roomId = roomId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
        this.status=status;
    }

    public Room(String roomId) {
        this.roomId = roomId;
    }

    public Room(String roomTypeId, String roomId, String type, Double keyMoney, int qty) {
        this.roomTypeId = roomTypeId;
        this.roomId = roomId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

}
