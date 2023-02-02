package lk.ijse.AirlineTicketReservationSystem.to;

public class MealPlan {
    private String m_Id;
    private String m_Name;
    private String type;
    private Double price;

    public MealPlan(String m_Id, String m_Name, String type, Double price) {
        this.m_Id = m_Id;
        this.m_Name = m_Name;
        this.type = type;
        this.price = price;
    }

    public MealPlan() {

    }

    public String getM_Id() {
        return m_Id;
    }

    public void setM_Id(String m_Id) {
        this.m_Id = m_Id;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "m_Id='" + m_Id + '\'' +
                ", m_Name='" + m_Name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

}
