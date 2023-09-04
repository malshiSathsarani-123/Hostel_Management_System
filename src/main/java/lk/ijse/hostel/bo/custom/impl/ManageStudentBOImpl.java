package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.ManageStudentBO;
import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel.dto.StudentDto;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

public class ManageStudentBOImpl implements ManageStudentBO {

    StudentDAO studentDAO = new StudentDAOImpl();
    @Override
    public boolean delete(StudentDto studentDto) {
        return studentDAO.delete(new Student(studentDto.getStudentId()));
    }
}
