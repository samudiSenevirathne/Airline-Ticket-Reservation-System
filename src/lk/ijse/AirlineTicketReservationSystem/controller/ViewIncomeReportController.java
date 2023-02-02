package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewIncomeReportController {
    public JFXButton btnMiniId;
    public AnchorPane anchorIncomeReport;
    public StackedAreaChart chartId;
    public NumberAxis chartVerticalSideId;
    public NumberAxis chartHorizantalSideId;
    public JFXComboBox comViewMonthly;
    public JFXComboBox comViewAnnualy;
    private Stage stage;

    public void inti(Stage stage){
        this.stage=stage;
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        stage.close();
    }

    public void btnMinimizeOnAction(ActionEvent actionEvent) {
        stage.setIconified(true);
    }

    public void comViewMonthlyOnAction(ActionEvent actionEvent) {
    }

    public void comViewAnnualyOnAction(ActionEvent actionEvent) {
    }
}
