package lk.ijse.AirlineTicketReservationSystem.to;

public class Flight {
    private String f_Id;
    private String s_Id;
    private String airline_name;
    private String journey;
    private int transferCount;
    private String airbusCode;

    public Flight(String f_Id, String s_Id, String airline_name, String journey, int transferCount,String airbusCode) {
        this.f_Id = f_Id;
        this.s_Id = s_Id;
        this.airline_name = airline_name;
        this.journey = journey;
        this.transferCount = transferCount;
        this.airbusCode=airbusCode;
    }


    public String getF_Id() {
        return f_Id;
    }

    public void setF_Id(String f_Id) {
        this.f_Id = f_Id;
    }

    public String getS_Id() {
        return s_Id;
    }

    public void setS_Id(String s_Id) {
        this.s_Id = s_Id;
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

    @Override
    public String toString() {
        return "Flight{" +
                "f_Id='" + f_Id + '\'' +
                ", s_Id='" + s_Id + '\'' +
                ", airline_name='" + airline_name + '\'' +
                ", journey='" + journey + '\'' +
                ", transferCount=" + transferCount +
                ", airbusCode='" + airbusCode + '\'' +
                '}';
    }
}
