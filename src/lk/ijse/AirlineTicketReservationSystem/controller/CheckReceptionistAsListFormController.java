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
import lk.ijse.AirlineTicketReservationSystem.model.UserModel;
import lk.ijse.AirlineTicketReservationSystem.to.User;

import java.io.IOException;
import java.sql.SQLException;

public class CheckReceptionistAsListFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public ScrollPane ScrollPaneId;
    public TableView tableRecepId;
    public TableColumn colUsername;
    public TableColumn colName;
    public TableColumn colTel;
    public TableColumn colRole;
    public TableColumn colEmail;
    public TableColumn colSalary;
    public TableColumn colPassword;
    public TableColumn colAddress;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colAction;

    public void initialize() {
        colUsername.setCellValueFactory(new PropertyValueFactory("username"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colRole.setCellValueFactory(new PropertyValueFactory("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colTel.setCellValueFactory(new PropertyValueFactory("tele"));
        colSalary.setCellValueFactory(new PropertyValueFactory("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colPassword.setCellValueFactory(new PropertyValueFactory("password"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));

        try {
            ObservableList<User> list = UserModel.loadAll();
            tableRecepId.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/ReceptionistForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
