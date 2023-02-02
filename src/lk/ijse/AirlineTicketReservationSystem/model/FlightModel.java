package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.Flight;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightModel {
    public static boolean save(Flight f) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO flight VALUES (?,?,?,?,?,?)";
        return CurdUtil.execute(sql,f.getF_Id(),f.getS_Id(),f.getAirline_name(),f.getJourney(),f.getTransferCount(),f.getAirbusCode());
    }


   public static  ObservableList<String> loadSceduleIds() throws SQLException, ClassNotFoundException {
       ObservableList<String> list= FXCollections.observableArrayList();
       String sql="SELECT S_Id FROM schedule";
       ResultSet resultSet = CurdUtil.execute(sql);
       while(resultSet.next()) {
           list.add(resultSet.getString(1));
       }
       return list;
   }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM flight WHERE F_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static Flight search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM flight WHERE F_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new Flight(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getString(6)

            );
        }
        return null;
    }



   public static boolean update(Flight f) throws SQLException, ClassNotFoundException {
        String sql="UPDATE flight SET S_Id=?,airline_name=?,journey=?,transferCount=?,airbusCode=? WHERE F_Id=?";
        return CurdUtil.execute(sql,f.getS_Id(),f.getAirline_name(),f.getJourney(),f.getTransferCount(),f.getAirbusCode(),f.getF_Id());
    }

    public static ObservableList<Flight> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<Flight> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM flight";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            Flight f=new Flight(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6)
            );
            list.add(f);
        }
        return list;
    }

    public static ResultSet loadFlightIdsDueJorney(String name) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT F_Id FROM flight WHERE journey=?",name);
    }

    public static ResultSet getAirlineName(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT airline_name FROM flight WHERE F_Id=?",id);
    }

    public static ResultSet loadFlightCount() throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT COUNT(F_Id) FROM flight");
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT F_Id FROM flight ORDER BY F_Id DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("F00-", "")) + 1;
            return String.format("F00-%03d", newId);
        } else {
            return "F00-001";
        }
    }
}
