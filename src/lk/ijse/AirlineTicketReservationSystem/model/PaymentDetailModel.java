package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;
import lk.ijse.AirlineTicketReservationSystem.to.PaymentDetail;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PaymentDetailModel {
    public static boolean save(PaymentDetail pd) throws ParseException, SQLException, ClassNotFoundException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="INSERT INTO payment_detail VALUES (?,?,?,?,?,?)";
        return CurdUtil.execute(sql,pd.getP_Ticket_Id(),pd.getP_code(),formatDate.parse(pd.getT_Relise_Date())
                ,formatTime.parse(pd.getT_Relise_Time()),formatDate.parse(pd.getT_Valid_Date())
                ,formatDate.parse(pd.getExpire_Date()));
    }


    public static ObservableList<String> loadPCode() throws SQLException, ClassNotFoundException {
        ObservableList<String> list= FXCollections.observableArrayList();
        String sql="SELECT p_code FROM payment";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM payment_detail WHERE P_Ticket_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static PaymentDetail search(String id) throws SQLException,ClassNotFoundException {
        String sql="SELECT * FROM payment_detail WHERE P_Ticket_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new PaymentDetail(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }


    public static boolean update(PaymentDetail pd) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="UPDATE payment_detail SET p_code=?,T_Relise_Date=?,T_Relise_Time=?,T_Valid_Date=?,expire_Date=? WHERE P_Ticket_Id=?";
        return CurdUtil.execute(sql,pd.getP_code(),formatDate.parse(pd.getT_Relise_Date())
                ,formatTime.parse(pd.getT_Relise_Time()),formatDate.parse(pd.getT_Valid_Date())
                ,formatDate.parse(pd.getExpire_Date()),pd.getP_Ticket_Id());
    }

    public static ObservableList<PaymentDetail> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<PaymentDetail> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM payment_detail";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            PaymentDetail pd =new PaymentDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            list.add(pd);
        }
        return list;
    }
}
