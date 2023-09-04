package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.bo.custom.ManageStudentBO;
import lk.ijse.hostel.bo.custom.impl.ManageStudentBOImpl;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.dto.StudentDto;

public class ManageStudentFormController {

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
    private JFXComboBox<?> cmbGender;

    @FXML
    private TableView<?> tblStudent;

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
    @FXML
    void btnClearOnAction(ActionEvent event) {

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
        }else {
            clear();
            new Alert(Alert.AlertType.WARNING,"DELETED NOT STUDENT!!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void cmbDobOnAction(ActionEvent event) {

    }

    @FXML
    void cmbGenderOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

    }

    @FXML
    void txtIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

}
