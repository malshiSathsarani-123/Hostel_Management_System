package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.RemainingKeyMoneyBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.custom.PaymentDAO;
import lk.ijse.hostel.dao.custom.QueryDAO;
import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.hostel.dao.custom.impl.QueryDAOImpl;
import lk.ijse.hostel.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel.entity.PaymentDetails;

import java.util.List;

public class RemainingKeyMoneyBOImpl implements RemainingKeyMoneyBO {

    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);


    @Override
    public List<Object[]> getAll() {
        return queryDAO.getKeyMoneyDetails();
    }

    @Override
    public String getName(String id) {
        return studentDAO.getName(id);
    }

    @Override
    public List<String> getStudentId() {
        return studentDAO.getIdsReserved();
    }

    @Override
    public List<Object[]> getAll(String id) {
        return queryDAO.getReservationData(id);
    }

    @Override
    public boolean updatePayment(PaymentDetails paymentDetails) {
        return paymentDAO.updatePaymet(paymentDetails);
    }

    @Override
    public String getReservationId(String id) {
        return studentDAO.getReservationId(id);
    }
}
