package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel.bo.custom.LoginBO;
import lk.ijse.hostel.bo.custom.impl.LoginBOImpl;
import lk.ijse.hostel.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    @FXML
    private JFXButton btnClose;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserPassword;

    LoginBO loginBO = new LoginBOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createDatabase();
    }
    private void createDatabase() {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.commit();
//        session.close();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        String name = txtUserName.getText();
        String password = txtUserPassword.getText();
            boolean isConform = loginBO.conform(name,password);
            if (isConform){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashbord_form.fxml"));
                AnchorPane anchorPane = loader.load();
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("DASH BORD");
                stage.centerOnScreen();
            }else {
                new Alert(Alert.AlertType.ERROR,"SORRY!!! RECHECK YOUR PASSWORD OR USER NAME!!!").show();
                txtUserPassword.setText("");
                txtUserName.setText("");
            }
    }

    @FXML
    void btnSignOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sign_form.fxml"));
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
    void txtUserPasswordOnAction(ActionEvent event) throws IOException {
        String name = txtUserName.getText();
        String password = txtUserPassword.getText();
        boolean isConform = loginBO.conform(name,password);
        if (isConform){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashbord_form.fxml"));
            AnchorPane anchorPane = loader.load();
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("DASH BORD");
            stage.centerOnScreen();
        }else {
            new Alert(Alert.AlertType.ERROR,"SORRY!!! RECHECK YOUR PASSWORD OR USER NAME!!!").show();
            txtUserPassword.setText("");
            txtUserName.setText("");
        }
    }
    @FXML
    void btnCloseOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/view/dashbord_form.fxml"));
        Scene scene =new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();

        stage.close();
    }
}
