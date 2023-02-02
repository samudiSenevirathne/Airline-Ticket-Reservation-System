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
import lk.ijse.AirlineTicketReservationSystem.model.ClassTypeDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.ClassTypeDetail;

import java.io.IOException;
import java.sql.SQLException;

public class CheckClassTypeDetailAsListFormController {

    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tableClassTypeDetail;
    public TableColumn colClassTypeDetailId;
    public TableColumn colClassCode;
    public TableColumn colFlightId;
    public TableColumn colDemand;
    public TableColumn colPrice;
    public TableColumn colAction;

    public void initialize() {
        colClassTypeDetailId.setCellValueFactory(new PropertyValueFactory("fli_cla_type_Id"));
        colClassCode.setCellValueFactory(new PropertyValueFactory("class_code"));
        colFlightId.setCellValueFactory(new PropertyValueFactory("f_Id"));
        colDemand.setCellValueFactory(new PropertyValueFactory("demand"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));

        try {
            ObservableList<ClassTypeDetail> list = ClassTypeDetailModel.loadAll();
            tableClassTypeDetail.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/FlightClassTypeDetailForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }
}
