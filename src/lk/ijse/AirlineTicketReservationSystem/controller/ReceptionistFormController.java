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
import lk.ijse.AirlineTicketReservationSystem.model.UserModel;
import lk.ijse.AirlineTicketReservationSystem.to.Schedule;
import lk.ijse.AirlineTicketReservationSystem.to.User;
import rex.utils.S;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceptionistFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXTextField txtUserName;
    public JFXTextField txtTel;
    public JFXTextField txtAddress;
    public JFXTextField txtName;
    public JFXComboBox<String>comGender;
    public JFXTextField txtEmail;
    public JFXTextField txtSalary;
    public JFXTextField txtPassword;
    public JFXTextField txtDob;
    public JFXComboBox<String>comRole;

    public Label lblUserNameWarning;
    public Label lblNameWarning;
    public Label lblTeleWarning;
    public Label lblEmailWarning;
    public Label lblSalaryWarning;
    public Label lblPasswordWarning;
    public Label lblAddressWarning;
    public Label lblDobWarning;

    public Matcher userNameMatcher;
    public Matcher nameMatcher;
    public Matcher telMatcher;
    public Matcher emailMatcher;
    public Matcher pwMatcher;
    public Matcher salaryMatcher;
    public Matcher addressMatcher;
    public Matcher dobMatcher;

    public User u;

    String[]gender={"male","female"};
    ObservableList<String>listGender= FXCollections.observableArrayList(gender);

    String[]role={"admin","receptionist"};
    ObservableList<String>listRole= FXCollections.observableArrayList(role);

    public void initialize(){
        comGender.setItems(listGender);
        comRole.setItems(listRole);
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
        txtUserName.clear();
        txtName.clear();
        txtTel.clear();
        txtAddress.clear();
        txtDob.clear();
        txtPassword.clear();
        txtEmail.clear();
        txtSalary.clear();
        comRole.setValue(null);
        comGender.setValue(null);
    }

    public boolean condition(){
        boolean condition=false;
        if(txtUserName.getText().isEmpty()|txtName.getText().isEmpty()|String.valueOf(comRole.getValue()).isEmpty()|String.valueOf(comGender.getValue()).isEmpty()|txtPassword.getText().isEmpty()|txtTel.getText().isEmpty()|txtSalary.getText().isEmpty()|txtEmail.getText().isEmpty()|txtDob.getText().isEmpty()|txtAddress.getText().isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            User user = new User(txtUserName.getText(), txtName.getText(), String.valueOf(comRole.getValue()), txtEmail.getText()
                    , txtTel.getText(), Double.parseDouble(txtSalary.getText()), txtAddress.getText()
                    , txtPassword.getText(), String.valueOf(comGender.getValue()), txtDob.getText());
            try {
                if (UserModel.save(user)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    clearAll();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        }else {
            try {
                if (UserModel.delete(txtUserName.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted!...").show();
                    clearAll();
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
            if(u.getUsername().equals(txtUserName.getText()) & u.getName().equals(txtName.getText()) & u.getRole().equals( String.valueOf(comRole.getValue())) & u.getEmail().equals(txtEmail.getText()) & u.getTele().equals(txtTel.getText()) & String.valueOf(u.getSalary()).equals(txtSalary.getText()) & u.getAddress().equals(txtAddress.getText()) & u.getPassword().equals(txtPassword.getText()) & u.getGender().equals(String.valueOf(comGender.getValue())) & u.getDob().equals(txtDob.getText())){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                User u = new User(
                        txtUserName.getText(), txtName.getText(), String.valueOf(comRole.getValue()), txtEmail.getText()
                        , txtTel.getText(), Double.parseDouble(txtSalary.getText()), txtAddress.getText()
                        , txtPassword.getText(), String.valueOf(comGender.getValue()), txtDob.getText()
                );
                try {
                    if (UserModel.update(u)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                        clearAll();
                    }
                } catch (ClassNotFoundException | SQLException | ParseException ex) {
                    System.out.println(ex);
                    new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
                }
            }
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
       u=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckReceptionistAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtUserNameOnAction(ActionEvent actionEvent) {
        u=checking();
    }


    public User checking(){
        try {
            search();
            u=new User(txtUserName.getText(), txtName.getText(), String.valueOf(comRole.getValue()), txtEmail.getText()
                    , txtTel.getText(), Double.parseDouble(txtSalary.getText()), txtAddress.getText()
                    , txtPassword.getText(), String.valueOf(comGender.getValue()), txtDob.getText());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    private void search() throws ClassNotFoundException, SQLException {
        User user= UserModel.search(txtUserName.getText());
        if(user!=null){
            fillData(user);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
  }

    private void fillData(User u) {
        txtUserName.setText(u.getUsername());
        txtName.setText(u.getName());
        comRole.setValue(u.getRole());
        txtEmail.setText(u.getEmail());
        txtTel.setText(u.getTele());
        txtSalary.setText(String.valueOf(u.getSalary()));
        txtAddress.setText(u.getAddress());
        txtPassword.setText(u.getPassword());
        comGender.setValue(u.getGender());
        txtDob.setText(String.valueOf(u.getDob()));
    }

    public void txtUserNameKeyTypedOnAction(KeyEvent keyEvent) {
        lblUserNameWarning.setText("");
        txtUserName.setFocusColor(Paint.valueOf("Blue"));

        Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());

        if(!userNameMatcher.matches()) {
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            lblUserNameWarning.setText("invalid");
        }
    }

    public void txtTeleKeyTypedOnAction(KeyEvent keyEvent) {
        lblTeleWarning.setText("");
        txtTel.setFocusColor(Paint.valueOf("Blue"));

        Pattern telPattern = Pattern.compile("^(?:7|0|(?:\\+94))[0-9]{9,10}$");
        telMatcher = telPattern.matcher(txtTel.getText());

        if(!telMatcher.matches()) {
            txtTel.requestFocus();
            txtTel.setFocusColor(Paint.valueOf("Red"));
            lblTeleWarning.setText("invalid");
        }
    }

    public void txtAddressKeyTypedOnAction(KeyEvent keyEvent) {
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

    public void txtNameKeyTypedOnAction(KeyEvent keyEvent) {
        lblNameWarning.setText("");
        txtName.setFocusColor(Paint.valueOf("Blue"));

        Pattern namePattern = Pattern.compile("^[a-zA-Z]{4,}$");
        nameMatcher = namePattern.matcher(txtName.getText());

        if(!nameMatcher.matches()) {
            txtName.requestFocus();
            txtName.setFocusColor(Paint.valueOf("Red"));
            lblNameWarning.setText("invalid");
        }
    }

    public void txtEmailKeyTypedOnAction(KeyEvent keyEvent) {
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

    public void txtSalaryKeyTypedOnAction(KeyEvent keyEvent) {
        lblSalaryWarning.setText("");
        txtSalary.setFocusColor(Paint.valueOf("Blue"));

        Pattern salaryPattern = Pattern.compile("^[0-9]{5,6}$");
        salaryMatcher = salaryPattern.matcher(txtSalary.getText());

        if(!salaryMatcher.matches()) {
            txtSalary.requestFocus();
            txtSalary.setFocusColor(Paint.valueOf("Red"));
            lblSalaryWarning.setText("invalid");
        }
    }

    public void txtPasswordKeyTypedOnAction(KeyEvent keyEvent) {
        lblPasswordWarning.setText("");
        txtPassword.setFocusColor(Paint.valueOf("Blue"));

        Pattern pwPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        pwMatcher = pwPattern.matcher(txtPassword.getText());

        if(!pwMatcher.matches()) {
            txtPassword.requestFocus();
            txtPassword.setFocusColor(Paint.valueOf("Red"));
            lblPasswordWarning.setText("invalid");
        }
    }

    public void txtDobKeyTypedOnAction(KeyEvent keyEvent) {
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

}
