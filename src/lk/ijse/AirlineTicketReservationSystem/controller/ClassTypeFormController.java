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
import lk.ijse.AirlineTicketReservationSystem.model.ClassTypeModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanModel;
import lk.ijse.AirlineTicketReservationSystem.to.ClassType;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassTypeFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXTextField txtClassCode;
    public JFXTextField txtClassPrice;
    public JFXTextField txtSeatCount;
    public JFXComboBox<String>comClassName;
    public Label lblClassCodeWarning;
    public Label lblSeatCountWarning;
    public Label lblClassPriceWarning;

    public Matcher classCodeMatcher;
    public Matcher seatCountMatcher;
    public Matcher classPriceMatcher;

    String[]className={"FIRST","ECONOMY","BUSINESS"};
    ObservableList<String> listClassName= FXCollections.observableArrayList(className);

    public ClassType c;

    public void initialize() {
        getGenerateNewId();
        comClassName.setItems(listClassName);
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
        txtClassCode.clear();
        txtClassPrice.clear();
        txtSeatCount.clear();
        comClassName.setValue(null);
    }

    public void getGenerateNewId(){
        try {
            txtClassCode.setText(ClassTypeModel.generateNewID());
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean condition(){
        boolean condition=false;
        if(txtClassCode.getText().isEmpty()|txtSeatCount.getText().isEmpty()|txtClassPrice.getText().isEmpty()|String.valueOf(comClassName.getValue()).isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            ClassType ct = new ClassType(txtClassCode.getText(), String.valueOf(comClassName.getValue()), Integer.parseInt(txtSeatCount.getText())
                    , Double.parseDouble(txtClassPrice.getText()));

            try {
                if (ClassTypeModel.save(ct)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                    clearAll();
                    getGenerateNewId();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
                }
            } catch (ClassNotFoundException | SQLException e) {
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
                if (ClassTypeModel.delete(txtClassCode.getText())) {
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
            if (c.getClass_code().equals(txtClassCode.getText()) & c.getName().equals(String.valueOf(comClassName.getValue())) & String.valueOf(c.getS_qty()).equals(txtSeatCount.getText()) & String.valueOf(c.getPrice()).equals(txtClassPrice.getText())) {
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            } else {
                ClassType ct = new ClassType(txtClassCode.getText(), String.valueOf(comClassName.getValue()), Integer.parseInt(txtSeatCount.getText())
                        , Double.parseDouble(txtClassPrice.getText()));
                try {
                    if (ClassTypeModel.update(ct)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                        clearAll();
                        getGenerateNewId();
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println(ex);
                    new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
                }
            }
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
        c=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckClassTypeAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtClassCodeOnAction(ActionEvent actionEvent) {
        c=checking();
    }

    public ClassType checking(){
        try {
            search();
            c=new ClassType(txtClassCode.getText(), String.valueOf(comClassName.getValue()), Integer.parseInt(txtSeatCount.getText())
                    , Double.parseDouble(txtClassPrice.getText()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    private void search() throws ClassNotFoundException, SQLException {
        ClassType ct =ClassTypeModel.search(txtClassCode.getText());
        if(ct!=null){
            fillData(ct);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(ClassType ct) {
        txtClassCode.setText(ct.getClass_code());
        comClassName.setValue(ct.getName());
        txtSeatCount.setText(String.valueOf(ct.getS_qty()));
        txtClassPrice.setText(String.valueOf(ct.getPrice()));
    }

    public void txtClassCodeKeyTypedOnAction(KeyEvent keyEvent) {
        lblClassCodeWarning.setText("");
        txtClassCode.setFocusColor(Paint.valueOf("Blue"));

        Pattern ccPattern = Pattern.compile("^(C00-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        classCodeMatcher = ccPattern.matcher(txtClassCode.getText());

        if (!classCodeMatcher.matches()) {
            txtClassCode.requestFocus();
            txtClassCode.setFocusColor(Paint.valueOf("Red"));
            lblClassCodeWarning.setText("invalid");
        }

    }

    public void txtClassPriceKeyTypedOnAction(KeyEvent keyEvent) {
        lblClassPriceWarning.setText("");
        txtClassPrice.setFocusColor(Paint.valueOf("Blue"));

        Pattern cpPattern = Pattern.compile("^([1-9]{1})([0-9]{1})([0-9]{1})([0-9]{1})([0-9]{1})([0-9]{1})([0-9]{1,})$");
        classPriceMatcher = cpPattern.matcher(txtClassPrice.getText());

        if (!classPriceMatcher.matches()) {
            txtClassPrice.requestFocus();
            txtClassPrice.setFocusColor(Paint.valueOf("Red"));
            lblClassPriceWarning.setText("invalid");
        }

    }

    public void txtSeatCountKeyTypedOnAction(KeyEvent keyEvent) {
        lblSeatCountWarning.setText("");
        txtSeatCount.setFocusColor(Paint.valueOf("Blue"));

        Pattern scPattern = Pattern.compile("^([1-9]{1})([0-9]{1,})$");
        seatCountMatcher = scPattern.matcher(txtSeatCount.getText());

        if (!seatCountMatcher.matches()) {
            txtSeatCount.requestFocus();
            txtSeatCount.setFocusColor(Paint.valueOf("Red"));
            lblSeatCountWarning.setText("invalid");
        }

    }
}
