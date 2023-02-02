package lk.ijse.AirlineTicketReservationSystem.util;

import lk.ijse.AirlineTicketReservationSystem.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CurdUtil {
    public static <T> T execute(String sql, Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getDbConnection().getConnection().prepareStatement(sql);
        for(int i=0;i<args.length;i++){
            stm.setObject((i+1),args[i]);
        }
        if(sql.startsWith("SELECT")||sql.startsWith("select")){
            return (T) stm.executeQuery();
        }else{
            return (T)(Boolean)(stm.executeUpdate()>0);
        }
    }
}
