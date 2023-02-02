package lk.ijse.AirlineTicketReservationSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.AirlineTicketReservationSystem.controller.*;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/WelcomeForm.fxml"));
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
       ((WelcomeFormController) loader.getController()).inti(primaryStage);
        primaryStage.show();
    }
}
