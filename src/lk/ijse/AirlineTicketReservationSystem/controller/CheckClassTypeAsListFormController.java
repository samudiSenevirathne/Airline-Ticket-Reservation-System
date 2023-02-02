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
import lk.ijse.AirlineTicketReservationSystem.model.ClassTypeModel;
import lk.ijse.AirlineTicketReservationSystem.model.MealPlanModel;
import lk.ijse.AirlineTicketReservationSystem.to.ClassType;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlan;

import java.io.IOException;
import java.sql.SQLException;

public class CheckClassTypeAsListFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tableClassType;
    public TableColumn colClassCode;
    public TableColumn colName;
    public TableColumn colSeatCount;
    public TableColumn colPrice;
    public TableColumn colAction;

    public void initialize() {
        colClassCode.setCellValueFactory(new PropertyValueFactory("class_code"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colSeatCount.setCellValueFactory(new PropertyValueFactory("s_qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));

        try {
            ObservableList<ClassType> list = ClassTypeModel.loadAll();
            tableClassType.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/ClassTypeForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
