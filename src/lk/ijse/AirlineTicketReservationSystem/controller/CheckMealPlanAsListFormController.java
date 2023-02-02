package lk.ijse.AirlineTicketReservationSystem.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanModel;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlan;

import java.io.IOException;
import java.sql.SQLException;

public class CheckMealPlanAsListFormController {
    public JFXButton btnMiniId;
    public TableView tabaleMealPlanId;
    public TableColumn colMealId;
    public TableColumn colMName;
    public TableColumn colType;
    public TableColumn colPrice;
    public TableColumn colAction;
    public AnchorPane anchorMealListId;
    public ScrollPane ScorllPaneId;


    public void initialize() {
        colMealId.setCellValueFactory(new PropertyValueFactory("m_Id"));
        colMName.setCellValueFactory(new PropertyValueFactory("m_Name"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));


        try {
            ObservableList<MealPlan> list = MealPlanModel.loadAll();
            tabaleMealPlanId.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/MealPlanForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        anchorMealListId.getChildren().clear();
        anchorMealListId.getChildren().add(node);
    }
}
