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
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.to.Passenger;
import rex.utils.S;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassengerFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXTextField txtPssengerId;
    public JFXTextField txtLastName;
    public JFXTextField txtAddress;
    public JFXTextField txtxFirstName;
    public JFXTextField txtTele;
    public JFXComboBox<String>comGender;
    public JFXTextField txtEmail;

    public Label lblPassengerIdWarning;
    public Label lblFirstNameWarning;
    public Label lblLastNameWarning;
    public Label lblTeleWarning;
    public Label lblEmailWarning;
    public Label lblAddressWarning;
    public Label lblDobWarning;
    public JFXTextField txtDob;

    public Matcher passengerIdMatcher;
    public Matcher fnameMatcher;
    public Matcher lnameMatcher;
    public Matcher teleMatcher;
    public Matcher emailMatcher;
    public Matcher addressMatcher;
    public Matcher dobMatcher;

    public JFXComboBox<String>comPassengerType;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnEdit;
    public JFXButton btnCheck;
    public JFXButton btnList;
    public JFXButton btnNext;

    public Passenger p;


    String[]gender={"male","female"};
    ObservableList<String> listGender= FXCollections.observableArrayList(gender);

    String[]pType={"Adult","Children"};
    ObservableList<String>list= FXCollections.observableArrayList(pType);

    public void initialize(){
        getGenerateNewId();
        comGender.setItems(listGender);
        comPassengerType.setItems(list);
        btnNext.setDisable(true);
    }

    public void clearAll(){
        txtPssengerId.clear();
        txtxFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        txtTele.clear();
        txtEmail.clear();
        comGender.setValue(null);
        txtDob.clear();
        comPassengerType.setValue(null);
    }

    public void getGenerateNewId(){
        try {
            txtPssengerId.setText(PassengerModel.generateNewID());
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean condition(){
        boolean condition=false;
        if(txtPssengerId.getText().isEmpty()|txtxFirstName.getText().isEmpty()|txtLastName.getText().isEmpty()|txtAddress.getText().isEmpty()|txtTele.getText().isEmpty()|txtEmail.getText().isEmpty()|String.valueOf(comGender.getValue()).isEmpty()|txtDob.getText().isEmpty()|String.valueOf(comPassengerType.getValue()).isEmpty()){
            condition=true;
        }
        return condition;
    }

    private int round ;
    private ArrayList<String>pIdList=new ArrayList<>();

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            Passenger p = new Passenger(txtPssengerId.getText(), txtxFirstName.getText(), txtLastName.getText(), txtAddress.getText()
                    , txtTele.getText(), txtEmail.getText(), String.valueOf(comGender.getValue()), txtDob.getText(), String.valueOf(comPassengerType.getValue()));
            try {
                if (PassengerModel.save(p)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    pIdList.add(txtPssengerId.getText());
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
        if(round==FlightAvailabilityFormController.getCount()){
            btnSave.setDisable(true);
            btnEdit.setDisable(true);
            btnDelete.setDisable(true);
            btnCheck.setDisable(true);
            btnList.setDisable(true);
            btnNext.setDisable(false);
        }
    }

    public ArrayList<String> getPidList(){
        return pIdList;
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        }else {
            try {
                if (PassengerModel.delete(txtPssengerId.getText())) {
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
            if(p.getPass_Id().equals(txtPssengerId.getText()) & p.getF_Name().equals(txtxFirstName.getText()) & p.getL_Name().equals( txtLastName.getText()) & p.getAddress().equals(txtAddress.getText()) & p.getTele().equals(txtTele.getText()) & p.getEmail().equals(txtEmail.getText()) & p.getGender().equals(String.valueOf(comGender.getValue())) & p.getDob().equals(txtDob.getText()) & p.getPassenger_type().equals(String.valueOf(comPassengerType.getValue()))){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                Passenger p = new Passenger(txtPssengerId.getText(), txtxFirstName.getText(), txtLastName.getText(), txtAddress.getText()
                        , txtTele.getText(), txtEmail.getText(), String.valueOf(comGender.getValue()), txtDob.getText(), String.valueOf(comPassengerType.getValue()));

                try {
                    if (PassengerModel.update(p)) {
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
        p=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckPassengerAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtPssengerIdOnAction(ActionEvent actionEvent) {
       p=checking();
    }

    public Passenger checking(){
        try {
            search();
            p= new Passenger(txtPssengerId.getText(), txtxFirstName.getText(), txtLastName.getText(), txtAddress.getText()
                    , txtTele.getText(), txtEmail.getText(), String.valueOf(comGender.getValue()), txtDob.getText(), String.valueOf(comPassengerType.getValue()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    private void search() throws ClassNotFoundException, SQLException {
        Passenger p = PassengerModel.search(txtPssengerId.getText());
        if(p!=null){
            fillData(p);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(Passenger p) {
        txtPssengerId.setText(p.getPass_Id());
        txtxFirstName.setText(p.getF_Name());
        txtLastName.setText(p.getL_Name());
        txtAddress.setText(p.getAddress());
        txtTele.setText(p.getTele());
        txtEmail.setText(p.getEmail());
        comGender.setValue(p.getGender());
        txtDob.setText(p.getDob());
        comPassengerType.setValue(p.getPassenger_type());
    }


    public void txtPssengerIdKeyReleasedOnAction(KeyEvent keyEvent) {
        lblPassengerIdWarning.setText("");
        txtPssengerId.setFocusColor(Paint.valueOf("Blue"));

        Pattern pIdPattern = Pattern.compile("^(P00-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        passengerIdMatcher = pIdPattern.matcher(txtPssengerId.getText());

        if(!passengerIdMatcher.matches()) {
            txtPssengerId.requestFocus();
            txtPssengerId.setFocusColor(Paint.valueOf("Red"));
            lblPassengerIdWarning.setText("invalid");
        }
    }

    public void txtFirstNameKeyReleasedOnAction(KeyEvent keyEvent) {
        lblFirstNameWarning.setText("");
        txtxFirstName.setFocusColor(Paint.valueOf("Blue"));

        Pattern fnamePattern = Pattern.compile("^[a-zA-Z]{4,}$");
        fnameMatcher = fnamePattern.matcher(txtxFirstName.getText());

        if(!fnameMatcher.matches()) {
            txtxFirstName.requestFocus();
            txtxFirstName.setFocusColor(Paint.valueOf("Red"));
            lblFirstNameWarning.setText("invalid");
        }
    }

    public void txtLastNameKeyReleasedOnAction(KeyEvent keyEvent) {
        lblLastNameWarning.setText("");
        txtLastName.setFocusColor(Paint.valueOf("Blue"));

        Pattern lnamePattern = Pattern.compile("^[a-zA-Z]{4,}$");
        lnameMatcher = lnamePattern.matcher(txtLastName.getText());

        if(!lnameMatcher.matches()) {
            txtLastName.requestFocus();
            txtLastName.setFocusColor(Paint.valueOf("Red"));
            lblLastNameWarning.setText("invalid");
        }
    }

    public void txtDobKeyReleasedOnAction(KeyEvent keyEvent) {
        lblDobWarning.setText("");
        txtDob.setFocusColor(Paint.valueOf("Blue"));

        Pattern dobPattern = Pattern.compile("^([0-9]{4})([-])([0-9]{2})([-])([0-9]{2})$");
        dobMatcher = dobPattern.matcher(txtDob.getText());

        if(!dobMatcher.matches()) {
            txtDob.requestFocus();
            txtDob.setFocusColor(Paint.valueOf("Red"));
            lblDobWarning.setText("invalid");
        }
    }



    public void txtTeleKeyReleasedOnAction(KeyEvent keyEvent) {
        lblTeleWarning.setText("");
        txtTele.setFocusColor(Paint.valueOf("Blue"));

        Pattern telPattern = Pattern.compile("^(?:7|0|(?:\\+94))[0-9]{9,10}$");
        teleMatcher = telPattern.matcher(txtTele.getText());

        if(!teleMatcher.matches()) {
            txtTele.requestFocus();
            txtTele.setFocusColor(Paint.valueOf("Red"));
            lblTeleWarning.setText("invalid");
        }
    }

    public void txtEmailKeyReleasedOnAction(KeyEvent keyEvent) {
        lblEmailWarning.setText("");
        txtEmail.setFocusColor(Paint.valueOf("Blue"));

        Pattern emailPattern = Pattern.compile("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        emailMatcher = emailPattern.matcher(txtEmail.getText());

        if(!emailMatcher.matches()) {
            txtEmail.requestFocus();
            txtEmail.setFocusColor(Paint.valueOf("Red"));
            lblEmailWarning.setText("invalid");
        }
    }


    public void txtAddressKeyReleasedOnAction(KeyEvent keyEvent) {
        lblAddressWarning.setText("");
        txtAddress.setFocusColor(Paint.valueOf("Blue"));

        Pattern addressPattern = Pattern.compile("^[a-zA-Z]{4,}$");
        addressMatcher = addressPattern.matcher(txtAddress.getText());

        if(!addressMatcher.matches()) {
            txtAddress.requestFocus();
            txtAddress.setFocusColor(Paint.valueOf("Red"));
            lblAddressWarning.setText("invalid");
        }
    }

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/PaymentForm");
    }
}
