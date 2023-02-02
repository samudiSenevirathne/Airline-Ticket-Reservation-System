package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.MealPlan;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class MealPlanModel {
    public static boolean save(MealPlan m) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO meal_plan VALUES (?,?,?,?)";
        return CurdUtil.execute(sql, m.getM_Id(),m.getM_Name(),m.getType(),m.getPrice());
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM meal_plan WHERE M_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static MealPlan search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM meal_plan WHERE M_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new MealPlan(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4)
            );
        }
        return null;
    }



    public static boolean update(MealPlan m) throws SQLException, ClassNotFoundException {
        String sql="UPDATE meal_plan SET M_Name=?,type=?,price=? WHERE M_Id=?";
        return CurdUtil.execute(sql,m.getM_Name(),m.getType(),m.getPrice(),m.getM_Id());
    }

    public static ObservableList<MealPlan> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<MealPlan> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM meal_plan";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            MealPlan m=new MealPlan(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
            list.add(m);
        }
        return list;
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT M_Id FROM meal_plan ORDER BY M_Id DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("M00-", "")) + 1;
            return String.format("M00-%03d", newId);
        } else {
            return "M00-001";
        }
    }
}
