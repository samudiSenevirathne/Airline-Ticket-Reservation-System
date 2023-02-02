package lk.ijse.AirlineTicketReservationSystem.to;

public class User {
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

    public User(String username, String name, String role, String email, String tele, Double salary, String address, String password, String gender, String dob) {
        this.username = username;
        this.name = name;
        this.role = role;
        this.email = email;
        this.tele = tele;
        this.salary = salary;
        this.address = address;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
    }

    public User() {

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", tele='" + tele + '\'' +
                ", salary='" + salary + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + dob + '\'' +
                '}';
    }

}
