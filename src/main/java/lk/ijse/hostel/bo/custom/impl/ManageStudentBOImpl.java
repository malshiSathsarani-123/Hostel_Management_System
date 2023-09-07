package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.ManageStudentBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel.dto.StudentDto;
import lk.ijse.hostel.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ManageStudentBOImpl implements ManageStudentBO {

//    StudentDAO studentDAO = new StudentDAOImpl();
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public boolean delete(StudentDto studentDto) {
        return studentDAO.delete(new Student(studentDto.getStudentId()));
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentDto>studentDtos = new ArrayList<>();
        List<Student>studentList = studentDAO.getAll();
        for (Student student : studentList){
            studentDtos.add(new StudentDto(student.getStudentId(),student.getName(),student.getAddress(),student.getContact(),student.getDate(),student.getGender(),student.getStatus()));
        }
        return studentDtos;
    }

    @Override
    public StudentDto search(String id) {
        Student student = studentDAO.getStudentData(id);
        return new StudentDto(student.getStudentId(),student.getName(),student.getAddress(),student.getContact(),student.getDate(),student.getGender(),student.getStatus());
    }

    @Override
    public boolean update(StudentDto studentDto) {
        return studentDAO.update(new Student(studentDto.getStudentId(),studentDto.getName(),studentDto.getAddress(),studentDto.getContact(),studentDto.getDate(),studentDto.getGender(),studentDto.getStatus()));
    }

    @Override
    public boolean save(StudentDto studentDto) {
        return studentDAO.save(new Student(studentDto.getStudentId(),studentDto.getName(),studentDto.getAddress(),studentDto.getContact(),studentDto.getDate(),studentDto.getGender(),studentDto.getStatus()));
    }
}
