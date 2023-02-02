package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.Passenger;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PassengerModel {
    public static boolean save(Passenger p) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql="INSERT INTO passenger VALUES (?,?,?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql,p.getPass_Id(),p.getF_Name(),p.getL_Name(),p.getAddress(),p.getTele()
                ,p.getEmail(),p.getGender(),format.parse(p.getDob()),p.getPassenger_type());
    }

    public static boolean delete(String id) throws SQLException,ClassNotFoundException {
        String sql="DELETE FROM passenger WHERE pass_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static Passenger search(String id) throws SQLException,ClassNotFoundException{
        String sql="SELECT * FROM passenger WHERE pass_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new Passenger(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9)
            );
        }
        return null;
    }

   public static boolean update(Passenger p) throws SQLException, ClassNotFoundException, ParseException {
       DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql="UPDATE passenger SET F_Name=?,L_Name=?,address=?,tele=?,email=?,gender=?,dob=?,passenger_type=? WHERE pass_Id=?";
        return CurdUtil.execute(sql,p.getF_Name(),p.getL_Name(),p.getAddress(),p.getTele()
                ,p.getEmail(),p.getGender(),format.parse(p.getDob()),p.getPassenger_type(),p.getPass_Id());
    }

    public static ObservableList<Passenger> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<Passenger> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM passenger";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            Passenger p=new Passenger(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            );
            list.add(p);
        }
        return list;
    }

    public static ResultSet loadPassengerCount() throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT COUNT(pass_Id) FROM passenger");
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT pass_Id FROM passenger ORDER BY pass_Id DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("P00-", "")) + 1;
            return String.format("P00-%03d", newId);
        } else {
            return "P00-001";
        }
    }

}
