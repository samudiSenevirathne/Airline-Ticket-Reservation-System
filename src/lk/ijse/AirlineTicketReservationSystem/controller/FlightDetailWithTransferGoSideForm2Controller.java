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
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightDetailWithTransferGoSideForm2Controller {


    public AnchorPane context;
    public JFXDatePicker dpTransferArrivalDate;
    public JFXTimePicker tpTransferArrivalTime;
    public JFXTextField txtNextFlightId;
    public Label lblNextFlightIdWarning;
    public JFXTextField txtNextAirbusCode;
    public Label lblNextAirbusCodeWarning;
    public JFXDatePicker dpTransferDepartureDate;
    public JFXTimePicker tpTransferDepartureTime;
    public JFXButton btnNextId;
    public JFXComboBox<String>comTransferName;
    public JFXComboBox<String>comTransferAirportName;
    public JFXComboBox<String>comNextAirlineName;
    public JFXButton btnBackId;
    public Matcher nextFlightIdMatcher;
    public Matcher nextAirbusCodeMatcher;

    public  static ArrayList<FlightDetail> getRecords=new ArrayList<>();
    public int tc=FlightDetailFormController.getTransferCount();

    String[]transferNames={"SIN","DOH","ARN","DXB","CDG","MLE","DEL"};
    ObservableList<String> listTransferNames= FXCollections.observableArrayList(transferNames);

    String[]transferAirportNames={"Changi Intl Airport (SIN)","Doha Intl Airport (DOH)","Arlanda Airport (ARN)","Dubai Intl Airport (DXB)","Charles De Gaulle (Roissy) Airport (CDG)","Velana Intl Airport (MLE)","Gandhi Intl Airport (DEL)"};
    ObservableList<String> listTransferAirportNames= FXCollections.observableArrayList(transferAirportNames);

    String[]nextAirlineNames={"Srilankan","Finnair","Qatar Airways","Emirates Airlines","Nordic Regional"};
    ObservableList<String> listNextAirlineNames= FXCollections.observableArrayList(nextAirlineNames);

    public void initialize(){
        comTransferName.setItems(listTransferNames);
        comTransferAirportName.setItems(listTransferAirportNames);
        comNextAirlineName.setItems(listNextAirlineNames);
        if (getRecords!=null){
            for (FlightDetail fd : getRecords) {
                comTransferName.setValue(fd.getYanaTransfer1Name());
                comTransferAirportName.setValue(fd.getYanaTransfer1AirportName());
                comNextAirlineName.setValue(fd.getYanaTransfer1AirlineName());
                dpTransferArrivalDate.setValue(LocalDate.parse(fd.getYanaTransfer1ArrivalDate()));
                tpTransferArrivalTime.setValue(LocalTime.parse(fd.getYanaTransfer1ArrivalTime()));
                txtNextFlightId.setText(fd.getYanaTransfer1FlightId());
                txtNextAirbusCode.setText(fd.getYanaTransfer1AirbusCode());
                dpTransferDepartureDate.setValue(LocalDate.parse(fd.getYanaTransfer1DepartureDate()));
                tpTransferDepartureTime.setValue(LocalTime.parse(fd.getYanaTransfer1DepartureTime()));
            }
        }
    }

    public void txtNextFlightIdKeyReleasedOnAction(KeyEvent keyEvent) {
        lblNextFlightIdWarning.setText("");
        txtNextFlightId.setFocusColor(Paint.valueOf("Blue"));

        Pattern nextFidPattern = Pattern.compile("^(F00-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        nextFlightIdMatcher = nextFidPattern.matcher(txtNextFlightId.getText());

        if (!nextFlightIdMatcher.matches()) {
            txtNextFlightId.requestFocus();
            txtNextFlightId.setFocusColor(Paint.valueOf("Red"));
            lblNextFlightIdWarning.setText("invalid");
        }
    }

    public void txtNextAirbusCodeKeyReleasedOnAction(KeyEvent keyEvent) {
        lblNextAirbusCodeWarning.setText("");
        txtNextAirbusCode.setFocusColor(Paint.valueOf("Blue"));

        Pattern nextAirbusCodePattern = Pattern.compile("^(ABC)([1-9]{1,})([0-9]{0,})$");
        nextAirbusCodeMatcher = nextAirbusCodePattern.matcher(txtNextAirbusCode.getText());

        if (!nextAirbusCodeMatcher.matches()) {
            txtNextAirbusCode.requestFocus();
            txtNextAirbusCode.setFocusColor(Paint.valueOf("Red"));
            lblNextAirbusCodeWarning.setText("invalid");
        }
    }

    public void collectRecords(){
        getRecords.add(new FlightDetail(String.valueOf(comTransferName.getValue()),String.valueOf(comTransferAirportName.getValue()),String.valueOf(dpTransferArrivalDate.getValue())
                ,String.valueOf(tpTransferArrivalTime.getValue()),txtNextFlightId.getText(),txtNextAirbusCode.getText()
                ,String.valueOf(dpTransferDepartureDate.getValue()),String.valueOf(tpTransferDepartureTime.getValue()),String.valueOf(comNextAirlineName.getValue())));
    }

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        if(condition()){
            new Alert(Alert.AlertType.WARNING,"Please fill above blank fields or field!!!").show();
        }else {
            collectRecords();
            if (tc == 2) {
                setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferComeSideForm1");
            } else if (tc > 2) {
                setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferGoSideForm3");
            }
        }
    }

    public boolean condition(){
        boolean condition=false;
        if(String.valueOf(comTransferName.getValue()).isEmpty()|String.valueOf(comTransferAirportName.getValue()).isEmpty()|String.valueOf(dpTransferArrivalDate.getValue()).isEmpty()|String.valueOf(tpTransferArrivalTime.getValue()).isEmpty()|txtNextFlightId.getText().isEmpty()|txtNextAirbusCode.getText().isEmpty()|String.valueOf(dpTransferDepartureDate.getValue()).isEmpty()|String.valueOf(tpTransferDepartureTime.getValue()).isEmpty()|String.valueOf(comNextAirlineName.getValue()).isEmpty()){
            condition=true;
        }
        return condition;
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public  static ArrayList<FlightDetail>getTransfer2GoSideRecords(){
        return getRecords;
    }

    public  static void setTransfer2GoSideRecords(){
        getRecords=new ArrayList();
    }

    public static void setTransfer2GoSideRecordsWithPara(ArrayList<FlightDetail>getRecords){
        FlightDetailWithTransferGoSideForm2Controller.getRecords =getRecords;
    }

    public void btnBackIdOnAction(ActionEvent actionEvent) throws IOException {
        collectRecords();
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferGoSideForm1");
    }
}
