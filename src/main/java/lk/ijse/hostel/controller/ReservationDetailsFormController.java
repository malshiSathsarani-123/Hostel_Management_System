package lk.ijse.hostel.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.hostel.bo.custom.ReservationDetailsBO;
import lk.ijse.hostel.bo.custom.impl.ReservationDetailsBOImpl;
import lk.ijse.hostel.dto.ReservationDto;
import lk.ijse.hostel.dto.RoomDto;
import lk.ijse.hostel.tm.ManageRoomTM;
import lk.ijse.hostel.tm.RemainKeyMoneyTM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationDetailsFormController implements Initializable {

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
    private TableView<ManageRoomTM> tblAvailableRoom;

    @FXML
    private TableView<ManageRoomTM> tblResevedRoom;

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

    ReservationDetailsBO detailsBO = new ReservationDetailsBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAvailableTable();
        loadReservedTable();
        setCellValueFactory();
        setCellValueFactory1();
    }

    private void loadReservedTable() {
        ObservableList<ManageRoomTM> obList= FXCollections.observableArrayList();

        List<RoomDto> roomDtoList = detailsBO.getAllReserved();

        for (RoomDto roomDto : roomDtoList){
            obList.add(new ManageRoomTM(
                    roomDto.getRoomId(),
                    roomDto.getType(),
                    roomDto.getQty()
            ));
        }
        tblResevedRoom.setItems(obList);
        tblResevedRoom.refresh();
    }

    private void loadAvailableTable() {
        ObservableList<ManageRoomTM> obList= FXCollections.observableArrayList();

        List<RoomDto> roomDtoList = detailsBO.getAll();

        for (RoomDto roomDto : roomDtoList){
            obList.add(new ManageRoomTM(
                    roomDto.getRoomId(),
                    roomDto.getType(),
                    roomDto.getQty()
            ));
        }
        tblAvailableRoom.setItems(obList);
        tblAvailableRoom.refresh();
    }
    private void setCellValueFactory() {
        clmRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        clmType.setCellValueFactory(new PropertyValueFactory<>("type"));
        clmRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void setCellValueFactory1() {
        clmRoomIdReseved.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        clmTypeReseved.setCellValueFactory(new PropertyValueFactory<>("type"));
        clmRoomTypeIdReseved.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    public void getStudentDetails(MouseEvent mouseEvent) {
        if (tblResevedRoom.getSelectionModel().getSelectedItem() != null) {
            ManageRoomTM selectedItem = tblResevedRoom.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
               String id = selectedItem.getRoomId();
               ReservationDto reservationDto = detailsBO.searchStudent(id);
               if (reservationDto != null){
                   txtId.setText(reservationDto.getStudentDto().getStudentId());
                   txtName.setText(reservationDto.getStudentDto().getName());
                   txtAddress.setText(reservationDto.getStudentDto().getAddress());
                   txtContact.setText(reservationDto.getStudentDto().getContact());
                   txtGender.setText(reservationDto.getStudentDto().getGender());
                   dateStart.setValue(reservationDto.getStartDate());
                   dateEnd.setValue(reservationDto.getEndDate());
               }

            }
        }
    }
}
