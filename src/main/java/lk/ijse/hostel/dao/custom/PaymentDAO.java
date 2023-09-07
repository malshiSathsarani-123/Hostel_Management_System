package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SuperDAO;
import lk.ijse.hostel.entity.PaymentDetails;

public interface PaymentDAO extends SuperDAO {
    String getNextId();

    boolean savePayment(PaymentDetails paymentDetails);

    boolean updatePaymet(PaymentDetails paymentDetails);
}
