package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.ReservationDAO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public String getNextId() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("SELECT reservationId FROM Reservation ORDER BY reservationId DESC LIMIT 1");
        String currentId = String.valueOf(query.uniqueResult());
        transaction.commit();
        session.close();
        return nextId(currentId);
    }

    private String nextId(String currentId) {
        if (currentId != null){
            String[] strings = currentId.split("R");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "R"+id;
        }
        return "O001";
    }

    @Override
    public List<String> getRoomId(String typeId) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("select roomId from Room where roomTypeId=?1");
        query.setParameter(1,typeId);
        List<String> ids = query.list();
        transaction.commit();
        session.close();
        return ids;
    }

    @Override
    public boolean save(Reservation reservation) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(reservation);
        transaction.commit();
        session.close();
        return true;
    }
}