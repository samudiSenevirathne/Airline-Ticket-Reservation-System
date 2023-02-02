package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.*;
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
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;
import lk.ijse.AirlineTicketReservationSystem.to.Schedule;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScheduleFormController {

    public AnchorPane context;
    public JFXButton btnMiniId;
    public JFXTextField txtScheduleId;
    public JFXTextField txtScheduleName;
    public JFXComboBox<String>comUserName;
    public Label lblSceIdWarning;
    public Label lblScelNameWarning;
    public Matcher scheduleIdMatcher;
    public Matcher scheduleNameMatcher;
    public JFXComboBox<Object>comTo;
    public Label lblFrom;
    public JFXComboBox<Object>comDepaAirportName;
    public JFXComboBox<Object>comArrivalAirportName;
    public JFXDatePicker dpScheduleDate;
    public JFXTimePicker tpScheduleTime;
    public JFXTimePicker tpFlightDepartureTime;
    public JFXDatePicker dpFlightDepartureDate;
    public JFXDatePicker dpFlightArrivalDate;
    public JFXTimePicker tpFlightArrivalTime;

    String[]too={"Parise","London","USA","UK","NewYork","Malesiya","Dubai","Katar","Finland","India","Canada"
            ,"Japan","Singapore","Australia","NewZealand","Moldives","Thailand","Koria","Jurman","Turkey","Alaska","Indonesia","China"};
    ObservableList<Object>listToo= FXCollections.observableArrayList(too);

    String[]airportNames={"Colombo (CMB)","Helsinki (HEL)","Hambantota (HRI)","Chicago (MDW)","Charlotte (CLT)","Matthews, NC","Kansai Intl Airport(Japan)","Vantaa, Finland"};
    ObservableList<Object>listAirportNames= FXCollections.observableArrayList(airportNames);

    public Schedule s;

    public void initialize() {
        getGenerateNewId();
        loadUseName();
        comTo.setItems(listToo);
        comDepaAirportName.setItems(listAirportNames);
        comArrivalAirportName.setItems(listAirportNames);
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
            txtScheduleId.setText(ScheduleModel.generateNewID());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void clearAll(){
       txtScheduleId.clear();
       txtScheduleName.clear();
       comUserName.setValue(null);
       dpScheduleDate.setValue(null);
       tpScheduleTime.setValue(null);
       dpFlightDepartureDate.setValue(null);
       tpFlightDepartureTime.setValue(null);
       dpFlightArrivalDate.setValue(null);
       tpFlightArrivalTime.setValue(null);
       lblFrom.setText(null);
       comTo.setValue(null);
       comDepaAirportName.setValue(null);
       comArrivalAirportName.setValue(null);
    }

    public boolean condition(){
        boolean condition=false;
        if(txtScheduleId.getText().isEmpty()|txtScheduleName.getText().isEmpty()|String.valueOf(comUserName.getValue()).isEmpty()|String.valueOf(dpScheduleDate.getValue()).isEmpty()|String.valueOf(tpScheduleTime.getValue()).isEmpty()|String.valueOf(dpFlightDepartureDate.getValue()).isEmpty()|String.valueOf(tpFlightDepartureTime.getValue()).isEmpty()|String.valueOf(dpFlightArrivalDate.getValue()).isEmpty()|String.valueOf(tpFlightArrivalTime.getValue()).isEmpty()|lblFrom.getText().isEmpty()|String.valueOf(comTo.getValue()).isEmpty()|String.valueOf(comDepaAirportName.getValue()).isEmpty()|String.valueOf(comArrivalAirportName.getValue()).isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            lblFrom.setText("SriLanka");
            Schedule schedule = new Schedule(txtScheduleId.getText(),String.valueOf(comUserName.getValue()), txtScheduleName.getText()
                    , String.valueOf(dpScheduleDate.getValue()), String.valueOf(tpScheduleTime.getValue())
                    , String.valueOf(dpFlightDepartureDate.getValue()), String.valueOf(tpFlightDepartureTime.getValue())
                    , String.valueOf(dpFlightArrivalDate.getValue()), String.valueOf(tpFlightArrivalTime.getValue())
                    , lblFrom.getText(),String.valueOf(comTo.getValue()),String.valueOf(comDepaAirportName.getValue()),String.valueOf(comArrivalAirportName.getValue()));
            try {
                if (ScheduleModel.save(schedule)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    clearAll();
                    getGenerateNewId();
                    lblFrom.setText("You no need input");
                } else {
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    private void loadUseName() {
        try {
            ObservableList<String> ids = ScheduleModel.loadUserNames();
            comUserName.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        }else {
            try {
                if (ScheduleModel.delete(txtScheduleId.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted!...").show();
                    clearAll();
                    getGenerateNewId();
                    lblFrom.setText("You no need input");
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
            if(s.getS_Id().equals(txtScheduleId.getText())&s.getUserName().equals(String.valueOf(comUserName.getValue()))&s.getS_Name().equals( txtScheduleName.getText())&s.getS_date().equals(String.valueOf(dpScheduleDate.getValue()))&s.getS_time().equals(String.valueOf(tpScheduleTime.getValue()))&s.getFlight_departure_date().equals(String.valueOf(dpFlightDepartureDate.getValue()))&s.getFlight_departure_time().equals(String.valueOf(tpFlightDepartureTime.getValue()))&s.getFlight_arrival_date().equals(String.valueOf(dpFlightArrivalDate.getValue()))&s.getFlight_arrival_time().equals(String.valueOf(tpFlightArrivalTime.getValue()))&s.getFromm().equals(lblFrom.getText())&s.getToo().equals(String.valueOf(comTo.getValue()))&s.getDeparture_airport_name().equals(String.valueOf(comDepaAirportName.getValue()))&s.getArrival_airport_name().equals(String.valueOf(comArrivalAirportName.getValue()))){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                lblFrom.setText("SriLanka");
                Schedule schedule = new Schedule(txtScheduleId.getText(),String.valueOf(comUserName.getValue()), txtScheduleName.getText()
                        , String.valueOf(dpScheduleDate.getValue()), String.valueOf(tpScheduleTime.getValue())
                        , String.valueOf(dpFlightDepartureDate.getValue()), String.valueOf(tpFlightDepartureTime.getValue())
                        , String.valueOf(dpFlightArrivalDate.getValue()), String.valueOf(tpFlightArrivalTime.getValue())
                        , lblFrom.getText(),String.valueOf(comTo.getValue()),String.valueOf(comDepaAirportName.getValue()),String.valueOf(comArrivalAirportName.getValue()));

                try {
                    if (ScheduleModel.update(schedule)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                        clearAll();
                        getGenerateNewId();
                        lblFrom.setText("You no need input");
                    }
                } catch (ClassNotFoundException | SQLException | ParseException ex) {
                    System.out.println(ex);
                    new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
                }
            }
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
       s=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckScheduleAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtScheduleIdOnAction(ActionEvent actionEvent) {
        s=checking();
    }

    public Schedule checking(){
        try {
            search();
            s=new Schedule(txtScheduleId.getText(),String.valueOf(comUserName.getValue()), txtScheduleName.getText()
                    , String.valueOf(dpScheduleDate.getValue()), String.valueOf(tpScheduleTime.getValue())
                    , String.valueOf(dpFlightDepartureDate.getValue()), String.valueOf(tpFlightDepartureTime.getValue())
                    , String.valueOf(dpFlightArrivalDate.getValue()), String.valueOf(tpFlightArrivalTime.getValue())
                    , lblFrom.getText(),String.valueOf(comTo.getValue()),String.valueOf(comDepaAirportName.getValue()),String.valueOf(comArrivalAirportName.getValue()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    private void search() throws ClassNotFoundException, SQLException {
        Schedule schedule= ScheduleModel.search(txtScheduleId.getText());
        if(schedule!=null){
            fillData(schedule);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(Schedule s) {
        txtScheduleId.setText(s.getS_Id());
        comUserName.setValue(s.getUserName());
        txtScheduleName.setText(s.getS_Name());
        dpScheduleDate.setValue(LocalDate.parse(s.getS_date()));
        tpScheduleTime.setValue(LocalTime.parse(s.getS_time()));
        dpFlightDepartureDate.setValue(LocalDate.parse(s.getFlight_departure_date()));
        tpFlightDepartureTime.setValue(LocalTime.parse(s.getFlight_departure_time()));
        dpFlightArrivalDate.setValue(LocalDate.parse(s.getFlight_arrival_date()));
        tpFlightArrivalTime.setValue(LocalTime.parse(s.getFlight_arrival_time()));
        lblFrom.setText(s.getFromm());
        comTo.setValue(s.getToo());
        comDepaAirportName.setValue(s.getDeparture_airport_name());
        comArrivalAirportName.setValue(s.getArrival_airport_name());
    }


    public void txtScheduleNameKeyTypedOnAction(KeyEvent keyEvent) {
        lblScelNameWarning.setText("");
        txtScheduleName.setFocusColor(Paint.valueOf("Blue"));

        Pattern sNamePattern = Pattern.compile("^[a-zA-Z]{5,}$");
        scheduleNameMatcher = sNamePattern.matcher(txtScheduleName.getText());

        if(!scheduleNameMatcher.matches()) {
            txtScheduleName.requestFocus();
            txtScheduleName.setFocusColor(Paint.valueOf("Red"));
            lblScelNameWarning.setText("invalid");
        }
    }

    public void txtScheduleIdKeyTypedOnAction(KeyEvent keyEvent) {
        lblSceIdWarning.setText("");
        txtScheduleId.setFocusColor(Paint.valueOf("Blue"));

        Pattern scheduleIdPattern = Pattern.compile("^(S00-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        scheduleIdMatcher = scheduleIdPattern.matcher(txtScheduleId.getText());

        if (!scheduleIdMatcher.matches()) {
            txtScheduleId.requestFocus();
            txtScheduleId.setFocusColor(Paint.valueOf("Red"));
            lblSceIdWarning.setText("invalid");
        }
    }


}
