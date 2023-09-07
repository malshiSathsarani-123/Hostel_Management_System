package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.entity.Room;
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
        Query query = session.createQuery("select id from Student where status=?1");
        query.setParameter(1,"not-reserved");
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

    @Override
    public boolean delete(Student student) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.remove(student);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Student> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from Student ");
        List <Student> studentList = query.list();
        transaction.commit();
        session.close();

        return studentList;
    }

    @Override
    public Student getStudentData(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Student where id=?1");
        query.setParameter(1,id);
        Student student = (Student) query.uniqueResult();
        transaction.commit();
        session.close();
        if (student != null){
            return student;
        }else {
            return null;
        }
    }

    @Override
    public boolean update(Student student) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();

        return true;    }

    @Override
    public boolean updateStatus(Student student) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery(" update Student set status=?1 where id=?2");
        query.setParameter(1,"reserved");
        query.setParameter(2,student.getStudentId());
        int executeUpdate = query.executeUpdate();
        transaction.commit();
        session.close();
        if (executeUpdate>0){
            return true;
        }else {
            return false;
        }
    }
}
