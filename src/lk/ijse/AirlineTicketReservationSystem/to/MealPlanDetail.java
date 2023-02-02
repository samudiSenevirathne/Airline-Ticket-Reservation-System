package lk.ijse.AirlineTicketReservationSystem.to;

public class MealPlanDetail {
    private String flight_meal_Plan_Detail_Id;
    private String m_Id;
    private String f_Id;
    private double price;
    private int qty;
    private String date;
    private String time;

    public MealPlanDetail(String flight_meal_Plan_Detail_Id, String m_Id, String f_Id, double price, int qty, String date, String time) {
        this.flight_meal_Plan_Detail_Id = flight_meal_Plan_Detail_Id;
        this.m_Id = m_Id;
        this.f_Id = f_Id;
        this.price = price;
        this.qty = qty;
        this.date = date;
        this.time = time;
    }

    public MealPlanDetail() {
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

    public String getF_Id() {
        return f_Id;
    }

    public void setF_Id(String f_Id) {
        this.f_Id = f_Id;
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
        return "MealPlanDetail{" +
                "flight_meal_Plan_Detail_Id='" + flight_meal_Plan_Detail_Id + '\'' +
                ", m_Id='" + m_Id + '\'' +
                ", f_Id='" + f_Id + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
