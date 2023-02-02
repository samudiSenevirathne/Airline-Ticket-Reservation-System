package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.AirlineTicketReservationSystem.model.PaymentDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.PaymentDetail;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentDetailFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public JFXTextField txtPTicketId;
    public JFXComboBox<String>comPaymentCode;
    public Label lblPayTicIdWarning;
    public Label lblTicReliseDate;
    public Label lblTicReliseTime;
    public Label lblTicValidDate;
    public Label lblExpireDate;

    public Matcher pTicIdMatcher;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnEdit;
    public JFXButton btnCheck;
    public JFXButton btnList;
    public JFXButton btnNext;

    public void initialize() {
        loadPCodes();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        setDate();
        setTime();
        PaymentDetail pd = new PaymentDetail(txtPTicketId.getText(),String.valueOf(comPaymentCode.getValue()),lblTicReliseDate.getText()
            ,lblTicReliseTime.getText(),lblTicValidDate.getText(),lblExpireDate.getText());
        try {
            if(PaymentDetailModel.save(pd)){
                new Alert(Alert.AlertType.CONFIRMATION, "Added!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Added Failed!!").show();
            }
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setDate() {
        LocalDate date = LocalDate.now();
        LocalDate expireDate=date.plusMonths(6);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String string1 = date.format(pattern);
        lblTicReliseDate.setText(string1);
        lblTicValidDate.setText(string1);
        String string2 = expireDate.format(pattern);
        lblExpireDate.setText(string2);
    }
    private void setTime() {
        LocalTime time=LocalTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("hh:mm:ss");
        String string = time.format(pattern);
        lblTicReliseTime.setText(string);
    }

    private void loadPCodes(){
        try {
            ObservableList<String> ids = PaymentDetailModel.loadPCode();
            comPaymentCode.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            if(PaymentDetailModel.delete(txtPTicketId.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!...").show();
            }
        }catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, "Deleted Failed!...").show();
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        setDate();
        setTime();
        PaymentDetail pd = new PaymentDetail(txtPTicketId.getText(),String.valueOf(comPaymentCode.getValue()),lblTicReliseDate.getText()
                ,lblTicReliseTime.getText(),lblTicValidDate.getText(),lblExpireDate.getText());
        try {
            if(PaymentDetailModel.update(pd)){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!...").show();
            }
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            System.out.println(ex);
            new Alert(Alert.AlertType.WARNING, "Update Failed!....").show();
        }
    }

    public void btnCheckOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnListOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/CheckPaymentDetailAsListForm");
    }

    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }


    public void txtPTicketIdOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void search() throws ClassNotFoundException, SQLException {
        PaymentDetail pd= PaymentDetailModel.search(txtPTicketId.getText());
        if(pd!=null){
            fillData(pd);
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }
    }

    private void fillData(PaymentDetail pd) {
        txtPTicketId.setText(pd.getP_Ticket_Id());
        comPaymentCode.setValue(pd.getP_code());
        lblTicReliseDate.setText(String.valueOf(pd.getT_Relise_Date()));
        lblTicReliseTime.setText(String.valueOf(pd.getT_Relise_Time()));
        lblTicValidDate.setText(String.valueOf(pd.getT_Valid_Date()));
        lblExpireDate.setText(String.valueOf(pd.getExpire_Date()));
    }

    public void txtPTicketIdKeyRelesedOnAction(KeyEvent keyEvent) {
        lblPayTicIdWarning.setText("");
        txtPTicketId.setFocusColor(Paint.valueOf("Blue"));

        Pattern ptIdPattern = Pattern.compile("^(PD0)([1-9]{1,})([0-9]{0,})$");
        pTicIdMatcher = ptIdPattern.matcher(txtPTicketId.getText());

        if (!pTicIdMatcher.matches()) {
            txtPTicketId.requestFocus();
            txtPTicketId.setFocusColor(Paint.valueOf("Red"));
            lblPayTicIdWarning.setText("invalid");
        }
    }

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/BookingForm");
    }
}
