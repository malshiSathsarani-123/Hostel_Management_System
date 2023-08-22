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
    private String roomTypeId;
    private String roomId;
    private String type;
    private Double keyMoney;
    private int qty;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> resList = new ArrayList<>();
    public Room() {

    }
}
