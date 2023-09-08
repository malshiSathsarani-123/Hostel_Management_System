package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.entity.User;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean conform(String name, String password) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from User where userName=?1 and password=?2");
        query.setParameter(1,name);
        query.setParameter(2,password);
        Object user = query.uniqueResult();
        transaction.commit();
        session.close();

        if (user != null){
            return true;
        }else {
            return false;
        }
    }
}
