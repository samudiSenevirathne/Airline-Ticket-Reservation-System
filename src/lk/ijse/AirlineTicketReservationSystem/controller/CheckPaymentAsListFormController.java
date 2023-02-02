package lk.ijse.AirlineTicketReservationSystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.PaymentModel;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;
import lk.ijse.AirlineTicketReservationSystem.to.Payment;

import java.io.IOException;
import java.sql.SQLException;

public class CheckPaymentAsListFormController {

    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tablePayment;
    public TableColumn colPCode;
    public TableColumn colFlightId;
    public TableColumn colpName;
    public TableColumn colType;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colAction;


    public void initialize() {
        colPCode.setCellValueFactory(new PropertyValueFactory("p_code"));
        colFlightId.setCellValueFactory(new PropertyValueFactory("f_Id"));
        colpName.setCellValueFactory(new PropertyValueFactory("p_name"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
        colTime.setCellValueFactory(new PropertyValueFactory("time"));

        try {
            ObservableList<Payment> list = PaymentModel.loadAll();
            tablePayment.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/PaymentForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
