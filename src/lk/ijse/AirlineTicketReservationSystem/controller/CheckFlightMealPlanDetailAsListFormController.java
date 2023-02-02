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
import lk.ijse.AirlineTicketReservationSystem.model.ClassTypeModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.ClassType;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;

import java.io.IOException;
import java.sql.SQLException;

public class CheckFlightMealPlanDetailAsListFormController {

    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tableMealPlanDetail;
    public TableColumn colMealPlanDetailId;
    public TableColumn colMealId;
    public TableColumn colFlightId;
    public TableColumn colPrice;
    public TableColumn colQty;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colAction;

    public void initialize() {
        colMealPlanDetailId.setCellValueFactory(new PropertyValueFactory("flight_meal_Plan_Detail_Id"));
        colMealId.setCellValueFactory(new PropertyValueFactory("m_Id"));
        colFlightId.setCellValueFactory(new PropertyValueFactory("f_Id"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
        colTime.setCellValueFactory(new PropertyValueFactory("time"));

        try {
            ObservableList<MealPlanDetail> list = MealPlanDetailModel.loadAll();
            tableMealPlanDetail.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightMealPlanDetailForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
