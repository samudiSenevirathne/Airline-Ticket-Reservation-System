package lk.ijse.AirlineTicketReservationSystem.model;

import lk.ijse.AirlineTicketReservationSystem.util.CurdUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomModel {

    public static ResultSet flightDetails(String id) throws SQLException, ClassNotFoundException {
        return CurdUtil.execute("SELECT f.journey,f.transferCount,s.flight_departure_date,s.flight_departure_time,s.flight_arrival_date,s.flight_arrival_time FROM schedule s INNER JOIN flight f ON s.S_Id=f.S_Id WHERE F_Id=?",id);
    }


    public static ResultSet loadCheckWithReturnTicket1(String text, String to, String depardate, String transferOrDirect, String cType,int count) throws SQLException, ClassNotFoundException{
        String sql="SELECT f.F_Id,f.airbusCode,s.flight_departure_time,s.departure_airport_name,s.arrival_airport_name,f.transferCount,f.airline_name,c.price FROM schedule s INNER JOIN flight f ON s.S_Id=f.S_Id INNER JOIN flight_class_type_detail fc ON f.F_Id=fc.F_Id INNER JOIN class_type c ON fc.class_code=c.class_code WHERE s.fromm=? && s.too=? && s.flight_departure_date=? && f.journey=? && c.name=? && c.s_qty>?";
        return CurdUtil.execute(sql,text,to,depardate,transferOrDirect,cType,count);
    }

    public static ResultSet loadCheckWithReturnTicket2(String text, String to, String returndate, String transferOrDirect, String cType,int count) throws SQLException, ClassNotFoundException{
        String sql="SELECT f.F_Id,f.airbusCode,s.flight_arrival_time,s.departure_airport_name,s.arrival_airport_name,f.transferCount,f.airline_name,c.price FROM schedule s INNER JOIN flight f ON s.S_Id=f.S_Id INNER JOIN flight_class_type_detail fc ON f.F_Id=fc.F_Id INNER JOIN class_type c ON fc.class_code=c.class_code WHERE s.fromm=? && s.too=? && s.flight_arrival_date=? && f.journey=? && c.name=? && c.s_qty>?";
        return CurdUtil.execute(sql,text,to,returndate,transferOrDirect,cType,count);
    }

    public static ResultSet loadCheckWithOneWayTicket(String text, String to, String depardate, String transferOrDirect, String cType, int count) throws SQLException, ClassNotFoundException{
        String sql = "SELECT f.F_Id,f.airbusCode,s.flight_departure_time,s.departure_airport_name,s.arrival_airport_name,f.transferCount,f.airline_name,c.price FROM schedule s INNER JOIN flight f ON s.S_Id=f.S_Id INNER JOIN flight_class_type_detail fc ON f.F_Id=fc.F_Id INNER JOIN class_type c ON fc.class_code=c.class_code WHERE s.fromm=? && s.too=? && s.flight_departure_date=? && f.journey=? && c.name=? && c.s_qty>?";
        return  CurdUtil.execute(sql,text,to,depardate,transferOrDirect,cType,count);
    }



}
