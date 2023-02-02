package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.AirlineTicketReservationSystem.model.CustomModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailMaintainModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.Custom;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightDetailFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXTextField txtFlightDetailId;
    public JFXTextField txtGuidline;
    public Label lblGuidlineWarning;
    public Label lblFlightDetailIdWarning;
    public Matcher fdIdMatcher;
    public Matcher guidlineMatcher;
    public JFXButton btnSaveId;
    public JFXButton btnDeleteId;
    public JFXButton btnEditId;
    public JFXButton btnCheckId;
    public JFXButton btnListId;
    public JFXButton btnNextId;
    public ScrollPane scrollPaneId;
    public Label lblTransferCountTitleId;
    public Label lblJourneyId;
    public Label lblTransferCountId;
    public JFXComboBox<String> comFlightIds;
    public JFXDatePicker dpDirectGoArrivalDateId;
    public JFXDatePicker dpDirectComeArrivalDateId;
    public JFXTimePicker dpDirectGoArrivalTimeId;
    public JFXTimePicker dpDirectComeArrivalTimeId;
    public Label lblDirectGoArrivalDateTitleId;
    public Label lblDirectGoArrivalDateStarId;
    public Label lblDirectGoArrivalTimeTitleId;
    public Label lblDirectGoArrivalTimeStarId;
    public Label lblDirectComeArrivalDateTitleId;
    public Label lblDirectComeArrivalTimeTitleId;
    public Label lblDirectComeArrivalTimeStarId;
    public Label lblDirectComeArrivalDateStarId;
    public JFXDatePicker dpDeparDate;
    public JFXTimePicker tpDeparTime;
    public JFXDatePicker dpArrivalDate;
    public JFXTimePicker tpArrivalTime;

    public static ArrayList<FlightDetail> getRecords = new ArrayList<>();
    public static ArrayList<Custom> getRecords2 = new ArrayList<>();
    public static ArrayList<Custom> getRecapDetails = new ArrayList<>();
    public static int transferCount;
    public static String flightDetailId;
    public FlightDetail fd;
    String previousComFlightId;



    public void initialize() {
        getGenerateNewId();
        dpDeparDate.setEditable(false);
        tpDeparTime.setEditable(false);
        dpArrivalDate.setEditable(false);
        tpArrivalTime.setEditable(false);
        loadFlightIds();
        getBackDetail();
    }

    private void getBackDetail() {
        if (getRecords != null) {
            for (FlightDetail fd : getRecords) {
                txtFlightDetailId.setText(fd.getF_Detail_Id());
                txtGuidline.setText(fd.getGuidline());
                hide();
            }
            setRecapDetailsAgain();
        }
    }

    public void setRecapDetailsAgain(){
        for (Custom c : getRecapDetails) {
            comFlightIds.setValue(c.getF_Id());
            previousComFlightId=String.valueOf(comFlightIds.getValue());
            lblJourneyId.setText(c.getJourney());
            lblTransferCountId.setText(String.valueOf(c.getTransferCount()));
            dpDeparDate.setValue(LocalDate.parse(c.getFlight_departure_date()));
            tpDeparTime.setValue(LocalTime.parse(c.getFlight_departure_time()));
            dpArrivalDate.setValue(LocalDate.parse(c.getFlight_arrival_date()));
            tpArrivalTime.setValue(LocalTime.parse(c.getFlight_arrival_time()));
        }
    }



    public void getGenerateNewId() {
        try {
            txtFlightDetailId.setText(FlightDetailModel.generateNewID());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearAll() {
        txtFlightDetailId.clear();
        txtGuidline.clear();
        dpDirectGoArrivalDateId.setValue(null);
        dpDirectGoArrivalTimeId.setValue(null);
        dpDirectComeArrivalDateId.setValue(null);
        dpDirectComeArrivalTimeId.setValue(null);
    }
    public void clearAllWithoutFdId(){
        txtGuidline.clear();
        dpDirectGoArrivalDateId.setValue(null);
        dpDirectGoArrivalTimeId.setValue(null);
        dpDirectComeArrivalDateId.setValue(null);
        dpDirectComeArrivalTimeId.setValue(null);
    }


    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (lblTransferCountId.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "First you should select FlightId use above short recap and next you should have to fill data and finally you can save the data").show();
            clearAll();
            getGenerateNewId();
        } else {
            if (condition()) {
                new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
            } else {
                FlightDetail fd = new FlightDetail(txtFlightDetailId.getText(), txtGuidline.getText()
                        , String.valueOf(dpDirectGoArrivalDateId.getValue()), String.valueOf(dpDirectGoArrivalTimeId.getValue())
                        , String.valueOf(dpDirectComeArrivalDateId.getValue()), String.valueOf(dpDirectComeArrivalTimeId.getValue()));
                try {
                    if (FlightDetailModel.save(fd)) {
                        getRecords2.add(new Custom(String.valueOf(comFlightIds.getValue()), txtFlightDetailId.getText()));
                        new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                        clearAll();
                        getGenerateNewId();
                        //TimeUnit.SECONDS.toSeconds(5);
                        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightFlightDetailMaintainForm");
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                    }
                } catch (ClassNotFoundException | SQLException | IOException e) {
                    e.printStackTrace();
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if (condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        } else {
            try {
                if (FlightDetailModel.delete(txtFlightDetailId.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted!...").show();
                    clearAll();
                    setRecapDetails();
                    getGenerateNewId();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.WARNING, "Deleted Failed!...").show();
            }
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        if (condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to edit!!!").show();
        } else {
            if (fd.getF_Detail_Id().equals(txtFlightDetailId.getText()) & fd.getGuidline().equals(txtGuidline.getText()) & fd.getDirectYanaArrivalDate().equals(String.valueOf(dpDirectGoArrivalDateId.getValue())) & fd.getDirectYanaArrivalTime().equals(String.valueOf(dpDirectGoArrivalTimeId.getValue())) & fd.getDirectEnaArrivalDate().equals(String.valueOf(dpDirectComeArrivalDateId.getValue())) & fd.getDirectEnaArrivalTime().equals(String.valueOf(dpDirectComeArrivalTimeId.getValue()))) {
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            } else {
                FlightDetail fd = new FlightDetail(txtFlightDetailId.getText(), txtGuidline.getText()
                        , String.valueOf(dpDirectGoArrivalDateId.getValue()), String.valueOf(dpDirectGoArrivalTimeId.getValue())
                        , String.valueOf(dpDirectComeArrivalDateId.getValue()), String.valueOf(dpDirectComeArrivalTimeId.getValue()));
                try {
                    if (FlightDetailModel.update(fd)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                        clearAll();
                        setRecapDetails();
                        getGenerateNewId();
                    }
                } catch (ClassNotFoundException | SQLException  ex) {
                    new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
                }
            }
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
        clearAllWithoutFdId();
        setRecapDetails();
        fd = checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckFlightDetailAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtFlightDetailIdOnAction(ActionEvent actionEvent) {
        clearAllWithoutFdId();
        setRecapDetails();
        fd = checking();
    }

    public FlightDetail checking() {
        try {
            search();
                fd = new FlightDetail(txtFlightDetailId.getText(), txtGuidline.getText()
                        , String.valueOf(dpDirectGoArrivalDateId.getValue()), String.valueOf(dpDirectGoArrivalTimeId.getValue())
                        , String.valueOf(dpDirectComeArrivalDateId.getValue()), String.valueOf(dpDirectComeArrivalTimeId.getValue()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return fd;
    }

    private void search() throws ClassNotFoundException, SQLException {
        flightDetailId=txtFlightDetailId.getText();
        String fId= FlightDetailMaintainModel.searchFlightId(txtFlightDetailId.getText());
        ResultSet set = CustomModel.flightDetails(fId);
        while (set.next()){
            getRecapDetails.add(new Custom(fId,set.getString(1),set.getInt(2),set.getString(3)
                    ,set.getString(4),set.getString(5),set.getString(6)));
         }
        setRecapDetailsAgain();
        for(Custom cus:getRecapDetails){
            transferCount=cus.getTransferCount();
        }
        if(transferCount==0) {
            FlightDetail fd = FlightDetailModel.search(txtFlightDetailId.getText());
            if (fd != null) {
                fillData(fd);
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }else if(transferCount==1){
            FlightDetail fd = FlightDetailModel.search1(txtFlightDetailId.getText());
            if (fd != null) {
                fillData1(fd);
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }else if(transferCount==2){
            FlightDetail fd = FlightDetailModel.search2(txtFlightDetailId.getText());
            if (fd != null) {
                fillData2(fd);
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }else if(transferCount==3){
            FlightDetail fd = FlightDetailModel.search3(txtFlightDetailId.getText());
            if (fd != null) {
                fillData3(fd);
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }
    }

    private void fillData(FlightDetail fd) {
        txtGuidline.setText(fd.getGuidline());
        dpDirectGoArrivalDateId.setValue(LocalDate.parse(fd.getDirectYanaArrivalDate()));
        dpDirectGoArrivalTimeId.setValue(LocalTime.parse(fd.getDirectYanaArrivalTime()));
        dpDirectComeArrivalDateId.setValue(LocalDate.parse(fd.getDirectEnaArrivalDate()));
        dpDirectComeArrivalTimeId.setValue(LocalTime.parse(fd.getDirectEnaArrivalTime()));
    }

    public static ArrayList<FlightDetail>fdArray=new ArrayList();
    public static ArrayList<FlightDetail>fdArray1=new ArrayList();
    public static ArrayList<FlightDetail>fdArray2=new ArrayList();

    public static ArrayList<FlightDetail> getFdArray(){
        return fdArray;
    }
    public static ArrayList<FlightDetail> getFdArray1(){
        return fdArray1;
    }
    public static ArrayList<FlightDetail> getFdArray2(){
        return fdArray2;
    }

    private void fillData1(FlightDetail fd) {
        txtGuidline.setText(fd.getGuidline());
        fdArray.add(new FlightDetail(txtFlightDetailId.getText(),fd.getGuidline()));
        setFlightDetailsRecordsWithPara(fdArray);
        fdArray1.add(new FlightDetail(fd.getYanaTransfer1Name(),fd.getYanaTransfer1AirportName()
                ,fd.getYanaTransfer1ArrivalDate(),fd.getYanaTransfer1ArrivalTime()
        ,fd.getYanaTransfer1FlightId(),fd.getYanaTransfer1AirbusCode(),fd.getYanaTransfer1DepartureDate(),fd.getYanaTransfer1DepartureTime(),fd.getYanaTransfer1AirlineName()));
        FlightDetailWithTransferGoSideForm1Controller.setTransfer1GoSideRecordsWithPara(fdArray1);
        fdArray2.add(new FlightDetail(fd.getEnaTransfer1Name(),fd.getEnaTransfer1AirportName()
                ,fd.getEnaTransfer1ArrivalDate(),fd.getEnaTransfer1ArrivalTime(),fd.getEnaTransfer1FlightId(),fd.getEnaTransfer1AirbusCode()
                ,fd.getEnaTransfer1DepartureDate(),fd.getEnaTransfer1DepartureTime(),fd.getEnaTransfer1AirlineName()));
        FlightDetailWithTransferComeSideForm1Controller.setTransfer1ComeSideRecordsWithPara(fdArray2);
    }

    public static ArrayList<FlightDetail>fdArray3=new ArrayList();
    public static ArrayList<FlightDetail>fdArray4=new ArrayList();

    public static ArrayList<FlightDetail> getFdArray3(){
        return fdArray3;
    }
    public static ArrayList<FlightDetail> getFdArray4(){
        return fdArray4;
    }

    private void fillData2(FlightDetail fd) {
        fillData1(fd);
        fdArray3.add(new FlightDetail(fd.getYanaTransfer2Name(),fd.getYanaTransfer2AirportName()
                ,fd.getYanaTransfer2ArrivalDate(),fd.getYanaTransfer2ArrivalTime()
                ,fd.getYanaTransfer2FlightId(),fd.getYanaTransfer2AirbusCode(),fd.getYanaTransfer2DepartureDate(),fd.getYanaTransfer2DepartureTime(),fd.getYanaTransfer2AirlineName()));
        FlightDetailWithTransferGoSideForm2Controller.setTransfer2GoSideRecordsWithPara(fdArray3);
        fdArray4.add(new FlightDetail(fd.getEnaTransfer2Name(),fd.getEnaTransfer2AirportName()
                ,fd.getEnaTransfer2ArrivalDate(),fd.getEnaTransfer2ArrivalTime(),fd.getEnaTransfer2FlightId(),fd.getEnaTransfer2AirbusCode()
                ,fd.getEnaTransfer2DepartureDate(),fd.getEnaTransfer2DepartureTime(),fd.getEnaTransfer2AirlineName()));
        FlightDetailWithTransferComeSideForm2Controller.setTransfer2ComeSideRecordsWithPara(fdArray4);
    }

    public static ArrayList<FlightDetail>fdArray5=new ArrayList();
    public static ArrayList<FlightDetail>fdArray6=new ArrayList();

    public static ArrayList<FlightDetail> getFdArray5(){
        return fdArray5;
    }
    public static ArrayList<FlightDetail> getFdArray6(){
        return fdArray6;
    }

    private void fillData3(FlightDetail fd) {
        fillData1(fd);
        fillData2(fd);
        fdArray5.add(new FlightDetail(fd.getYanaTransfer3Name(),fd.getYanaTransfer3AirportName()
                ,fd.getYanaTransfer3ArrivalDate(),fd.getYanaTransfer3ArrivalTime()
                ,fd.getYanaTransfer3FlightId(),fd.getYanaTransfer3AirbusCode(),fd.getYanaTransfer3DepartureDate(),fd.getYanaTransfer3DepartureTime(),fd.getYanaTransfer3AirlineName()));
        FlightDetailWithTransferGoSideForm3Controller.setTransfer3GoSideRecordsWithPara(fdArray5);
        fdArray6.add(new FlightDetail(fd.getEnaTransfer3Name(),fd.getEnaTransfer3AirportName()
                ,fd.getEnaTransfer3ArrivalDate(),fd.getEnaTransfer3ArrivalTime(),fd.getEnaTransfer3FlightId(),fd.getEnaTransfer3AirbusCode()
                ,fd.getEnaTransfer3DepartureDate(),fd.getEnaTransfer3DepartureTime(),fd.getEnaTransfer3AirlineName()));
        FlightDetailWithTransferComeSideForm3Controller.setTransfer3ComeSideRecordsWithPara(fdArray6);
    }


    public void txtFlightDetailIdKeyTypedOnAction(KeyEvent keyEvent) {
        lblFlightDetailIdWarning.setText("");
        txtFlightDetailId.setFocusColor(Paint.valueOf("Blue"));

        Pattern fdIdPattern = Pattern.compile("^(FD0-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        fdIdMatcher = fdIdPattern.matcher(txtFlightDetailId.getText());

        if (!fdIdMatcher.matches()) {
            txtFlightDetailId.requestFocus();
            txtFlightDetailId.setFocusColor(Paint.valueOf("Red"));
            lblFlightDetailIdWarning.setText("invalid");
        }
    }

    public void txtGuidlineKeyTypedOnAction(KeyEvent keyEvent) {
        lblGuidlineWarning.setText("");
        txtGuidline.setFocusColor(Paint.valueOf("Blue"));

        Pattern glPattern = Pattern.compile("^([0-9]{1,})([-])([0-9]{1,})([a-zA-Z]{4,})$");
        guidlineMatcher = glPattern.matcher(txtGuidline.getText());

        if (!guidlineMatcher.matches()) {
            txtGuidline.requestFocus();
            txtGuidline.setFocusColor(Paint.valueOf("Red"));
            lblGuidlineWarning.setText("invalid");
        }
    }

    public boolean condition() {
        boolean condition = false;
        if (txtFlightDetailId.getText().isEmpty() | txtGuidline.getText().isEmpty() | String.valueOf(dpDirectGoArrivalDateId.getValue()).isEmpty() | String.valueOf(dpDirectGoArrivalTimeId.getValue()).isEmpty() | String.valueOf(dpDirectComeArrivalDateId.getValue()).isEmpty() | String.valueOf(dpDirectComeArrivalTimeId.getValue()).isEmpty()) {
            condition = true;
        }
        return condition;
    }

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        if (lblTransferCountId.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "First you should select FlightId use above short recap and next you should have to fill data and finally you can press next button").show();
        } else {
            if (previousComFlightId != null & !(String.valueOf(comFlightIds.getValue())).equals(previousComFlightId)) {
                clearAll();
                getGenerateNewId();
                getRecords2.add(new Custom(String.valueOf(comFlightIds.getValue()), txtFlightDetailId.getText()));
                getRecords.add(new FlightDetail(txtFlightDetailId.getText(), txtGuidline.getText()));
                getRecapDetails.add(new Custom(String.valueOf(comFlightIds.getValue()), lblJourneyId.getText(), Integer.parseInt(lblTransferCountId.getText()), String.valueOf(dpDeparDate.getValue()), String.valueOf(tpDeparTime.getValue()), String.valueOf(dpArrivalDate.getValue()), String.valueOf(tpArrivalTime.getValue())));
            } else {
                transferCount = Integer.parseInt(lblTransferCountId.getText());
                if (condition()) {
                    new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
                } else {
                    if (Integer.parseInt(lblTransferCountId.getText()) != 0) {
                        getRecords.add(new FlightDetail(txtFlightDetailId.getText(), txtGuidline.getText()));
                        getRecords2.add(new Custom(String.valueOf(comFlightIds.getValue()), txtFlightDetailId.getText()));
                        getRecapDetails.add(new Custom(String.valueOf(comFlightIds.getValue()), lblJourneyId.getText(), Integer.parseInt(lblTransferCountId.getText()), String.valueOf(dpDeparDate.getValue()), String.valueOf(tpDeparTime.getValue()), String.valueOf(dpArrivalDate.getValue()), String.valueOf(tpArrivalTime.getValue())));
                        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailWithTransferGoSideForm1");
                    }
                }
            }
        }
    }



    public void comFlightIdsOnAction(ActionEvent actionEvent) {
        try {
            ResultSet set = CustomModel.flightDetails(String.valueOf(comFlightIds.getValue()));
            while (set.next()) {
                lblJourneyId.setText(set.getString(1));
                lblTransferCountId.setText(set.getString(2));
                dpDeparDate.setValue(LocalDate.parse(set.getString(3)));
                tpDeparTime.setValue(LocalTime.parse(set.getString(4)));
                dpArrivalDate.setValue(LocalDate.parse(set.getString(5)));
                tpArrivalTime.setValue(LocalTime.parse(set.getString(6)));
            }
            if(Integer.parseInt(lblTransferCountId.getText())!=0){
                hide();
               }else{
                unhide();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void hide(){
        btnSaveId.setDisable(true);
        btnDeleteId.setDisable(true);
        btnEditId.setDisable(true);
        btnCheckId.setDisable(true);
        btnListId.setDisable(true);
        lblDirectGoArrivalDateTitleId.setDisable(true);
        lblDirectGoArrivalDateStarId.setDisable(true);
        lblDirectGoArrivalTimeTitleId.setDisable(true);
        lblDirectGoArrivalTimeStarId.setDisable(true);
        lblDirectComeArrivalDateTitleId.setDisable(true);
        lblDirectComeArrivalDateStarId.setDisable(true);
        lblDirectComeArrivalTimeTitleId.setDisable(true);
        lblDirectComeArrivalTimeStarId.setDisable(true);
        dpDirectGoArrivalDateId.setDisable(true);
        dpDirectGoArrivalTimeId.setDisable(true);
        dpDirectComeArrivalDateId.setDisable(true);
        dpDirectComeArrivalTimeId.setDisable(true);
        btnNextId.setDisable(false);
    }

    private void unhide(){
        btnSaveId.setDisable(false);
        btnDeleteId.setDisable(false);
        btnEditId.setDisable(false);
        btnCheckId.setDisable(false);
        btnListId.setDisable(false);
        lblDirectGoArrivalDateTitleId.setDisable(false);
        lblDirectGoArrivalDateStarId.setDisable(false);
        lblDirectGoArrivalTimeTitleId.setDisable(false);
        lblDirectGoArrivalTimeStarId.setDisable(false);
        lblDirectComeArrivalDateTitleId.setDisable(false);
        lblDirectComeArrivalDateStarId.setDisable(false);
        lblDirectComeArrivalTimeTitleId.setDisable(false);
        lblDirectComeArrivalTimeStarId.setDisable(false);
        dpDirectGoArrivalDateId.setDisable(false);
        dpDirectGoArrivalTimeId.setDisable(false);
        dpDirectComeArrivalDateId.setDisable(false);
        dpDirectComeArrivalTimeId.setDisable(false);
        btnNextId.setDisable(true);
    }


    public void loadFlightIds() {
        try {
            ObservableList<String> list = FXCollections.observableArrayList();
            ResultSet set = FlightDetailModel.flightIds();
            while (set.next()) {
                list.add(set.getString(1));
            }
            comFlightIds.setItems(list);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<FlightDetail>getFlightDetailsRecords(){
        return getRecords;
    }

    public static void setFlightDetailsRecords(){
        getRecords=new ArrayList();
    }

    public static void setFlightDetailsRecordsWithPara(ArrayList<FlightDetail>getRecords){
        FlightDetailFormController.getRecords=getRecords;
    }

    public  static int getTransferCount(){
        return transferCount;
    }

    public  static String getFlightDetailId(){
        return flightDetailId;
    }

    public  static ArrayList<Custom> getCustomObjectRecords(){
        return getRecords2;
    }

    public static void setCustomObjectRecords(){
       getRecords2=new ArrayList();
    }

    public static void setRecapDetails() {
        getRecapDetails=new ArrayList();
    }

}
