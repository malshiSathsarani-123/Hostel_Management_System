package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.bo.custom.ManageStudentBO;
import lk.ijse.hostel.bo.custom.impl.ManageStudentBOImpl;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.dto.StudentDto;
import lk.ijse.hostel.tm.ManageRoomTM;
import lk.ijse.hostel.tm.StudentTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageStudentFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> clmAddress;

    @FXML
    private TableColumn<?, ?> clmContact;

    @FXML
    private TableColumn<?, ?> clmDob;

    @FXML
    private TableColumn<?, ?> clmGender;

    @FXML
    private TableColumn<?, ?> clmId;

    @FXML
    private TableColumn<?, ?> clmName;

    @FXML
    private DatePicker cmbDob;

    @FXML
    private JFXComboBox<String> cmbGender;

    @FXML
    private TableView<StudentTM> tblStudent;

    @FXML
    private AnchorPane text;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    ManageStudentBO studentBO = new ManageStudentBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();
        loadGender();
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

    private void setCellValueFactory() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        clmDob.setCellValueFactory(new PropertyValueFactory<>("date"));
        clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void getAll() {
        ObservableList<StudentTM> obList= FXCollections.observableArrayList();

        List<StudentDto> studentDtos = studentBO.getAll();

        for (StudentDto studentDto : studentDtos){
            obList.add(new StudentTM(
                    studentDto.getStudentId(),
                    studentDto.getName(),
                    studentDto.getAddress(),
                    studentDto.getContact(),
                    studentDto.getDate(),
                    studentDto.getGender()
            ));
        }
        tblStudent.setItems(obList);
        tblStudent.refresh();
    }

    public void clear(){
        cmbGender.setPromptText("Gender");
        txtId.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        txtName.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        boolean isDelete = studentBO.delete(new StudentDto(id));
        if (isDelete){
            clear();
            new Alert(Alert.AlertType.CONFIRMATION,"DELETED STUDENT!!!").show();
            getAll();
        }else {
            clear();
            new Alert(Alert.AlertType.WARNING,"DELETED NOT STUDENT!!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        StudentDto studentDto = studentBO.search(txtId.getText());
        if (studentDto != null){
            txtName.setText(studentDto.getName());
            txtAddress.setText(studentDto.getAddress());
            txtContact.setText(studentDto.getContact());
            cmbDob.setValue(studentDto.getDate());
        }if (studentDto == null){
            new Alert(Alert.AlertType.ERROR,"Student Not Found.....").show();
            clear();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String gender = String.valueOf(cmbGender.getSelectionModel().getSelectedItem());
        LocalDate date = cmbDob.getValue();

        boolean isUpdate = studentBO.update(new StudentDto(id,name,address,contact,date,gender,"not-reserved"));
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION,"Student Updated!!!").show();
            clear();
            getAll();
        }else {
            new Alert(Alert.AlertType.ERROR,"Student Not Updated!!!").show();
            clear();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String gender = String.valueOf(cmbGender.getSelectionModel().getSelectedItem());
        LocalDate date = cmbDob.getValue();

        boolean isSave = studentBO.save(new StudentDto(id,name,address,contact,date,gender,"not-reserved"));
        if (isSave){
            new Alert(Alert.AlertType.CONFIRMATION,"Student Saved!!!").show();
            clear();
            getAll();
        }else {
            new Alert(Alert.AlertType.ERROR,"Student Not Saved!!!").show();
            clear();
        }
    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {
        txtContact.requestFocus();
    }
    @FXML
    void txtIdOnAction(ActionEvent event) {
        txtName.requestFocus();
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtAddress.requestFocus();
    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

    }

    @FXML
    void cmbDobOnAction(ActionEvent event) {

    }

    @FXML
    void cmbGenderOnAction(ActionEvent event) {

    }


}
