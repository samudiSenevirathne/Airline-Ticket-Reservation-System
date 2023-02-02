package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanDetailModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AvailableMealPlanFormController {
    public JFXButton btnMiniId;
    public JFXComboBox comFlightId;
    public JFXComboBox comMealId;
    public Label lblMealName;
    public Label lblMealPrice;

    public void initialize() {
        loadFlightId();
    }

    public void comFlightIdOnAction(ActionEvent actionEvent) {
        clear();
            ObservableList<Object> list = FXCollections.observableArrayList();
            try {
                ResultSet set = MealPlanDetailModel.loadMealPlanDetailIds((String) comFlightId.getValue());
                    while (set.next()) {
                        list.add(set.getString(1));
                        comMealId.setItems(list);
                    }
                    //new Alert(Alert.AlertType.WARNING, "This flight has not set Meal plan").show();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    private void loadFlightId(){
        try {
            ObservableList<String> ids = MealPlanDetailModel.loadFlightIds();
            comFlightId.setItems(ids);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void comMealIdOnAction(ActionEvent actionEvent) {
            try {
                ResultSet set = MealPlanDetailModel.getDetails((String) comMealId.getValue());
                if (set.next()) {
                    lblMealName.setText(set.getString(1));
                    lblMealPrice.setText(set.getString(2));
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
    }

    private void clear(){
        lblMealPrice.setText(null);
        lblMealName.setText(null);
        comMealId.setItems(null);
    }

}
