package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.User;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserModel{

    public static boolean save(User u) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql="INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql, u.getUsername(), u.getName(), u.getRole(), u.getEmail(), u.getTele(), u.getSalary(), u.getAddress(), u.getPassword(), u.getGender(), format.parse(u.getDob()));
    }

    public static boolean delete(String username) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM user WHERE UserName =?";
        return CurdUtil.execute(sql,username);
    }

   public static User search(String username) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE UserName=?";
        ResultSet result = CurdUtil.execute(sql,username);
        if(result.next()) {
            return new User(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDouble(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9),
                    result.getString(10)
            );
        }
        return null;
    }



    public static boolean update(User u) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql="UPDATE user SET Name=?,role=?,email=?,tele=?,salary=?,address=?,password=?,gender=?,dob=? WHERE UserName =?";
        return CurdUtil.execute(sql,u.getName(),u.getRole(),u.getEmail(),u.getTele(),u.getSalary(),u.getAddress(),u.getPassword(),u.getGender(),format.parse(u.getDob()),u.getUsername());
    }

    public static ObservableList<User> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<User> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM user";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            User c=new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10)
            );
            list.add(c);
        }
        return list;
    }

    public static ResultSet loadReceptionistCount() throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT COUNT(UserName) FROM user WHERE role='receptionist'");
    }

}
