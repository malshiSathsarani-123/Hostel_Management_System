package lk.ijse.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
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

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
