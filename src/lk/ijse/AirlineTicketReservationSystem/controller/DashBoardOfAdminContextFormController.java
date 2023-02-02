package lk.ijse.AirlineTicketReservationSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.FlightModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DashBoardOfAdminContextFormController {

    public AnchorPane dachRealContextId;

    public Label lblTotalOfSchedule;
    public Label lblTotalOfReceptionist;
    public Label lblTotalOfFlight;
    public StackedAreaChart chartId;
    public NumberAxis chartHorizantalSide;
    public NumberAxis chartVerticalSide;


    public void initialize(){
        getScheduleCount();
        getFlightCount();
        getReceptionistCount();
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

}
