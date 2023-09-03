package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.PaymentDAO;
import lk.ijse.hostel.entity.PaymentDetails;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public String getNextId() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("select paymentDetailsId FROM PaymentDetails order by paymentDetailsId desc limit 1");
        String currentId = String.valueOf(query.uniqueResult());
        transaction.commit();
        session.close();
        return nextId(currentId);
    }

    @Override
    public boolean savePayment(PaymentDetails paymentDetails) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(paymentDetails);
        transaction.commit();
        session.close();
        return true;
    }

    private String nextId(String currentId) {
        if (currentId != null){
            String[] strings = currentId.split("0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "P0"+id;
        }
        return "P01";
    }
}
