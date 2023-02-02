package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.BookDetail;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookDetailModel {
    public static boolean save(BookDetail b) throws ParseException, SQLException, ClassNotFoundException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="INSERT INTO book_detail VALUES (?,?,?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql,b.getB_Id(),b.getPass_Id(),b.getF_Id(),formatDate.parse(b.getDate())
                ,formatTime.parse(b.getTime()),b.getCountry(),b.getTotal(),b.getMeal_Id(),b.getClass_code());
    }


        public static ObservableList<String> loadPassengerIds() throws SQLException, ClassNotFoundException {
            ObservableList<String> list= FXCollections.observableArrayList();
            String sql="SELECT pass_Id FROM passenger ";
            ResultSet resultSet = CurdUtil.execute(sql);
            while(resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            return list;
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

    public static ResultSet loadMealPlanDetailIds(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT M_Id FROM flight_meal_plan_detail WHERE F_Id=?",id);
    }

    public static ResultSet loadClassCodes(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT class_code FROM flight_class_type_detail WHERE F_Id=?",id);
    }

    public static ResultSet loadMealPlanPrice(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT price FROM flight_meal_plan_detail WHERE M_Id=?",id);
    }

    public static ResultSet loadClassPrice(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT price FROM flight_class_type_detail WHERE class_code=?",id);
    }

    public static boolean updateClassSeat(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("UPDATE class_type SET s_qty=s_qty-1 WHERE class_code=?",id);
    }

    public static boolean replaceClassSeat(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("UPDATE class_type SET s_qty=s_qty+1 WHERE class_code=?",id);
    }


    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM book_detail WHERE B_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static BookDetail search(String id) throws SQLException,ClassNotFoundException {
        String sql="SELECT * FROM book_detail WHERE B_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new BookDetail(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getDouble(7),
                    result.getString(8),
                    result.getString(9)
            );
        }
        return null;
    }


    public static boolean update(BookDetail b) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="UPDATE book_detail SET pass_Id=?,F_Id=?,date=?,time=?,country=?,total=?,meal_Id=?,class_code=? WHERE B_Id=?";
        return CurdUtil.execute(sql,b.getPass_Id(),b.getF_Id(),formatDate.parse(b.getDate())
                ,formatTime.parse(b.getTime()),b.getCountry(),b.getTotal(),b.getMeal_Id(),b.getClass_code(),b.getB_Id());
    }

    public static ObservableList<BookDetail> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<BookDetail> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM book_detail";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            BookDetail bd=new BookDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            );
            list.add(bd);
        }
        return list;
    }

    public static ResultSet loadBookingCount() throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT COUNT(B_Id) FROM book_detail");
    }

}
