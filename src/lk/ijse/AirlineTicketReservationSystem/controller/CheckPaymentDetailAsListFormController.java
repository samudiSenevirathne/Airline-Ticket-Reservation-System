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
import lk.ijse.AirlineTicketReservationSystem.model.PaymentDetailModel;
import lk.ijse.AirlineTicketReservationSystem.to.PaymentDetail;

import java.io.IOException;
import java.sql.SQLException;

public class CheckPaymentDetailAsListFormController {
    public JFXButton btnMiniId;
    public AnchorPane context;
    public ScrollPane scrollPaneId;
    public TableView tablePaymentDetail;
    public TableColumn colPCode;
    public TableColumn colPTicketId;
    public TableColumn colTReliseDate;
    public TableColumn colTReliseTime;
    public TableColumn colTValidDate;
    public TableColumn colExpireDate;
    public TableColumn colAction;


    public void initialize() {
        colPTicketId.setCellValueFactory(new PropertyValueFactory("p_Ticket_Id"));
        colPCode.setCellValueFactory(new PropertyValueFactory("p_code"));
        colTReliseDate.setCellValueFactory(new PropertyValueFactory("t_Relise_Date"));
        colTReliseTime.setCellValueFactory(new PropertyValueFactory("t_Relise_Time"));
        colTValidDate.setCellValueFactory(new PropertyValueFactory("t_Valid_Date"));
        colExpireDate.setCellValueFactory(new PropertyValueFactory("expire_Date"));

        try {
            ObservableList<PaymentDetail> list = PaymentDetailModel.loadAll();
            tablePaymentDetail.setItems(list);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/AirlineTicketReservationSystem/view/PaymentDetailForm");
    }
    private void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        context.getChildren().clear();
        context.getChildren().add(node);
    }

}
