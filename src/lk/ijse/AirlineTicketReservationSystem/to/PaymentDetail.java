package lk.ijse.AirlineTicketReservationSystem.to;

public class PaymentDetail {
    private String p_Ticket_Id;
    private String p_code;
    private String t_Relise_Date;
    private String t_Relise_Time;
    private String t_Valid_Date;
    private String expire_Date;

    public PaymentDetail(String p_Ticket_Id, String p_code, String t_Relise_Date, String t_Relise_Time, String t_Valid_Date, String expire_Date) {
        this.p_Ticket_Id = p_Ticket_Id;
        this.p_code = p_code;
        this.t_Relise_Date = t_Relise_Date;
        this.t_Relise_Time = t_Relise_Time;
        this.t_Valid_Date = t_Valid_Date;
        this.expire_Date = expire_Date;
    }

    public PaymentDetail() {

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

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "p_Ticket_Id='" + p_Ticket_Id + '\'' +
                ", p_code='" + p_code + '\'' +
                ", t_Relise_Date='" + t_Relise_Date + '\'' +
                ", t_Relise_Time='" + t_Relise_Time + '\'' +
                ", t_Valid_Date='" + t_Valid_Date + '\'' +
                ", expire_Date='" + expire_Date + '\'' +
                '}';
    }
}
