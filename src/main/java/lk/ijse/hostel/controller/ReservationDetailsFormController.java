package lk.ijse.hostel.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReservationDetailsFormController {

    @FXML
    private TableColumn<?, ?> clmRoomId;

    @FXML
    private TableColumn<?, ?> clmRoomIdReseved;

    @FXML
    private TableColumn<?, ?> clmRoomTypeId;

    @FXML
    private TableColumn<?, ?> clmRoomTypeIdReseved;

    @FXML
    private TableColumn<?, ?> clmType;

    @FXML
    private TableColumn<?, ?> clmTypeReseved;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private DatePicker dateStart;

    @FXML
    private TableView<?> tblAvailableRoom;

    @FXML
    private TableView<?> tblResevedRoom;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

}
