package lk.ijse.AirlineTicketReservationSystem.to;

public class ClassType {
    private String class_code;
    private String name;
    private int s_qty;
    private double price;

    public ClassType(String class_code, String name, int s_qty, double price) {
        this.class_code = class_code;
        this.name = name;
        this.s_qty = s_qty;
        this.price = price;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getS_qty() {
        return s_qty;
    }

    public void setS_qty(int s_qty) {
        this.s_qty = s_qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClassType{" +
                "class_code='" + class_code + '\'' +
                ", name='" + name + '\'' +
                ", s_qty=" + s_qty +
                ", price=" + price +
                '}';
    }
}
