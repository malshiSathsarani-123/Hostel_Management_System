package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RemainingKeyMoneyFormController {

    @FXML
    private TableColumn<?, ?> clmBalance;

    @FXML
    private TableColumn<?, ?> clmDate;

    @FXML
    private TableColumn<?, ?> clmKeyMoney;

    @FXML
    private TableColumn<?, ?> clmRoomId;

    @FXML
    private TableColumn<?, ?> clmStudentId;

    @FXML
    private TableColumn<?, ?> clmType;

    @FXML
    private JFXComboBox<?> cmbStudentId;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<?> tblRemainKeyMoney;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtKeyMoney;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPayAmoub;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtType;

    @FXML
    void btnPayOnAction(ActionEvent event) {

    }

    @FXML
    void cmbStudentIdOnAction(ActionEvent event) {

    }

}
