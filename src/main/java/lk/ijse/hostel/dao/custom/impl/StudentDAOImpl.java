package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public String getName(String id) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("select name from Student where id=?1");
        query.setParameter(1,id);
        String students = String.valueOf(query.uniqueResult());
        transaction.commit();
        session.close();

        return students;
    }

    @Override
    public List<String> getIds() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("select id from Student ");
        List<String> ids = query.list();
        transaction.commit();
        session.close();
        return ids;
    }

    @Override
    public String getReservationId(String id) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("select reservation from PaymentDetails where id=?1");
        query.setParameter(1,id);
        String students = String.valueOf(query.uniqueResult());
        transaction.commit();
        session.close();

        return students;
    }
}
