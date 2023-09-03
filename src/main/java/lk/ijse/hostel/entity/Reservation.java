package lk.ijse.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Reservation {
    @Id
    private String reservationId;
    private LocalDate StartDate;
    private LocalDate endDate;
    private String roomTypeId;

    public Reservation() {

    }
    @ManyToOne
    @JoinColumn(name = "RoomId")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "StudentId")
    private Student student;

    public Reservation(String reservationId) {
        this.reservationId = reservationId;
    }
}
