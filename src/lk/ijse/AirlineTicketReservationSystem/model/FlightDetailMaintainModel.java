package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetailMaintain;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightDetailMaintainModel {
    public static boolean save(FlightDetailMaintain fdm) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO flight_flight_detail_maintain VALUES (?,?,?,?,?)";
        return CurdUtil.execute(sql,fdm.getFli_Fli_Det_Main_Id(),fdm.getF_Detail_Id(),fdm.getF_Id()
        ,fdm.getCommen_guidline_count(),fdm.getAll_guidline_count());
    }


    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM flight_flight_detail_maintain WHERE F_F_D_M_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static FlightDetailMaintain search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM flight_flight_detail_maintain WHERE F_F_D_M_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new FlightDetailMaintain(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5)
            );
        }
        return null;
    }

    public static String searchFlightId(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT F_Id FROM flight_flight_detail_maintain WHERE F_Detail_Id=?";
        ResultSet result = CurdUtil.execute(sql, id);
        String fId=null;
        if(result.next()) {
            return fId=result.getString(1);
        }
        return fId;
    }

    public static boolean update(FlightDetailMaintain fdm) throws SQLException, ClassNotFoundException {
        String sql="UPDATE flight_flight_detail_maintain SET F_Detail_Id=?,F_Id=?,commen_guidline_count=?,all_guidline_count=? WHERE F_F_D_M_Id=?";
        return CurdUtil.execute(sql,fdm.getF_Detail_Id(),fdm.getF_Id(),fdm.getCommen_guidline_count()
        ,fdm.getAll_guidline_count(),fdm.getFli_Fli_Det_Main_Id());
    }

    public static ObservableList<FlightDetailMaintain> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<FlightDetailMaintain> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM flight_flight_detail_maintain";
        ResultSet resultSet = CurdUtil.execute(sql);
        while(resultSet.next()){
            FlightDetailMaintain fdm=new FlightDetailMaintain(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5)
            );
            list.add(fdm);
        }
        return list;
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT F_F_D_M_Id FROM  flight_flight_detail_maintain ORDER BY F_F_D_M_Id DESC LIMIT 1;");
        if (set.next()) {
            String id = set.getString(1);
            int newId = Integer.parseInt(id.replace("FDM0-", "")) + 1;
            return String.format("FDM0-%03d", newId);
        } else {
            return "FDM0-001";
        }
    }
}
