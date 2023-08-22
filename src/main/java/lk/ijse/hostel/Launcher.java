package lk.ijse.hostel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launcher extends Application {

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/dashbord_form.fxml"));
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.centerOnScreen();
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
}