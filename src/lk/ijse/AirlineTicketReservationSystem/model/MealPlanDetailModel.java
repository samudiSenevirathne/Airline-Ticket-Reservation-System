package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlanDetail;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MealPlanDetailModel {
    public static boolean save(MealPlanDetail mpd) throws ParseException, SQLException, ClassNotFoundException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="INSERT INTO flight_meal_plan_detail VALUES (?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql,mpd.getFlight_meal_Plan_Detail_Id(),mpd.getM_Id(),mpd.getF_Id()
                ,mpd.getPrice(),mpd.getQty(),formatDate.parse(mpd.getDate()),formatTime.parse(mpd.getTime()));
    }


    public static ObservableList<String> loadMealIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> list= FXCollections.observableArrayList();
        String sql="SELECT M_Id FROM meal_plan";
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

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM flight_meal_plan_detail WHERE F_M_P_D_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static MealPlanDetail search(String id) throws SQLException,ClassNotFoundException {
        String sql="SELECT * FROM flight_meal_plan_detail WHERE F_M_P_D_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new MealPlanDetail(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getString(7)

            );
        }
        return null;
    }


    public static boolean update(MealPlanDetail mpd) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        String sql="UPDATE flight_meal_plan_detail SET M_Id=?,F_Id=?,price=?,qty=?,date=?,time=? WHERE F_M_P_D_Id =?";
        return CurdUtil.execute(sql,mpd.getM_Id(),mpd.getF_Id()
                ,mpd.getPrice(),mpd.getQty(),formatDate.parse(mpd.getDate()),formatTime.parse(mpd.getTime())
                ,mpd.getFlight_meal_Plan_Detail_Id());
     }

   public static ObservableList<MealPlanDetail> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<MealPlanDetail> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM flight_meal_plan_detail";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            MealPlanDetail mpd=new MealPlanDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
            list.add(mpd);
        }
        return list;
    }

    public static ResultSet loadMealPlanDetailIds(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT M_Id FROM flight_meal_plan_detail WHERE F_Id=?",id);
    }

    public static ResultSet getDetails(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT meal_plan.M_Name,flight_meal_plan_detail.price FROM flight_meal_plan_detail INNER JOIN meal_plan ON meal_plan.M_Id=flight_meal_plan_detail.M_Id WHERE flight_meal_plan_detail.M_Id =?",id);
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT F_M_P_D_Id FROM flight_meal_plan_detail ORDER BY F_M_P_D_Id DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("FMD0-", "")) + 1;
            return String.format("FMD0-%03d", newId);
        } else {
            return "FMD0-001";
        }
    }

}
