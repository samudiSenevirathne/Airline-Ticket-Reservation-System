package lk.ijse.AirlineTicketReservationSystem.to;

public class Custom {
    private String username;
    private String name;
    private String role;
    private String email;
    private String tele;
    private Double salary;
    private String address;
    private String password;
    private String gender;
    private String dob;
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
    private String p_Ticket_Id;
    private String p_code;
    private String t_Relise_Date;
    private String t_Relise_Time;
    private String t_Valid_Date;
    private String expire_Date;
//    private String p_code;
    private String f_Id;
    private String p_name;
    private String type;
    private String date;
    private String time;
    private String pass_Id;
    private String f_Name;
    private String l_Name;
//    private String address;
//    private String tele;
//    private String email;
//    private String gender;
//    private String dob;
    private String passenger_type;
    private String flight_meal_Plan_Detail_Id;
    private String m_Id;
//    private String f_Id;
    private double price;
    private int qty;
//    private String date;
//    private String time;
//    private String m_Id;
    private String m_Name;
//    private String type;
//    private Double price;
    private String fli_Fli_Det_Main_Id;
    private String f_Detail_Id;
//    private String f_Id;
    private int commen_guidline_count;
    private int all_guidline_count;
//    private String f_Detail_Id;
    private String guidline;
    private String DirectYanaArrivalDate;
    private String DirectYanaArrivalTime;
    private String yanaTransfer1Name;
    private String  yanaTransfer1AirportName;
    private String  yanaTransfer1ArrivalDate;
    private String  yanaTransfer1ArrivalTime;
    private String  yanaTransfer1FlightId;
    private String  yanaTransfer1AirbusCode;
    private String  yanaTransfer1DepartureDate;
    private String yanaTransfer1DepartureTime;
    private String  yanaTransfer2Name;
    private String yanaTransfer2AirportName;
    private String  yanaTransfer2ArrivalDate;
    private String yanaTransfer2ArrivalTime;
    private String  yanaTransfer2FlightId;
    private String  yanaTransfer2AirbusCode;
    private String  yanaTransfer2DepartureDate;
    private String  yanaTransfer2DepartureTime;
    private String yanaTransfer3Name;
    private String yanaTransfer3AirportName;
    private String  yanaTransfer3ArrivalDate;
    private String  yanaTransfer3ArrivalTime;
    private String  yanaTransfer3FlightId;
    private String  yanaTransfer3AirbusCode;
    private String  yanaTransfer3DepartureDate;
    private String  yanaTransfer3DepartureTime;
    private String DirectEnaArrivalDate;
    private String DirectEnaArrivalTime;
    private String enaTransfer1Name;
    private String enaTransfer1AirportName;
    private String enaTransfer1FlightId;
    private String enaTransfer1AirbusCode;
    private String enaTransfer1ArrivalDate;
    private String enaTransfer1ArrivalTime;
    private String enaTransfer1DepartureDate;
    private String enaTransfer1DepartureTime;
    private String enaTransfer2Name;
    private String enaTransfer2AirportName;
    private String enaTransfer2FlightId;
    private String enaTransfer2AirbusCode;
    private String enaTransfer2ArrivalDate;
    private String enaTransfer2ArrivalTime;
    private String enaTransfer2DepartureDate;
    private String enaTransfer2DepartureTime;
    private String enaTransfer3Name;
    private String enaTransfer3AirportName;
    private String enaTransfer3FlightId;
    private String enaTransfer3AirbusCode;
    private String enaTransfer3ArrivalDate;
    private String enaTransfer3ArrivalTime;
    private String enaTransfer3DepartureDate;
    private String enaTransfer3DepartureTime;
    private String yanaTransfer1AirlineName;
    private String yanaTransfer2AirlineName;
    private String yanaTransfer3AirlineName;
    private String enaTransfer1AirlineName;
    private String enaTransfer2AirlineName;
    private String enaTransfer3AirlineName;
//    private String f_Id;
    private String s_Id;
    private String airline_name;
    private String journey;
    private int transferCount;
    private String airbusCode;
    private String fli_cla_type_Id;
    private String class_code;
//    private String f_Id;
    private String demand;
//    private double price;
//    private String class_code;
//    private String name;
    private int s_qty;
//    private double price;
    private String b_Id;
//    private String pass_Id;
//    private String f_Id;
//    private String date;
//    private String time;
//    private String country;
    private double total;
    private String meal_Id;
//  private String class_code;


    public Custom(String f_Id,String airbusCode, String flight_departure_time, String departure_airport_name,String arrival_airport_name, int transferCount, String airline_name,double price) {
        this.f_Id=f_Id;
        this.airbusCode=airbusCode;
        this.flight_departure_time = flight_departure_time;
        this.departure_airport_name=departure_airport_name;
        this.arrival_airport_name=arrival_airport_name;
        this.transferCount = transferCount;
        this.airline_name = airline_name;
        this.price=price;
    }

    public Custom(String f_Id,String fromm, String too, String type,String flight_departure_date, String flight_departure_time, String journey, int transferCount, String airline_name, String name, int s_qty) {
        this.f_Id=f_Id;
        this.fromm = fromm;
        this.too = too;
        this.type = type;
        this.flight_departure_date = flight_departure_date;
        this.flight_departure_time = flight_departure_time;
        this.journey = journey;
        this.transferCount = transferCount;
        this.airline_name = airline_name;
        this.name=name;
        this.s_qty = s_qty;
    }

    public Custom(String f_Id, String f_Detail_Id) {
        this.f_Id = f_Id;
        this.f_Detail_Id = f_Detail_Id;
    }

    public Custom(String f_Id, String journey, int transferCount,String flight_departure_date, String flight_departure_time, String flight_arrival_date, String flight_arrival_time) {
        this.f_Id = f_Id;
        this.journey = journey;
        this.transferCount = transferCount;
        this.flight_departure_date = flight_departure_date;
        this.flight_departure_time = flight_departure_time;
        this.flight_arrival_date = flight_arrival_date;
        this.flight_arrival_time = flight_arrival_time;
    }
    public Custom(String journey, int transferCount,String flight_departure_date, String flight_departure_time, String flight_arrival_date, String flight_arrival_time) {
        this.journey = journey;
        this.transferCount = transferCount;
        this.flight_departure_date = flight_departure_date;
        this.flight_departure_time = flight_departure_time;
        this.flight_arrival_date = flight_arrival_date;
        this.flight_arrival_time = flight_arrival_time;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getS_Id() {
        return S_Id;
    }

    public void setS_Id(String s_Id) {
        S_Id = s_Id;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    public int getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(int transferCount) {
        this.transferCount = transferCount;
    }

    public String getAirbusCode() {
        return airbusCode;
    }

    public void setAirbusCode(String airbusCode) {
        this.airbusCode = airbusCode;
    }

    public String getFli_cla_type_Id() {
        return fli_cla_type_Id;
    }

    public void setFli_cla_type_Id(String fli_cla_type_Id) {
        this.fli_cla_type_Id = fli_cla_type_Id;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public int getS_qty() {
        return s_qty;
    }

    public void setS_qty(int s_qty) {
        this.s_qty = s_qty;
    }

    public String getB_Id() {
        return b_Id;
    }

    public void setB_Id(String b_Id) {
        this.b_Id = b_Id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMeal_Id() {
        return meal_Id;
    }

    public void setMeal_Id(String meal_Id) {
        this.meal_Id = meal_Id;
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

    public String getP_Ticket_Id() {
        return p_Ticket_Id;
    }

    public void setP_Ticket_Id(String p_Ticket_Id) {
        this.p_Ticket_Id = p_Ticket_Id;
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }

    public String getT_Relise_Date() {
        return t_Relise_Date;
    }

    public void setT_Relise_Date(String t_Relise_Date) {
        this.t_Relise_Date = t_Relise_Date;
    }

    public String getT_Relise_Time() {
        return t_Relise_Time;
    }

    public void setT_Relise_Time(String t_Relise_Time) {
        this.t_Relise_Time = t_Relise_Time;
    }

    public String getT_Valid_Date() {
        return t_Valid_Date;
    }

    public void setT_Valid_Date(String t_Valid_Date) {
        this.t_Valid_Date = t_Valid_Date;
    }

    public String getExpire_Date() {
        return expire_Date;
    }

    public void setExpire_Date(String expire_Date) {
        this.expire_Date = expire_Date;
    }

    public String getF_Id() {
        return f_Id;
    }

    public void setF_Id(String f_Id) {
        this.f_Id = f_Id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPass_Id() {
        return pass_Id;
    }

    public void setPass_Id(String pass_Id) {
        this.pass_Id = pass_Id;
    }

    public String getF_Name() {
        return f_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public String getL_Name() {
        return l_Name;
    }

    public void setL_Name(String l_Name) {
        this.l_Name = l_Name;
    }

    public String getPassenger_type() {
        return passenger_type;
    }

    public void setPassenger_type(String passenger_type) {
        this.passenger_type = passenger_type;
    }

    public String getFlight_meal_Plan_Detail_Id() {
        return flight_meal_Plan_Detail_Id;
    }

    public void setFlight_meal_Plan_Detail_Id(String flight_meal_Plan_Detail_Id) {
        this.flight_meal_Plan_Detail_Id = flight_meal_Plan_Detail_Id;
    }

    public String getM_Id() {
        return m_Id;
    }

    public void setM_Id(String m_Id) {
        this.m_Id = m_Id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getFli_Fli_Det_Main_Id() {
        return fli_Fli_Det_Main_Id;
    }

    public void setFli_Fli_Det_Main_Id(String fli_Fli_Det_Main_Id) {
        this.fli_Fli_Det_Main_Id = fli_Fli_Det_Main_Id;
    }

    public String getF_Detail_Id() {
        return f_Detail_Id;
    }

    public void setF_Detail_Id(String f_Detail_Id) {
        this.f_Detail_Id = f_Detail_Id;
    }

    public int getCommen_guidline_count() {
        return commen_guidline_count;
    }

    public void setCommen_guidline_count(int commen_guidline_count) {
        this.commen_guidline_count = commen_guidline_count;
    }

    public int getAll_guidline_count() {
        return all_guidline_count;
    }

    public void setAll_guidline_count(int all_guidline_count) {
        this.all_guidline_count = all_guidline_count;
    }

    public String getGuidline() {
        return guidline;
    }

    public void setGuidline(String guidline) {
        this.guidline = guidline;
    }

    public String getDirectYanaArrivalDate() {
        return DirectYanaArrivalDate;
    }

    public void setDirectYanaArrivalDate(String directYanaArrivalDate) {
        DirectYanaArrivalDate = directYanaArrivalDate;
    }

    public String getDirectYanaArrivalTime() {
        return DirectYanaArrivalTime;
    }

    public void setDirectYanaArrivalTime(String directYanaArrivalTime) {
        DirectYanaArrivalTime = directYanaArrivalTime;
    }

    public String getYanaTransfer1Name() {
        return yanaTransfer1Name;
    }

    public void setYanaTransfer1Name(String yanaTransfer1Name) {
        this.yanaTransfer1Name = yanaTransfer1Name;
    }

    public String getYanaTransfer1AirportName() {
        return yanaTransfer1AirportName;
    }

    public void setYanaTransfer1AirportName(String yanaTransfer1AirportName) {
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
    }

    public String getYanaTransfer1ArrivalDate() {
        return yanaTransfer1ArrivalDate;
    }

    public void setYanaTransfer1ArrivalDate(String yanaTransfer1ArrivalDate) {
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
    }

    public String getYanaTransfer1ArrivalTime() {
        return yanaTransfer1ArrivalTime;
    }

    public void setYanaTransfer1ArrivalTime(String yanaTransfer1ArrivalTime) {
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
    }

    public String getYanaTransfer1FlightId() {
        return yanaTransfer1FlightId;
    }

    public void setYanaTransfer1FlightId(String yanaTransfer1FlightId) {
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
    }

    public String getYanaTransfer1AirbusCode() {
        return yanaTransfer1AirbusCode;
    }

    public void setYanaTransfer1AirbusCode(String yanaTransfer1AirbusCode) {
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
    }

    public String getYanaTransfer1DepartureDate() {
        return yanaTransfer1DepartureDate;
    }

    public void setYanaTransfer1DepartureDate(String yanaTransfer1DepartureDate) {
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
    }

    public String getYanaTransfer1DepartureTime() {
        return yanaTransfer1DepartureTime;
    }

    public void setYanaTransfer1DepartureTime(String yanaTransfer1DepartureTime) {
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
    }

    public String getYanaTransfer2Name() {
        return yanaTransfer2Name;
    }

    public void setYanaTransfer2Name(String yanaTransfer2Name) {
        this.yanaTransfer2Name = yanaTransfer2Name;
    }

    public String getYanaTransfer2AirportName() {
        return yanaTransfer2AirportName;
    }

    public void setYanaTransfer2AirportName(String yanaTransfer2AirportName) {
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
    }

    public String getYanaTransfer2ArrivalDate() {
        return yanaTransfer2ArrivalDate;
    }

    public void setYanaTransfer2ArrivalDate(String yanaTransfer2ArrivalDate) {
        this.yanaTransfer2ArrivalDate = yanaTransfer2ArrivalDate;
    }

    public String getYanaTransfer2ArrivalTime() {
        return yanaTransfer2ArrivalTime;
    }

    public void setYanaTransfer2ArrivalTime(String yanaTransfer2ArrivalTime) {
        this.yanaTransfer2ArrivalTime = yanaTransfer2ArrivalTime;
    }

    public String getYanaTransfer2FlightId() {
        return yanaTransfer2FlightId;
    }

    public void setYanaTransfer2FlightId(String yanaTransfer2FlightId) {
        this.yanaTransfer2FlightId = yanaTransfer2FlightId;
    }

    public String getYanaTransfer2AirbusCode() {
        return yanaTransfer2AirbusCode;
    }

    public void setYanaTransfer2AirbusCode(String yanaTransfer2AirbusCode) {
        this.yanaTransfer2AirbusCode = yanaTransfer2AirbusCode;
    }

    public String getYanaTransfer2DepartureDate() {
        return yanaTransfer2DepartureDate;
    }

    public void setYanaTransfer2DepartureDate(String yanaTransfer2DepartureDate) {
        this.yanaTransfer2DepartureDate = yanaTransfer2DepartureDate;
    }

    public String getYanaTransfer2DepartureTime() {
        return yanaTransfer2DepartureTime;
    }

    public void setYanaTransfer2DepartureTime(String yanaTransfer2DepartureTime) {
        this.yanaTransfer2DepartureTime = yanaTransfer2DepartureTime;
    }

    public String getYanaTransfer3Name() {
        return yanaTransfer3Name;
    }

    public void setYanaTransfer3Name(String yanaTransfer3Name) {
        this.yanaTransfer3Name = yanaTransfer3Name;
    }

    public String getYanaTransfer3AirportName() {
        return yanaTransfer3AirportName;
    }

    public void setYanaTransfer3AirportName(String yanaTransfer3AirportName) {
        this.yanaTransfer3AirportName = yanaTransfer3AirportName;
    }

    public String getYanaTransfer3ArrivalDate() {
        return yanaTransfer3ArrivalDate;
    }

    public void setYanaTransfer3ArrivalDate(String yanaTransfer3ArrivalDate) {
        this.yanaTransfer3ArrivalDate = yanaTransfer3ArrivalDate;
    }

    public String getYanaTransfer3ArrivalTime() {
        return yanaTransfer3ArrivalTime;
    }

    public void setYanaTransfer3ArrivalTime(String yanaTransfer3ArrivalTime) {
        this.yanaTransfer3ArrivalTime = yanaTransfer3ArrivalTime;
    }

    public String getYanaTransfer3FlightId() {
        return yanaTransfer3FlightId;
    }

    public void setYanaTransfer3FlightId(String yanaTransfer3FlightId) {
        this.yanaTransfer3FlightId = yanaTransfer3FlightId;
    }

    public String getYanaTransfer3AirbusCode() {
        return yanaTransfer3AirbusCode;
    }

    public void setYanaTransfer3AirbusCode(String yanaTransfer3AirbusCode) {
        this.yanaTransfer3AirbusCode = yanaTransfer3AirbusCode;
    }

    public String getYanaTransfer3DepartureDate() {
        return yanaTransfer3DepartureDate;
    }

    public void setYanaTransfer3DepartureDate(String yanaTransfer3DepartureDate) {
        this.yanaTransfer3DepartureDate = yanaTransfer3DepartureDate;
    }

    public String getYanaTransfer3DepartureTime() {
        return yanaTransfer3DepartureTime;
    }

    public void setYanaTransfer3DepartureTime(String yanaTransfer3DepartureTime) {
        this.yanaTransfer3DepartureTime = yanaTransfer3DepartureTime;
    }

    public String getDirectEnaArrivalDate() {
        return DirectEnaArrivalDate;
    }

    public void setDirectEnaArrivalDate(String directEnaArrivalDate) {
        DirectEnaArrivalDate = directEnaArrivalDate;
    }

    public String getDirectEnaArrivalTime() {
        return DirectEnaArrivalTime;
    }

    public void setDirectEnaArrivalTime(String directEnaArrivalTime) {
        DirectEnaArrivalTime = directEnaArrivalTime;
    }

    public String getEnaTransfer1Name() {
        return enaTransfer1Name;
    }

    public void setEnaTransfer1Name(String enaTransfer1Name) {
        this.enaTransfer1Name = enaTransfer1Name;
    }

    public String getEnaTransfer1AirportName() {
        return enaTransfer1AirportName;
    }

    public void setEnaTransfer1AirportName(String enaTransfer1AirportName) {
        this.enaTransfer1AirportName = enaTransfer1AirportName;
    }

    public String getEnaTransfer1FlightId() {
        return enaTransfer1FlightId;
    }

    public void setEnaTransfer1FlightId(String enaTransfer1FlightId) {
        this.enaTransfer1FlightId = enaTransfer1FlightId;
    }

    public String getEnaTransfer1AirbusCode() {
        return enaTransfer1AirbusCode;
    }

    public void setEnaTransfer1AirbusCode(String enaTransfer1AirbusCode) {
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
    }

    public String getEnaTransfer1ArrivalDate() {
        return enaTransfer1ArrivalDate;
    }

    public void setEnaTransfer1ArrivalDate(String enaTransfer1ArrivalDate) {
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
    }

    public String getEnaTransfer1ArrivalTime() {
        return enaTransfer1ArrivalTime;
    }

    public void setEnaTransfer1ArrivalTime(String enaTransfer1ArrivalTime) {
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
    }

    public String getEnaTransfer1DepartureDate() {
        return enaTransfer1DepartureDate;
    }

    public void setEnaTransfer1DepartureDate(String enaTransfer1DepartureDate) {
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
    }

    public String getEnaTransfer1DepartureTime() {
        return enaTransfer1DepartureTime;
    }

    public void setEnaTransfer1DepartureTime(String enaTransfer1DepartureTime) {
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
    }

    public String getEnaTransfer2Name() {
        return enaTransfer2Name;
    }

    public void setEnaTransfer2Name(String enaTransfer2Name) {
        this.enaTransfer2Name = enaTransfer2Name;
    }

    public String getEnaTransfer2AirportName() {
        return enaTransfer2AirportName;
    }

    public void setEnaTransfer2AirportName(String enaTransfer2AirportName) {
        this.enaTransfer2AirportName = enaTransfer2AirportName;
    }

    public String getEnaTransfer2FlightId() {
        return enaTransfer2FlightId;
    }

    public void setEnaTransfer2FlightId(String enaTransfer2FlightId) {
        this.enaTransfer2FlightId = enaTransfer2FlightId;
    }

    public String getEnaTransfer2AirbusCode() {
        return enaTransfer2AirbusCode;
    }

    public void setEnaTransfer2AirbusCode(String enaTransfer2AirbusCode) {
        this.enaTransfer2AirbusCode = enaTransfer2AirbusCode;
    }

    public String getEnaTransfer2ArrivalDate() {
        return enaTransfer2ArrivalDate;
    }

    public void setEnaTransfer2ArrivalDate(String enaTransfer2ArrivalDate) {
        this.enaTransfer2ArrivalDate = enaTransfer2ArrivalDate;
    }

    public String getEnaTransfer2ArrivalTime() {
        return enaTransfer2ArrivalTime;
    }

    public void setEnaTransfer2ArrivalTime(String enaTransfer2ArrivalTime) {
        this.enaTransfer2ArrivalTime = enaTransfer2ArrivalTime;
    }

    public String getEnaTransfer2DepartureDate() {
        return enaTransfer2DepartureDate;
    }

    public void setEnaTransfer2DepartureDate(String enaTransfer2DepartureDate) {
        this.enaTransfer2DepartureDate = enaTransfer2DepartureDate;
    }

    public String getEnaTransfer2DepartureTime() {
        return enaTransfer2DepartureTime;
    }

    public void setEnaTransfer2DepartureTime(String enaTransfer2DepartureTime) {
        this.enaTransfer2DepartureTime = enaTransfer2DepartureTime;
    }

    public String getEnaTransfer3Name() {
        return enaTransfer3Name;
    }

    public void setEnaTransfer3Name(String enaTransfer3Name) {
        this.enaTransfer3Name = enaTransfer3Name;
    }

    public String getEnaTransfer3AirportName() {
        return enaTransfer3AirportName;
    }

    public void setEnaTransfer3AirportName(String enaTransfer3AirportName) {
        this.enaTransfer3AirportName = enaTransfer3AirportName;
    }

    public String getEnaTransfer3FlightId() {
        return enaTransfer3FlightId;
    }

    public void setEnaTransfer3FlightId(String enaTransfer3FlightId) {
        this.enaTransfer3FlightId = enaTransfer3FlightId;
    }

    public String getEnaTransfer3AirbusCode() {
        return enaTransfer3AirbusCode;
    }

    public void setEnaTransfer3AirbusCode(String enaTransfer3AirbusCode) {
        this.enaTransfer3AirbusCode = enaTransfer3AirbusCode;
    }

    public String getEnaTransfer3ArrivalDate() {
        return enaTransfer3ArrivalDate;
    }

    public void setEnaTransfer3ArrivalDate(String enaTransfer3ArrivalDate) {
        this.enaTransfer3ArrivalDate = enaTransfer3ArrivalDate;
    }

    public String getEnaTransfer3ArrivalTime() {
        return enaTransfer3ArrivalTime;
    }

    public void setEnaTransfer3ArrivalTime(String enaTransfer3ArrivalTime) {
        this.enaTransfer3ArrivalTime = enaTransfer3ArrivalTime;
    }

    public String getEnaTransfer3DepartureDate() {
        return enaTransfer3DepartureDate;
    }

    public void setEnaTransfer3DepartureDate(String enaTransfer3DepartureDate) {
        this.enaTransfer3DepartureDate = enaTransfer3DepartureDate;
    }

    public String getEnaTransfer3DepartureTime() {
        return enaTransfer3DepartureTime;
    }

    public void setEnaTransfer3DepartureTime(String enaTransfer3DepartureTime) {
        this.enaTransfer3DepartureTime = enaTransfer3DepartureTime;
    }

    public String getYanaTransfer1AirlineName() {
        return yanaTransfer1AirlineName;
    }

    public void setYanaTransfer1AirlineName(String yanaTransfer1AirlineName) {
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
    }

    public String getYanaTransfer2AirlineName() {
        return yanaTransfer2AirlineName;
    }

    public void setYanaTransfer2AirlineName(String yanaTransfer2AirlineName) {
        this.yanaTransfer2AirlineName = yanaTransfer2AirlineName;
    }

    public String getYanaTransfer3AirlineName() {
        return yanaTransfer3AirlineName;
    }

    public void setYanaTransfer3AirlineName(String yanaTransfer3AirlineName) {
        this.yanaTransfer3AirlineName = yanaTransfer3AirlineName;
    }

    public String getEnaTransfer1AirlineName() {
        return enaTransfer1AirlineName;
    }

    public void setEnaTransfer1AirlineName(String enaTransfer1AirlineName) {
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
    }

    public String getEnaTransfer2AirlineName() {
        return enaTransfer2AirlineName;
    }

    public void setEnaTransfer2AirlineName(String enaTransfer2AirlineName) {
        this.enaTransfer2AirlineName = enaTransfer2AirlineName;
    }

    public String getEnaTransfer3AirlineName() {
        return enaTransfer3AirlineName;
    }

    public void setEnaTransfer3AirlineName(String enaTransfer3AirlineName) {
        this.enaTransfer3AirlineName = enaTransfer3AirlineName;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", tele='" + tele + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", S_Id='" + S_Id + '\'' +
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
                ", p_Ticket_Id='" + p_Ticket_Id + '\'' +
                ", p_code='" + p_code + '\'' +
                ", t_Relise_Date='" + t_Relise_Date + '\'' +
                ", t_Relise_Time='" + t_Relise_Time + '\'' +
                ", t_Valid_Date='" + t_Valid_Date + '\'' +
                ", expire_Date='" + expire_Date + '\'' +
                ", f_Id='" + f_Id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", pass_Id='" + pass_Id + '\'' +
                ", f_Name='" + f_Name + '\'' +
                ", l_Name='" + l_Name + '\'' +
                ", passenger_type='" + passenger_type + '\'' +
                ", flight_meal_Plan_Detail_Id='" + flight_meal_Plan_Detail_Id + '\'' +
                ", m_Id='" + m_Id + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", m_Name='" + m_Name + '\'' +
                ", fli_Fli_Det_Main_Id='" + fli_Fli_Det_Main_Id + '\'' +
                ", f_Detail_Id='" + f_Detail_Id + '\'' +
                ", commen_guidline_count=" + commen_guidline_count +
                ", all_guidline_count=" + all_guidline_count +
                ", guidline='" + guidline + '\'' +
                ", DirectYanaArrivalDate='" + DirectYanaArrivalDate + '\'' +
                ", DirectYanaArrivalTime='" + DirectYanaArrivalTime + '\'' +
                ", yanaTransfer1Name='" + yanaTransfer1Name + '\'' +
                ", yanaTransfer1AirportName='" + yanaTransfer1AirportName + '\'' +
                ", yanaTransfer1ArrivalDate='" + yanaTransfer1ArrivalDate + '\'' +
                ", yanaTransfer1ArrivalTime='" + yanaTransfer1ArrivalTime + '\'' +
                ", yanaTransfer1FlightId='" + yanaTransfer1FlightId + '\'' +
                ", yanaTransfer1AirbusCode='" + yanaTransfer1AirbusCode + '\'' +
                ", yanaTransfer1DepartureDate='" + yanaTransfer1DepartureDate + '\'' +
                ", yanaTransfer1DepartureTime='" + yanaTransfer1DepartureTime + '\'' +
                ", yanaTransfer2Name='" + yanaTransfer2Name + '\'' +
                ", yanaTransfer2AirportName='" + yanaTransfer2AirportName + '\'' +
                ", yanaTransfer2ArrivalDate='" + yanaTransfer2ArrivalDate + '\'' +
                ", yanaTransfer2ArrivalTime='" + yanaTransfer2ArrivalTime + '\'' +
                ", yanaTransfer2FlightId='" + yanaTransfer2FlightId + '\'' +
                ", yanaTransfer2AirbusCode='" + yanaTransfer2AirbusCode + '\'' +
                ", yanaTransfer2DepartureDate='" + yanaTransfer2DepartureDate + '\'' +
                ", yanaTransfer2DepartureTime='" + yanaTransfer2DepartureTime + '\'' +
                ", yanaTransfer3Name='" + yanaTransfer3Name + '\'' +
                ", yanaTransfer3AirportName='" + yanaTransfer3AirportName + '\'' +
                ", yanaTransfer3ArrivalDate='" + yanaTransfer3ArrivalDate + '\'' +
                ", yanaTransfer3ArrivalTime='" + yanaTransfer3ArrivalTime + '\'' +
                ", yanaTransfer3FlightId='" + yanaTransfer3FlightId + '\'' +
                ", yanaTransfer3AirbusCode='" + yanaTransfer3AirbusCode + '\'' +
                ", yanaTransfer3DepartureDate='" + yanaTransfer3DepartureDate + '\'' +
                ", yanaTransfer3DepartureTime='" + yanaTransfer3DepartureTime + '\'' +
                ", DirectEnaArrivalDate='" + DirectEnaArrivalDate + '\'' +
                ", DirectEnaArrivalTime='" + DirectEnaArrivalTime + '\'' +
                ", enaTransfer1Name='" + enaTransfer1Name + '\'' +
                ", enaTransfer1AirportName='" + enaTransfer1AirportName + '\'' +
                ", enaTransfer1FlightId='" + enaTransfer1FlightId + '\'' +
                ", enaTransfer1AirbusCode='" + enaTransfer1AirbusCode + '\'' +
                ", enaTransfer1ArrivalDate='" + enaTransfer1ArrivalDate + '\'' +
                ", enaTransfer1ArrivalTime='" + enaTransfer1ArrivalTime + '\'' +
                ", enaTransfer1DepartureDate='" + enaTransfer1DepartureDate + '\'' +
                ", enaTransfer1DepartureTime='" + enaTransfer1DepartureTime + '\'' +
                ", enaTransfer2Name='" + enaTransfer2Name + '\'' +
                ", enaTransfer2AirportName='" + enaTransfer2AirportName + '\'' +
                ", enaTransfer2FlightId='" + enaTransfer2FlightId + '\'' +
                ", enaTransfer2AirbusCode='" + enaTransfer2AirbusCode + '\'' +
                ", enaTransfer2ArrivalDate='" + enaTransfer2ArrivalDate + '\'' +
                ", enaTransfer2ArrivalTime='" + enaTransfer2ArrivalTime + '\'' +
                ", enaTransfer2DepartureDate='" + enaTransfer2DepartureDate + '\'' +
                ", enaTransfer2DepartureTime='" + enaTransfer2DepartureTime + '\'' +
                ", enaTransfer3Name='" + enaTransfer3Name + '\'' +
                ", enaTransfer3AirportName='" + enaTransfer3AirportName + '\'' +
                ", enaTransfer3FlightId='" + enaTransfer3FlightId + '\'' +
                ", enaTransfer3AirbusCode='" + enaTransfer3AirbusCode + '\'' +
                ", enaTransfer3ArrivalDate='" + enaTransfer3ArrivalDate + '\'' +
                ", enaTransfer3ArrivalTime='" + enaTransfer3ArrivalTime + '\'' +
                ", enaTransfer3DepartureDate='" + enaTransfer3DepartureDate + '\'' +
                ", enaTransfer3DepartureTime='" + enaTransfer3DepartureTime + '\'' +
                ", yanaTransfer1AirlineName='" + yanaTransfer1AirlineName + '\'' +
                ", yanaTransfer2AirlineName='" + yanaTransfer2AirlineName + '\'' +
                ", yanaTransfer3AirlineName='" + yanaTransfer3AirlineName + '\'' +
                ", enaTransfer1AirlineName='" + enaTransfer1AirlineName + '\'' +
                ", enaTransfer2AirlineName='" + enaTransfer2AirlineName + '\'' +
                ", enaTransfer3AirlineName='" + enaTransfer3AirlineName + '\'' +
                ", s_Id='" + s_Id + '\'' +
                ", airline_name='" + airline_name + '\'' +
                ", journey='" + journey + '\'' +
                ", transferCount=" + transferCount +
                ", airbusCode='" + airbusCode + '\'' +
                ", fli_cla_type_Id='" + fli_cla_type_Id + '\'' +
                ", class_code='" + class_code + '\'' +
                ", demand='" + demand + '\'' +
                ", s_qty=" + s_qty +
                ", b_Id='" + b_Id + '\'' +
                ", total=" + total +
                ", meal_Id='" + meal_Id + '\'' +
                '}';
    }
}
