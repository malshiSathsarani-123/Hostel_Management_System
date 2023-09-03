package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostel.bo.custom.ManageRoomBO;
import lk.ijse.hostel.bo.custom.impl.ManageRoomBOImpl;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.tm.ManageRoomTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageRoomFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> clmId;

    @FXML
    private TableColumn<?, ?> clmKeyMoney;

    @FXML
    private TableColumn<?, ?> clmQty;

    @FXML
    private TableColumn<?, ?> clmType;

    @FXML
    private JFXComboBox<String> cmbTypeId;

    @FXML
    private TableView<ManageRoomTM> tblRoom;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtKeyMoney;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtType;

    ManageRoomBO roomBO = new ManageRoomBOImpl();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        loadRoomTypeId();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        clmId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        clmType.setCellValueFactory(new PropertyValueFactory<>("type"));
        clmKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        clmQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void getAll() {
        ObservableList<ManageRoomTM>obList=FXCollections.observableArrayList();

        List<RoomDto> roomDtoList = roomBO.getAll();

        for (RoomDto roomDto : roomDtoList){
            obList.add(new ManageRoomTM(
                    roomDto.getRoomId(),
                    roomDto.getType(),
                    roomDto.getKeyMoney(),
                    roomDto.getQty()
            ));
        }
        tblRoom.setItems(obList);
        tblRoom.refresh();
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
        cmbTypeId.setItems(obList);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        boolean isDelete = roomBO.delete(new RoomDto(id));
        if (isDelete){
            clear();
            new Alert(Alert.AlertType.CONFIRMATION,"DELETED ROOM!!!").show();
        }else {
            clear();
            new Alert(Alert.AlertType.WARNING,"DELETED NOT ROOM!!!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String typeId =  cmbTypeId.getSelectionModel().getSelectedItem();
        String id = txtId.getText();
        String type = txtType.getText();
        Double keyMoney = Double.valueOf(txtKeyMoney.getText());
        Integer qty = Integer.valueOf(txtQty.getText());

        boolean isSave = roomBO.save(new RoomDto(typeId,id,type,keyMoney,qty,"available"));
        if(isSave){
            clear();
            new Alert(Alert.AlertType.CONFIRMATION,"SAVED ROOM!!!").show();
        }else {
            clear();
            new Alert(Alert.AlertType.WARNING,"SAVED NOT ROOM!!!").show();
        }
    }

    public void clear(){
        cmbTypeId.setValue("");
        txtId.setText("");
        txtType.setText("");
        txtKeyMoney.setText("");
        txtQty.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String typeId =  cmbTypeId.getSelectionModel().getSelectedItem();
        String id = txtId.getText();
        String type = txtType.getText();
        Double keyMoney = Double.valueOf(txtKeyMoney.getText());
        Integer qty = Integer.valueOf(txtQty.getText());

        boolean isUpdate = roomBO.update(new RoomDto(typeId,id,type,keyMoney,qty));
        if (isUpdate){
            clear();
            new Alert(Alert.AlertType.CONFIRMATION,"UPDATED ROOM!!!").show();
        }else {
            clear();
            new Alert(Alert.AlertType.WARNING,"UPDATED NOT ROOM!!!").show();
        }
    }

    @FXML
    void cmbTypeIdOnAction(ActionEvent event) {
        if (cmbTypeId.getSelectionModel().getSelectedItem().equals("RM-1324")){
            txtType.setText("NON-AC");
            txtKeyMoney.setText(String.valueOf(3100.00));
        }
        if (cmbTypeId.getSelectionModel().getSelectedItem().equals("RM-5467")){
            txtType.setText("NON-AC / FOOD");
            txtKeyMoney.setText(String.valueOf(6500.00));
        }
        if (cmbTypeId.getSelectionModel().getSelectedItem().equals("RM-7896")){
            txtType.setText("AC");
            txtKeyMoney.setText(String.valueOf(8900.00));
        }
        if (cmbTypeId.getSelectionModel().getSelectedItem().equals("RM-0093")){
            txtType.setText("AC / FOOD");
            txtKeyMoney.setText(String.valueOf(16000.00));
        }
    }

    @FXML
    public void btnSearchOnAction(ActionEvent event) {
        RoomDto roomDto = roomBO.search(txtId.getText());
        if (roomDto!=null){
            cmbTypeId.setValue(roomDto.getRoomTypeId());
            txtId.setText(roomDto.getRoomId());
            txtType.setText(roomDto.getType());
            txtKeyMoney.setText(String.valueOf(roomDto.getKeyMoney()));
            txtQty.setText(String.valueOf(roomDto.getQty()));
        }
        if (roomDto == null){
            new Alert(Alert.AlertType.ERROR,"Room Not Found.....").show();
        }
    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        txtQty.requestFocus();
    }

}
