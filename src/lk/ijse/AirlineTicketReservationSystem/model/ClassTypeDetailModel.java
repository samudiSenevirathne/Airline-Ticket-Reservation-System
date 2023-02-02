package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.ClassTypeDetail;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetailMaintain;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassTypeDetailModel {

    public static boolean save(ClassTypeDetail ctd) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO flight_class_type_detail VALUES (?,?,?,?,?)";
        return CurdUtil.execute(sql,ctd.getFli_cla_type_Id(),ctd.getClass_code(),ctd.getF_Id(),ctd.getDemand()
                ,ctd.getPrice());
    }


    public static ObservableList<String> loadClassCodes() throws SQLException, ClassNotFoundException {
        ObservableList<String> list= FXCollections.observableArrayList();
        String sql="SELECT class_code FROM class_type";
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
        String sql="DELETE FROM flight_class_type_detail WHERE F_C_T_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static ClassTypeDetail search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM flight_class_type_detail WHERE F_C_T_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new ClassTypeDetail(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5)
            );
        }
        return null;
    }


    public static boolean update(ClassTypeDetail ctd) throws SQLException, ClassNotFoundException {
        String sql="UPDATE flight_class_type_detail SET class_code=?,F_Id=?,demand=?,price=? WHERE F_C_T_Id=?";
        return CurdUtil.execute(sql,ctd.getClass_code(),ctd.getF_Id(),ctd.getDemand(),ctd.getPrice()
        ,ctd.getFli_cla_type_Id());
    }

    public static ObservableList<ClassTypeDetail> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<ClassTypeDetail> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM flight_class_type_detail";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            ClassTypeDetail ctd=new ClassTypeDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)
            );
            list.add(ctd);
        }
        return list;
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT F_C_T_Id FROM flight_class_type_detail ORDER BY F_C_T_Id DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("FCD0-", "")) + 1;
            return String.format("FCD0-%03d", newId);
        } else {
            return "FCD0-001";
        }
    }

}
