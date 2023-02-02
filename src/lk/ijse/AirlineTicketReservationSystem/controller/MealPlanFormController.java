package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanModel;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlan;


import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MealPlanFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXTextField txtMealId;
    public JFXTextField txtMealName;
    public JFXTextField txtMealPrice;
    public JFXTextField txtMealType;
    public Label lblMealIdWarning;
    public Label lblMealNameWarning;
    public Label lblMealTypeWarning;
    public Label lblMealPriceWarning;

    public Matcher mealIdMatcher;
    public Matcher mealNameMatcher;
    public Matcher mealTypeMatcher;
    public Matcher mealPriceMatcher;

    public MealPlan m;

    public void initialize() {
        getGenerateNewId();
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
        txtMealId.clear();
        txtMealName.clear();
        txtMealType.clear();
        txtMealPrice.clear();
    }

    public boolean condition(){
        boolean condition=false;
        if(txtMealId.getText().isEmpty()|txtMealName.getText().isEmpty()|txtMealType.getText().isEmpty()|txtMealPrice.getText().isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void getGenerateNewId(){
        try {
            txtMealId.setText(MealPlanModel.generateNewID());
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            MealPlan meal = new MealPlan(txtMealId.getText(), txtMealName.getText(), txtMealType.getText()
                    , Double.parseDouble(txtMealPrice.getText()));

            try {
                if (MealPlanModel.save(meal)) {
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
                if (MealPlanModel.delete(txtMealId.getText())) {
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
            if(m.getM_Id().equals(txtMealId.getText()) & m.getM_Name().equals(txtMealName.getText()) & m.getType().equals(txtMealType.getText()) & String.valueOf(m.getPrice()).equals(txtMealPrice.getText())){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                MealPlan meal = new MealPlan(txtMealId.getText(), txtMealName.getText(), txtMealType.getText()
                        , Double.parseDouble(txtMealPrice.getText()));
                try {
                    if (MealPlanModel.update(meal)) {
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
        m=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckMealPlanAsListForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtMealIdOnAction(ActionEvent actionEvent) {
       m=checking();
    }

    public MealPlan checking(){
        try {
            search();
            m=new MealPlan(txtMealId.getText(), txtMealName.getText(), txtMealType.getText()
                    , Double.parseDouble(txtMealPrice.getText()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    private void search() throws ClassNotFoundException, SQLException {
        MealPlan meal=MealPlanModel.search(txtMealId.getText());
        if(meal!=null){
            fillData(meal);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }

    }

    private void fillData(MealPlan m) {
        txtMealId.setText(m.getM_Id());
        txtMealName.setText(m.getM_Name());
        txtMealType.setText(m.getType());
        txtMealPrice.setText(String.valueOf(m.getPrice()));
    }

    public void txtMealIdKeyTypedOnAction(KeyEvent keyEvent) {
        lblMealIdWarning.setText("");
        txtMealId.setFocusColor(Paint.valueOf("Blue"));

        Pattern mealIdPattern = Pattern.compile("^(M00-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        mealIdMatcher = mealIdPattern.matcher(txtMealId.getText());

        if (!mealIdMatcher.matches()) {
            txtMealId.requestFocus();
            txtMealId.setFocusColor(Paint.valueOf("Red"));
            lblMealIdWarning.setText("invalid");
        }
    }

    public void txtMealNameKeyTypedOnAction(KeyEvent keyEvent) {
        lblMealNameWarning.setText("");
        txtMealName.setFocusColor(Paint.valueOf("Blue"));

        Pattern mealNamePattern = Pattern.compile("^[a-zA-Z]{4,}$");
        mealNameMatcher = mealNamePattern.matcher(txtMealName.getText());

        if (!mealNameMatcher.matches()) {
            txtMealName.requestFocus();
            txtMealName.setFocusColor(Paint.valueOf("Red"));
            lblMealNameWarning.setText("invalid");
        }
    }

    public void txtMealPriceKeyTypedOnAction(KeyEvent keyEvent) {
        lblMealPriceWarning.setText("");
        txtMealPrice.setFocusColor(Paint.valueOf("Blue"));

        Pattern mealPricePattern = Pattern.compile("^([1-9]{1})([0-9]{1})([0-9]{1})([0-9]{1,})$");
        mealPriceMatcher = mealPricePattern.matcher(txtMealPrice.getText());

        if (!mealPriceMatcher.matches()) {
            txtMealPrice.requestFocus();
            txtMealPrice.setFocusColor(Paint.valueOf("Red"));
            lblMealPriceWarning.setText("invalid");
        }
    }

    public void txtMealTypeKeyTypedOnAction(KeyEvent keyEvent) {
        lblMealTypeWarning.setText("");
        txtMealType.setFocusColor(Paint.valueOf("Blue"));

        Pattern mealTypePattern =  Pattern.compile("^[a-zA-Z]{4,}$");
        mealTypeMatcher = mealTypePattern.matcher(txtMealType.getText());

        if (!mealTypeMatcher.matches()) {
            txtMealType.requestFocus();
            txtMealType.setFocusColor(Paint.valueOf("Red"));
            lblMealTypeWarning.setText("invalid");
        }
    }
}
