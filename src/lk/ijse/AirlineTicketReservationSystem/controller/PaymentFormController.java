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
import lk.ijse.AirlineTicketReservationSystem.model.PassengerModel;
import lk.ijse.AirlineTicketReservationSystem.model.PaymentModel;
import lk.ijse.AirlineTicketReservationSystem.to.Passenger;
import lk.ijse.AirlineTicketReservationSystem.to.Payment;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PaymentFormController {

    public AnchorPane context;
    public JFXComboBox<String>comFlightId;
    public JFXComboBox<String>comType;
    public JFXTextField txtName;
    public JFXTextField txtPaymentCode;
    public Label lblDate;
    public Label lblTime;
    public Label lblPaymentCodeWarning;
    public Label lblNameWarning;

    public Matcher pCodeMatcher;
    public Matcher nameMatcher;
    public JFXButton btnList;
    public JFXButton btnSave;
    public JFXButton btnEdit;
    public JFXButton btnDelete;
    public JFXButton btnCheck;
    public JFXButton btnNext;

    String[]type={"card","cash"};
    ObservableList<String>list= FXCollections.observableArrayList(type);

    public Payment p;

    public void initialize() {
        getGenerateNewId();
        comType.setItems(list);
        loadFlightId();
        btnNext.setDisable(true);
    }


    public void clearAll(){
        txtPaymentCode.clear();
        comFlightId.setValue(null);
        txtName.clear();
        comType.setValue(null);
        lblDate.setText("no need input data");
        lblTime.setText("no need input data");
    }

    public void getGenerateNewId(){
        try {
            txtPaymentCode.setText(PaymentModel.generateNewID());
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean condition(){
        boolean condition=false;
        if(txtPaymentCode.getText().isEmpty()|String.valueOf(comFlightId.getValue()).isEmpty()|txtName.getText().isEmpty()|String.valueOf(comType.getValue()).isEmpty()){
            condition=true;
        }
        return condition;
    }
    private int round ;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            setDate();
            setTime();
            Payment p = new Payment(txtPaymentCode.getText(), String.valueOf(comFlightId.getValue()), txtName.getText(), String.valueOf(comType.getValue()),
                    lblDate.getText(), lblTime.getText());
            try {
                if (PaymentModel.save(p)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    round++;
                    clearAll();
                    getGenerateNewId();
                    btnNextShow();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    private void btnNextShow(){
        if(round==comFlightId.getItems().size()){
            btnSave.setDisable(true);
            btnEdit.setDisable(true);
            btnDelete.setDisable(true);
            btnCheck.setDisable(true);
            btnList.setDisable(true);
            btnNext.setDisable(false);
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

    private void loadFlightId(){
        /*try {
            ObservableList<String> ids = PaymentModel.loadFlightIds();
            comFlightId.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

        ArrayList<String>fIds= FlightAvailabilityForm2Controller.getFidList();
        ObservableList<String>flist= FXCollections.observableArrayList(fIds);
        comFlightId.setItems(flist);
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to edit!!!").show();
        }else {
            if(p.getP_code().equals(txtPaymentCode.getText()) & p.getF_Id().equals(String.valueOf(comFlightId.getValue())) & p.getP_name().equals( txtName.getText()) & p.getType().equals(String.valueOf(comType.getValue())) & p.getDate().equals(lblDate.getText()) & p.getTime().equals(lblTime.getText())){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                setDate();
                setTime();
                Payment p = new Payment(txtPaymentCode.getText(), String.valueOf(comFlightId.getValue()), txtName.getText(), String.valueOf(comType.getValue()),
                        lblDate.getText(), lblTime.getText());
                try {
                    if (PaymentModel.update(p)) {
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

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        }else {
            try {
                if (PaymentModel.delete(txtPaymentCode.getText())) {
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

    public void btnCheckOnAction(ActionEvent actionEvent) {
        p=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckPaymentAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }


    public void txtPaymentCodeOnAction(ActionEvent actionEvent) {
        p=checking();
    }

    public Payment checking(){
        try {
            search();
            p=new Payment(txtPaymentCode.getText(), String.valueOf(comFlightId.getValue()), txtName.getText(), String.valueOf(comType.getValue()),
                    lblDate.getText(), lblTime.getText());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    private void search() throws ClassNotFoundException, SQLException {
        Payment p= PaymentModel.search(txtPaymentCode.getText());
        if(p!=null){
            fillData(p);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(Payment p) {
        txtPaymentCode.setText(p.getP_code());
        comFlightId.setValue(p.getF_Id());
        txtName.setText(p.getP_name());
        comType.setValue(p.getType());
        lblDate.setText(String.valueOf(p.getDate()));
        lblTime.setText(String.valueOf(p.getTime()));
    }

    public void txtNameKeyReleasedOnAction(KeyEvent keyEvent) {
        lblNameWarning.setText("");
        txtName.setFocusColor(Paint.valueOf("Blue"));

        Pattern namePattern = Pattern.compile("^[a-zA-Z]{4,}$");
        nameMatcher = namePattern.matcher(txtName.getText());

        if (!nameMatcher.matches()) {
            txtName.requestFocus();
            txtName.setFocusColor(Paint.valueOf("Red"));
            lblNameWarning.setText("invalid");
        }
    }

    public void txtPaymentCodeKeyReleasedOnAction(KeyEvent keyEvent) {
        lblPaymentCodeWarning.setText("");
        txtPaymentCode.setFocusColor(Paint.valueOf("Blue"));

        Pattern pCodePattern = Pattern.compile("^(PC0-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        pCodeMatcher = pCodePattern.matcher(txtPaymentCode.getText());

        if (!pCodeMatcher.matches()) {
            txtPaymentCode.requestFocus();
            txtPaymentCode.setFocusColor(Paint.valueOf("Red"));
            lblPaymentCodeWarning.setText("invalid");
        }
    }


    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/PaymentDetailForm");
    }
}
