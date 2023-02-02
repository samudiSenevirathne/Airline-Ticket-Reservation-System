package lk.ijse.AirlineTicketReservationSystem.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.AirlineTicketReservationSystem.to.FlightDetail;
import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FlightDetailModel {
    public static boolean save(FlightDetail fd) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO flight_detail (F_Detail_Id,guidline,DirectYanaArrivalDate,DirectYanaArrivalTime,DirectEnaArrivalDate,DirectEnaArrivalTime) VALUES (?,?,?,?,?,?)";
        return CurdUtil.execute(sql,fd.getF_Detail_Id(),fd.getGuidline(),fd.getDirectYanaArrivalDate()
                ,fd.getDirectYanaArrivalTime(),fd.getDirectEnaArrivalDate(),fd.getDirectEnaArrivalTime());
     }

    public static boolean save2(FlightDetail fd) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO flight_detail (F_Detail_Id,guidline,yanaTransfer1Name,yanaTransfer1AirportName,yanaTransfer1ArrivalDate,yanaTransfer1ArrivalTime,yanaTransfer1FlightId,yanaTransfer1AirbusCode,yanaTransfer1DepartureDate,yanaTransfer1DepartureTime,yanaTransfer1AirlineName,enaTransfer1Name,enaTransfer1AirportName,enaTransfer1FlightId,enaTransfer1AirbusCode,enaTransfer1ArrivalDate,enaTransfer1ArrivalTime,enaTransfer1DepartureDate,enaTransfer1DepartureTime,enaTransfer1AirlineName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql,fd.getF_Detail_Id(),fd.getGuidline(),fd.getYanaTransfer1Name()
                ,fd.getYanaTransfer1AirportName(),fd.getYanaTransfer1ArrivalDate(),fd.getYanaTransfer1ArrivalTime()
                ,fd.getYanaTransfer1FlightId(),fd.getYanaTransfer1AirbusCode(),fd.getYanaTransfer1DepartureDate()
                ,fd.getYanaTransfer1DepartureTime(),fd.getYanaTransfer1AirlineName(),fd.getEnaTransfer1Name()
                ,fd.getEnaTransfer1AirportName(),fd.getEnaTransfer1FlightId(),fd.getEnaTransfer1AirbusCode()
                ,fd.getEnaTransfer1ArrivalDate(),fd.getEnaTransfer1ArrivalTime(),fd.getEnaTransfer1DepartureDate()
                ,fd.getEnaTransfer1DepartureTime(),fd.getEnaTransfer1AirlineName());
    }

    public static boolean save3(FlightDetail fd) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO flight_detail (F_Detail_Id,guidline,yanaTransfer1Name,yanaTransfer1AirportName,yanaTransfer1ArrivalDate,yanaTransfer1ArrivalTime,yanaTransfer1FlightId,yanaTransfer1AirbusCode,yanaTransfer1DepartureDate,yanaTransfer1DepartureTime,yanaTransfer1AirlineName, yanaTransfer2Name,yanaTransfer2AirportName,yanaTransfer2ArrivalDate,yanaTransfer2ArrivalTime,yanaTransfer2FlightId,yanaTransfer2AirbusCode,yanaTransfer2DepartureDate,yanaTransfer2DepartureTime,yanaTransfer2AirlineName,enaTransfer1Name,enaTransfer1AirportName,enaTransfer1FlightId,enaTransfer1AirbusCode,enaTransfer1ArrivalDate,enaTransfer1ArrivalTime,enaTransfer1DepartureDate,enaTransfer1DepartureTime,enaTransfer1AirlineName,enaTransfer2Name,enaTransfer2AirportName,enaTransfer2FlightId,enaTransfer2AirbusCode,enaTransfer2ArrivalDate,enaTransfer2ArrivalTime,enaTransfer2DepartureDate,enaTransfer2DepartureTime,enaTransfer2AirlineName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql,fd.getF_Detail_Id(),fd.getGuidline(),fd.getYanaTransfer1Name()
                ,fd.getYanaTransfer1AirportName(),fd.getYanaTransfer1ArrivalDate(),fd.getYanaTransfer1ArrivalTime()
                ,fd.getYanaTransfer1FlightId(),fd.getYanaTransfer1AirbusCode(),fd.getYanaTransfer1DepartureDate()
                ,fd.getYanaTransfer1DepartureTime(),fd.getYanaTransfer1AirlineName(),fd.getYanaTransfer2Name()
                ,fd.getYanaTransfer2AirportName(),fd.getYanaTransfer2ArrivalDate(),fd.getYanaTransfer2ArrivalTime()
                ,fd.getYanaTransfer2FlightId(),fd.getYanaTransfer2AirbusCode(),fd.getYanaTransfer2DepartureDate()
                ,fd.getYanaTransfer2DepartureTime(),fd.getYanaTransfer2AirlineName(),fd.getEnaTransfer1Name()
                ,fd.getEnaTransfer1AirportName(),fd.getEnaTransfer1FlightId(),fd.getEnaTransfer1AirbusCode()
                ,fd.getEnaTransfer1ArrivalDate(),fd.getEnaTransfer1ArrivalTime(),fd.getEnaTransfer1DepartureDate()
                ,fd.getEnaTransfer1DepartureTime(),fd.getEnaTransfer1AirlineName(), fd.getEnaTransfer2Name()
                ,fd.getEnaTransfer2AirportName(),fd.getEnaTransfer2FlightId(),fd.getEnaTransfer2AirbusCode()
                ,fd.getEnaTransfer2ArrivalDate(),fd.getEnaTransfer2ArrivalTime(),fd.getEnaTransfer2DepartureDate()
                ,fd.getEnaTransfer2DepartureTime(),fd.getEnaTransfer2AirlineName());
    }

    public static boolean save4(FlightDetail fd) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO flight_detail (F_Detail_Id,guidline,yanaTransfer1Name,yanaTransfer1AirportName,yanaTransfer1ArrivalDate,yanaTransfer1ArrivalTime,yanaTransfer1FlightId,yanaTransfer1AirbusCode,yanaTransfer1DepartureDate,yanaTransfer1DepartureTime,yanaTransfer1AirlineName, yanaTransfer2Name,yanaTransfer2AirportName,yanaTransfer2ArrivalDate,yanaTransfer2ArrivalTime,yanaTransfer2FlightId,yanaTransfer2AirbusCode,yanaTransfer2DepartureDate,yanaTransfer2DepartureTime,yanaTransfer2AirlineName, yanaTransfer3Name,yanaTransfer3AirportName,yanaTransfer3ArrivalDate,yanaTransfer3ArrivalTime,yanaTransfer3FlightId,yanaTransfer3AirbusCode,yanaTransfer3DepartureDate,yanaTransfer3DepartureTime,yanaTransfer3AirlineName,enaTransfer1Name,enaTransfer1AirportName,enaTransfer1FlightId,enaTransfer1AirbusCode,enaTransfer1ArrivalDate,enaTransfer1ArrivalTime,enaTransfer1DepartureDate,enaTransfer1DepartureTime,enaTransfer1AirlineName,enaTransfer2Name,enaTransfer2AirportName,enaTransfer2FlightId,enaTransfer2AirbusCode,enaTransfer2ArrivalDate,enaTransfer2ArrivalTime,enaTransfer2DepartureDate,enaTransfer2DepartureTime,enaTransfer2AirlineName,enaTransfer3Name,enaTransfer3AirportName,enaTransfer3FlightId,enaTransfer3AirbusCode,enaTransfer3ArrivalDate,enaTransfer3ArrivalTime,enaTransfer3DepartureDate,enaTransfer3DepartureTime,enaTransfer3AirlineName) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return CurdUtil.execute(sql,fd.getF_Detail_Id(),fd.getGuidline(),fd.getYanaTransfer1Name()
                ,fd.getYanaTransfer1AirportName(),fd.getYanaTransfer1ArrivalDate(),fd.getYanaTransfer1ArrivalTime()
                ,fd.getYanaTransfer1FlightId(),fd.getYanaTransfer1AirbusCode(),fd.getYanaTransfer1DepartureDate()
                ,fd.getYanaTransfer1DepartureTime(),fd.getYanaTransfer1AirlineName(),fd.getYanaTransfer2Name()
                ,fd.getYanaTransfer2AirportName(),fd.getYanaTransfer2ArrivalDate(),fd.getYanaTransfer2ArrivalTime()
                ,fd.getYanaTransfer2FlightId(),fd.getYanaTransfer2AirbusCode(),fd.getYanaTransfer2DepartureDate()
                ,fd.getYanaTransfer2DepartureTime(),fd.getYanaTransfer2AirlineName(),fd.getYanaTransfer3Name()
                ,fd.getYanaTransfer3AirportName(),fd.getYanaTransfer3ArrivalDate(),fd.getYanaTransfer3ArrivalTime()
                ,fd.getYanaTransfer3FlightId(),fd.getYanaTransfer3AirbusCode(),fd.getYanaTransfer3DepartureDate()
                ,fd.getYanaTransfer3DepartureTime(),fd.getYanaTransfer3AirlineName(),fd.getEnaTransfer1Name()
                ,fd.getEnaTransfer1AirportName(),fd.getEnaTransfer1FlightId(),fd.getEnaTransfer1AirbusCode()
                ,fd.getEnaTransfer1ArrivalDate(),fd.getEnaTransfer1ArrivalTime(),fd.getEnaTransfer1DepartureDate()
                ,fd.getEnaTransfer1DepartureTime(),fd.getEnaTransfer1AirlineName(), fd.getEnaTransfer2Name()
                ,fd.getEnaTransfer2AirportName(),fd.getEnaTransfer2FlightId(),fd.getEnaTransfer2AirbusCode()
                ,fd.getEnaTransfer2ArrivalDate(),fd.getEnaTransfer2ArrivalTime(),fd.getEnaTransfer2DepartureDate()
                ,fd.getEnaTransfer2DepartureTime(),fd.getEnaTransfer2AirlineName(), fd.getEnaTransfer3Name()
                ,fd.getEnaTransfer3AirportName(),fd.getEnaTransfer3FlightId(),fd.getEnaTransfer3AirbusCode()
                ,fd.getEnaTransfer3ArrivalDate(),fd.getEnaTransfer3ArrivalTime(),fd.getEnaTransfer3DepartureDate()
                ,fd.getEnaTransfer3DepartureTime(),fd.getEnaTransfer3AirlineName());
    }


    public static FlightDetail search(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT guidline,DirectYanaArrivalDate,DirectYanaArrivalTime,DirectEnaArrivalDate,DirectEnaArrivalTime FROM flight_detail WHERE F_Detail_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new FlightDetail(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
        }
        return null;
    }

    public static FlightDetail search1(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT guidline,yanaTransfer1Name,yanaTransfer1AirportName,yanaTransfer1ArrivalDate,yanaTransfer1ArrivalTime,yanaTransfer1FlightId,yanaTransfer1AirbusCode,yanaTransfer1DepartureDate,yanaTransfer1DepartureTime,yanaTransfer1AirlineName,enaTransfer1Name,enaTransfer1AirportName,enaTransfer1FlightId,enaTransfer1AirbusCode,enaTransfer1ArrivalDate,enaTransfer1ArrivalTime,enaTransfer1DepartureDate,enaTransfer1DepartureTime,enaTransfer1AirlineName FROM flight_detail WHERE F_Detail_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new FlightDetail(
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
                    result.getString(13),
                    result.getString(14),
                    result.getString(15),
                    result.getString(16),
                    result.getString(17),
                    result.getString(18),
                    result.getString(19)
            );
        }
        return null;
    }

    public static FlightDetail search2(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT guidline,yanaTransfer1Name,yanaTransfer1AirportName,yanaTransfer1ArrivalDate,yanaTransfer1ArrivalTime,yanaTransfer1FlightId,yanaTransfer1AirbusCode,yanaTransfer1DepartureDate,yanaTransfer1DepartureTime,yanaTransfer1AirlineName, yanaTransfer2Name,yanaTransfer2AirportName,yanaTransfer2ArrivalDate,yanaTransfer2ArrivalTime,yanaTransfer2FlightId,yanaTransfer2AirbusCode,yanaTransfer2DepartureDate,yanaTransfer2DepartureTime,yanaTransfer2AirlineName,enaTransfer1Name,enaTransfer1AirportName,enaTransfer1FlightId,enaTransfer1AirbusCode,enaTransfer1ArrivalDate,enaTransfer1ArrivalTime,enaTransfer1DepartureDate,enaTransfer1DepartureTime,enaTransfer1AirlineName,enaTransfer2Name,enaTransfer2AirportName,enaTransfer2FlightId,enaTransfer2AirbusCode,enaTransfer2ArrivalDate,enaTransfer2ArrivalTime,enaTransfer2DepartureDate,enaTransfer2DepartureTime,enaTransfer2AirlineName FROM flight_detail WHERE F_Detail_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new FlightDetail(
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
                    result.getString(13),
                    result.getString(14),
                    result.getString(15),
                    result.getString(16),
                    result.getString(17),
                    result.getString(18),
                    result.getString(19),
                    result.getString(20),
                    result.getString(21),
                    result.getString(22),
                    result.getString(23),
                    result.getString(24),
                    result.getString(25),
                    result.getString(26),
                    result.getString(27),
                    result.getString(28),
                    result.getString(29),
                    result.getString(30),
                    result.getString(31),
                    result.getString(32),
                    result.getString(33),
                    result.getString(34),
                    result.getString(35),
                    result.getString(36),
                    result.getString(37)
            );
        }
        return null;
    }

    public static FlightDetail search3(String id) throws SQLException, ClassNotFoundException {
        String sql="SELECT guidline,yanaTransfer1Name,yanaTransfer1AirportName,yanaTransfer1ArrivalDate,yanaTransfer1ArrivalTime,yanaTransfer1FlightId,yanaTransfer1AirbusCode,yanaTransfer1DepartureDate,yanaTransfer1DepartureTime,yanaTransfer1AirlineName, yanaTransfer2Name,yanaTransfer2AirportName,yanaTransfer2ArrivalDate,yanaTransfer2ArrivalTime,yanaTransfer2FlightId,yanaTransfer2AirbusCode,yanaTransfer2DepartureDate,yanaTransfer2DepartureTime,yanaTransfer2AirlineName, yanaTransfer3Name,yanaTransfer3AirportName,yanaTransfer3ArrivalDate,yanaTransfer3ArrivalTime,yanaTransfer3FlightId,yanaTransfer3AirbusCode,yanaTransfer3DepartureDate,yanaTransfer3DepartureTime,yanaTransfer3AirlineName,enaTransfer1Name,enaTransfer1AirportName,enaTransfer1FlightId,enaTransfer1AirbusCode,enaTransfer1ArrivalDate,enaTransfer1ArrivalTime,enaTransfer1DepartureDate,enaTransfer1DepartureTime,enaTransfer1AirlineName,enaTransfer2Name,enaTransfer2AirportName,enaTransfer2FlightId,enaTransfer2AirbusCode,enaTransfer2ArrivalDate,enaTransfer2ArrivalTime,enaTransfer2DepartureDate,enaTransfer2DepartureTime,enaTransfer2AirlineName,enaTransfer3Name,enaTransfer3AirportName,enaTransfer3FlightId,enaTransfer3AirbusCode,enaTransfer3ArrivalDate,enaTransfer3ArrivalTime,enaTransfer3DepartureDate,enaTransfer3DepartureTime,enaTransfer3AirlineName  FROM flight_detail WHERE F_Detail_Id=?";
        ResultSet result = CurdUtil.execute(sql,id);
        if(result.next()) {
            return new FlightDetail(
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
                    result.getString(13),
                    result.getString(14),
                    result.getString(15),
                    result.getString(16),
                    result.getString(17),
                    result.getString(18),
                    result.getString(19),
                    result.getString(20),
                    result.getString(21),
                    result.getString(22),
                    result.getString(23),
                    result.getString(24),
                    result.getString(25),
                    result.getString(26),
                    result.getString(27),
                    result.getString(28),
                    result.getString(29),
                    result.getString(30),
                    result.getString(31),
                    result.getString(32),
                    result.getString(33),
                    result.getString(34),
                    result.getString(35),
                    result.getString(36),
                    result.getString(37),
                    result.getString(38),
                    result.getString(39),
                    result.getString(40),
                    result.getString(41),
                    result.getString(42),
                    result.getString(43),
                    result.getString(44),
                    result.getString(45),
                    result.getString(46),
                    result.getString(47),
                    result.getString(48),
                    result.getString(49),
                    result.getString(50),
                    result.getString(51),
                    result.getString(52),
                    result.getString(53),
                    result.getString(54),
                    result.getString(55)
            );
        }
        return null;
    }

    public static boolean update(FlightDetail fd) throws SQLException, ClassNotFoundException{
        String sql="UPDATE flight_detail SET guidline=?,DirectYanaArrivalDate=?,DirectYanaArrivalTime=?,DirectEnaArrivalDate=?,DirectEnaArrivalTime=? WHERE F_Detail_Id=?";
        return CurdUtil.execute(sql,fd.getGuidline(),fd.getDirectYanaArrivalDate(),fd.getDirectYanaArrivalTime()
                ,fd.getDirectEnaArrivalDate(),fd.getDirectEnaArrivalTime(),fd.getF_Detail_Id());
    }

    public static boolean update1(FlightDetail fd) throws SQLException, ClassNotFoundException {
        String sql="UPDATE flight_detail SET guidline=?,yanaTransfer1Name=?,yanaTransfer1AirportName=?,yanaTransfer1ArrivalDate=?,yanaTransfer1ArrivalTime=?,yanaTransfer1FlightId=?,yanaTransfer1AirbusCode=?,yanaTransfer1DepartureDate=?,yanaTransfer1DepartureTime=?,yanaTransfer1AirlineName=?,enaTransfer1Name=?,enaTransfer1AirportName=?,enaTransfer1FlightId=?,enaTransfer1AirbusCode=?,enaTransfer1ArrivalDate=?,enaTransfer1ArrivalTime=?,enaTransfer1DepartureDate=?,enaTransfer1DepartureTime=?,enaTransfer1AirlineName=? WHERE F_Detail_Id=?";
        return CurdUtil.execute(sql,fd.getGuidline(), fd.getYanaTransfer1Name(),fd.getYanaTransfer1AirportName()
                ,fd.getYanaTransfer1ArrivalDate(),fd.getYanaTransfer1ArrivalTime(),fd.getYanaTransfer1FlightId()
                ,fd.getYanaTransfer1AirbusCode(),fd.getYanaTransfer1DepartureDate(),fd.getYanaTransfer1DepartureTime()
                ,fd.getYanaTransfer1AirlineName(),fd.getEnaTransfer1Name(),fd.getEnaTransfer1AirportName()
                ,fd.getEnaTransfer1FlightId(),fd.getEnaTransfer1AirbusCode(),fd.getEnaTransfer1ArrivalDate()
                ,fd.getEnaTransfer1ArrivalTime(),fd.getEnaTransfer1DepartureDate(),fd.getEnaTransfer1DepartureTime()
                ,fd.getEnaTransfer1AirlineName(),fd.getF_Detail_Id());
    }

    public static boolean update2(FlightDetail fd) throws SQLException, ClassNotFoundException {
        String sql="UPDATE flight_detail SET guidline=?,yanaTransfer1Name=?,yanaTransfer1AirportName=?,yanaTransfer1ArrivalDate=?,yanaTransfer1ArrivalTime=?,yanaTransfer1FlightId=?,yanaTransfer1AirbusCode=?,yanaTransfer1DepartureDate=?,yanaTransfer1DepartureTime=?,yanaTransfer1AirlineName=?, yanaTransfer2Name=?,yanaTransfer2AirportName=?,yanaTransfer2ArrivalDate=?,yanaTransfer2ArrivalTime=?,yanaTransfer2FlightId=?,yanaTransfer2AirbusCode=?,yanaTransfer2DepartureDate=?,yanaTransfer2DepartureTime=?,yanaTransfer2AirlineName=?,enaTransfer1Name=?,enaTransfer1AirportName=?,enaTransfer1FlightId=?,enaTransfer1AirbusCode=?,enaTransfer1ArrivalDate=?,enaTransfer1ArrivalTime=?,enaTransfer1DepartureDate=?,enaTransfer1DepartureTime=?,enaTransfer1AirlineName=?,enaTransfer2Name=?,enaTransfer2AirportName=?,enaTransfer2FlightId=?,enaTransfer2AirbusCode=?,enaTransfer2ArrivalDate=?,enaTransfer2ArrivalTime=?,enaTransfer2DepartureDate=?,enaTransfer2DepartureTime=?,enaTransfer2AirlineName=?  WHERE F_Detail_Id=?";
        return CurdUtil.execute(sql,fd.getGuidline(),fd.getYanaTransfer1Name(),fd.getYanaTransfer1AirportName()
                ,fd.getYanaTransfer1ArrivalDate(),fd.getYanaTransfer1ArrivalTime(),fd.getYanaTransfer1FlightId()
                ,fd.getYanaTransfer1AirbusCode(),fd.getYanaTransfer1DepartureDate(),fd.getYanaTransfer1DepartureTime()
                ,fd.getYanaTransfer1AirlineName(),fd.getYanaTransfer2Name(),fd.getYanaTransfer2AirportName()
                ,fd.getYanaTransfer2ArrivalDate(),fd.getYanaTransfer2ArrivalTime(),fd.getYanaTransfer2FlightId()
                ,fd.getYanaTransfer2AirbusCode(),fd.getYanaTransfer2DepartureDate(),fd.getYanaTransfer2DepartureTime()
                ,fd.getYanaTransfer2AirlineName(),fd.getEnaTransfer1Name(),fd.getEnaTransfer1AirportName()
                ,fd.getEnaTransfer1FlightId(),fd.getEnaTransfer1AirbusCode(),fd.getEnaTransfer1ArrivalDate()
                ,fd.getEnaTransfer1ArrivalTime(),fd.getEnaTransfer1DepartureDate(),fd.getEnaTransfer1DepartureTime()
                ,fd.getEnaTransfer1AirlineName(),fd.getEnaTransfer2Name(),fd.getEnaTransfer2AirportName()
                ,fd.getEnaTransfer2FlightId(),fd.getEnaTransfer2AirbusCode(),fd.getEnaTransfer2ArrivalDate()
                ,fd.getEnaTransfer2ArrivalTime(),fd.getEnaTransfer2DepartureDate(),fd.getEnaTransfer2DepartureTime()
                ,fd.getEnaTransfer2AirlineName(),fd.getF_Detail_Id());
    }

    public static boolean update3(FlightDetail fd) throws SQLException, ClassNotFoundException {
        String sql="UPDATE flight_detail SET guidline=?,yanaTransfer1Name=?,yanaTransfer1AirportName=?,yanaTransfer1ArrivalDate=?,yanaTransfer1ArrivalTime=?,yanaTransfer1FlightId=?,yanaTransfer1AirbusCode=?,yanaTransfer1DepartureDate=?,yanaTransfer1DepartureTime=?,yanaTransfer1AirlineName=?, yanaTransfer2Name=?,yanaTransfer2AirportName=?,yanaTransfer2ArrivalDate=?,yanaTransfer2ArrivalTime=?,yanaTransfer2FlightId=?,yanaTransfer2AirbusCode=?,yanaTransfer2DepartureDate=?,yanaTransfer2DepartureTime=?,yanaTransfer2AirlineName=?, yanaTransfer3Name=?,yanaTransfer3AirportName=?,yanaTransfer3ArrivalDate=?,yanaTransfer3ArrivalTime=?,yanaTransfer3FlightId=?,yanaTransfer3AirbusCode=?,yanaTransfer3DepartureDate=?,yanaTransfer3DepartureTime=?,yanaTransfer3AirlineName=?,enaTransfer1Name=?,enaTransfer1AirportName=?,enaTransfer1FlightId=?,enaTransfer1AirbusCode=?,enaTransfer1ArrivalDate=?,enaTransfer1ArrivalTime=?,enaTransfer1DepartureDate=?,enaTransfer1DepartureTime=?,enaTransfer1AirlineName=?,enaTransfer2Name=?,enaTransfer2AirportName=?,enaTransfer2FlightId=?,enaTransfer2AirbusCode=?,enaTransfer2ArrivalDate=?,enaTransfer2ArrivalTime=?,enaTransfer2DepartureDate=?,enaTransfer2DepartureTime=?,enaTransfer2AirlineName=?,enaTransfer3Name=?,enaTransfer3AirportName=?,enaTransfer3FlightId=?,enaTransfer3AirbusCode=?,enaTransfer3ArrivalDate=?,enaTransfer3ArrivalTime=?,enaTransfer3DepartureDate=?,enaTransfer3DepartureTime=?,enaTransfer3AirlineName=? WHERE F_Detail_Id=?";
        return CurdUtil.execute(sql,fd.getGuidline(),fd.getYanaTransfer1Name(),fd.getYanaTransfer1AirportName()
                ,fd.getYanaTransfer1ArrivalDate(),fd.getYanaTransfer1ArrivalTime(),fd.getYanaTransfer1FlightId()
                ,fd.getYanaTransfer1AirbusCode(),fd.getYanaTransfer1DepartureDate(),fd.getYanaTransfer1DepartureTime()
                ,fd.getYanaTransfer1AirlineName(),fd.getYanaTransfer2Name(),fd.getYanaTransfer2AirportName()
                ,fd.getYanaTransfer2ArrivalDate(),fd.getYanaTransfer2ArrivalTime(),fd.getYanaTransfer2FlightId()
                ,fd.getYanaTransfer2AirbusCode(),fd.getYanaTransfer2DepartureDate(),fd.getYanaTransfer2DepartureTime()
                ,fd.getYanaTransfer2AirlineName(), fd.getYanaTransfer3Name(),fd.getYanaTransfer3AirportName()
                ,fd.getYanaTransfer3ArrivalDate(),fd.getYanaTransfer3ArrivalTime(),fd.getYanaTransfer3FlightId()
                ,fd.getYanaTransfer3AirbusCode(),fd.getYanaTransfer3DepartureDate(),fd.getYanaTransfer3DepartureTime()
                ,fd.getYanaTransfer3AirlineName(),fd.getEnaTransfer1Name(),fd.getEnaTransfer1AirportName()
                ,fd.getEnaTransfer1FlightId(),fd.getEnaTransfer1AirbusCode(),fd.getEnaTransfer1ArrivalDate()
                ,fd.getEnaTransfer1ArrivalTime(),fd.getEnaTransfer1DepartureDate(),fd.getEnaTransfer1DepartureTime()
                ,fd.getEnaTransfer1AirlineName(),fd.getEnaTransfer2Name(),fd.getEnaTransfer2AirportName()
                ,fd.getEnaTransfer2FlightId(),fd.getEnaTransfer2AirbusCode(),fd.getEnaTransfer2ArrivalDate()
                ,fd.getEnaTransfer2ArrivalTime(),fd.getEnaTransfer2DepartureDate(),fd.getEnaTransfer2DepartureTime()
                ,fd.getEnaTransfer2AirlineName(),fd.getEnaTransfer3Name(),fd.getEnaTransfer3AirportName()
                ,fd.getEnaTransfer3FlightId(),fd.getEnaTransfer3AirbusCode(),fd.getEnaTransfer3ArrivalDate()
                ,fd.getEnaTransfer3ArrivalTime(),fd.getEnaTransfer3DepartureDate(),fd.getEnaTransfer3DepartureTime()
                ,fd.getEnaTransfer3AirlineName(),fd.getF_Detail_Id());
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM flight_detail WHERE F_Detail_Id=?";
        return CurdUtil.execute(sql,id);
    }

    public static ObservableList<FlightDetail> loadAll() throws SQLException, ClassNotFoundException {
        ObservableList<FlightDetail> list= FXCollections.observableArrayList();
        String sql="SELECT * FROM flight_detail";
        ResultSet result = CurdUtil.execute(sql);
        while(result.next()){
            FlightDetail fd=new FlightDetail(
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
                    result.getString(13),
                    result.getString(14),
                    result.getString(15),
                    result.getString(16),
                    result.getString(17),
                    result.getString(18),
                    result.getString(19),
                    result.getString(20),
                    result.getString(21),
                    result.getString(22),
                    result.getString(23),
                    result.getString(24),
                    result.getString(25),
                    result.getString(26),
                    result.getString(27),
                    result.getString(28),
                    result.getString(29),
                    result.getString(30),
                    result.getString(31),
                    result.getString(32),
                    result.getString(33),
                    result.getString(34),
                    result.getString(35),
                    result.getString(36),
                    result.getString(37),
                    result.getString(38),
                    result.getString(39),
                    result.getString(40),
                    result.getString(41),
                    result.getString(42),
                    result.getString(43),
                    result.getString(44),
                    result.getString(45),
                    result.getString(46),
                    result.getString(47),
                    result.getString(48),
                    result.getString(49),
                    result.getString(50),
                    result.getString(51),
                    result.getString(52),
                    result.getString(53),
                    result.getString(54),
                    result.getString(55),
                    result.getString(56),
                    result.getString(57),
                    result.getString(58),
                    result.getString(59),
                    result.getString(60)
            );
            list.add(fd);
        }
        return list;
    }

    public static ResultSet flightIds() throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT F_Id FROM flight");
    }

    public static String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet set = CurdUtil.execute("SELECT F_Detail_Id FROM  flight_detail ORDER BY F_Detail_Id DESC LIMIT 1;");
        if (set.next()) {
        String id = set.getString(1);
        int newId = Integer.parseInt(id.replace("FD0-", "")) + 1;
        return String.format("FD0-%03d", newId);
    } else {
        return "FD0-001";
    }
}


}
