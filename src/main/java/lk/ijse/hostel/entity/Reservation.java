package lk.ijse.hostel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
public class Reservation {
    @Id
    private String reservationId;
    private Date date;
    private String studentId;
    private String roomTypeId;
    private String roomId;
    private String status;

    public Reservation() {

    }
    @ManyToOne
    private Room room;

    @ManyToOne
    private Student student;
}
