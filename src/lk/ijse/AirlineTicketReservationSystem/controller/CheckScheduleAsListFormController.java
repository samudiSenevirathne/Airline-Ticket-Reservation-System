package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.to.Schedule;

import java.io.IOException;
import java.sql.SQLException;

public class CheckScheduleAsListFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public ScrollPane scrollPane;
    public TableView tblSchedule;
    public TableColumn colsId;
    public TableColumn colsName;
    public TableColumn colUserName;
    public TableColumn colsDate;
    public TableColumn colStime;
    public TableColumn colflightDeparDate;
    public TableColumn colflightDeparTime;
    public TableColumn colFlightArrivalDate;
    public TableColumn colFlightArrivalTime;
    public TableColumn colFrom;
    public TableColumn colTo;
    public TableColumn colDeparAirName;
    public TableColumn colArriAirName;


    public void initialize(){

       colsId.setCellValueFactory(new PropertyValueFactory("S_Id"));
       colUserName.setCellValueFactory(new PropertyValueFactory("UserName"));
       colsName.setCellValueFactory(new PropertyValueFactory("S_Name"));
       colsDate.setCellValueFactory(new PropertyValueFactory("S_date"));
       colStime.setCellValueFactory(new PropertyValueFactory("S_time"));
       colflightDeparDate.setCellValueFactory(new PropertyValueFactory("flight_departure_date"));
       colflightDeparTime.setCellValueFactory(new PropertyValueFactory("flight_departure_time"));
       colFlightArrivalDate.setCellValueFactory(new PropertyValueFactory("flight_arrival_date"));
       colFlightArrivalTime.setCellValueFactory(new PropertyValueFactory("flight_arrival_time"));
       colFrom.setCellValueFactory(new PropertyValueFactory("fromm"));
       colTo.setCellValueFactory(new PropertyValueFactory("too"));
        colDeparAirName.setCellValueFactory(new PropertyValueFactory("departure_airport_name"));
        colArriAirName.setCellValueFactory(new PropertyValueFactory("arrival_airport_name"));



       try {
           ObservableList<Schedule>list=ScheduleModel.loadAll();
           tblSchedule.setItems(list);
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
       }

   }



    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/ScheduleForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
