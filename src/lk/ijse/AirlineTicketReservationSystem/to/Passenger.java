package lk.ijse.AirlineTicketReservationSystem.to;

public class Passenger {
    private String pass_Id;
    private String f_Name;
    private String l_Name;
    private String address;
    private String tele;
    private String email;
    private String gender;
    private String dob;
    private String passenger_type;

    public Passenger(String pass_Id, String f_Name, String l_Name, String address, String tele, String email, String gender, String dob, String passenger_type) {
        this.pass_Id = pass_Id;
        this.f_Name = f_Name;
        this.l_Name = l_Name;
        this.address = address;
        this.tele = tele;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.passenger_type = passenger_type;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassenger_type() {
        return passenger_type;
    }

    public void setPassenger_type(String passenger_type) {
        this.passenger_type = passenger_type;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pass_Id='" + pass_Id + '\'' +
                ", f_Name='" + f_Name + '\'' +
                ", l_Name='" + l_Name + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", passenger_type='" + passenger_type + '\'' +
                '}';
    }
}
