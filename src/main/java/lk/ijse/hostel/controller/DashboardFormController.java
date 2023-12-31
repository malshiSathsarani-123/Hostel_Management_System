package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    public Rectangle root;

    @FXML
    private Label lblAcCount;

    @FXML
    private Label lblAcFoodCount;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblNonAcCount;

    @FXML
    private Label lblNonAcFoodCount;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane loadContext;

    @FXML
    void btnKeyMoneyOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/remaining_key_money_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    @FXML
    void btnReservationDetailsOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/reservation_details_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    @FXML
    void btnReservationOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/ReserveRoomsForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    @FXML
    void btnRoomOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/manage_room_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/manage_student_form.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDate();
        setTime();
        setCount();
    }

    private void setCount() {

    }

    private void setTime() {
        lblTime.setText(String.valueOf(Time.valueOf(LocalTime.now())));
    }

    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    public void btnCloseOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene =new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.close();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DASH BORD");
        stage.centerOnScreen();
    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashbord_form.fxml"))));
        window.centerOnScreen();
        window.show();
    }
}
