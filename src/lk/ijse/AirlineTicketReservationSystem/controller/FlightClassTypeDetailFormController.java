package lk.ijse.AirlineTicketReservationSystem.controller;

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
import lk.ijse.AirlineTicketReservationSystem.model.ClassTypeDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.ScheduleModel;
import lk.ijse.AirlineTicketReservationSystem.to.ClassTypeDetail;
import rex.utils.S;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightClassTypeDetailFormController {

    public AnchorPane context;
    public JFXTextField txtClassTypeDetailId;
    public JFXTextField txtPrice;
    public JFXComboBox<String>comClassCode;
    public JFXComboBox<String>comFlightId;
    public JFXComboBox<String>comDemand;
    public Label lblClassTypeDetailIdWarning;
    public Label lblPriceWarning;

    public Matcher classTypeDetailIddMatcher;
    public Matcher priceMatcher;

    public ClassTypeDetail ctd;

    String[]demand={"HIGH","LOW"};
    ObservableList<String>list= FXCollections.observableArrayList(demand);

    public void initialize() {
        getGenerateNewId();
        loadClassCode();
        loadFlightId();
        comDemand.setItems(list);
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
        txtClassTypeDetailId.clear();
        comClassCode.setValue(null);
        comFlightId.setValue(null);
        comDemand.setValue(null);
        txtPrice.clear();
    }

    public void getGenerateNewId(){
        try {
            txtClassTypeDetailId.setText(ClassTypeDetailModel.generateNewID());
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public boolean condition(){
        boolean condition=false;
        if(txtClassTypeDetailId.getText().isEmpty()|String.valueOf(comClassCode.getValue()).isEmpty()|String.valueOf(comFlightId.getValue()).isEmpty()|String.valueOf(comDemand.getValue()).isEmpty()|txtPrice.getText().isEmpty()){
            condition=true;
        }
        return condition;
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
        }else {
            ClassTypeDetail ctd = new ClassTypeDetail(txtClassTypeDetailId.getText(), String.valueOf(comClassCode.getValue())
                    , String.valueOf(comFlightId.getValue()), String.valueOf(comDemand.getValue())
                    , Double.parseDouble(txtPrice.getText()));
            try {
                if (ClassTypeDetailModel.save(ctd)) {
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

    private void loadClassCode() {
        try {
            ObservableList<String> id = ClassTypeDetailModel.loadClassCodes();
            comClassCode.setItems(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFlightId(){
        try {
            ObservableList<String> id = ClassTypeDetailModel.loadFlightIds();
            comFlightId.setItems(id);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        if(condition()) {
            new Alert(Alert.AlertType.WARNING, "First check data you want to delete!!!").show();
        }else {
            try {
                if (ClassTypeDetailModel.delete(txtClassTypeDetailId.getText())) {
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
            if(ctd.getFli_cla_type_Id().equals(txtClassTypeDetailId.getText()) & ctd.getClass_code().equals(String.valueOf(comClassCode.getValue())) & ctd.getF_Id().equals(String.valueOf(comFlightId.getValue())) & ctd.getDemand().equals(String.valueOf(comDemand.getValue())) & String.valueOf(ctd.getPrice()).equals(txtPrice.getText())){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                ClassTypeDetail ctd = new ClassTypeDetail(txtClassTypeDetailId.getText(), String.valueOf(comClassCode.getValue())
                        , String.valueOf(comFlightId.getValue()), String.valueOf(comDemand.getValue())
                        , Double.parseDouble(txtPrice.getText()));

                try {
                    if (ClassTypeDetailModel.update(ctd)) {
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
       ctd=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckClassTypeDetailAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtClassTypeDetailIdOnAction(ActionEvent actionEvent) {
        ctd=checking();
    }

    public ClassTypeDetail checking(){
        try {
            search();
            ctd= new ClassTypeDetail(txtClassTypeDetailId.getText(), String.valueOf(comClassCode.getValue())
                    , String.valueOf(comFlightId.getValue()), String.valueOf(comDemand.getValue())
                    , Double.parseDouble(txtPrice.getText()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ctd;
    }

    private void search() throws ClassNotFoundException, SQLException {
       ClassTypeDetail ctd =ClassTypeDetailModel.search(txtClassTypeDetailId.getText());
        if(ctd!=null){
            fillData(ctd);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(ClassTypeDetail ctd) {
        txtClassTypeDetailId.setText(ctd.getFli_cla_type_Id());
        comClassCode.setValue(ctd.getClass_code());
        comFlightId.setValue(ctd.getF_Id());
        comDemand.setValue(ctd.getDemand());
        txtPrice.setText(String.valueOf(ctd.getPrice()));
    }


    public void txtClassTypeDetailIdKeyTypedOnAction(KeyEvent keyEvent) {
        lblClassTypeDetailIdWarning.setText("");
        txtClassTypeDetailId.setFocusColor(Paint.valueOf("Blue"));

        Pattern ctdiPattern = Pattern.compile("^(FCD0-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        classTypeDetailIddMatcher = ctdiPattern.matcher(txtClassTypeDetailId.getText());

        if (!classTypeDetailIddMatcher.matches()) {
            txtClassTypeDetailId.requestFocus();
            txtClassTypeDetailId.setFocusColor(Paint.valueOf("Red"));
            lblClassTypeDetailIdWarning.setText("invalid");
        }
    }

    public void txtPriceKeyTypedOnAction(KeyEvent keyEvent) {
        lblPriceWarning.setText("");
        txtPrice.setFocusColor(Paint.valueOf("Blue"));

        Pattern pricePattern = Pattern.compile("^([1-9]{1})([0-9]{1})([0-9]{1})([0-9]{1})([0-9]{1})([0-9]{1})([0-9]{1,})$");
        priceMatcher = pricePattern.matcher(txtPrice.getText());

        if (!priceMatcher.matches()) {
            txtPrice.requestFocus();
            txtPrice.setFocusColor(Paint.valueOf("Red"));
            lblPriceWarning.setText("invalid");
        }
    }
}
