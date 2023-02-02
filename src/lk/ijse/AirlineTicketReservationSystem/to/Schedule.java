package lk.ijse.AirlineTicketReservationSystem.to;

public class Schedule {
    private String S_Id;
    private String UserName;
    private String S_Name;
    private String S_date;
    private String S_time;
    private String flight_departure_date;
    private String flight_departure_time;
    private String flight_arrival_date;
    private String flight_arrival_time;
    private String fromm;
    private String too;
    private String departure_airport_name;
    private String arrival_airport_name;

    public Schedule(String s_Id, String userName, String s_Name, String s_date, String s_time, String flight_departure_date, String flight_departure_time, String flight_arrival_date, String flight_arrival_time, String fromm, String too, String departure_airport_name, String arrival_airport_name) {
        S_Id = s_Id;
        UserName = userName;
        S_Name = s_Name;
        S_date = s_date;
        S_time = s_time;
        this.flight_departure_date = flight_departure_date;
        this.flight_departure_time = flight_departure_time;
        this.flight_arrival_date = flight_arrival_date;
        this.flight_arrival_time = flight_arrival_time;
        this.fromm = fromm;
        this.too = too;
        this.departure_airport_name = departure_airport_name;
        this.arrival_airport_name = arrival_airport_name;
    }

    public String getS_Id() {
        return S_Id;
    }

    public void setS_Id(String s_Id) {
        S_Id = s_Id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getS_Name() {
        return S_Name;
    }

    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    public String getS_date() {
        return S_date;
    }

    public void setS_date(String s_date) {
        S_date = s_date;
    }

    public String getS_time() {
        return S_time;
    }

    public void setS_time(String s_time) {
        S_time = s_time;
    }


    public String getFlight_departure_date() {
        return flight_departure_date;
    }

    public void setFlight_departure_date(String flight_departure_date) {
        this.flight_departure_date = flight_departure_date;
    }

    public String getFlight_departure_time() {
        return flight_departure_time;
    }

    public void setFlight_departure_time(String flight_departure_time) {
        this.flight_departure_time = flight_departure_time;
    }

    public String getFlight_arrival_date() {
        return flight_arrival_date;
    }

    public void setFlight_arrival_date(String flight_arrival_date) {
        this.flight_arrival_date = flight_arrival_date;
    }

    public String getFlight_arrival_time() {
        return flight_arrival_time;
    }

    public void setFlight_arrival_time(String flight_arrival_time) {
        this.flight_arrival_time = flight_arrival_time;
    }

    public String getFromm() {
        return fromm;
    }

    public void setFromm(String fromm) {
        this.fromm = fromm;
    }

    public String getToo() {
        return too;
    }

    public void setToo(String too) {
        this.too = too;
    }

    public String getDeparture_airport_name() {
        return departure_airport_name;
    }

    public void setDeparture_airport_name(String departure_airport_name) {
        this.departure_airport_name = departure_airport_name;
    }

    public String getArrival_airport_name() {
        return arrival_airport_name;
    }

    public void setArrival_airport_name(String arrival_airport_name) {
        this.arrival_airport_name = arrival_airport_name;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "S_Id='" + S_Id + '\'' +
                ", UserName='" + UserName + '\'' +
                ", S_Name='" + S_Name + '\'' +
                ", S_date='" + S_date + '\'' +
                ", S_time='" + S_time + '\'' +
                ", flight_departure_date='" + flight_departure_date + '\'' +
                ", flight_departure_time='" + flight_departure_time + '\'' +
                ", flight_arrival_date='" + flight_arrival_date + '\'' +
                ", flight_arrival_time='" + flight_arrival_time + '\'' +
                ", fromm='" + fromm + '\'' +
                ", too='" + too + '\'' +
                ", departure_airport_name='" + departure_airport_name + '\'' +
                ", arrival_airport_name='" + arrival_airport_name + '\'' +
                '}';
    }
}
