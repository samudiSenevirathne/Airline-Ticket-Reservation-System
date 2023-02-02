package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.Schedule;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class ScheduleModel {
    public static boolean save(Schedule s) throws SQLException, ClassNotFoundException, ParseException {
        String sql="INSERT INTO schedule VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql, s.getS_Id(),s.getUserName(),s.getS_Name(),s.getS_date()
                ,s.getS_time(),s.getFlight_departure_date(),s.getFlight_departure_time()
                ,s.getFlight_arrival_date(),s.getFlight_arrival_time(),s.getFromm(),s.getToo()
               ,s.getDeparture_airport_name(),s.getArrival_airport_name());
    }


    public static  ObservableList<String> loadUserNames() throws SQLException, ClassNotFoundException {
        ObservableList<String> list= FXCollections.observableArrayList();
        String sql="SELECT UserName FROM user WHERE role='admin'";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()) {
            list.add(resultSet.getString(1));
        }
        return list;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM schedule WHERE S_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static Schedule search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM schedule WHERE S_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new Schedule(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9),
                    result.getString(10),
                    result.getString(11),
                    result.getString(12),
                    result.getString(13)
            );
        }
        return null;
    }


    public static boolean update(Schedule s) throws SQLException, ClassNotFoundException, ParseException {
        String sql="UPDATE schedule SET UserName=?,S_Name=?,S_date=?,S_time=?,flight_departure_date=?,flight_departure_time=?,flight_arrival_date=?,flight_arrival_time=?,fromm=?,too=?,departure_airport_name=?,arrival_airport_name=? WHERE S_Id =?";
        return CurdUtil.execute(sql,s.getUserName(),s.getS_Name(),s.getS_date(),s.getS_time()
                ,s.getFlight_departure_date(),s.getFlight_departure_time(), s.getFlight_arrival_date()
                ,s.getFlight_arrival_time(), s.getFromm(),s.getToo(),s.getDeparture_airport_name()
                ,s.getArrival_airport_name(),s.getS_Id());
    }

    public static ObservableList<Schedule> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<Schedule> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM schedule";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            Schedule s=new Schedule(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12),
                    resultSet.getString(13)
            );
            list.add(s);
        }
        return list;
    }

    public static ResultSet loadSheduleCount() throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT COUNT(S_Id) FROM schedule");
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT S_Id FROM schedule ORDER BY S_Id DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("S00-", "")) + 1;
            return String.format("S00-%03d", newId);
        } else {
            return "S00-001";
        }
    }

}
