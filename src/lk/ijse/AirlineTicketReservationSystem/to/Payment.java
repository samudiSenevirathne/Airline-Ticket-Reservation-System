package lk.ijse.AirlineTicketReservationSystem.to;

public class Payment {
    private String p_code;
    private String f_Id;
    private String p_name;
    private String type;
    private String date;
    private String time;

    public Payment(String p_code, String f_Id, String p_name, String type, String date, String time) {
        this.p_code = p_code;
        this.f_Id = f_Id;
        this.p_name = p_name;
        this.type = type;
        this.date = date;
        this.time = time;
    }

    public Payment() {
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
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

    @Override
    public String toString() {
        return "Payment{" +
                "p_code='" + p_code + '\'' +
                ", f_Id='" + f_Id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
