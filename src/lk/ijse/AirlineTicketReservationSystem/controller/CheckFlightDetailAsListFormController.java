package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;

import java.io.IOException;
import java.sql.SQLException;

public class CheckFlightDetailAsListFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public TableView tableFlightDeatail;
    public TableColumn colFlightDetailId;
    public TableColumn colGuidline;
    public TableColumn colDirectGoArrivalDate;
    public TableColumn colDirectGoArrivalTime;
    public TableColumn colDirectComeArrivalDate;
    public TableColumn colDirectComeArrivalTime;
    public JFXScrollPane scrollpaneId;

    public TableColumn Transfer1GoName;
    public TableColumn Transfer1GoAirportName;
    public TableColumn Transfer1GoAirlineName;
    public TableColumn Transfer1GoFlightId;
    public TableColumn Transfer1GoAirbusCode;
    public TableColumn Transfer1GoArrivalDate;
    public TableColumn Transfer1GoArrivalTime;
    public TableColumn Transfer1GoDepartureDate;
    public TableColumn Transfer1GoDepartureTime;
    public TableColumn Transfer2GoName;
    public TableColumn Transfer2GoAirportName;
    public TableColumn Transfer2GoAirlineName;
    public TableColumn Transfer2GoFlightId;
    public TableColumn Transfer2GoAirbusCode;
    public TableColumn Transfer2GoArrivalDate;
    public TableColumn Transfer2GoArrivalTime;
    public TableColumn Transfer2GoDepartureDate;
    public TableColumn Transfer2GoDepartureTime;
    public TableColumn Transfer3GoName;
    public TableColumn Transfer3GoAirportName;
    public TableColumn Transfer3GoAirlineName;
    public TableColumn Transfer3GoFlightId;
    public TableColumn Transfer3GoAirbusCode;
    public TableColumn Transfer3GoArrivalDate;
    public TableColumn Transfer3GoArrivalTime;
    public TableColumn Transfer3GoDepartureDate;
    public TableColumn Transfer3GoDepartureTime;
    public TableColumn Transfer1ComeName;
    public TableColumn Transfer1ComeAirportName;
    public TableColumn Transfer1ComeAirlineName;
    public TableColumn Transfer1ComeFlightId;
    public TableColumn Transfer1ComeAirbusCode;
    public TableColumn Transfer1ComeArrivalDate;
    public TableColumn Transfer1ComeArrivalTime;
    public TableColumn Transfer1ComeDepartureDate;
    public TableColumn Transfer1ComeDepartureTime;
    public TableColumn Transfer2ComeName;
    public TableColumn Transfer2ComeAirportName;
    public TableColumn Transfer2ComeAirlineName;
    public TableColumn Transfer2ComeFlightId;
    public TableColumn Transfer2ComeAirbusCode;
    public TableColumn Transfer2ComeArrivalDate;
    public TableColumn Transfer2ComeArrivalTime;
    public TableColumn Transfer2ComeDepartureDate;
    public TableColumn Transfer2ComeDepartureTime;
    public TableColumn Transfer3ComeName;
    public TableColumn Transfer3ComeAirportName;
    public TableColumn Transfer3ComeAirlineName;
    public TableColumn Transfer3ComeFlightId;
    public TableColumn Transfer3ComeAirbusCode;
    public TableColumn Transfer3ComeArrivalDate;
    public TableColumn Transfer3ComeArrivalTime;
    public TableColumn Transfer3ComeDepartureDate;
    public TableColumn Transfer3ComeDepartureTime;

    public void initialize() {
        colFlightDetailId.setCellValueFactory(new PropertyValueFactory("f_Detail_Id"));
        colGuidline.setCellValueFactory(new PropertyValueFactory("guidline"));
        colDirectGoArrivalDate.setCellValueFactory(new PropertyValueFactory("DirectYanaArrivalDate"));
        colDirectGoArrivalTime.setCellValueFactory(new PropertyValueFactory("DirectYanaArrivalTime"));
        colDirectComeArrivalDate.setCellValueFactory(new PropertyValueFactory("DirectEnaArrivalDate"));
        colDirectComeArrivalTime.setCellValueFactory(new PropertyValueFactory("DirectEnaArrivalTime"));

         Transfer1GoName.setCellValueFactory(new PropertyValueFactory("yanaTransfer1Name"));
         Transfer1GoAirportName.setCellValueFactory(new PropertyValueFactory("yanaTransfer1AirportName"));
         Transfer1GoAirlineName.setCellValueFactory(new PropertyValueFactory("yanaTransfer1AirlineName"));
         Transfer1GoFlightId.setCellValueFactory(new PropertyValueFactory("yanaTransfer1FlightId"));
         Transfer1GoAirbusCode.setCellValueFactory(new PropertyValueFactory("yanaTransfer1AirbusCode"));
         Transfer1GoArrivalDate.setCellValueFactory(new PropertyValueFactory("yanaTransfer1ArrivalDate"));
         Transfer1GoArrivalTime.setCellValueFactory(new PropertyValueFactory("yanaTransfer1ArrivalTime"));
         Transfer1GoDepartureDate.setCellValueFactory(new PropertyValueFactory("yanaTransfer1DepartureDate"));
         Transfer1GoDepartureTime.setCellValueFactory(new PropertyValueFactory("yanaTransfer1DepartureTime"));

         Transfer2GoName.setCellValueFactory(new PropertyValueFactory("yanaTransfer2Name"));
         Transfer2GoAirportName.setCellValueFactory(new PropertyValueFactory("yanaTransfer2AirportName"));
         Transfer2GoAirlineName.setCellValueFactory(new PropertyValueFactory("yanaTransfer2AirlineName"));
         Transfer2GoFlightId.setCellValueFactory(new PropertyValueFactory("yanaTransfer2FlightId"));
         Transfer2GoAirbusCode.setCellValueFactory(new PropertyValueFactory("yanaTransfer2AirbusCode"));
         Transfer2GoArrivalDate.setCellValueFactory(new PropertyValueFactory("yanaTransfer2ArrivalDate"));
         Transfer2GoArrivalTime.setCellValueFactory(new PropertyValueFactory("yanaTransfer2ArrivalTime"));
         Transfer2GoDepartureDate.setCellValueFactory(new PropertyValueFactory("yanaTransfer2DepartureDate"));
         Transfer2GoDepartureTime.setCellValueFactory(new PropertyValueFactory("yanaTransfer2DepartureTime"));

         Transfer3GoName.setCellValueFactory(new PropertyValueFactory("yanaTransfer3Name"));
         Transfer3GoAirportName.setCellValueFactory(new PropertyValueFactory("yanaTransfer3AirportName"));
         Transfer3GoAirlineName.setCellValueFactory(new PropertyValueFactory("yanaTransfer3AirlineName"));
         Transfer3GoFlightId.setCellValueFactory(new PropertyValueFactory("yanaTransfer3FlightId"));
         Transfer3GoAirbusCode.setCellValueFactory(new PropertyValueFactory("yanaTransfer3AirbusCode"));
         Transfer3GoArrivalDate.setCellValueFactory(new PropertyValueFactory("yanaTransfer3ArrivalDate"));
         Transfer3GoArrivalTime.setCellValueFactory(new PropertyValueFactory("yanaTransfer3ArrivalTime"));
         Transfer3GoDepartureDate.setCellValueFactory(new PropertyValueFactory("yanaTransfer3DepartureDate"));
         Transfer3GoDepartureTime.setCellValueFactory(new PropertyValueFactory("yanaTransfer3DepartureTime"));

         Transfer1ComeName.setCellValueFactory(new PropertyValueFactory("enaTransfer1Name"));
         Transfer1ComeAirportName.setCellValueFactory(new PropertyValueFactory("enaTransfer1AirportName"));
         Transfer1ComeAirlineName.setCellValueFactory(new PropertyValueFactory("enaTransfer1AirlineName"));
         Transfer1ComeFlightId.setCellValueFactory(new PropertyValueFactory("enaTransfer1FlightId"));
         Transfer1ComeAirbusCode.setCellValueFactory(new PropertyValueFactory("enaTransfer1AirbusCode"));
         Transfer1ComeArrivalDate.setCellValueFactory(new PropertyValueFactory("enaTransfer1ArrivalDate"));
         Transfer1ComeArrivalTime.setCellValueFactory(new PropertyValueFactory("enaTransfer1ArrivalTime"));
         Transfer1ComeDepartureDate.setCellValueFactory(new PropertyValueFactory("enaTransfer1DepartureDate"));
         Transfer1ComeDepartureTime.setCellValueFactory(new PropertyValueFactory("enaTransfer1DepartureTime"));

         Transfer2ComeName.setCellValueFactory(new PropertyValueFactory("enaTransfer2Name"));
         Transfer2ComeAirportName.setCellValueFactory(new PropertyValueFactory("enaTransfer2AirportName"));
         Transfer2ComeAirlineName.setCellValueFactory(new PropertyValueFactory("enaTransfer2AirlineName"));
         Transfer2ComeFlightId.setCellValueFactory(new PropertyValueFactory("enaTransfer2FlightId"));
         Transfer2ComeAirbusCode.setCellValueFactory(new PropertyValueFactory("enaTransfer2AirbusCode"));
         Transfer2ComeArrivalDate.setCellValueFactory(new PropertyValueFactory("enaTransfer2ArrivalDate"));
         Transfer2ComeArrivalTime.setCellValueFactory(new PropertyValueFactory("enaTransfer2ArrivalTime"));
         Transfer2ComeDepartureDate.setCellValueFactory(new PropertyValueFactory("enaTransfer2DepartureDate"));
         Transfer2ComeDepartureTime.setCellValueFactory(new PropertyValueFactory("enaTransfer2DepartureTime"));

         Transfer3ComeName.setCellValueFactory(new PropertyValueFactory("enaTransfer3Name"));
         Transfer3ComeAirportName.setCellValueFactory(new PropertyValueFactory("enaTransfer3AirportName"));
         Transfer3ComeAirlineName.setCellValueFactory(new PropertyValueFactory("enaTransfer3AirlineName"));
         Transfer3ComeFlightId.setCellValueFactory(new PropertyValueFactory("enaTransfer3FlightId"));
         Transfer3ComeAirbusCode.setCellValueFactory(new PropertyValueFactory("enaTransfer3AirbusCode"));
         Transfer3ComeArrivalDate.setCellValueFactory(new PropertyValueFactory("enaTransfer3ArrivalDate"));
         Transfer3ComeArrivalTime.setCellValueFactory(new PropertyValueFactory("enaTransfer3ArrivalTime"));
         Transfer3ComeDepartureDate.setCellValueFactory(new PropertyValueFactory("enaTransfer3DepartureDate"));
         Transfer3ComeDepartureTime.setCellValueFactory(new PropertyValueFactory("enaTransfer3DepartureTime"));

        try {
            ObservableList<FlightDetail> list = FlightDetailModel.loadAll();
            tableFlightDeatail.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
