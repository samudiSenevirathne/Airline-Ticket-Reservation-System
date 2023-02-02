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
import lk.ijse.AirlineTicketReservationSystem.model.BookDetailModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.BookDetail;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;

import java.io.IOException;
import java.sql.SQLException;

public class CheckBookingAsListFormController {
    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tableBooking;
    public TableColumn colBookingId;
    public TableColumn colDate;
    public TableColumn colFlightId;
    public TableColumn colTime;
    public TableColumn colCountry;
    public TableColumn colClassCode;
    public TableColumn colTotal;
    public TableColumn colAction;
    public TableColumn colpassId;
    public TableColumn colMealId;

    public void initialize() {
        colBookingId.setCellValueFactory(new PropertyValueFactory("b_Id"));
        colpassId.setCellValueFactory(new PropertyValueFactory("pass_Id"));
        colFlightId.setCellValueFactory(new PropertyValueFactory("f_Id"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
        colTime.setCellValueFactory(new PropertyValueFactory("time"));
        colCountry.setCellValueFactory(new PropertyValueFactory("country"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colMealId.setCellValueFactory(new PropertyValueFactory("meal_Id"));
        colClassCode.setCellValueFactory(new PropertyValueFactory("class_code"));



        try {
            ObservableList<BookDetail> list = BookDetailModel.loadAll();
            tableBooking.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/BookingForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
