package lk.ijse.hostel.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(Double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Reservation> getResList() {
        return resList;
    }

    public void setResList(List<Reservation> resList) {
        this.resList = resList;
    }
}
