package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.ReservationRoomsBO;
import lk.ijse.hostel.dao.custom.PaymentDAO;
import lk.ijse.hostel.dao.custom.ReservationDAO;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.hostel.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.hostel.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostel.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostel.dto.PaymentDetailsDto;
import lk.ijse.hostel.dto.ReservationDto;
import lk.ijse.hostel.dto.StudentDto;
import lk.ijse.hostel.entity.PaymentDetails;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

import java.util.List;

public class ReserveRoomsBOImpl implements ReservationRoomsBO {

    ReservationDAO reservationDAO = new ReservationDAOImpl();
    StudentDAO studentDAO = new StudentDAOImpl();
    PaymentDAO paymentDAO = new PaymentDAOImpl();
    RoomDAO roomDAO = new RoomDAOImpl();
    @Override
    public List<String> getRoomId(String selectedItem) {
        return reservationDAO.getRoomId(selectedItem);
    }
//
//    @Override
//    public boolean reservedRoom(StudentDto studentDto, ReservationDto reservationDto) throws SQLException {
////        String URL = "jdbc:mysql://localhost:3306/hibernate";
////        Properties props = new Properties();
////        props.setProperty("user", "root");
////        props.setProperty("password", "1234");
////        Connection connection =  DriverManager.getConnection(URL, props);
////
////        try {
////            Student student = new Student(studentDto.getStudentId(), studentDto.getName(), studentDto.getAddress(), studentDto.getContact(), studentDto.getDate(), studentDto.getGender());
////            Room room = new Room(reservationDto.getRoom().getRoomId());
////            boolean isSaveStudent = studentDAO.save(student);
////            if (isSaveStudent){
////                boolean isSReservedRoom = reservationDAO.save(new Reservation(reservationDto.getReservationId(),reservationDto.getStartDate(),reservationDto.getEndDate(),reservationDto.getRoomTypeId(),room,student));
////                    if (isSReservedRoom){
////                        connection.commit();
////                        return true;
////                    }
////                }
////            return false;
////        } catch (SQLException e) {
////            e.printStackTrace();
////            connection.rollback();
////            return false;
////        }finally {
////            connection.setAutoCommit(true);
////        }
//        Student student = new Student(studentDto.getStudentId(), studentDto.getName(), studentDto.getAddress(), studentDto.getContact(), studentDto.getDate(), studentDto.getGender());
//        Room room = new Room(reservationDto.getRoomDto().getRoomId());
//        boolean isSaveStudent = studentDAO.save(student);
//        if (isSaveStudent){
//            boolean isSReservedRoom = reservationDAO.save(new Reservation(reservationDto.getReservationId(),reservationDto.getStartDate(),reservationDto.getEndDate(),reservationDto.getRoomTypeId(),room,student));
//            if (isSReservedRoom){
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean reservedRoomWithPayment(StudentDto studentDto, ReservationDto reservationDto, PaymentDetailsDto paymentDetailsDto) {
        Student student = new Student(studentDto.getStudentId(), studentDto.getName(), studentDto.getAddress(), studentDto.getContact(), studentDto.getDate(), studentDto.getGender());
        Room room = new Room(reservationDto.getRoomDto().getRoomId());
        Reservation reservation = new Reservation(reservationDto.getReservationId(),reservationDto.getStartDate(),reservationDto.getEndDate(),reservationDto.getRoomTypeId(),room,student);
        boolean isSaveStudent = studentDAO.save(student);
        if (isSaveStudent){
            boolean isSReservedRoom = reservationDAO.save(reservation);
            if (isSReservedRoom){
                boolean isPayed = paymentDAO.savePayment(new PaymentDetails(paymentDetailsDto.getPaymentDetailsId(), paymentDetailsDto.getKeyMoney(), paymentDetailsDto.getPayAmount(), paymentDetailsDto.getBalance(),reservation));
                if (isPayed){
                    boolean isUpdateRoomStatus = roomDAO.updateStatus(room);
                    if (isUpdateRoomStatus){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getNextId(){
        return reservationDAO.getNextId();
    }

    @Override
    public String getNextPaymentId() {
        return paymentDAO.getNextId();
    }

}
