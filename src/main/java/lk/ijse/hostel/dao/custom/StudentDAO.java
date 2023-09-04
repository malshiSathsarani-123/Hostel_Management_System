package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.entity.Student;

import java.util.List;

public interface StudentDAO {
    boolean save(Student student);

    String getName(String id);

    List<String> getIds();

    String getReservationId(String id);

    boolean delete(Student student);
}
