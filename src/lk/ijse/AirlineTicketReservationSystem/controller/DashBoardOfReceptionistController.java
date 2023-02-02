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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.AirlineTicketReservationSystem.model.BookDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightModel;
import lk.ijse.AirlineTicketReservationSystem.model.PassengerModel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class DashBoardOfReceptionistController {

    public JFXButton btnMiniId;
    public AnchorPane resepAnchorId;
    public AnchorPane context;
    public Label lblDate;
    public Label lblTime;
    public StackedAreaChart chartId;
    public NumberAxis chartHorizantalSide;
    public NumberAxis chartVerticalSide;
    public Label lblTotalOfBooking;
    public Label lblTotalOfPassengers;
    public Label TotalAvailabalFlight;
    public ComboBox comPaymentInformation;
    public Label lblPaymentInfomationId;
    private Stage stage;

    String[]paymentInformation={"Payment","Payment Detail"};
    ObservableList<Object> list= FXCollections.observableArrayList(paymentInformation);

    public void initialize(){
        comPaymentInformation.setItems(list);
        setDate();
        setTime();
        getPassengerCount();
        getBookingCount();
        getFlightCount();
    }

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

    public void btnPassengerOnAction(ActionEvent actionEvent) throws IOException {
        setFont("Payment Information");
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/PassengerForm");
    }

    public void btnAvailableMealPlanOnAction(ActionEvent actionEvent) throws IOException {
        setFont("Payment Information");
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/AvailableMealPlanForm");
    }

    public void btnFlightAvailabilityOnAction(ActionEvent actionEvent) throws IOException {
        setFont("Payment Information");
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightAvailabilityForm");
    }

    public void btnFlightBookingOnAction(ActionEvent actionEvent) throws IOException {
        setFont("Payment Information");
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/BookingForm");
    }

    public void btnTicketOnAction(ActionEvent actionEvent) throws IOException {
        setFont("Payment Information");
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/TicketForm");
    }

    public void comPaymentInformationOnAction(ActionEvent actionEvent) throws IOException {
        if(comPaymentInformation.getSelectionModel().isSelected(0)){
            setFont("Payment");
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/PaymentForm");
        }else if(comPaymentInformation.getSelectionModel().isSelected(1)) {
            setFont("Payment Detail");
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/PaymentDetailForm");
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setFont("Payment Information");
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/DashBoardOfReceptionistContextForm");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) resepAnchorId.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/AirlineTicketReservationSystem/view/LoginForm.fxml"));
        Scene scene = new Scene(loader.load());
        stage.centerOnScreen();
        stage.setScene(scene);
        ((LoginFormController) loader.getController()).inti(stage);
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    private void setFont(String name){
        comPaymentInformation.getSelectionModel().clearSelection();
        lblPaymentInfomationId.setText(name);
    }
    private void getPassengerCount(){
        try {
            ResultSet set = PassengerModel.loadPassengerCount();
            if (set.next()) {
                lblTotalOfPassengers.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getBookingCount(){
        try {
            ResultSet set = BookDetailModel.loadBookingCount();
            if (set.next()) {
                lblTotalOfBooking.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getFlightCount(){
        try {
            ResultSet set = FlightModel.loadFlightCount();
            if (set.next()) {
                TotalAvailabalFlight.setText(set.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
