package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.entity.PaymentDetails;

import java.util.List;

public interface RemainingKeyMoneyBO {
    List<Object[]> getAll();

    String getName(String id);

    List<String> getStudentId();

    List<Object[]> getAll(String id);

    boolean updatePayment(PaymentDetails paymentDetails);

    String getReservationId(String id);
}
