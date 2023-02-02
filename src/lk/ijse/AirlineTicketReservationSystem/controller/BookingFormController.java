package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.*;
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
import javafx.stage.Stage;
import lk.ijse.AirlineTicketReservationSystem.db.DBConnection;
import lk.ijse.AirlineTicketReservationSystem.model.BookDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.BookDetail;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXComboBox<String>comFlightId;
    public JFXComboBox<String>comPassengerId;
    public JFXComboBox<String>comMealId;
    public JFXComboBox<String>comClassCode;
    public JFXTextField txtBookId;
    public Label lblBookIdWarning;
    public Label lblData;
    public Label lblTime;
    public Label lblTotal;
    public JFXTextField txtCountry;
    public Label lblCountryWarning;

    public Matcher bIdMatcher;
    public Matcher countryMatcher;

    public String preview="";

    public void initialize() {
        loadPassengerId();
        loadFlightId();
    }


    public void btnBookingOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DBConnection.getDbConnection().getConnection().setAutoCommit(false);
        setDate();
        setTime();
        calculateTotal();
        BookDetail b = new BookDetail(txtBookId.getText(),String.valueOf(comPassengerId.getValue()),String.valueOf(comFlightId.getValue())
                ,lblData.getText(),lblTime.getText(),txtCountry.getText(),Double.parseDouble(lblTotal.getText())
                ,String.valueOf(comMealId.getValue()),String.valueOf(comClassCode.getValue()));
        try {
            if(BookDetailModel.save(b)){
                          if(BookDetailModel.updateClassSeat(String.valueOf(comClassCode.getValue()))){
                                DBConnection.getDbConnection().getConnection().commit();
                              new Alert(Alert.AlertType.CONFIRMATION, "Booking booked!").show();
                          }
            }else{
                new Alert(Alert.AlertType.WARNING, "Booked Failed!!").show();
            }
            DBConnection.getDbConnection().getConnection().rollback();

        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } finally {
        DBConnection.getDbConnection().getConnection().setAutoCommit(true);
       }
    }

    private void setDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String string = date.format(pattern);
        lblData.setText(string);
    }
    private void setTime() {
        LocalTime time=LocalTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("hh:mm:ss");
        String string = time.format(pattern);
        lblTime.setText(string);
    }

    private void loadPassengerId(){
        try {
            ObservableList<String> ids = BookDetailModel.loadPassengerIds();
            comPassengerId.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFlightId(){
        try {
            ObservableList<String> ids = BookDetailModel.loadFlightIds();
            comFlightId.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void calculateTotal(){
        double mprice=0,cprice=0;
        try {
            ResultSet set1 = BookDetailModel.loadMealPlanPrice(String.valueOf(comMealId.getValue()));
            ResultSet set2 = BookDetailModel.loadClassPrice(String.valueOf(comClassCode.getValue()));
            while(set1.next()){
                 mprice=(set1.getDouble(1));
            }
            while(set2.next()){
                cprice=(set2.getDouble(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        double total=mprice+cprice;
        lblTotal.setText(String.valueOf(total));
    }

    public void btnCancelOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DBConnection.getDbConnection().getConnection().setAutoCommit(false);
        try {
            if(BookDetailModel.delete(txtBookId.getText())) {
                if(BookDetailModel.replaceClassSeat(preview)) {
                    preview="";
                    DBConnection.getDbConnection().getConnection().commit();
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted!...").show();
                }
            }
            DBConnection.getDbConnection().getConnection().rollback();
        }catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, "Deleted Failed!...").show();
        } finally {
            DBConnection.getDbConnection().getConnection().setAutoCommit(true);
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        setDate();
        setTime();
        calculateTotal();
        BookDetail b = new BookDetail(txtBookId.getText(),String.valueOf(comPassengerId.getValue()),String.valueOf(comFlightId.getValue())
                ,lblData.getText(),lblTime.getText(),txtCountry.getText(),Double.parseDouble(lblTotal.getText())
                ,String.valueOf(comMealId.getValue()),String.valueOf(comClassCode.getValue()));
        try {
            if(BookDetailModel.update(b)){
                if(BookDetailModel.replaceClassSeat(preview)){
                    if(BookDetailModel.updateClassSeat(String.valueOf(comClassCode.getValue()))) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            System.out.println(ex);
            new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
        }
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckBookingAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void txtBookIdOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void search() throws ClassNotFoundException, SQLException {
        BookDetail b= BookDetailModel.search(txtBookId.getText());
        if(b!=null){
            fillData(b);
            preview=String.valueOf(comClassCode.getValue());
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(BookDetail b) {
        txtBookId.setText(b.getB_Id());
        comPassengerId.setValue(b.getPass_Id());
        comFlightId.setValue(b.getF_Id());
        lblData.setText(String.valueOf(b.getDate()));
        lblTime.setText(String.valueOf(b.getTime()));
        txtCountry.setText(b.getCountry());
        lblTotal.setText(String.valueOf(b.getTotal()));
        comMealId.setValue(b.getMeal_Id());
        comClassCode.setValue(b.getClass_code());
    }

    public void comFlightIdOnAction(ActionEvent actionEvent) {

       /* ObservableList<Object> list1 = FXCollections.observableArrayList();
        ObservableList<Object> list2 = FXCollections.observableArrayList();*/

        try {
            ResultSet set1 = BookDetailModel.loadMealPlanDetailIds(String.valueOf(comFlightId.getValue()));
            ResultSet set2 = BookDetailModel.loadClassCodes(String.valueOf(comFlightId.getValue()));
            while(set1.next()){
                comMealId.setValue(set1.getString(1));
            }
            while(set2.next()){
                comClassCode.setValue(set2.getString(1));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public void txtBookIdKeyRelesedOnAction(KeyEvent keyEvent) {
        lblBookIdWarning.setText("");
        txtBookId.setFocusColor(Paint.valueOf("Blue"));

        Pattern bIdPattern = Pattern.compile("^(B0)([1-9]{1,})([0-9]{0,})$");
        bIdMatcher = bIdPattern.matcher(txtBookId.getText());

        if (!bIdMatcher.matches()) {
            txtBookId.requestFocus();
            txtBookId.setFocusColor(Paint.valueOf("Red"));
            lblBookIdWarning.setText("invalid");
        }
    }

    public void txtCountryKeyReleasedOnAction(KeyEvent keyEvent) {
        lblCountryWarning.setText("");
        txtCountry.setFocusColor(Paint.valueOf("Blue"));

        Pattern countryPattern =  Pattern.compile("^[a-zA-Z]{2,}$");
        countryMatcher = countryPattern.matcher(txtCountry.getText());

        if (!countryMatcher.matches()) {
            txtCountry.requestFocus();
            txtCountry.setFocusColor(Paint.valueOf("Red"));
            lblCountryWarning.setText("invalid");
        }
    }

    public void btnViewTicketOnAction(ActionEvent actionEvent) {
        InputStream resource = this.getClass()
                .getResourceAsStream("/lk/ijse/AirlineTicketReservationSystem/report/Ticket1.jrxml");



        HashMap<String,Object> hm=new HashMap<>();
      /*  hm.put("cashier_name",txtName.getText());
        hm.put("table_no",Integer.parseInt(txtCount.getText()));*/

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,hm, DBConnection.getDbConnection().getConnection());
            // jasperPrintManager.printReport(jasperprint,true);
            JasperViewer.viewReport(jasperPrint);
        }
        catch (SQLException | ClassNotFoundException | JRException e){
            //throw new RuntimeException();
        }
    }

    public void btnPrintTicketOnAction(ActionEvent actionEvent) {
        // jasperPrintManager.printReport(jasperprint,true);
    }
}
