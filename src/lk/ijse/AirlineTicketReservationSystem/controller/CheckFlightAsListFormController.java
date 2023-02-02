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
import javafx.stage.Stage;
import lk.ijse.AirlineTicketReservationSystem.model.FlightModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanModel;
import lk.ijse.AirlineTicketReservationSystem.to.Flight;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlan;

import java.io.IOException;
import java.sql.SQLException;

public class CheckFlightAsListFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tableFlight;
    public TableColumn colFlightId;
    public TableColumn colScheduleId;
    public TableColumn colJourney;
    public TableColumn colAirlineName;
    public TableColumn colAction;
    public TableColumn colTransferCount;
    public TableColumn colAirbusCode;

    public void initialize() {
        colFlightId.setCellValueFactory(new PropertyValueFactory("f_Id"));
        colScheduleId.setCellValueFactory(new PropertyValueFactory("s_Id"));
        colAirlineName.setCellValueFactory(new PropertyValueFactory("airline_name"));
        colJourney.setCellValueFactory(new PropertyValueFactory("journey"));
        colTransferCount.setCellValueFactory(new PropertyValueFactory("transferCount"));
        colAirbusCode.setCellValueFactory(new PropertyValueFactory("airbusCode"));



        try {
            ObservableList<Flight> list = FlightModel.loadAll();
            tableFlight.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

}
