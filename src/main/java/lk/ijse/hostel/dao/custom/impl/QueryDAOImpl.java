package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.QueryDAO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<Object[]> getReservationData(String id) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        NativeQuery query= session.createNativeQuery("select Reservation.studentId, Reservation.roomId, Reservation.roomTypeId, PaymentDetails.KeyMoney, PaymentDetails.balance, Reservation.StartDate   from PaymentDetails inner join Reservation on Reservation.reservationId = PaymentDetails.reservationId");
        List<Object[]> list= query.list();
        transaction.commit();
        session.close();

        return list;
    }
    @Override
    public List<Object[]> getKeyMoneyDetails() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        NativeQuery query= session.createNativeQuery("select Reservation.studentId, Reservation.roomId, Reservation.roomTypeId, PaymentDetails.KeyMoney, PaymentDetails.balance, Reservation.StartDate   from PaymentDetails inner join Reservation on Reservation.studentId= PaymentDetails.paymentDetailsId");
        List<Object[]> list= query.list();
        transaction.commit();
        session.close();

        return list;

        //        NativeQuery query= session.createNativeQuery("select * from Customer");
//        query.addEntity(Customer.class);
//        List<Customer> list= query.list();
//        for (Customer customers : list) {
//            System.out.println(customers);
//        }

        //        Query query=session.createQuery("select a.aid,a.name from Address a inner join Customer c on a.aid = c.cid");
//        List<Object[]> list= query.list();
//        for (Object[] objects : list) {
//            System.out.println(objects[0]+" - "+objects[1]);
//        }
    }

}
