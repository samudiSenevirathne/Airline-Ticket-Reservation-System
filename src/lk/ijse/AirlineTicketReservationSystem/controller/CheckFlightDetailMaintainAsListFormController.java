package lk.ijse.AirlineTicketReservationSystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.ClassTypeModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailMaintainModel;
import lk.ijse.AirlineTicketReservationSystem.to.ClassType;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetailMaintain;

import java.io.IOException;
import java.sql.SQLException;

public class CheckFlightDetailMaintainAsListFormController {

    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tableFlightDeatailMaintain;
    public TableColumn colFlightDetailMaintainId;
    public TableColumn colFlightDetailId;
    public TableColumn colFlightId;
    public TableColumn colCommenGuidlineCount;
    public TableColumn colAllGuidlineCount;
    public TableColumn colAction;

    public void initialize() {
        colFlightDetailMaintainId.setCellValueFactory(new PropertyValueFactory("fli_Fli_Det_Main_Id"));
        colFlightDetailId.setCellValueFactory(new PropertyValueFactory("f_Detail_Id"));
        colFlightId.setCellValueFactory(new PropertyValueFactory("f_Id"));
        colCommenGuidlineCount.setCellValueFactory(new PropertyValueFactory("commen_guidline_count"));
        colAllGuidlineCount.setCellValueFactory(new PropertyValueFactory("all_guidline_count"));



        try {
            ObservableList<FlightDetailMaintain> list = FlightDetailMaintainModel.loadAll();
            tableFlightDeatailMaintain.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightFlightDetailMaintainForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
