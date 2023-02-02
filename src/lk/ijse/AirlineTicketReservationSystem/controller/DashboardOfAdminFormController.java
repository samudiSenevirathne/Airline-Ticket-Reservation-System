package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lk.ijse.AirlineTicketReservationSystem.model.FlightModel;
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.model.UserModel;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DashboardOfAdminFormController {

    public JFXButton btnMiniId;
    public AnchorPane DadhAdmiAnchId;
    public AnchorPane context;
    public ComboBox<Object>comFlightInforId;
    public Label lblFlightInfomationId;
    public Label lblTotalOfSchedule;
    public Label lblTotalOfReceptionist;
    public Label lblTotalOfFlight;
    public StackedAreaChart chartId;
    public NumberAxis chartHorizantalSide;
    public NumberAxis chartVerticalSide;
    public Label lblDate;
    public Label lblTime;

    String[]flightInformation={"Flight","Flight Detail","Class Type","Flight Maintain","Class Type Detail","Meal Plan Detail"};
    ObservableList<Object>list= FXCollections.observableArrayList(flightInformation);

    public void initialize(){
        comFlightInforId.setItems(list);
        setDate();
        setTime();
        getScheduleCount();
        getFlightCount();
        getReceptionistCount();
    }

    private  Stage stage;

    public void inti(Stage stage){
        this.stage=stage;
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        stage.close();
    }

    public void btnMinimizeOnAction(ActionEvent actionEvent) {
        stage.setIconified(true);
    }

    private void setDate() {
        LocalDate date = LocalDate.now();
        lblDate.setText(String.valueOf(date));
    }

    private void setTime() {
        LocalTime time = LocalTime.now();
        lblTime.setText(String.valueOf(time));
    }

    private void getScheduleCount(){
        try {
            ResultSet set = ScheduleModel.loadSheduleCount();
            if (set.next()) {
                lblTotalOfSchedule.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getFlightCount(){
        try {
            ResultSet set = FlightModel.loadFlightCount();
            if (set.next()) {
                lblTotalOfFlight.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getReceptionistCount(){
        try {
            ResultSet set = UserModel.loadReceptionistCount();
            if (set.next()) {
                lblTotalOfReceptionist.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent)  {
        comFlightInforId.setValue("Flight Information");
        lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/DashBoardOfAdminContextForm");
    }

    public void comFlightInforOnAction(ActionEvent actionEvent) {
        if (comFlightInforId.getSelectionModel().isSelected(0)) {
            lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightForm");
        } else if (comFlightInforId.getSelectionModel().isSelected(1)) {
            lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailForm");
        } else if (comFlightInforId.getSelectionModel().isSelected(2)) {
            lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/ClassTypeForm");
        } else if (comFlightInforId.getSelectionModel().isSelected(3)) {
            lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightFlightDetailMaintainForm");
        } else if (comFlightInforId.getSelectionModel().isSelected(4)) {
            lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightClassTypeDetailForm");
        } else if (comFlightInforId.getSelectionModel().isSelected(5)) {
            lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightMealPlanDetailForm");
        }
    }

    public void btnMealplOnAction(ActionEvent actionEvent) {
        comFlightInforId.setValue("Flight Information");
        lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/MealPlanForm");
    }

    public void btnIncRepOnAction(ActionEvent actionEvent) {
        comFlightInforId.setValue("Flight Information");
        lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/ViewIncomeReport");
    }

    public void btnResepOnAction(ActionEvent actionEvent) {
        comFlightInforId.setValue("Flight Information");
        lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/ReceptionistForm");
    }

    public void btnSheduleOnAction(ActionEvent actionEvent)  {
        comFlightInforId.setValue("Flight Information");
        lblFlightInfomationId.setText(String.valueOf(comFlightInforId.getValue()));
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/ScheduleForm");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) DadhAdmiAnchId.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/LoginForm.fxml"));
        Scene scene = new Scene(loader.load());
        stage.centerOnScreen();
        stage.setScene(scene);
        ((LoginFormController) loader.getController()).inti(stage);
    }
    private void setUi(String ui){
        try{
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
          context.getChildren().clear();
          context.getChildren().add(node);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
