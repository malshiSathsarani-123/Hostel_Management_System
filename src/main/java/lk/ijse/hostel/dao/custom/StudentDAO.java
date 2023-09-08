package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SuperDAO;
import lk.ijse.hostel.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends SuperDAO {
    boolean save(Student student);
    public List<String> getIdsReserved();
    String getName(String id);

    List<String> getIds();

    String getReservationId(String id);

    boolean delete(Student student);

    List<Student> getAll();

    Student getStudentData(String id);

    boolean update(Student student);

    boolean updateStatus(Student student);

    boolean delete(String id) throws SQLException;
}
