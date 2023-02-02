package lk.ijse.AirlineTicketReservationSystem.to;

public class FlightDetailMaintain {
    private String fli_Fli_Det_Main_Id;
    private String f_Detail_Id;
    private String f_Id;
    private int commen_guidline_count;
    private int all_guidline_count;

    public FlightDetailMaintain(String fli_Fli_Det_Main_Id, String f_Detail_Id, String f_Id, int commen_guidline_count, int all_guidline_count) {
        this.fli_Fli_Det_Main_Id = fli_Fli_Det_Main_Id;
        this.f_Detail_Id = f_Detail_Id;
        this.f_Id = f_Id;
        this.commen_guidline_count = commen_guidline_count;
        this.all_guidline_count = all_guidline_count;
    }

    public FlightDetailMaintain() {

    }

    public String getFli_Fli_Det_Main_Id() {
        return fli_Fli_Det_Main_Id;
    }

    public void setFli_Fli_Det_Main_Id(String fli_Fli_Det_Main_Id) {
        this.fli_Fli_Det_Main_Id = fli_Fli_Det_Main_Id;
    }

    public String getF_Detail_Id() {
        return f_Detail_Id;
    }

    public void setF_Detail_Id(String f_Detail_Id) {
        this.f_Detail_Id = f_Detail_Id;
    }

    public String getF_Id() {
        return f_Id;
    }

    public void setF_Id(String f_Id) {
        this.f_Id = f_Id;
    }

    public int getCommen_guidline_count() {
        return commen_guidline_count;
    }

    public void setCommen_guidline_count(int commen_guidline_count) {
        this.commen_guidline_count = commen_guidline_count;
    }

    public int getAll_guidline_count() {
        return all_guidline_count;
    }

    public void setAll_guidline_count(int all_guidline_count) {
        this.all_guidline_count = all_guidline_count;
    }

    @Override
    public String toString() {
        return "FlightDetailMaintain{" +
                "fli_Fli_Det_Main_Id='" + fli_Fli_Det_Main_Id + '\'' +
                ", f_Detail_Id='" + f_Detail_Id + '\'' +
                ", f_Id='" + f_Id + '\'' +
                ", commen_guidline_count=" + commen_guidline_count +
                ", all_guidline_count=" + all_guidline_count +
                '}';
    }

}
