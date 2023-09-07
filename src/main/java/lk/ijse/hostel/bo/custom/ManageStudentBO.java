package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.dto.StudentDto;

import java.util.List;

public interface ManageStudentBO  {

    boolean delete(StudentDto studentDto);

    List<StudentDto> getAll();

    StudentDto search(String text);

    boolean update(StudentDto studentDto);

    boolean save(StudentDto studentDto);
}
