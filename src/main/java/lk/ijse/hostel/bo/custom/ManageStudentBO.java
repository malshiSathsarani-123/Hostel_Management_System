package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface ManageStudentBO  {

    boolean delete(StudentDto studentDto);

    List<StudentDto> getAll();

    StudentDto search(String text);

    boolean update(StudentDto studentDto);

    boolean save(StudentDto studentDto);

    boolean delete(String id) throws SQLException;
}
