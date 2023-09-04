package lk.ijse.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentDetails {
    @Id
    private String paymentDetailsId;
    private Double KeyMoney;
    private Double balance;
    private Double payAmount;


    @OneToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

}
