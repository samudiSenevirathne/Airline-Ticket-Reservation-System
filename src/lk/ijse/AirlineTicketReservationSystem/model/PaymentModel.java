package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;
import lk.ijse.AirlineTicketReservationSystem.to.Payment;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PaymentModel {
    public static boolean save(Payment p) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="INSERT INTO payment VALUES (?,?,?,?,?,?)";
        return CurdUtil.execute(sql,p.getP_code(),p.getF_Id(),p.getP_name(),p.getType(),formatDate.parse(p.getDate())
                ,formatTime.parse(p.getTime()));
    }


    public static ObservableList<String> loadFlightIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> list= FXCollections.observableArrayList();
        String sql="SELECT F_Id FROM flight";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM payment WHERE p_code=?";
        return CurdUtil.execute(sql,id);
    }

    public static Payment search(String id) throws SQLException,ClassNotFoundException {
        String sql="SELECT * FROM payment WHERE p_code=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new Payment(
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


    public static boolean update(Payment p) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="UPDATE payment SET F_Id=?,p_name=?,type=?,date=?,time=? WHERE p_code=?";
        return CurdUtil.execute(sql,p.getF_Id(),p.getP_name(),p.getType(),formatDate.parse(p.getDate())
                ,formatTime.parse(p.getTime()),p.getP_code());
    }

    public static ObservableList<Payment> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<Payment> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM payment";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            Payment p =new Payment(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            list.add(p);
        }
        return list;
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT p_code FROM payment ORDER BY p_code DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("PC0-", "")) + 1;
            return String.format("PC0-%03d", newId);
        } else {
            return "PC0-001";
        }
    }
}
