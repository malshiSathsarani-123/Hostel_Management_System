package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room room) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(room);
        transaction.commit();
        session.close();

        return true;

    }

    @Override
    public boolean update(Room room) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.update(room);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(Room room) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.remove(room);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Room search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Room where roomId=?1");
        query.setParameter(1,id);
        Room room = (Room) query.uniqueResult();
        transaction.commit();
        session.close();
        if (room != null){
            return room;
        }else {
                return null;
        }
    }

    @Override
    public List<Room> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Room ");
        List <Room> roomList = query.list();
        transaction.commit();
        session.close();

        return roomList;
    }

    @Override
    public boolean updateStatus(Room room) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery(" update Room set status=?1 where roomId=?2");
        query.setParameter(1,"reserved");
        query.setParameter(2,room.getRoomId());
        int executeUpdate = query.executeUpdate();
        transaction.commit();
        session.close();
        if (executeUpdate>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Room> getAllAvailable() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Room where status =?1");
        query.setParameter(1,"available");
        List <Room> roomList = query.list();
        transaction.commit();
        session.close();

        return roomList;
    }
    @Override
    public List<Room> getAllReserved() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Room where status =?1");
        query.setParameter(1,"reserved");
        List <Room> roomList = query.list();
        transaction.commit();
        session.close();

        return roomList;
    }
}
