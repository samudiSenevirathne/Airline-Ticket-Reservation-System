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
import lk.ijse.AirlineTicketReservationSystem.model.PassengerModel;
import lk.ijse.AirlineTicketReservationSystem.model.UserModel;
import lk.ijse.AirlineTicketReservationSystem.to.Passenger;
import lk.ijse.AirlineTicketReservationSystem.to.User;

import java.io.IOException;
import java.sql.SQLException;

public class CheckPassengerAsListFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tablePassenger;
    public TableColumn colPassId;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colTele;
    public TableColumn colEmail;
    public TableColumn colPassCount;
    public TableColumn colPassport;
    public TableColumn colAddress;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colAction;
    public TableColumn colpassengerType;

    public void initialize() {
        colPassId.setCellValueFactory(new PropertyValueFactory("pass_Id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory("f_Name"));
        colLastName.setCellValueFactory(new PropertyValueFactory("l_Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colTele.setCellValueFactory(new PropertyValueFactory("tele"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));
        colpassengerType.setCellValueFactory(new PropertyValueFactory("passenger_type"));

        try {
            ObservableList<Passenger> list = PassengerModel.loadAll();
            tablePassenger.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/PassengerForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
