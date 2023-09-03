package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.entity.PaymentDetails;

public interface PaymentDAO {
    String getNextId();

    boolean savePayment(PaymentDetails paymentDetails);
}
