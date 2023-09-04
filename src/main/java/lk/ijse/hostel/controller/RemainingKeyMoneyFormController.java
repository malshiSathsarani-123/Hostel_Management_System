package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel.bo.custom.RemainingKeyMoneyBO;
import lk.ijse.hostel.bo.custom.impl.RemainingKeyMoneyBOImpl;
import lk.ijse.hostel.dto.RemainKeyMoneyDto;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.entity.PaymentDetails;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Student;
import lk.ijse.hostel.tm.ManageRoomTM;
import lk.ijse.hostel.tm.RemainKeyMoneyTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class RemainingKeyMoneyFormController implements Initializable {

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
    private JFXComboBox<String> cmbStudentId;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<RemainKeyMoneyTM> tblRemainKeyMoney;

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

    RemainingKeyMoneyBO remainingKeyMoneyBO = new RemainingKeyMoneyBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();
        loadStudentId();
    }

    private void loadStudentId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> id = remainingKeyMoneyBO.getStudentId();

        for (String ids : id){
            obList.add(ids);
        }
        cmbStudentId.setItems(obList);
    }

    private void setCellValueFactory() {
        clmStudentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        clmRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        clmType.setCellValueFactory(new PropertyValueFactory<>("type"));
        clmKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        clmBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        clmDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));

    }

    private void getAll() {
        ObservableList<RemainKeyMoneyTM> obList= FXCollections.observableArrayList();
        List<Object[]> dtoList = remainingKeyMoneyBO.getAll();
        for (Object[] objects : dtoList) {
            obList.add(new RemainKeyMoneyTM(
                    objects[0],
                    objects[1],
                    objects[2],
                    objects[3],
                    objects[4],
                    objects[5]

            ));
        }
        tblRemainKeyMoney.setItems(obList);
        tblRemainKeyMoney.refresh();
    }

    @FXML
    void btnPayOnAction(ActionEvent event) {
        String id = cmbStudentId.getSelectionModel().getSelectedItem();
        Double balance = Double.valueOf(txtBalance.getText());
        Double payAmount = Double.valueOf(txtPayAmoub.getText());
        Double balance1 = balance-payAmount;
        Double keyMoney = Double.valueOf(txtKeyMoney.getText());
        Double payAmount1 = keyMoney - balance1;
        String resId = remainingKeyMoneyBO.getReservationId(id);

        Reservation reservation = new Reservation(resId);

        boolean isUpdate = remainingKeyMoneyBO.updatePayment(new PaymentDetails(id,keyMoney,balance1,payAmount1,reservation));
        if (isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION).show();
        }
    }

    @FXML
    void cmbStudentIdOnAction(ActionEvent event) {
        String id = cmbStudentId.getSelectionModel().getSelectedItem();
        String name = remainingKeyMoneyBO.getName(id);
        txtName.setText(name);
        for (int i = 0; i < tblRemainKeyMoney.getItems().size(); i++) {
            if (clmStudentId.getCellData(i).equals(id)) {
                txtRoomId.setText(String.valueOf(clmRoomId.getCellData(i)));
                txtType.setText(String.valueOf(clmType.getCellData(i)));
                txtKeyMoney.setText(String.valueOf(clmKeyMoney.getCellData(i)));
                txtBalance.setText(String.valueOf(clmBalance.getCellData(i)));
            }
        }
    }
}
