package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.CustomModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.Custom;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;
import rex.utils.S;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightAvailabilityFormController {

    public JFXButton btnMiniId;
    public JFXComboBox<String>comFlightId;

    public AnchorPane context;
    public JFXCheckBox chboxReturn;
    public JFXCheckBox chboxChildren;
    public JFXDatePicker dpDepart;
    public JFXDatePicker dpReturn;
    public JFXCheckBox chboxAdult;
    public JFXCheckBox chboxOneWay;
    public JFXTextField txtAdult;
    public JFXTextField txtChildren;
    public JFXCheckBox chboxFirst;
    public JFXCheckBox chboxBusiness;
    public JFXCheckBox chboxEconomy;
    public JFXComboBox<String>comTo;
    public JFXCheckBox chboxTransfer;
    public JFXCheckBox chboxDirect;
    public Label lblFrom;
    public Label lblReturnText;
    public Label lblReturnStar;

    String[]too={"Parise","London","USA","UK","NewYork","Malesiya","Dubai","Katar","Finland","India","Canada"
            ,"Japan","Singappor","Australia","NewZeland","Moldives","Thailand","Koria","Jurman","Turkey","Alaska","Induneesia"};
    ObservableList<String>listToo= FXCollections.observableArrayList(too);

    public void initialize(){
        lblFrom.setText("SriLanka");
        comTo.setItems(listToo);
    }

    public String returnOrOneway;
    public String children;
    public String adult;
    public String datedeparstring;
    public String dateretuenstring;
    public int adultCount;
    public int childrenCount;
    public static String cType;
    public String transferOrDirect;


    public void chboxReturnOnAction(ActionEvent actionEvent) {
        returnOrOneway=chboxReturn.getText();
        dpReturn.setVisible(true);
        lblReturnText.setVisible(true);
        lblReturnStar.setVisible(true);
    }

    public void chboxOneWayOnAction(ActionEvent actionEvent) {
        returnOrOneway=chboxOneWay.getText();
        dpReturn.setVisible(false);
        lblReturnText.setVisible(false);
        lblReturnStar.setVisible(false);
    }

    public void chboxAdultOnAction(ActionEvent actionEvent) {
        adult=chboxAdult.getText();
    }

    public void chboxChildrenWayOnAction(ActionEvent actionEvent) {
        children=chboxChildren.getText();
    }

    public void chboxFirstOnAction(ActionEvent actionEvent) {
         cType=chboxFirst.getText();
    }

    public void chboxBusinessOnAction(ActionEvent actionEvent) {
        cType=chboxBusiness.getText();
    }

    public void chboxEconomyOnAction(ActionEvent actionEvent) {
        cType=chboxEconomy.getText();
    }

    public void chboxTransferOnAction(ActionEvent actionEvent) {
       transferOrDirect=chboxTransfer.getText();
    }

    public void chboxDirectOnAction(ActionEvent actionEvent) {
        transferOrDirect=chboxDirect.getText();
    }

    public static int count;
    public void seatCountCalculate(){
        if(txtChildren.getText().isEmpty()){
            childrenCount=0;
            adultCount = Integer.parseInt(txtAdult.getText());
            count = adultCount + childrenCount;
        }else {
            adultCount = Integer.parseInt(txtAdult.getText());
            childrenCount = Integer.parseInt(txtChildren.getText());
            count = adultCount + childrenCount;
        }
    }

    public  static ArrayList<Custom>allRecords1=new ArrayList<>();
    public  static ArrayList<Custom>allRecords2=new ArrayList<>();

       public static int round;
       public static int round1;


    public static String fromm;
    public static String to;


    private void returnTandD() throws SQLException, ClassNotFoundException, IOException {
        datedeparstring = String.valueOf(dpDepart.getValue());
        dateretuenstring = String.valueOf(dpReturn.getValue());
        ResultSet set = CustomModel.loadCheckWithReturnTicket1(lblFrom.getText(), String.valueOf(comTo.getValue()), datedeparstring, transferOrDirect, cType, count);
        ResultSet sett = CustomModel.loadCheckWithReturnTicket2(lblFrom.getText(), String.valueOf(comTo.getValue()), dateretuenstring, transferOrDirect, cType, count);
        while (set.next()) {
            allRecords1.add(new Custom(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getInt(6), set.getString(7),set.getDouble(8)));
            round++;
        }
        while (sett.next()) {
            allRecords2.add(new Custom(sett.getString(1), sett.getString(2), sett.getString(3), sett.getString(4), sett.getString(5), sett.getInt(6), sett.getString(7),sett.getDouble(8)));
            round1++;
        }
        if (round != 0 & round1 != 0) {
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightAvailabilityForm2");
        } else {
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightAvailabilityForm3");
        }
    }
    private void directTandD() throws SQLException, ClassNotFoundException, IOException {
        datedeparstring = String.valueOf(dpDepart.getValue());
        ResultSet set = CustomModel.loadCheckWithOneWayTicket(lblFrom.getText(), String.valueOf(comTo.getValue()), datedeparstring, transferOrDirect, cType, count);
        while (set.next()) {
            allRecords1.add(new Custom(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getInt(6), set.getString(7),set.getDouble(8)));
            round++;
        }
        if (round != 0) {
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightAvailabilityForm2");
        } else {
            setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightAvailabilityForm3");
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent)  {
        fromm=lblFrom.getText();
        to=String.valueOf(comTo.getValue());
        try {
            seatCountCalculate();
            if(returnOrOneway.equals("Return") & transferOrDirect.equals("Transfer")) {
                 returnTandD();
            }else if(returnOrOneway.equals("Return") & transferOrDirect.equals("Direct")){
                returnTandD();
            }else if(returnOrOneway.equals("One-Way") & transferOrDirect.equals("Transfer")){
                directTandD();
            }else if(returnOrOneway.equals("One-Way") & transferOrDirect.equals("Direct")){
                directTandD();
            }
        } catch (SQLException | IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

    private  void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public  static ArrayList<Custom> getAllRecords1(){
        return allRecords1;
    }

    public  static ArrayList<Custom> getAllRecords2(){
        return allRecords2;
    }

    public  static void setAllRecords1(){
         allRecords1=new ArrayList<>();
    }

    public  static void setAllRecords2(){
        allRecords2=new ArrayList<>();
    }

    public  static String getFrom(){
        return fromm;
    }

    public  static String getTo(){
        return to;
    }

    public static String getType(){
        return cType;
    }

    public static int getCount(){
        return count;
    }


    public void btnClearOnAction(ActionEvent actionEvent) {
        dpDepart.setValue(null);
        dpReturn.setValue(null);
        comTo.setValue(null);
        chboxReturn.setSelected(false);
        chboxOneWay.setSelected(false);
        chboxTransfer.setSelected(false);
        chboxDirect.setSelected(false);
        chboxFirst.setSelected(false);
        chboxEconomy.setSelected(false);
        chboxBusiness.setSelected(false);
        chboxAdult.setSelected(false);
        chboxChildren.setSelected(false);
        txtAdult.clear();
        txtChildren.clear();
    }
}
