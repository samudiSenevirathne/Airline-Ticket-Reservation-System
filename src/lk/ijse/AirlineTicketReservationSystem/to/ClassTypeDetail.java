package lk.ijse.AirlineTicketReservationSystem.to;

public class ClassTypeDetail {
    private String fli_cla_type_Id;
    private String class_code;
    private String f_Id;
    private String demand;
    private double price;

    public ClassTypeDetail(String fli_cla_type_Id, String class_code, String f_Id, String demand, double price) {
        this.fli_cla_type_Id = fli_cla_type_Id;
        this.class_code = class_code;
        this.f_Id = f_Id;
        this.demand = demand;
        this.price = price;
    }

    public ClassTypeDetail() {

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

    public String getF_Id() {
        return f_Id;
    }

    public void setF_Id(String f_Id) {
        this.f_Id = f_Id;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClassTypeDetail{" +
                "fli_cla_type_Id='" + fli_cla_type_Id + '\'' +
                ", class_code='" + class_code + '\'' +
                ", f_Id='" + f_Id + '\'' +
                ", demand='" + demand + '\'' +
                ", price=" + price +
                '}';
    }
}
