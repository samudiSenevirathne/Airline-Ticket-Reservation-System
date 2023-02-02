package lk.ijse.AirlineTicketReservationSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.to.Custom;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;

import java.io.IOException;
import java.util.ArrayList;

public class FlightAvailabilityForm2Controller {

    public AnchorPane context;
    public  AnchorPane inAnchorId;
    public ScrollPane scrollPane;
    public Label lblFlightId;
    public Label lbltimeperiodId;
    public Label lbljourneyId;
    public Label lblAirlineId;
    public Label lbltransferId;
    public Label lblTotalId;

    public AnchorPane inAnchorId1;
    public Label lblFlightId1;
    public Label lbltimeperiodId1;
    public Label lbljourneyId1;
    public Label lblAirlineId1;
    public Label lbltransferId1;
    public Label lblTotalId1;

    public ArrayList<Custom> arrayList1=FlightAvailabilityFormController.getAllRecords1();
    public ArrayList<Custom>arrayList2=FlightAvailabilityFormController.getAllRecords2();

    public static ArrayList<String>fIdList=new ArrayList<>();


    public void initialize() {
        if (arrayList1 != null) {
            for (Custom c : arrayList1) {
                lblFlightId.setText(c.getF_Id());
                lbltimeperiodId.setText(c.getFlight_departure_time() + "  " + c.getAirbusCode() + "  " + c.getAirline_name());
                lbljourneyId.setText(FlightAvailabilityFormController.getFrom() + "   -   " + FlightAvailabilityFormController.getTo());
                lblAirlineId.setText(c.getDeparture_airport_name() + "  -  " + c.getArrival_airport_name());
                lbltransferId.setText(FlightAvailabilityFormController.getType()+" class    "+c.getTransferCount() + " stops");
                if(arrayList1 != null & arrayList2!=null) {
                    lblTotalId.setText("$"+String.valueOf(Math.round(c.getPrice() *(FlightAvailabilityFormController.getCount()*2))/360));
                }else{
                    lblTotalId.setText("$"+String.valueOf(Math.round(c.getPrice() *FlightAvailabilityFormController.getCount())/360));

                }
            }
        }
        if (arrayList2!=null) {
            for (Custom c : arrayList2) {
                lblFlightId1.setText(c.getF_Id());
                lbltimeperiodId1.setText(c.getFlight_departure_time() + "  " + c.getAirbusCode() + "  " + c.getAirline_name());
                lbljourneyId1.setText(FlightAvailabilityFormController.getTo() + "   -   " + FlightAvailabilityFormController.getFrom());
                lblAirlineId1.setText(c.getDeparture_airport_name() + "  -  " + c.getArrival_airport_name());
                lbltransferId1.setText(FlightAvailabilityFormController.getType()+" class    "+c.getTransferCount() + " stops");
                lblTotalId1.setText("$ 0.0");
            }
        }else{
            inAnchorId1.setDisable(true);
        }
    }

    public static ArrayList<String> getFidList(){
        return fIdList;
    }

    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
       /* FlightAvailabilityFormController.setAllRecords1();
        FlightAvailabilityFormController.setAllRecords2();*/
        fIdList.add(lblFlightId.getText());
        fIdList.add(lblFlightId1.getText());
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/PassengerForm");
    }

    private  void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

}
