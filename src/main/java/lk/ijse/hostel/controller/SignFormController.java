package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel.bo.custom.SignBO;
import lk.ijse.hostel.bo.custom.impl.SignBOImpl;
import lk.ijse.hostel.dto.UserDto;

import java.io.IOException;

public class SignFormController {

    @FXML
    private JFXButton btnClose;

    @FXML
    private TextField txtRePassword1;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserPassword;

    @FXML
    private AnchorPane root;


    SignBO signBO = new SignBOImpl();

    @FXML
    void btnCloseOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane= FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene =new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.close();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String name = txtUserName.getText();
        String password = txtUserPassword.getText();

        boolean isSave = signBO.save(new UserDto(name,password));
        if (isSave){
            new Alert(Alert.AlertType.CONFIRMATION,"SUCCESSFUL!!!").show();
            txtUserPassword.setText("");
            txtUserName.setText("");
            txtRePassword1.setText("");
        }
    }
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        txtUserPassword.requestFocus();
    }

    @FXML
    void txtUserPasswordOnAction(ActionEvent event) {
        txtRePassword1.requestFocus();
    }

    @FXML
    public void txtRePasswordOnAction(ActionEvent event) {
        if (!txtUserPassword.getText().equals(txtRePassword1.getText())){
            new Alert(Alert.AlertType.ERROR,"RECHECK YOUR PASSWORD").show();
        }
    }
}
