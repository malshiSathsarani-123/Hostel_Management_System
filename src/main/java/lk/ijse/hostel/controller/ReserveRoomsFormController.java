package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.hostel.bo.custom.ReservationRoomsBO;
import lk.ijse.hostel.bo.custom.impl.ReserveRoomsBOImpl;
import lk.ijse.hostel.dto.PaymentDetailsDto;
import lk.ijse.hostel.dto.ReservationDto;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.dto.StudentDto;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReserveRoomsFormController implements Initializable {

    @FXML
    private Label lblReservationId;

    @FXML
    private DatePicker cmbDob;

    @FXML
    private JFXComboBox<String> cmbGender;

    @FXML
    private JFXComboBox<String> cmbRoomId;

    @FXML
    private JFXComboBox<String> cmbRoomTypeId;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private DatePicker dateStart;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtContact;

    @FXML
    private JFXComboBox<String> cmbStudentId;

    @FXML
    private TextField txtKeyMoney;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPayAmount;

    @FXML
    private TextField txtType;

    ReservationRoomsBO reservationRoomsBO = new ReserveRoomsBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadRoomTypeId();
        loadGender();
        generateNextId();
        loadStudentId();
    }

    private void loadStudentId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> id = reservationRoomsBO.getStudentId();

        for (String ids : id){
            obList.add(ids);
        }
        cmbStudentId.setItems(obList);
    }

    private void generateNextId() {
            lblReservationId.setText(reservationRoomsBO.getNextId());
    }

    private void loadRoomId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> id = reservationRoomsBO.getRoomId(cmbRoomTypeId.getSelectionModel().getSelectedItem());

        for (String ids : id){
            obList.add(ids);
        }
        cmbRoomId.setItems(obList);
    }

    private void loadRoomTypeId() {
        List<String> type = new ArrayList<>();
        ObservableList<String> obList = FXCollections.observableArrayList();

        type.add("RM-1324");
        type.add("RM-5467");
        type.add("RM-7896");
        type.add("RM-0093");

        for (String types : type){
            obList.add(types);
        }
        cmbRoomTypeId.setItems(obList);
    }

    private void loadGender() {
        List<String> gender = new ArrayList<>();
        ObservableList<String> obList = FXCollections.observableArrayList();

        gender.add("Mail");
        gender.add("Female");

        for (String genders : gender){
            obList.add(genders);
        }
        cmbGender.setItems(obList);
    }

    @FXML
    public void cmbStudentIdOnAction(ActionEvent actionEvent) {
        StudentDto studentDto = reservationRoomsBO.getStudentData(cmbStudentId.getSelectionModel().getSelectedItem());
        if (studentDto != null){
            txtName.setText(studentDto.getName());
            txtAddress.setText(studentDto.getAddress());
            txtContact.setText(studentDto.getContact());
            cmbDob.setValue(studentDto.getDate());
            cmbGender.setValue(studentDto.getGender());
        }if (studentDto == null){
            new Alert(Alert.AlertType.ERROR,"Student Not Found.....").show();
        }
    }

    @FXML
    void btnReserveOnAction(ActionEvent event) throws SQLException {
        String id = cmbStudentId.getSelectionModel().getSelectedItem();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        LocalDate date = cmbDob.getValue();
        String gender = cmbGender.getSelectionModel().getSelectedItem();

        String reservationId = lblReservationId.getText();
        String roomId = cmbRoomId.getSelectionModel().getSelectedItem();
        String roomTypeId = cmbRoomTypeId.getSelectionModel().getSelectedItem();
        LocalDate startDate = dateStart.getValue();
        LocalDate end = dateEnd.getValue();

        RoomDto roomDto = new RoomDto(roomId);

        StudentDto studentDto = new StudentDto(id,name,address,contact,date,gender,"reserved");
        ReservationDto reservationDto = new ReservationDto(reservationId,startDate,end,roomTypeId,roomDto,studentDto);

        Double keyMoney = Double.valueOf(txtKeyMoney.getText());
        Double payAmount = Double.valueOf(txtPayAmount.getText());
        Double balance = Double.valueOf(txtBalance.getText());

        PaymentDetailsDto paymentDetailsDto = new PaymentDetailsDto(id,keyMoney,payAmount,balance,reservationDto);

        boolean isReserved = reservationRoomsBO.reservedRoomWithPayment(studentDto,reservationDto, paymentDetailsDto);
        if (isReserved){
            new Alert(Alert.AlertType.CONFIRMATION,"Reserved Your Room!!!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"SOMETHINGS WENT WRONG!!!").show();
        }
    }

    @FXML
    void cmbDobOnAction(ActionEvent event) {

    }

    @FXML
    void cmbGenderOnAction(ActionEvent event) {

    }

    @FXML
    void cmbRoomIdOnAction(ActionEvent event) {

    }

    @FXML
    void cmbRoomTypeIdOnAction(ActionEvent event) {
        if (cmbRoomTypeId.getSelectionModel().getSelectedItem().equals("RM-1324")){
            txtType.setText("NON-AC");
            txtKeyMoney.setText(String.valueOf(3100.00));
        }
        if (cmbRoomTypeId.getSelectionModel().getSelectedItem().equals("RM-5467")){
            txtType.setText("NON-AC / FOOD");
            txtKeyMoney.setText(String.valueOf(6500.00));
        }
        if (cmbRoomTypeId.getSelectionModel().getSelectedItem().equals("RM-7896")){
            txtType.setText("AC");
            txtKeyMoney.setText(String.valueOf(8900.00));
        }
        if (cmbRoomTypeId.getSelectionModel().getSelectedItem().equals("RM-0093")){
            txtType.setText("AC / FOOD");
            txtKeyMoney.setText(String.valueOf(16000.00));
        }

        loadRoomId();
    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtBalanceOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {
        txtAddress.requestFocus();
    }

    @FXML
    void txtKeyMoneyOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtContact.requestFocus();
    }

    @FXML
    void txtPayAmountOnAction(ActionEvent event) {
        Double payAmount = Double.valueOf(txtPayAmount.getText());
        Double keyMoney = Double.valueOf(txtKeyMoney.getText());
        Double balance= keyMoney - payAmount;

        txtBalance.setText(String.valueOf(balance));
    }

    @FXML
    void txtTypeOnAction(ActionEvent event) {

    }
}
