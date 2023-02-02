package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class WelcomeFormController {


    public JFXButton btnMiniId;
    public JFXButton btnLoginId;
    public AnchorPane welcomeAnchorId;
    private Stage stage;

    public void initialize(){


    }

    public void inti(Stage stage){
        this.stage=stage;
    }
    public void btnMinimizeOnAction(ActionEvent actionEvent) {
         stage.setIconified(true);
   }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        stage.close();
    }


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) welcomeAnchorId.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/LoginForm.fxml"));
        Scene scene = new Scene(loader.load());
        stage.centerOnScreen();
        stage.setScene(scene);
        ((LoginFormController) loader.getController()).inti(stage);
    }
}
