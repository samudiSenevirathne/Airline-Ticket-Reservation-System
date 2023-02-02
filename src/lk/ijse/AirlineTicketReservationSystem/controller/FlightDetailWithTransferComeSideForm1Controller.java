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
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;
import rex.utils.S;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightDetailWithTransferComeSideForm1Controller {

    public AnchorPane context;
    public JFXButton btnSaveId;
    public JFXButton btnDeleteId;
    public JFXButton btnEditId;

    public JFXButton btnNextId;
    public JFXDatePicker dpTransferArrivalDate;
    public JFXTimePicker tpTransferArrivalTime;
    public JFXTextField txtNextFlightId;
    public Label lblNextFlightIdWarning;
    public JFXTextField txtNextAirbusCode;
    public Label lblNextAirbusCodeWarning;
    public JFXDatePicker dpTransferDepartureDate;
    public JFXTimePicker tpTransferDepartureTime;
    public JFXComboBox<String>comTransferName;
    public JFXComboBox<String>comTransferAirportName;
    public JFXComboBox<String>comNextAirlineName;
    public JFXButton btnBackId;
    public Matcher nextFlightIdMatcher;
    public Matcher nextAirbusCodeMatcher;

    public int tc=FlightDetailFormController.getTransferCount();
    public  static ArrayList<FlightDetail> getRecords=new ArrayList<>();

    public static ArrayList<FlightDetail> flightDetailsRecords1=new ArrayList<>();
    public static ArrayList<FlightDetail> flightDetailsRecords2=new ArrayList<>();

    public static ArrayList<FlightDetail>fdArray=new ArrayList<>();
    public static ArrayList<FlightDetail>fdArray1=new ArrayList<>();
    public static ArrayList<FlightDetail>fdArray2=new ArrayList<>();

    public String fdId;
    public String guidline;
    public String transferName;
    public String transferAirportName;
    public String nextAirlineName;
    public String transferDepartureDate;
    public String transferDepartureTime;
    public String nextFlightId;
    public String nextAirbusCode;
    public String transferArrivalDate;
    public String transferArrivalTime;

    public String pFdId;
    public String pGuidline;
    public String pYanaTransfer1Name;
    public String pYanaTransfer1AirportName;
    public String pYanaTransfer1NextAirlineName;
    public String pYanaTransfer1DepartureDate;
    public String pYanaTransfer1DepartureTime;
    public String pYanaTransfer1NextFlightId;
    public String pYanaTransfer1NextAirbusCode;
    public String pYanaTransfer1ArrivalDate;
    public String pYanaTransfer1ArrivalTime;
    public String pEnaTransfer1Name;
    public String pEnaTransfer1AirportName;
    public String pEnaTransfer1NextAirlineName;
    public String pEnaTransfer1DepartureDate;
    public String pEnaTransfer1DepartureTime;
    public String pEnaTransfer1NextFlightId;
    public String pEnaTransfer1NextAirbusCode;
    public String pEnaTransfer1ArrivalDate;
    public String pEnaTransfer1ArrivalTime;

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
        if(tc==1){
            btnNextId.setDisable(true);
        }else{
            btnSaveId.setDisable(true);
            btnEditId.setDisable(true);
            btnDeleteId.setDisable(true);
        }
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

    public void clearAll(){
        comTransferName.setValue(null);
        comTransferAirportName.setValue(null);
        comNextAirlineName.setValue(null);
        dpTransferDepartureDate.setValue(null);
        tpTransferDepartureTime.setValue(null);
        dpTransferArrivalDate.setValue(null);
        tpTransferArrivalTime.setValue(null);
        txtNextFlightId.clear();
        txtNextAirbusCode.clear();
    }

    public void collectRecords(){
        getRecords.add(new FlightDetail(String.valueOf(comTransferName.getValue()),String.valueOf(comTransferAirportName.getValue()),String.valueOf(dpTransferArrivalDate.getValue())
                ,String.valueOf(tpTransferArrivalTime.getValue()),txtNextFlightId.getText(),txtNextAirbusCode.getText()
                ,String.valueOf(dpTransferDepartureDate.getValue()),String.valueOf(tpTransferDepartureTime.getValue()),String.valueOf(comNextAirlineName.getValue())));
    }
    public void getOtherPreviousSidesRecords(){
        fdArray = FlightDetailFormController.getFdArray();
        fdArray1 = FlightDetailFormController.getFdArray1();
        fdArray2 = FlightDetailFormController.getFdArray2();
    }

    public void getOtherSidesRecords(){
        flightDetailsRecords1=FlightDetailFormController.getFlightDetailsRecords();
        flightDetailsRecords2=FlightDetailWithTransferGoSideForm1Controller.getTransfer1GoSideRecords();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()){
            new Alert(Alert.AlertType.WARNING,"Please fill above blank fields or field!!!").show();
        }else {
            getOtherSidesRecords();
            setFdRecordsVariables();
            setTranGoSideRecords1Variables();
            FlightDetail fd = new FlightDetail(fdId,guidline,transferName,transferAirportName,transferArrivalDate
                    ,transferArrivalTime,nextFlightId,nextAirbusCode,transferDepartureDate,transferDepartureTime
                    ,nextAirlineName,String.valueOf(comTransferName.getValue()),String.valueOf(comTransferAirportName.getValue())
                    ,txtNextFlightId.getText(),txtNextAirbusCode.getText(),String.valueOf(dpTransferArrivalDate.getValue())
                    ,String.valueOf(tpTransferArrivalTime.getValue()),String.valueOf(dpTransferDepartureDate.getValue())
                    ,String.valueOf(tpTransferDepartureTime.getValue()),String.valueOf(comNextAirlineName.getValue()));
            try {
                if(FlightDetailModel.save2(fd)){
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    clearAll();
                    FlightDetailFormController.setFlightDetailsRecords();
                    FlightDetailWithTransferGoSideForm1Controller.setTransfer1GoSideRecords();
                    setTransfer1ComeSideRecords();
                    setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightFlightDetailMaintainForm");
                }else{
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (SQLException  | ClassNotFoundException | IOException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    public void setFdRecordsVariables(){
        for(FlightDetail fd:flightDetailsRecords1){
            fdId=fd.getF_Detail_Id();
            guidline=fd.getGuidline();
        }
    }

    public void setTranGoSideRecords1Variables(){
        for(FlightDetail fd:flightDetailsRecords2){
            transferName=fd.getYanaTransfer1Name();
            transferAirportName=fd.getYanaTransfer1AirportName();
            nextAirlineName=fd.getYanaTransfer1AirlineName();
            transferDepartureDate=fd.getYanaTransfer1DepartureDate();
            transferDepartureTime=fd.getYanaTransfer1DepartureTime();
            nextFlightId=fd.getYanaTransfer1FlightId();
            nextAirbusCode=fd.getYanaTransfer1AirbusCode();
            transferArrivalDate=fd.getYanaTransfer1ArrivalDate();
            transferArrivalTime=fd.getYanaTransfer1ArrivalTime();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        } else {
            try {
                if (FlightDetailModel.delete(FlightDetailFormController.getFlightDetailId())){
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted!...").show();
                    clearAll();
                    clearOtherRecords();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.WARNING, "Deleted Failed!...").show();
            }
        }
    }

    public void clearOtherRecords(){
        FlightDetailFormController.setFlightDetailsRecords();
        FlightDetailFormController.setRecapDetails();
        FlightDetailWithTransferGoSideForm1Controller.setTransfer1GoSideRecords();
        setTransfer1ComeSideRecords();
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        if (condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to edit!!!").show();
        } else {
            getOtherPreviousSidesRecords();
            getOtherSidesRecords();
            setPreviousFdRecordsVariables();
            setPreviousTranGoSideRecords1Variables();
            setPreviousTranComeSideRecords1Variables();
            setFdRecordsVariables();
            setTranGoSideRecords1Variables();
            if(pFdId.equals(fdId) & pGuidline.equals(guidline) & pYanaTransfer1Name.equals(transferName)
                & pYanaTransfer1AirportName.equals(transferAirportName) & pYanaTransfer1NextAirlineName.equals(nextAirlineName)
                & pYanaTransfer1DepartureDate.equals(transferDepartureDate) & pYanaTransfer1DepartureTime.equals(transferDepartureTime)
                & pYanaTransfer1NextFlightId.equals(nextFlightId) & pYanaTransfer1NextAirbusCode.equals(nextAirbusCode)
                & pYanaTransfer1ArrivalDate.equals(transferArrivalDate) & pYanaTransfer1ArrivalTime.equals(transferArrivalTime)
                & pEnaTransfer1Name.equals(String.valueOf(comTransferName.getValue()))
                & pEnaTransfer1AirportName.equals(String.valueOf(comTransferAirportName.getValue()))
                & pEnaTransfer1NextAirlineName.equals(String.valueOf(comNextAirlineName.getValue()))
                & pEnaTransfer1DepartureDate.equals(String.valueOf(dpTransferDepartureDate.getValue()))
                &  pEnaTransfer1DepartureTime.equals(String.valueOf(tpTransferDepartureTime.getValue()))
                    & pEnaTransfer1NextFlightId.equals(txtNextFlightId.getText())
                    & pEnaTransfer1NextAirbusCode.equals(txtNextAirbusCode.getText())
                    & pEnaTransfer1ArrivalDate.equals(String.valueOf(dpTransferArrivalDate.getValue()))
                    & pEnaTransfer1ArrivalTime.equals(String.valueOf(tpTransferArrivalTime.getValue()))){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else{
                FlightDetail fd = new FlightDetail(fdId,guidline,transferName,transferAirportName,transferArrivalDate
                        ,transferArrivalTime,nextFlightId,nextAirbusCode,transferDepartureDate,transferDepartureTime
                        ,nextAirlineName,String.valueOf(comTransferName.getValue()),String.valueOf(comTransferAirportName.getValue())
                        ,txtNextFlightId.getText(),txtNextAirbusCode.getText(),String.valueOf(dpTransferArrivalDate.getValue())
                        ,String.valueOf(tpTransferArrivalTime.getValue()),String.valueOf(dpTransferDepartureDate.getValue())
                        ,String.valueOf(tpTransferDepartureTime.getValue()),String.valueOf(comNextAirlineName.getValue()));
                try {
                    if (FlightDetailModel.update1(fd)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                        clearAll();
                        clearOtherRecords();
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
                }
            }
        }
    }

    public void setPreviousFdRecordsVariables(){
        for(FlightDetail fd:fdArray){
            pFdId=fd.getF_Detail_Id();
            pGuidline=fd.getGuidline();
        }
    }

    public void setPreviousTranGoSideRecords1Variables(){
        for(FlightDetail fd:fdArray1){
            pYanaTransfer1Name=fd.getYanaTransfer1Name();
            pYanaTransfer1AirportName=fd.getYanaTransfer1AirportName();
            pYanaTransfer1NextAirlineName=fd.getYanaTransfer1AirlineName();
            pYanaTransfer1DepartureDate=fd.getYanaTransfer1DepartureDate();
            pYanaTransfer1DepartureTime=fd.getYanaTransfer1DepartureTime();
            pYanaTransfer1NextFlightId=fd.getYanaTransfer1FlightId();
            pYanaTransfer1NextAirbusCode=fd.getYanaTransfer1AirbusCode();
            pYanaTransfer1ArrivalDate=fd.getYanaTransfer1ArrivalDate();
            pYanaTransfer1ArrivalTime=fd.getYanaTransfer1ArrivalTime();
        }
    }

    public void setPreviousTranComeSideRecords1Variables(){
        for(FlightDetail fd:fdArray2){
            pEnaTransfer1Name=fd.getYanaTransfer1Name();
            pEnaTransfer1AirportName=fd.getYanaTransfer1AirportName();
            pEnaTransfer1NextAirlineName=fd.getYanaTransfer1AirlineName();
            pEnaTransfer1DepartureDate=fd.getYanaTransfer1DepartureDate();
            pEnaTransfer1DepartureTime=fd.getYanaTransfer1DepartureTime();
            pEnaTransfer1NextFlightId=fd.getYanaTransfer1FlightId();
            pEnaTransfer1NextAirbusCode=fd.getYanaTransfer1AirbusCode();
            pEnaTransfer1ArrivalDate=fd.getYanaTransfer1ArrivalDate();
            pEnaTransfer1ArrivalTime=fd.getYanaTransfer1ArrivalTime();
        }
    }


    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        if(condition()){
            new Alert(Alert.AlertType.WARNING,"Please fill above blank fields or field!!!").show();
        }else {
            collectRecords();
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferComeSideForm2");
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

    public void txtNextAirbusCodeKeyReleasedOnAction(KeyEvent keyEvent){
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

    public boolean condition(){
        boolean condition=false;
        if(String.valueOf(comTransferName.getValue()).isEmpty()|String.valueOf(comTransferAirportName.getValue()).isEmpty()|String.valueOf(dpTransferArrivalDate.getValue()).isEmpty()|String.valueOf(tpTransferArrivalTime.getValue()).isEmpty()|txtNextFlightId.getText().isEmpty()|txtNextAirbusCode.getText().isEmpty()|String.valueOf(dpTransferDepartureDate.getValue()).isEmpty()|String.valueOf(tpTransferDepartureTime.getValue()).isEmpty()|String.valueOf(comNextAirlineName.getValue()).isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnBackIdOnAction(ActionEvent actionEvent) throws IOException {
        collectRecords();
        if(tc == 1){
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferGoSideForm1");
        }else if(tc == 2){
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferGoSideForm2");
        }else{
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferGoSideForm3");
        }
    }

    public static ArrayList<FlightDetail> getTransfer1ComeSideRecords(){
        return getRecords;
    }

    public static void setTransfer1ComeSideRecords(){
        getRecords=new ArrayList();
    }

    public static void setTransfer1ComeSideRecordsWithPara(ArrayList<FlightDetail>getRecords){
        FlightDetailWithTransferComeSideForm1Controller.getRecords =getRecords;
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
