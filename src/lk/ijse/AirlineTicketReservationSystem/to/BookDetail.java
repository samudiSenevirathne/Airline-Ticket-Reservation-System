package lk.ijse.AirlineTicketReservationSystem.to;

public class BookDetail {
    private String b_Id;
    private String pass_Id;
    private String f_Id;
    private String date;
    private String time;
    private String country;
    private double total;
    private String meal_Id;
    private String class_code;

    public BookDetail(String b_Id, String pass_Id, String f_Id, String date, String time, String country, double total, String meal_Id, String class_code) {
        this.b_Id = b_Id;
        this.pass_Id = pass_Id;
        this.f_Id = f_Id;
        this.date = date;
        this.time = time;
        this.country = country;
        this.total = total;
        this.meal_Id = meal_Id;
        this.class_code = class_code;
    }

    public BookDetail() {
    }

    public String getB_Id() {
        return b_Id;
    }

    public void setB_Id(String b_Id) {
        this.b_Id = b_Id;
    }

    public String getPass_Id() {
        return pass_Id;
    }

    public void setPass_Id(String pass_Id) {
        this.pass_Id = pass_Id;
    }

    public String getF_Id() {
        return f_Id;
    }

    public void setF_Id(String f_Id) {
        this.f_Id = f_Id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    @Override
    public String toString() {
        return "BookDetail{" +
                "b_Id='" + b_Id + '\'' +
                ", pass_Id='" + pass_Id + '\'' +
                ", f_Id='" + f_Id + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", country='" + country + '\'' +
                ", total=" + total +
                ", meal_Id='" + meal_Id + '\'' +
                ", class_code='" + class_code + '\'' +
                '}';
    }
}
