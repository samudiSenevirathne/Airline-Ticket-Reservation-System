package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginFormController {


    public JFXButton btnMiniId;
    public AnchorPane loginAnchorId;
    public PasswordField txtPassword;
    public TextField txtUser;
    private Stage stage;

    private HashMap<String, String> hpText1 = new HashMap();
    private HashMap<String, String> hpText2 = new HashMap();

    public void inti(Stage stage){
        this.stage=stage;
        txtUser.requestFocus();
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        stage.close();
    }

    public void btnMinimizeOnAction(ActionEvent actionEvent) {
        stage.setIconified(true);
    }

    public void btnLoginOnAvtion(ActionEvent actionEvent) throws IOException {
        try {
            loginAdmin();
            hpText1.clear();
            loginReceptionist();
            hpText2.clear();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

            /*if(txtUser.getText().equals("saam123")||txtPassword.getText().equals("samuwa@123")){
                 Stage stage =(Stage) loginAnchorId.getScene().getWindow();
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/DashboardOfAdminForm.fxml"));
                 Scene scene = new Scene(loader.load());
                 stage.centerOnScreen();
                 stage.setScene(scene);
                 ((DashboardOfAdminFormController) loader.getController()).inti(stage);

             }else{
                     Stage stage =(Stage) loginAnchorId.getScene().getWindow();
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/DashBoardOfReceptionist.fxml"));
                     Scene scene = new Scene(loader.load());
                     stage.centerOnScreen();
                     stage.setScene(scene);
                     ((DashBoardOfReceptionistController) loader.getController()).inti(stage);
             }*/
    }

    public void btnCancelOnAvtion(ActionEvent actionEvent) {
           System.exit(0);
    }


    public void loginAdmin() throws SQLException, ClassNotFoundException, IOException {
        ResultSet set = CurdUtil.execute("SELECT UserName,password FROM user WHERE role='admin'");
        HashMap<String, String> hpDatabse = new HashMap();
        while (set.next()) {
            hpDatabse.put(set.getString(1), set.getString(2));
        }

        hpText1.put(txtUser.getText(),txtPassword.getText());

        for (Map.Entry<String, String> hp1 : hpText1.entrySet()) {
            for (Map.Entry<String, String> hp2 : hpDatabse.entrySet()) {
                if (hp1.getValue().equals(hp2.getValue())) {
                    Stage stage =(Stage) loginAnchorId.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/DashboardOfAdminForm.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.centerOnScreen();
                    stage.setScene(scene);
                    ((DashboardOfAdminFormController) loader.getController()).inti(stage);
                }
            }
        }
      //clear();
    }

    public void loginReceptionist() throws SQLException, ClassNotFoundException, IOException {
        ResultSet set = CurdUtil.execute("SELECT UserName,password FROM user WHERE role='receptionist'");
        HashMap<String, String> hpDatabse = new HashMap();
        while (set.next()) {
            hpDatabse.put(set.getString(1), set.getString(2));
        }

        hpText2.put(txtUser.getText(),txtPassword.getText());

        for (Map.Entry<String, String> hp1 : hpText2.entrySet()) {
            for (Map.Entry<String, String> hp2 : hpDatabse.entrySet()) {
                if (hp1.getValue().equals(hp2.getValue())) {
                    Stage stage =(Stage) loginAnchorId.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/DashBoardOfReceptionist.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.centerOnScreen();
                    stage.setScene(scene);
                    ((DashBoardOfReceptionistController) loader.getController()).inti(stage);
                }
            }
        }
        //clear();
        //new Alert(Alert.AlertType.WARNING,"Wrong Input").show();

    }


    private  void clear(){
        txtPassword.clear();
        txtUser.clear();
    }
    public void btnBackOnAvtion(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) loginAnchorId.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/WelcomeForm.fxml"));
        Scene scene = new Scene(loader.load());
        stage.centerOnScreen();
        stage.setScene(scene);
        ((WelcomeFormController) loader.getController()).inti(stage);
    }
}
