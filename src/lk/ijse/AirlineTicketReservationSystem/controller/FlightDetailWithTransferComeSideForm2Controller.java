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

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightDetailWithTransferComeSideForm2Controller {


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
    public static ArrayList<FlightDetail> flightDetailsRecords3=new ArrayList<>();
    public static ArrayList<FlightDetail> flightDetailsRecords4=new ArrayList<>();

    public static ArrayList<FlightDetail>fdArray=new ArrayList<>();
    public static ArrayList<FlightDetail>fdArray1=new ArrayList<>();
    public static ArrayList<FlightDetail>fdArray2=new ArrayList<>();
    public static ArrayList<FlightDetail>fdArray3=new ArrayList<>();
    public static ArrayList<FlightDetail>fdArray4=new ArrayList<>();

    public String fdId;
    public String guidline;

    public String transfer1GoSideName;
    public String transfer1GoSideAirportName;
    public String transfer1GoSideNextAirlineName;
    public String transfer1GoSideDepartureDate;
    public String transfer1GoSideDepartureTime;
    public String transfer1GoSideNextFlightId;
    public String transfer1GoSideNextAirbusCode;
    public String transfer1GoSideArrivalDate;
    public String transfer1GoSideArrivalTime;

    public String transfer2GoSideName;
    public String transfer2GoSideAirportName;
    public String transfer2GoSideNextAirlineName;
    public String transfer2GoSideDepartureDate;
    public String transfer2GoSideDepartureTime;
    public String transfer2GoSideNextFlightId;
    public String transfer2GoSideNextAirbusCode;
    public String transfer2GoSideArrivalDate;
    public String transfer2GoSideArrivalTime;

    public String transfer1ComeSideName;
    public String transfer1ComeSideAirportName;
    public String transfer1ComeSideNextAirlineName;
    public String transfer1ComeSideDepartureDate;
    public String transfer1ComeSideDepartureTime;
    public String transfer1ComeSideNextFlightId;
    public String transfer1ComeSideNextAirbusCode;
    public String transfer1ComeSideArrivalDate;
    public String transfer1ComeSideArrivalTime;


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

    public String pYanaTransfer2Name;
    public String pYanaTransfer2AirportName;
    public String pYanaTransfer2NextAirlineName;
    public String pYanaTransfer2DepartureDate;
    public String pYanaTransfer2DepartureTime;
    public String pYanaTransfer2NextFlightId;
    public String pYanaTransfer2NextAirbusCode;
    public String pYanaTransfer2ArrivalDate;
    public String pYanaTransfer2ArrivalTime;

    public String pEnaTransfer1Name;
    public String pEnaTransfer1AirportName;
    public String pEnaTransfer1NextAirlineName;
    public String pEnaTransfer1DepartureDate;
    public String pEnaTransfer1DepartureTime;
    public String pEnaTransfer1NextFlightId;
    public String pEnaTransfer1NextAirbusCode;
    public String pEnaTransfer1ArrivalDate;
    public String pEnaTransfer1ArrivalTime;

    public String pEnaTransfer2Name;
    public String pEnaTransfer2AirportName;
    public String pEnaTransfer2NextAirlineName;
    public String pEnaTransfer2DepartureDate;
    public String pEnaTransfer2DepartureTime;
    public String pEnaTransfer2NextFlightId;
    public String pEnaTransfer2NextAirbusCode;
    public String pEnaTransfer2ArrivalDate;
    public String pEnaTransfer2ArrivalTime;

    String[]transferNames={"SIN","DOH","ARN","DXB","CDG","MLE","DEL"};
    ObservableList<String> listTransferNames= FXCollections.observableArrayList(transferNames);

    String[]transferAirportNames={"Changi Intl Airport (SIN)","Doha Intl Airport (DOH)","Arlanda Airport (ARN)","Dubai Intl Airport (DXB)","Charles De Gaulle (Roissy) Airport (CDG)","Velana Intl Airport (MLE)","Gandhi Intl Airport (DEL)"};
    ObservableList<String> listTransferAirportNames= FXCollections.observableArrayList(transferAirportNames);

    String[]nextAirlineNames={"Srilankan","Finnair","Qatar Airways","Emirates Airlines","Nordic Regional"};
    ObservableList<String> listNextAirlineNames= FXCollections.observableArrayList(nextAirlineNames);

    public void initialize() {
        comTransferName.setItems(listTransferNames);
        comTransferAirportName.setItems(listTransferAirportNames);
        comNextAirlineName.setItems(listNextAirlineNames);
        if(tc==2){
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
        fdArray=FlightDetailFormController.getFdArray();
        fdArray1=FlightDetailFormController.getFdArray1();
        fdArray2=FlightDetailFormController.getFdArray2();
        fdArray3=FlightDetailFormController.getFdArray3();
        fdArray4=FlightDetailFormController.getFdArray4();
    }

    public void getOtherSidesRecords(){
        flightDetailsRecords1=FlightDetailFormController.getFlightDetailsRecords();
        flightDetailsRecords2=FlightDetailWithTransferGoSideForm1Controller.getTransfer1GoSideRecords();
        flightDetailsRecords3=FlightDetailWithTransferGoSideForm2Controller.getTransfer2GoSideRecords();
        flightDetailsRecords4=FlightDetailWithTransferComeSideForm1Controller.getTransfer1ComeSideRecords();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()){
            new Alert(Alert.AlertType.WARNING,"Please fill above blank fields or field!!!").show();
        }else {
            getOtherSidesRecords();
            setFdRecordsVariables();
            setTran1GoSideRecordsVariables();
            setTran2GoSideRecordsVariables();
            setTran1ComeSideRecordsVariables();
            FlightDetail fd = new FlightDetail(fdId,guidline,transfer1GoSideName,transfer1GoSideAirportName
                    ,transfer1GoSideArrivalDate,transfer1GoSideArrivalTime,transfer1GoSideNextFlightId
                    ,transfer1GoSideNextAirbusCode,transfer1GoSideDepartureDate,transfer1GoSideDepartureTime
                    ,transfer1GoSideNextAirlineName,transfer2GoSideName,transfer2GoSideAirportName
                    ,transfer2GoSideArrivalDate,transfer2GoSideArrivalTime,transfer2GoSideNextFlightId
                    ,transfer2GoSideNextAirbusCode,transfer2GoSideDepartureDate,transfer2GoSideDepartureTime
                    ,transfer2GoSideNextAirlineName,transfer1ComeSideName,transfer1ComeSideAirportName
                    ,transfer1ComeSideNextFlightId,transfer1ComeSideNextAirbusCode,transfer1ComeSideArrivalDate
                    ,transfer1ComeSideArrivalTime,transfer1ComeSideDepartureDate,transfer1ComeSideDepartureTime
                    ,transfer1ComeSideNextAirlineName,String.valueOf(comTransferName.getValue()),String.valueOf(comTransferAirportName.getValue())
                    ,txtNextFlightId.getText(),txtNextAirbusCode.getText(),String.valueOf(dpTransferArrivalDate.getValue())
                    ,String.valueOf(tpTransferArrivalTime.getValue()),String.valueOf(dpTransferDepartureDate.getValue())
                    ,String.valueOf(tpTransferDepartureTime.getValue()),String.valueOf(comNextAirlineName.getValue()));
            try {
                if(FlightDetailModel.save3(fd)){
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    clearAll();
                    FlightDetailFormController.setFlightDetailsRecords();
                    FlightDetailWithTransferGoSideForm1Controller.setTransfer1GoSideRecords();
                    FlightDetailWithTransferGoSideForm2Controller.setTransfer2GoSideRecords();
                    FlightDetailWithTransferComeSideForm1Controller.setTransfer1ComeSideRecords();
                    setTransfer2ComeSideRecords();
                    setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightFlightDetailMaintainForm");
                }else{
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (SQLException | ClassNotFoundException | IOException e) {
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

    public void setTran1GoSideRecordsVariables(){
        for(FlightDetail fd:flightDetailsRecords2){
            transfer1GoSideName=fd.getYanaTransfer1Name();
            transfer1GoSideAirportName=fd.getYanaTransfer1AirportName();
            transfer1GoSideNextAirlineName=fd.getYanaTransfer1AirlineName();
            transfer1GoSideDepartureDate=fd.getYanaTransfer1DepartureDate();
            transfer1GoSideDepartureTime=fd.getYanaTransfer1DepartureTime();
            transfer1GoSideNextFlightId=fd.getYanaTransfer1FlightId();
            transfer1GoSideNextAirbusCode=fd.getYanaTransfer1AirbusCode();
            transfer1GoSideArrivalDate=fd.getYanaTransfer1ArrivalDate();
            transfer1GoSideArrivalTime=fd.getYanaTransfer1ArrivalTime();
        }
    }

    public void setTran2GoSideRecordsVariables(){
        for(FlightDetail fd:flightDetailsRecords3){
            transfer2GoSideName=fd.getYanaTransfer1Name();
            transfer2GoSideAirportName=fd.getYanaTransfer1AirportName();
            transfer2GoSideNextAirlineName=fd.getYanaTransfer1AirlineName();
            transfer2GoSideDepartureDate=fd.getYanaTransfer1DepartureDate();
            transfer2GoSideDepartureTime=fd.getYanaTransfer1DepartureTime();
            transfer2GoSideNextFlightId=fd.getYanaTransfer1FlightId();
            transfer2GoSideNextAirbusCode=fd.getYanaTransfer1AirbusCode();
            transfer2GoSideArrivalDate=fd.getYanaTransfer1ArrivalDate();
            transfer2GoSideArrivalTime=fd.getYanaTransfer1ArrivalTime();
        }
    }

    public void setTran1ComeSideRecordsVariables(){
        for(FlightDetail fd:flightDetailsRecords4){
            transfer1ComeSideName=fd.getYanaTransfer1Name();
            transfer1ComeSideAirportName=fd.getYanaTransfer1AirportName();
            transfer1ComeSideNextAirlineName=fd.getYanaTransfer1AirlineName();
            transfer1ComeSideDepartureDate=fd.getYanaTransfer1DepartureDate();
            transfer1ComeSideDepartureTime=fd.getYanaTransfer1DepartureTime();
            transfer1ComeSideNextFlightId=fd.getYanaTransfer1FlightId();
            transfer1ComeSideNextAirbusCode=fd.getYanaTransfer1AirbusCode();
            transfer1ComeSideArrivalDate=fd.getYanaTransfer1ArrivalDate();
            transfer1ComeSideArrivalTime=fd.getYanaTransfer1ArrivalTime();
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
        FlightDetailWithTransferGoSideForm2Controller.setTransfer2GoSideRecords();
        FlightDetailWithTransferComeSideForm1Controller.setTransfer1ComeSideRecords();
        setTransfer2ComeSideRecords();
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
            setPreviousTranGoSideRecords2Variables();
            setPreviousTranComeSideRecords2Variables();
            setFdRecordsVariables();
            setTran1GoSideRecordsVariables();
            setTran2GoSideRecordsVariables();
            setTran1ComeSideRecordsVariables();
            if(pFdId.equals(fdId) & pGuidline.equals(guidline) & pYanaTransfer1Name.equals(transfer1GoSideName)
                    & pYanaTransfer1AirportName.equals(transfer1GoSideAirportName) & pYanaTransfer1NextAirlineName.equals(transfer1GoSideNextAirlineName)
                    & pYanaTransfer1DepartureDate.equals(transfer1GoSideDepartureDate) & pYanaTransfer1DepartureTime.equals(transfer1GoSideDepartureTime)
                    & pYanaTransfer1NextFlightId.equals(transfer1GoSideNextFlightId) & pYanaTransfer1NextAirbusCode.equals(transfer1GoSideNextAirbusCode)
                    & pYanaTransfer1ArrivalDate.equals(transfer1GoSideArrivalDate) & pYanaTransfer1ArrivalTime.equals(transfer1GoSideArrivalTime)
                    & pYanaTransfer2Name.equals(transfer2GoSideName) & pYanaTransfer2AirportName.equals(transfer2GoSideAirportName)
                    & pYanaTransfer2NextAirlineName.equals(transfer2GoSideNextAirlineName)
                    & pYanaTransfer2DepartureDate.equals(transfer2GoSideDepartureDate) & pYanaTransfer2DepartureTime.equals(transfer2GoSideDepartureTime)
                    & pYanaTransfer2NextFlightId.equals(transfer2GoSideNextFlightId) & pYanaTransfer2NextAirbusCode.equals(transfer2GoSideNextAirbusCode)
                    & pYanaTransfer2ArrivalDate.equals(transfer2GoSideArrivalDate) & pYanaTransfer2ArrivalTime.equals(transfer2GoSideArrivalTime)
                    & pEnaTransfer1Name.equals(transfer1ComeSideName) & pEnaTransfer1AirportName.equals(transfer1ComeSideAirportName)
                    & pEnaTransfer1NextAirlineName.equals(transfer1ComeSideNextAirlineName) & pEnaTransfer1DepartureDate.equals(transfer1ComeSideDepartureDate)
                    &  pEnaTransfer1DepartureTime.equals(transfer1ComeSideDepartureTime) & pEnaTransfer1NextFlightId.equals(transfer1ComeSideNextFlightId)
                    & pEnaTransfer1NextAirbusCode.equals(transfer1ComeSideNextAirbusCode) & pEnaTransfer1ArrivalDate.equals(transfer1ComeSideArrivalDate)
                    & pEnaTransfer1ArrivalTime.equals(transfer1ComeSideArrivalTime) & pEnaTransfer2Name.equals(String.valueOf(comTransferName.getValue()))
                    & pEnaTransfer2AirportName.equals(String.valueOf(comTransferAirportName.getValue()))
                    & pEnaTransfer2NextAirlineName.equals(String.valueOf(comNextAirlineName.getValue()))
                    & pEnaTransfer2DepartureDate.equals(String.valueOf(dpTransferDepartureDate.getValue()))
                    &  pEnaTransfer2DepartureTime.equals(String.valueOf(tpTransferDepartureTime.getValue()))
                    & pEnaTransfer2NextFlightId.equals(txtNextFlightId.getText())
                    & pEnaTransfer2NextAirbusCode.equals(txtNextAirbusCode.getText())
                    & pEnaTransfer2ArrivalDate.equals(String.valueOf(dpTransferArrivalDate.getValue()))
                    & pEnaTransfer2ArrivalTime.equals(String.valueOf(tpTransferArrivalTime.getValue()))){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else{
                FlightDetail fd = new FlightDetail(fdId,guidline,transfer1GoSideName,transfer1GoSideAirportName
                        ,transfer1GoSideArrivalDate,transfer1GoSideArrivalTime,transfer1GoSideNextFlightId
                        ,transfer1GoSideNextAirbusCode,transfer1GoSideDepartureDate,transfer1GoSideDepartureTime
                        ,transfer1GoSideNextAirlineName,transfer2GoSideName,transfer2GoSideAirportName
                        ,transfer2GoSideArrivalDate,transfer2GoSideArrivalTime,transfer2GoSideNextFlightId
                        ,transfer2GoSideNextAirbusCode,transfer2GoSideDepartureDate,transfer2GoSideDepartureTime
                        ,transfer2GoSideNextAirlineName,transfer1ComeSideName,transfer1ComeSideAirportName
                        ,transfer1ComeSideNextFlightId,transfer1ComeSideNextAirbusCode,transfer1ComeSideArrivalDate
                        ,transfer1ComeSideArrivalTime,transfer1ComeSideDepartureDate,transfer1ComeSideDepartureTime
                        ,transfer1ComeSideNextAirlineName,String.valueOf(comTransferName.getValue()),String.valueOf(comTransferAirportName.getValue())
                        ,txtNextFlightId.getText(),txtNextAirbusCode.getText(),String.valueOf(dpTransferArrivalDate.getValue())
                        ,String.valueOf(tpTransferArrivalTime.getValue()),String.valueOf(dpTransferDepartureDate.getValue())
                        ,String.valueOf(tpTransferDepartureTime.getValue()),String.valueOf(comNextAirlineName.getValue()));
                try {
                    if (FlightDetailModel.update2(fd)) {
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

    public void setPreviousTranGoSideRecords2Variables(){
        for(FlightDetail fd:fdArray3){
            pYanaTransfer2Name=fd.getYanaTransfer1Name();
            pYanaTransfer2AirportName=fd.getYanaTransfer1AirportName();
            pYanaTransfer2NextAirlineName=fd.getYanaTransfer1AirlineName();
            pYanaTransfer2DepartureDate=fd.getYanaTransfer1DepartureDate();
            pYanaTransfer2DepartureTime=fd.getYanaTransfer1DepartureTime();
            pYanaTransfer2NextFlightId=fd.getYanaTransfer1FlightId();
            pYanaTransfer2NextAirbusCode=fd.getYanaTransfer1AirbusCode();
            pYanaTransfer2ArrivalDate=fd.getYanaTransfer1ArrivalDate();
            pYanaTransfer2ArrivalTime=fd.getYanaTransfer1ArrivalTime();
        }
    }

    public void setPreviousTranComeSideRecords2Variables(){
        for(FlightDetail fd:fdArray4){
            pEnaTransfer2Name=fd.getYanaTransfer1Name();
            pEnaTransfer2AirportName=fd.getYanaTransfer1AirportName();
            pEnaTransfer2NextAirlineName=fd.getYanaTransfer1AirlineName();
            pEnaTransfer2DepartureDate=fd.getYanaTransfer1DepartureDate();
            pEnaTransfer2DepartureTime=fd.getYanaTransfer1DepartureTime();
            pEnaTransfer2NextFlightId=fd.getYanaTransfer1FlightId();
            pEnaTransfer2NextAirbusCode=fd.getYanaTransfer1AirbusCode();
            pEnaTransfer2ArrivalDate=fd.getYanaTransfer1ArrivalDate();
            pEnaTransfer2ArrivalTime=fd.getYanaTransfer1ArrivalTime();
        }
    }


    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        if(condition()){
            new Alert(Alert.AlertType.WARNING,"Please fill above blank fields or field!!!").show();
        }else {
            collectRecords();
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferComeSideForm3");
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

    public boolean condition(){
        boolean condition=false;
        if(String.valueOf(comTransferName.getValue()).isEmpty()|String.valueOf(comTransferAirportName.getValue()).isEmpty()|String.valueOf(dpTransferArrivalDate.getValue()).isEmpty()|String.valueOf(tpTransferArrivalTime.getValue()).isEmpty()|txtNextFlightId.getText().isEmpty()|txtNextAirbusCode.getText().isEmpty()|String.valueOf(dpTransferDepartureDate.getValue()).isEmpty()|String.valueOf(tpTransferDepartureTime.getValue()).isEmpty()|String.valueOf(comNextAirlineName.getValue()).isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnBackIdOnAction(ActionEvent actionEvent) throws IOException {
        collectRecords();
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferComeSideForm1");
    }

    public static ArrayList<FlightDetail> getTransfer2ComeSideRecords(){
        return getRecords;
    }

    public static void setTransfer2ComeSideRecords(){
        getRecords=new ArrayList();
    }

    public static void setTransfer2ComeSideRecordsWithPara(ArrayList<FlightDetail>getRecords){
        FlightDetailWithTransferComeSideForm2Controller.getRecords =getRecords;
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
