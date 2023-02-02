package lk.ijse.AirlineTicketReservationSystem.controller;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.BookDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightModel;
import lk.ijse.AirlineTicketReservationSystem.model.PassengerModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DashBoardOfReceptionistContextFormController {
    public AnchorPane context;
    public StackedAreaChart chartId;
    public NumberAxis chartHorizantalSide;
    public NumberAxis chartVerticalSide;
    public Label lblTotalOfBooking;
    public Label lblTotalOfPassengers;
    public Label TotalAvailabalFlight;


    public void initialize(){
        getPassengerCount();
        getBookingCount();
        getFlightCount();
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
