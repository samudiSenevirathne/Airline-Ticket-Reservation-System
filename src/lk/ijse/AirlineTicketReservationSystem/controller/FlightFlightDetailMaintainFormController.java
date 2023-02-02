package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailMaintainModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.FlightModel;
import lk.ijse.AirlineTicketReservationSystem.to.ClassType;
import lk.ijse.AirlineTicketReservationSystem.to.Custom;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetailMaintain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightFlightDetailMaintainFormController {
    public AnchorPane context;
    public JFXTextField txtFlightDetailMaintainId;
    public JFXTextField txtCommenGuidlineCount;
    public JFXTextField txtAllGuidlineCount;
    public Label lblFlightDetailMaintainIdWarning;
    public Label lblCommenGuidlineCountWarning;
    public Label lblAllGuidlineCountWarning;
    public Matcher flightDetailMaintainIdMatcher;
    public Matcher commenGuidlineCountMatcher;
    public Matcher allGuidlineCountMatcher;
    public JFXTextField txtFlightDetailId;
    public JFXTextField txtFlightId;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnEdit;
    public JFXButton btnCheck;
    public JFXButton btnList;
    public JFXButton btnBck;

      public ArrayList<Custom>arrayList;
      public FlightDetailMaintain fdm;


    public void initialize() {
        arrayList=FlightDetailFormController.getCustomObjectRecords();
         getGenerateNewId();
         txtFlightDetailId.setEditable(false);
         txtFlightId.setEditable(false);
            btnBck.setDisable(true);
            btnList.setDisable(false);
            btnSave.setDisable(true);
            btnDelete.setDisable(true);
            btnEdit.setDisable(false);
            btnCheck.setDisable(false);
         if(arrayList!=null) {
             for (Custom c : arrayList) {
                 txtFlightDetailId.setText(c.getF_Detail_Id());
                 txtFlightId.setText(c.getF_Id());
                 btnList.setDisable(true);
                 btnCheck.setDisable(true);
                 btnEdit.setDisable(true);
                 btnSave.setDisable(false);
             }
         }
    }


    public void getGenerateNewId(){
        try {
            txtFlightDetailMaintainId.setText(FlightDetailMaintainModel.generateNewID());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearAll(){
        txtFlightDetailMaintainId.clear();
        txtFlightDetailId.clear();
        txtFlightId.clear();
        txtCommenGuidlineCount.clear();
        txtAllGuidlineCount.clear();
    }

    public boolean condition(){
        boolean condition=false;
        if(txtFlightDetailMaintainId.getText().isEmpty()|txtFlightDetailId.getText().isEmpty()|txtFlightId.getText().isEmpty()|txtCommenGuidlineCount.getText().isEmpty()|txtAllGuidlineCount.getText().isEmpty()){
            condition=true;
        }
        return condition;
    }

        public void btnSaveOnAction(ActionEvent actionEvent) {
            if(condition()) {
                new Alert(Alert.AlertType.WARNING, "Please fill above blank fields or field!!!").show();
            }else {
                FlightDetailMaintain fdm = new FlightDetailMaintain(txtFlightDetailMaintainId.getText(), txtFlightDetailId.getText()
                        , txtFlightId.getText(), Integer.parseInt(txtCommenGuidlineCount.getText())
                        , Integer.parseInt(txtAllGuidlineCount.getText()));
                try {
                    if (FlightDetailMaintainModel.save(fdm)) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
                        clearAll();
                        getGenerateNewId();
                        FlightDetailFormController.setCustomObjectRecords();
                        FlightDetailFormController.setRecapDetails();
                        btnSave.setDisable(true);
                        btnList.setDisable(true);
                        btnCheck.setDisable(false);
                        btnEdit.setDisable(false);
                        btnBck.setDisable(false);
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
                if (FlightDetailMaintainModel.delete(txtFlightDetailMaintainId.getText())) {
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
            if(fdm.getFli_Fli_Det_Main_Id().equals(txtFlightDetailMaintainId.getText())&fdm.getF_Detail_Id().equals(txtFlightDetailId.getText())&fdm.getF_Id().equals(txtFlightId.getText())&String.valueOf(fdm.getCommen_guidline_count()).equals(txtCommenGuidlineCount.getText())&String.valueOf(fdm.getAll_guidline_count()).equals(txtAllGuidlineCount.getText())){
                new Alert(Alert.AlertType.WARNING, "you haven't changed any data!!!if you want to edit data first you should change you're data").show();
            }else {
                FlightDetailMaintain fdm = new FlightDetailMaintain(txtFlightDetailMaintainId.getText(), txtFlightDetailId.getText()
                        , txtFlightId.getText(), Integer.parseInt(txtCommenGuidlineCount.getText())
                        , Integer.parseInt(txtAllGuidlineCount.getText()));
                try {
                    if (FlightDetailMaintainModel.update(fdm)) {
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
        fdm=checking();
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckFlightDetailMaintainAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void txtFlightDetailMaintainIdOnAction(ActionEvent actionEvent) {
        fdm=checking();
    }


    public FlightDetailMaintain checking() {
        try {
            search();
            fdm= new FlightDetailMaintain(txtFlightDetailMaintainId.getText(), txtFlightDetailId.getText()
                    , txtFlightId.getText(), Integer.parseInt(txtCommenGuidlineCount.getText())
                    , Integer.parseInt(txtAllGuidlineCount.getText()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         return fdm;
    }

    private void search() throws ClassNotFoundException, SQLException {
        FlightDetailMaintain fdm =FlightDetailMaintainModel.search(txtFlightDetailMaintainId.getText());
        if(fdm!=null){
            fillData(fdm);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(FlightDetailMaintain fdm) {
       txtFlightDetailMaintainId.setText(fdm.getFli_Fli_Det_Main_Id());
       txtFlightDetailId.setText(fdm.getF_Detail_Id());
       txtFlightId.setText(fdm.getF_Id());
       txtCommenGuidlineCount.setText(String.valueOf(fdm.getCommen_guidline_count()));
       txtAllGuidlineCount.setText(String.valueOf(fdm.getAll_guidline_count()));
    }


    public void txtFlightDetailMaintainIdKeyTypedOnAction(KeyEvent keyEvent) {
        lblFlightDetailMaintainIdWarning.setText("");
        txtFlightDetailMaintainId.setFocusColor(Paint.valueOf("Blue"));

        Pattern fdmiPattern = Pattern.compile("^(FDM0-)([0-9]{1,})([0-9]{1,})([0-9]{1,})$");
        flightDetailMaintainIdMatcher = fdmiPattern.matcher(txtFlightDetailMaintainId.getText());

        if (!flightDetailMaintainIdMatcher.matches()) {
            txtFlightDetailMaintainId.requestFocus();
            txtFlightDetailMaintainId.setFocusColor(Paint.valueOf("Red"));
            lblFlightDetailMaintainIdWarning.setText("invalid");
        }
    }

    public void txtCommenGuidlineCountKeyTypedOnAction(KeyEvent keyEvent) {
        lblCommenGuidlineCountWarning.setText("");
        txtCommenGuidlineCount.setFocusColor(Paint.valueOf("Blue"));

        Pattern cgcPattern = Pattern.compile("^([1-9]{1})([0-9]{1,})$");
        commenGuidlineCountMatcher = cgcPattern.matcher(txtCommenGuidlineCount.getText());

        if (!commenGuidlineCountMatcher.matches()) {
            txtCommenGuidlineCount.requestFocus();
            txtCommenGuidlineCount.setFocusColor(Paint.valueOf("Red"));
            lblCommenGuidlineCountWarning.setText("invalid");
        }
    }

    public void txtAllGuidlineCountKeyTypedOnAction(KeyEvent keyEvent) {
        lblAllGuidlineCountWarning.setText("");
        txtAllGuidlineCount.setFocusColor(Paint.valueOf("Blue"));

        Pattern agcPattern = Pattern.compile("^([1-9]{1})([0-9]{1,})$");
        allGuidlineCountMatcher = agcPattern.matcher(txtAllGuidlineCount.getText());

        if (!allGuidlineCountMatcher.matches()) {
            txtAllGuidlineCount.requestFocus();
            txtAllGuidlineCount.setFocusColor(Paint.valueOf("Red"));
            lblAllGuidlineCountWarning.setText("invalid");
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightDetailForm");
    }
}
