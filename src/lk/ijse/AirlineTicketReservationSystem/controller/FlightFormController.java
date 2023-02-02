package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.AirlineTicketReservationSystem.model.FlightModel;
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.to.Flight;
import lk.ijse.AirlineTicketReservationSystem.to.Schedule;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXTextField txtFlightId;
    public JFXTextField txtAirlineName;
    public JFXComboBox<String>comScheduleId;
    public Label lblFlightIdWarning;
    public Label lblAirlineNameWarning;
    public Matcher fIdMatcher;
    public Matcher fAirlineNameMatcher;
    public JFXComboBox<Object>comJourney;
    public JFXTextField txtTransferCount;
    public JFXTextField txtAirbusCode;
    public Label lblAirbusCodeWarning;
    public Matcher airbusCodeMatcher;

    String[]journey={"Transfer","Direct"};
    ObservableList<Object>jList= FXCollections.observableArrayList(journey);

    public Flight f;
    FlightDetailFormController flightDetailFormController=new FlightDetailFormController();

    public void initialize() {
        getGenerateNewId();
        loadSchedId();
        comJourney.setItems(jList);
        FlightDetailFormController.setFlightDetailsRecords();
        FlightDetailFormController.setRecapDetails();
        FlightDetailWithTransferGoSideForm1Controller.setTransfer1GoSideRecords();
        FlightDetailWithTransferComeSideForm1Controller.setTransfer1ComeSideRecords();
        FlightDetailWithTransferGoSideForm2Controller.setTransfer2GoSideRecords();
        FlightDetailWithTransferComeSideForm2Controller.setTransfer2ComeSideRecords();
        FlightDetailWithTransferGoSideForm3Controller.setTransfer3GoSideRecords();
        FlightDetailWithTransferComeSideForm3Controller.setTransfer3ComeSideRecords();
    }

    public void getGenerateNewId(){
        try {
            txtFlightId.setText(FlightModel.generateNewID());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void clearAll(){
        txtFlightId.clear();
        comScheduleId.setValue(null);
        txtAirlineName.clear();
        comJourney.setValue(null);
        txtTransferCount.setText(null);
        txtAirbusCode.setText(null);
    }

    public boolean condition(){
        boolean condition=false;
        if(txtFlightId.getText().isEmpty()|String.valueOf(comScheduleId.getValue()).isEmpty()|txtAirlineName.getText().isEmpty()|String.valueOf(comJourney.getValue()).isEmpty()|txtTransferCount.getText().isEmpty()|txtAirbusCode.getText().isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            Flight flight = new Flight(txtFlightId.getText(),String.valueOf(comScheduleId.getValue()), txtAirlineName.getText()
                    ,String.valueOf(comJourney.getValue()), Integer.parseInt(txtTransferCount.getText()), txtAirbusCode.getText());

            try {
                if (FlightModel.save(flight)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    clearAll();
                    getGenerateNewId();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }


    private void loadSchedId() {
        try {
            ObservableList<String> ids = FlightModel.loadSceduleIds();
            comScheduleId.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        }else {
            try {
                if (FlightModel.delete(txtFlightId.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted!...").show();
                    clearAll();
                    getGenerateNewId();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.WARNING, "Deleted Failed!...").show();
            }
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to edit!!!").show();
        }else {
            if(f.getF_Id().equals(txtFlightId.getText())&f.getS_Id().equals(String.valueOf(comScheduleId.getValue()))&f.getAirline_name().equals( txtAirlineName.getText())&f.getJourney().equals(String.valueOf(comJourney.getValue()))&String.valueOf(f.getTransferCount()).equals(txtTransferCount.getText())&f.getAirbusCode().equals(txtAirbusCode.getText())){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                Flight flight = new Flight(txtFlightId.getText(),String.valueOf(comScheduleId.getValue()), txtAirlineName.getText()
                        ,String.valueOf(comJourney.getValue()), Integer.parseInt(txtTransferCount.getText()), txtAirbusCode.getText());
                try {
                    if (FlightModel.update(flight)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                        clearAll();
                        getGenerateNewId();
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println(ex);
                    new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
                }
            }
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
        f=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckFlightAsListForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtFlightIdOnAction(ActionEvent actionEvent) {
        f=checking();
    }

    public Flight checking(){
        try {
            search();
            f=new Flight(txtFlightId.getText(),String.valueOf(comScheduleId.getValue()), txtAirlineName.getText()
                    ,String.valueOf(comJourney.getValue()), Integer.parseInt(txtTransferCount.getText()), txtAirbusCode.getText());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
       return f;
    }


    private void search() throws ClassNotFoundException, SQLException {
        Flight flight=FlightModel.search(txtFlightId.getText());
        if(flight!=null){
            fillData(flight);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }

    }

    private void fillData(Flight f) {
        txtFlightId.setText(f.getF_Id());
        comScheduleId.setValue(f.getS_Id());
        txtAirlineName.setText(f.getAirline_name());
        comJourney.setValue(f.getJourney());
        txtTransferCount.setText(String.valueOf(f.getTransferCount()));
        txtAirbusCode.setText(f.getAirbusCode());

    }

    public void txtFlightIdKeyTypedOnAction(KeyEvent keyEvent) {
        lblFlightIdWarning.setText("");
        txtFlightId.setFocusColor(Paint.valueOf("Blue"));

        Pattern fIdPattern = Pattern.compile("^(F00-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        fIdMatcher = fIdPattern.matcher(txtFlightId.getText());

        if (!fIdMatcher.matches()) {
            txtFlightId.requestFocus();
            txtFlightId.setFocusColor(Paint.valueOf("Red"));
            lblFlightIdWarning.setText("invalid");
        }
    }

    public void txtAirlineNameTypedOnAction(KeyEvent keyEvent) {
        lblAirlineNameWarning.setText("");
        txtAirlineName.setFocusColor(Paint.valueOf("Blue"));

        Pattern airlineNamePattern =  Pattern.compile("^[a-zA-Z]{4,}$");
        fAirlineNameMatcher = airlineNamePattern.matcher(txtAirlineName.getText());

        if (!fAirlineNameMatcher.matches()) {
            txtAirlineName.requestFocus();
            txtAirlineName.setFocusColor(Paint.valueOf("Red"));
            lblAirlineNameWarning.setText("invalid");
        }
    }


    public void txtAirbusCodeOnAction(KeyEvent keyEvent) {
        lblAirbusCodeWarning.setText("");
        txtAirbusCode.setFocusColor(Paint.valueOf("Blue"));

        Pattern AirbusCodePattern = Pattern.compile("^(ABC)([1-9]{1,})([0-9]{0,})$");
        airbusCodeMatcher = AirbusCodePattern.matcher(txtAirbusCode.getText());

        if (!airbusCodeMatcher.matches()) {
            txtAirbusCode.requestFocus();
            txtAirbusCode.setFocusColor(Paint.valueOf("Red"));
            lblAirbusCodeWarning.setText("invalid");
        }
    }
}
