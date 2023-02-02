package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.ClassType;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassTypeModel {
    public static boolean save(ClassType ct) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO class_type VALUES (?,?,?,?)";
        return CurdUtil.execute(sql,ct.getClass_code(),ct.getName(),ct.getS_qty(),ct.getPrice());
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM class_type WHERE class_code=?";
        return CurdUtil.execute(sql,id);
    }

    public static ClassType search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM class_type WHERE class_code=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new ClassType(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getDouble(4)
            );
        }
        return null;
    }



    public static boolean update(ClassType ct) throws SQLException, ClassNotFoundException {
        String sql="UPDATE class_type SET name=?,s_qty=?,price=? WHERE class_code=?";
        return CurdUtil.execute(sql,ct.getName(),ct.getS_qty(),ct.getPrice(),ct.getClass_code());
    }

    public static ObservableList<ClassType> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<ClassType> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM class_type";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            ClassType ct=new ClassType(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            );
            list.add(ct);
        }
        return list;
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT class_code FROM class_type ORDER BY class_code DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newId);
        } else {
            return "C00-001";
        }
    }
}
