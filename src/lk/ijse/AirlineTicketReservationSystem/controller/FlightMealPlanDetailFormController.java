package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanModel;
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;
import lk.ijse.AirlineTicketReservationSystem.to.Schedule;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightMealPlanDetailFormController {

    public AnchorPane context;
    public JFXTextField txtMealPlanDetailId;
    public JFXComboBox<String>comMealId;
    public JFXComboBox<String>comFlightId;
    public JFXTextField txtPrice;
    public JFXTextField txtQty;
    public Label lblDate;
    public Label lblTime;
    public Label lblMealPlanDetailIdWarning;
    public Label lblPriceWarning;
    public Label lblQtyWarning;

    public Matcher mpdIdMatcher;
    public Matcher priceMatcher;
    public Matcher qtyMatcher;

    public MealPlanDetail mpd;

    public void initialize() {
        getGenerateNewId();
        loadMealId();
        loadFlightId();
        FlightDetailFormController.setFlightDetailsRecords();
        FlightDetailFormController.setRecapDetails();
        FlightDetailWithTransferGoSideForm1Controller.setTransfer1GoSideRecords();
        FlightDetailWithTransferComeSideForm1Controller.setTransfer1ComeSideRecords();
        FlightDetailWithTransferGoSideForm2Controller.setTransfer2GoSideRecords();
        FlightDetailWithTransferComeSideForm2Controller.setTransfer2ComeSideRecords();
        FlightDetailWithTransferGoSideForm3Controller.setTransfer3GoSideRecords();
        FlightDetailWithTransferComeSideForm3Controller.setTransfer3ComeSideRecords();
    }

    public void clearAll(){
        txtMealPlanDetailId.clear();
        comMealId.setValue(null);
        comFlightId.setValue(null);
        txtPrice.clear();
        txtQty.clear();
        lblTime.setText("no need input data");
        lblDate.setText("no need input data");
    }

    public void getGenerateNewId(){
        try {
            txtMealPlanDetailId.setText(MealPlanDetailModel.generateNewID());
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean condition(){
        boolean condition=false;
        if(txtMealPlanDetailId.getText().isEmpty()|String.valueOf(comMealId.getValue()).isEmpty()|String.valueOf(comFlightId.getValue()).isEmpty()|txtPrice.getText().isEmpty()|txtQty.getText().isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            setDate();
            setTime();
            MealPlanDetail mpd = new MealPlanDetail(txtMealPlanDetailId.getText(), String.valueOf(comMealId.getValue()), String.valueOf(comFlightId.getValue())
                    , Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText()), lblDate.getText(), lblTime.getText());
            try {
                if (MealPlanDetailModel.save(mpd)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    clearAll();
                    getGenerateNewId();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    private void loadMealId() {
        try {
            ObservableList<String> ids = MealPlanDetailModel.loadMealIds();
            comMealId.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFlightId(){
        try {
            ObservableList<String> ids = MealPlanDetailModel.loadFlightIds();
            comFlightId.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void setDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String string = date.format(pattern);
        lblDate.setText(string);
    }
    private void setTime() {
        LocalTime time=LocalTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("hh:mm:ss");
        String string = time.format(pattern);
        lblTime.setText(string);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        }else {
            try {
                if (MealPlanDetailModel.delete(txtMealPlanDetailId.getText())) {
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
            if(mpd.getFlight_meal_Plan_Detail_Id().equals(txtMealPlanDetailId.getText()) & mpd.getM_Id().equals(String.valueOf(comMealId.getValue())) & mpd.getF_Id().equals(String.valueOf(comFlightId.getValue())) & String.valueOf(mpd.getPrice()).equals(txtPrice.getText()) & String.valueOf(mpd.getQty()).equals(txtQty.getText())){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                setDate();
                setTime();
                MealPlanDetail mpd = new MealPlanDetail(txtMealPlanDetailId.getText(), String.valueOf(comMealId.getValue()), String.valueOf(comFlightId.getValue())
                        , Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText()), lblDate.getText(), lblTime.getText());
                try {
                    if (MealPlanDetailModel.update(mpd)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                        clearAll();
                        getGenerateNewId();
                    }
                } catch (ClassNotFoundException | SQLException | ParseException ex) {
                    System.out.println(ex);
                    new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
                }
            }
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
        mpd=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckFlightMealPlanDetailAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtMealPlanDetailIdOnAction(ActionEvent actionEvent){
        mpd=checking();
    }

    public MealPlanDetail checking(){
        try {
            search();
            mpd=new MealPlanDetail(txtMealPlanDetailId.getText(), String.valueOf(comMealId.getValue()), String.valueOf(comFlightId.getValue())
                    , Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQty.getText()), lblDate.getText(), lblTime.getText());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return mpd;
    }

    private void search() throws ClassNotFoundException, SQLException {
        MealPlanDetail mpd= MealPlanDetailModel.search(txtMealPlanDetailId.getText());
        if(mpd!=null){
            fillData(mpd);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(MealPlanDetail mpd) {
       txtMealPlanDetailId.setText(mpd.getFlight_meal_Plan_Detail_Id());
       comMealId.setValue(mpd.getM_Id());
       comFlightId.setValue(mpd.getF_Id());
       txtPrice.setText(String.valueOf(mpd.getPrice()));
       txtQty.setText(String.valueOf(mpd.getQty()));
       lblDate.setText(String.valueOf(mpd.getDate()));
       lblTime.setText(String.valueOf(mpd.getTime()));
    }


    public void txtMealPlanDetailIdKeyTypedOnAction(KeyEvent keyEvent) {
        lblMealPlanDetailIdWarning.setText("");
        txtMealPlanDetailId.setFocusColor(Paint.valueOf("Blue"));

        Pattern mpdIdPattern = Pattern.compile("^(FMD0-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        mpdIdMatcher = mpdIdPattern.matcher(txtMealPlanDetailId.getText());

        if (!mpdIdMatcher.matches()) {
            txtMealPlanDetailId.requestFocus();
            txtMealPlanDetailId.setFocusColor(Paint.valueOf("Red"));
            lblMealPlanDetailIdWarning.setText("invalid");
        }
    }

    public void txtPriceKeyTypedOnAction(KeyEvent keyEvent) {
        lblPriceWarning.setText("");
        txtPrice.setFocusColor(Paint.valueOf("Blue"));

        Pattern pricePattern = Pattern.compile("^([1-9]{1})([0-9]{1})([0-9]{1})([0-9]{1,})$");
        priceMatcher= pricePattern.matcher(txtPrice.getText());

        if (!priceMatcher.matches()) {
            txtPrice.requestFocus();
            txtPrice.setFocusColor(Paint.valueOf("Red"));
            lblPriceWarning.setText("invalid");
        }
    }

    public void txtQtyKeyTypedOnAction(KeyEvent keyEvent) {
        lblQtyWarning.setText("");
        txtQty.setFocusColor(Paint.valueOf("Blue"));

        Pattern qtyPattern = Pattern.compile("^([1-9]{1})([0-9]{0,})$");
         qtyMatcher= qtyPattern.matcher(txtQty.getText());

        if (!qtyMatcher.matches()) {
            txtQty.requestFocus();
            txtQty.setFocusColor(Paint.valueOf("Red"));
            lblQtyWarning.setText("invalid");
        }
    }
}
