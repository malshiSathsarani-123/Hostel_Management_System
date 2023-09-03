package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PaymentDetailsDto {

    private String paymentDetailsId;
    private Double KeyMoney;
    private Double payAmount;
    private Double balance;

    private ReservationDto reservationDto;

}
