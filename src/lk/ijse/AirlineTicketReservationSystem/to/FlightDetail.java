package lk.ijse.AirlineTicketReservationSystem.to;

public class FlightDetail {
    private String f_Detail_Id;
    private String guidline;
    private String DirectYanaArrivalDate;
    private String DirectYanaArrivalTime;
    private String yanaTransfer1Name;
    private String  yanaTransfer1AirportName;
    private String  yanaTransfer1ArrivalDate;
    private String  yanaTransfer1ArrivalTime;
    private String  yanaTransfer1FlightId;
    private String  yanaTransfer1AirbusCode;
    private String  yanaTransfer1DepartureDate;
    private String yanaTransfer1DepartureTime;
    private String  yanaTransfer2Name;
    private String yanaTransfer2AirportName;
    private String  yanaTransfer2ArrivalDate;
    private String yanaTransfer2ArrivalTime;
    private String  yanaTransfer2FlightId;
    private String  yanaTransfer2AirbusCode;
    private String  yanaTransfer2DepartureDate;
    private String  yanaTransfer2DepartureTime;
    private String yanaTransfer3Name;
    private String yanaTransfer3AirportName;
    private String  yanaTransfer3ArrivalDate;
    private String  yanaTransfer3ArrivalTime;
    private String  yanaTransfer3FlightId;
    private String  yanaTransfer3AirbusCode;
    private String  yanaTransfer3DepartureDate;
    private String  yanaTransfer3DepartureTime;
    private String DirectEnaArrivalDate;
    private String DirectEnaArrivalTime;
    private String enaTransfer1Name;
    private String enaTransfer1AirportName;
    private String enaTransfer1FlightId;
    private String enaTransfer1AirbusCode;
    private String enaTransfer1ArrivalDate;
    private String enaTransfer1ArrivalTime;
    private String enaTransfer1DepartureDate;
    private String enaTransfer1DepartureTime;
    private String enaTransfer2Name;
    private String enaTransfer2AirportName;
    private String enaTransfer2FlightId;
    private String enaTransfer2AirbusCode;
    private String enaTransfer2ArrivalDate;
    private String enaTransfer2ArrivalTime;
    private String enaTransfer2DepartureDate;
    private String enaTransfer2DepartureTime;
    private String enaTransfer3Name;
    private String enaTransfer3AirportName;
    private String enaTransfer3FlightId;
    private String enaTransfer3AirbusCode;
    private String enaTransfer3ArrivalDate;
    private String enaTransfer3ArrivalTime;
    private String enaTransfer3DepartureDate;
    private String enaTransfer3DepartureTime;
    private String yanaTransfer1AirlineName;
    private String yanaTransfer2AirlineName;
    private String yanaTransfer3AirlineName;
    private String enaTransfer1AirlineName;
    private String enaTransfer2AirlineName;
    private String enaTransfer3AirlineName;


    public FlightDetail(String f_Detail_Id, String guidline, String directYanaArrivalDate, String directYanaArrivalTime, String directEnaArrivalDate, String directEnaArrivalTime) {
        this.f_Detail_Id = f_Detail_Id;
        this.guidline = guidline;
        this.DirectYanaArrivalDate = directYanaArrivalDate;
        this.DirectYanaArrivalTime = directYanaArrivalTime;
        this.DirectEnaArrivalDate = directEnaArrivalDate;
        this.DirectEnaArrivalTime = directEnaArrivalTime;
    }

    public FlightDetail(String guidline, String directYanaArrivalDate, String directYanaArrivalTime, String directEnaArrivalDate, String directEnaArrivalTime) {
        this.guidline = guidline;
        this.DirectYanaArrivalDate = directYanaArrivalDate;
        this.DirectYanaArrivalTime = directYanaArrivalTime;
        this.DirectEnaArrivalDate = directEnaArrivalDate;
        this.DirectEnaArrivalTime = directEnaArrivalTime;
    }


    public FlightDetail(String f_Detail_Id, String guidline) {
        this.f_Detail_Id = f_Detail_Id;
        this.guidline = guidline;
    }

    public FlightDetail(String yanaTransfer1Name, String yanaTransfer1AirportName,String yanaTransfer2Name, String yanaTransfer2AirportName) {
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer2Name = yanaTransfer2Name;
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
    }

    public FlightDetail(String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime,String yanaTransfer1AirlineName) {
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
    }


    public FlightDetail(String f_Detail_Id, String guidline, String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime, String yanaTransfer1AirlineName, String enaTransfer1Name, String enaTransfer1AirportName, String enaTransfer1FlightId, String enaTransfer1AirbusCode, String enaTransfer1ArrivalDate, String enaTransfer1ArrivalTime, String enaTransfer1DepartureDate, String enaTransfer1DepartureTime, String enaTransfer1AirlineName) {
        this.f_Detail_Id = f_Detail_Id;
        this.guidline = guidline;
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
        this.enaTransfer1Name = enaTransfer1Name;
        this.enaTransfer1AirportName = enaTransfer1AirportName;
        this.enaTransfer1FlightId = enaTransfer1FlightId;
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;

    }

    public FlightDetail(String guidline, String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime, String yanaTransfer1AirlineName, String enaTransfer1Name, String enaTransfer1AirportName, String enaTransfer1FlightId, String enaTransfer1AirbusCode, String enaTransfer1ArrivalDate, String enaTransfer1ArrivalTime, String enaTransfer1DepartureDate, String enaTransfer1DepartureTime, String enaTransfer1AirlineName) {
        this.guidline = guidline;
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
        this.enaTransfer1Name = enaTransfer1Name;
        this.enaTransfer1AirportName = enaTransfer1AirportName;
        this.enaTransfer1FlightId = enaTransfer1FlightId;
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
    }


    public FlightDetail(String f_Detail_Id, String guidline, String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime,String yanaTransfer1AirlineName, String yanaTransfer2Name, String yanaTransfer2AirportName, String yanaTransfer2ArrivalDate, String yanaTransfer2ArrivalTime, String yanaTransfer2FlightId, String yanaTransfer2AirbusCode, String yanaTransfer2DepartureDate, String yanaTransfer2DepartureTime,String yanaTransfer2AirlineName, String enaTransfer1Name, String enaTransfer1AirportName, String enaTransfer1FlightId, String enaTransfer1AirbusCode, String enaTransfer1ArrivalDate, String enaTransfer1ArrivalTime, String enaTransfer1DepartureDate, String enaTransfer1DepartureTime,String enaTransfer1AirlineName, String enaTransfer2Name, String enaTransfer2AirportName, String enaTransfer2FlightId, String enaTransfer2AirbusCode, String enaTransfer2ArrivalDate, String enaTransfer2ArrivalTime, String enaTransfer2DepartureDate, String enaTransfer2DepartureTime,String enaTransfer2AirlineName){
        this.f_Detail_Id = f_Detail_Id;
        this.guidline = guidline;
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
        this.yanaTransfer2Name = yanaTransfer2Name;
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
        this.yanaTransfer2ArrivalDate = yanaTransfer2ArrivalDate;
        this.yanaTransfer2ArrivalTime = yanaTransfer2ArrivalTime;
        this.yanaTransfer2FlightId = yanaTransfer2FlightId;
        this.yanaTransfer2AirbusCode = yanaTransfer2AirbusCode;
        this.yanaTransfer2DepartureDate = yanaTransfer2DepartureDate;
        this.yanaTransfer2DepartureTime = yanaTransfer2DepartureTime;
        this.yanaTransfer2AirlineName = yanaTransfer2AirlineName;
        this.enaTransfer1Name = enaTransfer1Name;
        this.enaTransfer1AirportName = enaTransfer1AirportName;
        this.enaTransfer1FlightId = enaTransfer1FlightId;
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
        this.enaTransfer2Name = enaTransfer2Name;
        this.enaTransfer2AirportName = enaTransfer2AirportName;
        this.enaTransfer2FlightId = enaTransfer2FlightId;
        this.enaTransfer2AirbusCode = enaTransfer2AirbusCode;
        this.enaTransfer2ArrivalDate = enaTransfer2ArrivalDate;
        this.enaTransfer2ArrivalTime = enaTransfer2ArrivalTime;
        this.enaTransfer2DepartureDate = enaTransfer2DepartureDate;
        this.enaTransfer2DepartureTime = enaTransfer2DepartureTime;
        this.enaTransfer2AirlineName = enaTransfer2AirlineName;
    }

    public FlightDetail(String guidline, String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime,String yanaTransfer1AirlineName, String yanaTransfer2Name, String yanaTransfer2AirportName, String yanaTransfer2ArrivalDate, String yanaTransfer2ArrivalTime, String yanaTransfer2FlightId, String yanaTransfer2AirbusCode, String yanaTransfer2DepartureDate, String yanaTransfer2DepartureTime,String yanaTransfer2AirlineName, String enaTransfer1Name, String enaTransfer1AirportName, String enaTransfer1FlightId, String enaTransfer1AirbusCode, String enaTransfer1ArrivalDate, String enaTransfer1ArrivalTime, String enaTransfer1DepartureDate, String enaTransfer1DepartureTime,String enaTransfer1AirlineName, String enaTransfer2Name, String enaTransfer2AirportName, String enaTransfer2FlightId, String enaTransfer2AirbusCode, String enaTransfer2ArrivalDate, String enaTransfer2ArrivalTime, String enaTransfer2DepartureDate, String enaTransfer2DepartureTime,String enaTransfer2AirlineName) {
        this.guidline = guidline;
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
        this.yanaTransfer2Name = yanaTransfer2Name;
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
        this.yanaTransfer2ArrivalDate = yanaTransfer2ArrivalDate;
        this.yanaTransfer2ArrivalTime = yanaTransfer2ArrivalTime;
        this.yanaTransfer2FlightId = yanaTransfer2FlightId;
        this.yanaTransfer2AirbusCode = yanaTransfer2AirbusCode;
        this.yanaTransfer2DepartureDate = yanaTransfer2DepartureDate;
        this.yanaTransfer2DepartureTime = yanaTransfer2DepartureTime;
        this.yanaTransfer2AirlineName = yanaTransfer2AirlineName;
        this.enaTransfer1Name = enaTransfer1Name;
        this.enaTransfer1AirportName = enaTransfer1AirportName;
        this.enaTransfer1FlightId = enaTransfer1FlightId;
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
        this.enaTransfer2Name = enaTransfer2Name;
        this.enaTransfer2AirportName = enaTransfer2AirportName;
        this.enaTransfer2FlightId = enaTransfer2FlightId;
        this.enaTransfer2AirbusCode = enaTransfer2AirbusCode;
        this.enaTransfer2ArrivalDate = enaTransfer2ArrivalDate;
        this.enaTransfer2ArrivalTime = enaTransfer2ArrivalTime;
        this.enaTransfer2DepartureDate = enaTransfer2DepartureDate;
        this.enaTransfer2DepartureTime = enaTransfer2DepartureTime;
        this.enaTransfer2AirlineName = enaTransfer2AirlineName;
    }

    public FlightDetail(String f_Detail_Id, String guidline, String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime,String yanaTransfer1AirlineName, String yanaTransfer2Name, String yanaTransfer2AirportName, String yanaTransfer2ArrivalDate, String yanaTransfer2ArrivalTime, String yanaTransfer2FlightId, String yanaTransfer2AirbusCode, String yanaTransfer2DepartureDate, String yanaTransfer2DepartureTime,String yanaTransfer2AirlineName, String yanaTransfer3Name, String yanaTransfer3AirportName, String yanaTransfer3ArrivalDate, String yanaTransfer3ArrivalTime, String yanaTransfer3FlightId, String yanaTransfer3AirbusCode, String yanaTransfer3DepartureDate, String yanaTransfer3DepartureTime,String yanaTransfer3AirlineName, String enaTransfer1Name, String enaTransfer1AirportName, String enaTransfer1FlightId, String enaTransfer1AirbusCode, String enaTransfer1ArrivalDate, String enaTransfer1ArrivalTime, String enaTransfer1DepartureDate, String enaTransfer1DepartureTime, String enaTransfer1AirlineName , String enaTransfer2Name, String enaTransfer2AirportName, String enaTransfer2FlightId, String enaTransfer2AirbusCode, String enaTransfer2ArrivalDate, String enaTransfer2ArrivalTime, String enaTransfer2DepartureDate, String enaTransfer2DepartureTime, String enaTransfer2AirlineName, String enaTransfer3Name, String enaTransfer3AirportName, String enaTransfer3FlightId, String enaTransfer3AirbusCode, String enaTransfer3ArrivalDate, String enaTransfer3ArrivalTime, String enaTransfer3DepartureDate, String enaTransfer3DepartureTime,String enaTransfer3AirlineName) {
        this.f_Detail_Id = f_Detail_Id;
        this.guidline = guidline;
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
        this.yanaTransfer2Name = yanaTransfer2Name;
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
        this.yanaTransfer2ArrivalDate = yanaTransfer2ArrivalDate;
        this.yanaTransfer2ArrivalTime = yanaTransfer2ArrivalTime;
        this.yanaTransfer2FlightId = yanaTransfer2FlightId;
        this.yanaTransfer2AirbusCode = yanaTransfer2AirbusCode;
        this.yanaTransfer2DepartureDate = yanaTransfer2DepartureDate;
        this.yanaTransfer2DepartureTime = yanaTransfer2DepartureTime;
        this.yanaTransfer2AirlineName = yanaTransfer2AirlineName;
        this.yanaTransfer3Name = yanaTransfer3Name;
        this.yanaTransfer3AirportName = yanaTransfer3AirportName;
        this.yanaTransfer3ArrivalDate = yanaTransfer3ArrivalDate;
        this.yanaTransfer3ArrivalTime = yanaTransfer3ArrivalTime;
        this.yanaTransfer3FlightId = yanaTransfer3FlightId;
        this.yanaTransfer3AirbusCode = yanaTransfer3AirbusCode;
        this.yanaTransfer3DepartureDate = yanaTransfer3DepartureDate;
        this.yanaTransfer3DepartureTime = yanaTransfer3DepartureTime;
        this.yanaTransfer3AirlineName = yanaTransfer3AirlineName;
        this.enaTransfer1Name = enaTransfer1Name;
        this.enaTransfer1AirportName = enaTransfer1AirportName;
        this.enaTransfer1FlightId = enaTransfer1FlightId;
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
        this.enaTransfer2Name = enaTransfer2Name;
        this.enaTransfer2AirportName = enaTransfer2AirportName;
        this.enaTransfer2FlightId = enaTransfer2FlightId;
        this.enaTransfer2AirbusCode = enaTransfer2AirbusCode;
        this.enaTransfer2ArrivalDate = enaTransfer2ArrivalDate;
        this.enaTransfer2ArrivalTime = enaTransfer2ArrivalTime;
        this.enaTransfer2DepartureDate = enaTransfer2DepartureDate;
        this.enaTransfer2DepartureTime = enaTransfer2DepartureTime;
        this.enaTransfer2AirlineName = enaTransfer2AirlineName;
        this.enaTransfer3Name = enaTransfer3Name;
        this.enaTransfer3AirportName = enaTransfer3AirportName;
        this.enaTransfer3FlightId = enaTransfer3FlightId;
        this.enaTransfer3AirbusCode = enaTransfer3AirbusCode;
        this.enaTransfer3ArrivalDate = enaTransfer3ArrivalDate;
        this.enaTransfer3ArrivalTime = enaTransfer3ArrivalTime;
        this.enaTransfer3DepartureDate = enaTransfer3DepartureDate;
        this.enaTransfer3DepartureTime = enaTransfer3DepartureTime;
        this.enaTransfer3AirlineName = enaTransfer3AirlineName;
    }

    public FlightDetail(String guidline, String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime,String yanaTransfer1AirlineName, String yanaTransfer2Name, String yanaTransfer2AirportName, String yanaTransfer2ArrivalDate, String yanaTransfer2ArrivalTime, String yanaTransfer2FlightId, String yanaTransfer2AirbusCode, String yanaTransfer2DepartureDate, String yanaTransfer2DepartureTime,String yanaTransfer2AirlineName, String yanaTransfer3Name, String yanaTransfer3AirportName, String yanaTransfer3ArrivalDate, String yanaTransfer3ArrivalTime, String yanaTransfer3FlightId, String yanaTransfer3AirbusCode, String yanaTransfer3DepartureDate, String yanaTransfer3DepartureTime,String yanaTransfer3AirlineName, String enaTransfer1Name, String enaTransfer1AirportName, String enaTransfer1FlightId, String enaTransfer1AirbusCode, String enaTransfer1ArrivalDate, String enaTransfer1ArrivalTime, String enaTransfer1DepartureDate, String enaTransfer1DepartureTime, String enaTransfer1AirlineName , String enaTransfer2Name, String enaTransfer2AirportName, String enaTransfer2FlightId, String enaTransfer2AirbusCode, String enaTransfer2ArrivalDate, String enaTransfer2ArrivalTime, String enaTransfer2DepartureDate, String enaTransfer2DepartureTime, String enaTransfer2AirlineName, String enaTransfer3Name, String enaTransfer3AirportName, String enaTransfer3FlightId, String enaTransfer3AirbusCode, String enaTransfer3ArrivalDate, String enaTransfer3ArrivalTime, String enaTransfer3DepartureDate, String enaTransfer3DepartureTime,String enaTransfer3AirlineName) {
        this.guidline = guidline;
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
        this.yanaTransfer2Name = yanaTransfer2Name;
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
        this.yanaTransfer2ArrivalDate = yanaTransfer2ArrivalDate;
        this.yanaTransfer2ArrivalTime = yanaTransfer2ArrivalTime;
        this.yanaTransfer2FlightId = yanaTransfer2FlightId;
        this.yanaTransfer2AirbusCode = yanaTransfer2AirbusCode;
        this.yanaTransfer2DepartureDate = yanaTransfer2DepartureDate;
        this.yanaTransfer2DepartureTime = yanaTransfer2DepartureTime;
        this.yanaTransfer2AirlineName = yanaTransfer2AirlineName;
        this.yanaTransfer3Name = yanaTransfer3Name;
        this.yanaTransfer3AirportName = yanaTransfer3AirportName;
        this.yanaTransfer3ArrivalDate = yanaTransfer3ArrivalDate;
        this.yanaTransfer3ArrivalTime = yanaTransfer3ArrivalTime;
        this.yanaTransfer3FlightId = yanaTransfer3FlightId;
        this.yanaTransfer3AirbusCode = yanaTransfer3AirbusCode;
        this.yanaTransfer3DepartureDate = yanaTransfer3DepartureDate;
        this.yanaTransfer3DepartureTime = yanaTransfer3DepartureTime;
        this.yanaTransfer3AirlineName = yanaTransfer3AirlineName;
        this.enaTransfer1Name = enaTransfer1Name;
        this.enaTransfer1AirportName = enaTransfer1AirportName;
        this.enaTransfer1FlightId = enaTransfer1FlightId;
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
        this.enaTransfer2Name = enaTransfer2Name;
        this.enaTransfer2AirportName = enaTransfer2AirportName;
        this.enaTransfer2FlightId = enaTransfer2FlightId;
        this.enaTransfer2AirbusCode = enaTransfer2AirbusCode;
        this.enaTransfer2ArrivalDate = enaTransfer2ArrivalDate;
        this.enaTransfer2ArrivalTime = enaTransfer2ArrivalTime;
        this.enaTransfer2DepartureDate = enaTransfer2DepartureDate;
        this.enaTransfer2DepartureTime = enaTransfer2DepartureTime;
        this.enaTransfer2AirlineName = enaTransfer2AirlineName;
        this.enaTransfer3Name = enaTransfer3Name;
        this.enaTransfer3AirportName = enaTransfer3AirportName;
        this.enaTransfer3FlightId = enaTransfer3FlightId;
        this.enaTransfer3AirbusCode = enaTransfer3AirbusCode;
        this.enaTransfer3ArrivalDate = enaTransfer3ArrivalDate;
        this.enaTransfer3ArrivalTime = enaTransfer3ArrivalTime;
        this.enaTransfer3DepartureDate = enaTransfer3DepartureDate;
        this.enaTransfer3DepartureTime = enaTransfer3DepartureTime;
        this.enaTransfer3AirlineName = enaTransfer3AirlineName;
    }

    public FlightDetail(String f_Detail_Id, String guidline, String directYanaArrivalDate, String directYanaArrivalTime, String yanaTransfer1Name, String yanaTransfer1AirportName, String yanaTransfer1ArrivalDate, String yanaTransfer1ArrivalTime, String yanaTransfer1FlightId, String yanaTransfer1AirbusCode, String yanaTransfer1DepartureDate, String yanaTransfer1DepartureTime, String yanaTransfer2Name, String yanaTransfer2AirportName, String yanaTransfer2ArrivalDate, String yanaTransfer2ArrivalTime, String yanaTransfer2FlightId, String yanaTransfer2AirbusCode, String yanaTransfer2DepartureDate, String yanaTransfer2DepartureTime, String yanaTransfer3Name, String yanaTransfer3AirportName, String yanaTransfer3ArrivalDate, String yanaTransfer3ArrivalTime, String yanaTransfer3FlightId, String yanaTransfer3AirbusCode, String yanaTransfer3DepartureDate, String yanaTransfer3DepartureTime, String directEnaArrivalDate, String directEnaArrivalTime, String enaTransfer1Name, String enaTransfer1AirportName, String enaTransfer1FlightId, String enaTransfer1AirbusCode, String enaTransfer1ArrivalDate, String enaTransfer1ArrivalTime, String enaTransfer1DepartureDate, String enaTransfer1DepartureTime, String enaTransfer2Name, String enaTransfer2AirportName, String enaTransfer2FlightId, String enaTransfer2AirbusCode, String enaTransfer2ArrivalDate, String enaTransfer2ArrivalTime, String enaTransfer2DepartureDate, String enaTransfer2DepartureTime, String enaTransfer3Name, String enaTransfer3AirportName, String enaTransfer3FlightId, String enaTransfer3AirbusCode, String enaTransfer3ArrivalDate, String enaTransfer3ArrivalTime, String enaTransfer3DepartureDate, String enaTransfer3DepartureTime, String yanaTransfer1AirlineName, String yanaTransfer2AirlineName, String yanaTransfer3AirlineName, String enaTransfer1AirlineName, String enaTransfer2AirlineName, String enaTransfer3AirlineName) {
        this.f_Detail_Id = f_Detail_Id;
        this.guidline = guidline;
        DirectYanaArrivalDate = directYanaArrivalDate;
        DirectYanaArrivalTime = directYanaArrivalTime;
        this.yanaTransfer1Name = yanaTransfer1Name;
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
        this.yanaTransfer2Name = yanaTransfer2Name;
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
        this.yanaTransfer2ArrivalDate = yanaTransfer2ArrivalDate;
        this.yanaTransfer2ArrivalTime = yanaTransfer2ArrivalTime;
        this.yanaTransfer2FlightId = yanaTransfer2FlightId;
        this.yanaTransfer2AirbusCode = yanaTransfer2AirbusCode;
        this.yanaTransfer2DepartureDate = yanaTransfer2DepartureDate;
        this.yanaTransfer2DepartureTime = yanaTransfer2DepartureTime;
        this.yanaTransfer3Name = yanaTransfer3Name;
        this.yanaTransfer3AirportName = yanaTransfer3AirportName;
        this.yanaTransfer3ArrivalDate = yanaTransfer3ArrivalDate;
        this.yanaTransfer3ArrivalTime = yanaTransfer3ArrivalTime;
        this.yanaTransfer3FlightId = yanaTransfer3FlightId;
        this.yanaTransfer3AirbusCode = yanaTransfer3AirbusCode;
        this.yanaTransfer3DepartureDate = yanaTransfer3DepartureDate;
        this.yanaTransfer3DepartureTime = yanaTransfer3DepartureTime;
        DirectEnaArrivalDate = directEnaArrivalDate;
        DirectEnaArrivalTime = directEnaArrivalTime;
        this.enaTransfer1Name = enaTransfer1Name;
        this.enaTransfer1AirportName = enaTransfer1AirportName;
        this.enaTransfer1FlightId = enaTransfer1FlightId;
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
        this.enaTransfer2Name = enaTransfer2Name;
        this.enaTransfer2AirportName = enaTransfer2AirportName;
        this.enaTransfer2FlightId = enaTransfer2FlightId;
        this.enaTransfer2AirbusCode = enaTransfer2AirbusCode;
        this.enaTransfer2ArrivalDate = enaTransfer2ArrivalDate;
        this.enaTransfer2ArrivalTime = enaTransfer2ArrivalTime;
        this.enaTransfer2DepartureDate = enaTransfer2DepartureDate;
        this.enaTransfer2DepartureTime = enaTransfer2DepartureTime;
        this.enaTransfer3Name = enaTransfer3Name;
        this.enaTransfer3AirportName = enaTransfer3AirportName;
        this.enaTransfer3FlightId = enaTransfer3FlightId;
        this.enaTransfer3AirbusCode = enaTransfer3AirbusCode;
        this.enaTransfer3ArrivalDate = enaTransfer3ArrivalDate;
        this.enaTransfer3ArrivalTime = enaTransfer3ArrivalTime;
        this.enaTransfer3DepartureDate = enaTransfer3DepartureDate;
        this.enaTransfer3DepartureTime = enaTransfer3DepartureTime;
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
        this.yanaTransfer2AirlineName = yanaTransfer2AirlineName;
        this.yanaTransfer3AirlineName = yanaTransfer3AirlineName;
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
        this.enaTransfer2AirlineName = enaTransfer2AirlineName;
        this.enaTransfer3AirlineName = enaTransfer3AirlineName;
    }

    public String getF_Detail_Id() {
        return f_Detail_Id;
    }

    public void setF_Detail_Id(String f_Detail_Id) {
        this.f_Detail_Id = f_Detail_Id;
    }

    public String getGuidline() {
        return guidline;
    }

    public void setGuidline(String guidline) {
        this.guidline = guidline;
    }

    public String getDirectYanaArrivalDate() {
        return DirectYanaArrivalDate;
    }

    public void setDirectYanaArrivalDate(String directYanaArrivalDate) {
        DirectYanaArrivalDate = directYanaArrivalDate;
    }

    public String getDirectYanaArrivalTime() {
        return DirectYanaArrivalTime;
    }

    public void setDirectYanaArrivalTime(String directYanaArrivalTime) {
        DirectYanaArrivalTime = directYanaArrivalTime;
    }

    public String getYanaTransfer1Name() {
        return yanaTransfer1Name;
    }

    public void setYanaTransfer1Name(String yanaTransfer1Name) {
        this.yanaTransfer1Name = yanaTransfer1Name;
    }

    public String getYanaTransfer1AirportName() {
        return yanaTransfer1AirportName;
    }

    public void setYanaTransfer1AirportName(String yanaTransfer1AirportName) {
        this.yanaTransfer1AirportName = yanaTransfer1AirportName;
    }

    public String getYanaTransfer1ArrivalDate() {
        return yanaTransfer1ArrivalDate;
    }

    public void setYanaTransfer1ArrivalDate(String yanaTransfer1ArrivalDate) {
        this.yanaTransfer1ArrivalDate = yanaTransfer1ArrivalDate;
    }

    public String getYanaTransfer1ArrivalTime() {
        return yanaTransfer1ArrivalTime;
    }

    public void setYanaTransfer1ArrivalTime(String yanaTransfer1ArrivalTime) {
        this.yanaTransfer1ArrivalTime = yanaTransfer1ArrivalTime;
    }

    public String getYanaTransfer1FlightId() {
        return yanaTransfer1FlightId;
    }

    public void setYanaTransfer1FlightId(String yanaTransfer1FlightId) {
        this.yanaTransfer1FlightId = yanaTransfer1FlightId;
    }

    public String getYanaTransfer1AirbusCode() {
        return yanaTransfer1AirbusCode;
    }

    public void setYanaTransfer1AirbusCode(String yanaTransfer1AirbusCode) {
        this.yanaTransfer1AirbusCode = yanaTransfer1AirbusCode;
    }

    public String getYanaTransfer1DepartureDate() {
        return yanaTransfer1DepartureDate;
    }

    public void setYanaTransfer1DepartureDate(String yanaTransfer1DepartureDate) {
        this.yanaTransfer1DepartureDate = yanaTransfer1DepartureDate;
    }

    public String getYanaTransfer1DepartureTime() {
        return yanaTransfer1DepartureTime;
    }

    public void setYanaTransfer1DepartureTime(String yanaTransfer1DepartureTime) {
        this.yanaTransfer1DepartureTime = yanaTransfer1DepartureTime;
    }

    public String getYanaTransfer2Name() {
        return yanaTransfer2Name;
    }

    public void setYanaTransfer2Name(String yanaTransfer2Name) {
        this.yanaTransfer2Name = yanaTransfer2Name;
    }

    public String getYanaTransfer2AirportName() {
        return yanaTransfer2AirportName;
    }

    public void setYanaTransfer2AirportName(String yanaTransfer2AirportName) {
        this.yanaTransfer2AirportName = yanaTransfer2AirportName;
    }

    public String getYanaTransfer2ArrivalDate() {
        return yanaTransfer2ArrivalDate;
    }

    public void setYanaTransfer2ArrivalDate(String yanaTransfer2ArrivalDate) {
        this.yanaTransfer2ArrivalDate = yanaTransfer2ArrivalDate;
    }

    public String getYanaTransfer2ArrivalTime() {
        return yanaTransfer2ArrivalTime;
    }

    public void setYanaTransfer2ArrivalTime(String yanaTransfer2ArrivalTime) {
        this.yanaTransfer2ArrivalTime = yanaTransfer2ArrivalTime;
    }

    public String getYanaTransfer2FlightId() {
        return yanaTransfer2FlightId;
    }

    public void setYanaTransfer2FlightId(String yanaTransfer2FlightId) {
        this.yanaTransfer2FlightId = yanaTransfer2FlightId;
    }

    public String getYanaTransfer2AirbusCode() {
        return yanaTransfer2AirbusCode;
    }

    public void setYanaTransfer2AirbusCode(String yanaTransfer2AirbusCode) {
        this.yanaTransfer2AirbusCode = yanaTransfer2AirbusCode;
    }

    public String getYanaTransfer2DepartureDate() {
        return yanaTransfer2DepartureDate;
    }

    public void setYanaTransfer2DepartureDate(String yanaTransfer2DepartureDate) {
        this.yanaTransfer2DepartureDate = yanaTransfer2DepartureDate;
    }

    public String getYanaTransfer2DepartureTime() {
        return yanaTransfer2DepartureTime;
    }

    public void setYanaTransfer2DepartureTime(String yanaTransfer2DepartureTime) {
        this.yanaTransfer2DepartureTime = yanaTransfer2DepartureTime;
    }

    public String getYanaTransfer3Name() {
        return yanaTransfer3Name;
    }

    public void setYanaTransfer3Name(String yanaTransfer3Name) {
        this.yanaTransfer3Name = yanaTransfer3Name;
    }

    public String getYanaTransfer3AirportName() {
        return yanaTransfer3AirportName;
    }

    public void setYanaTransfer3AirportName(String yanaTransfer3AirportName) {
        this.yanaTransfer3AirportName = yanaTransfer3AirportName;
    }

    public String getYanaTransfer3ArrivalDate() {
        return yanaTransfer3ArrivalDate;
    }

    public void setYanaTransfer3ArrivalDate(String yanaTransfer3ArrivalDate) {
        this.yanaTransfer3ArrivalDate = yanaTransfer3ArrivalDate;
    }

    public String getYanaTransfer3ArrivalTime() {
        return yanaTransfer3ArrivalTime;
    }

    public void setYanaTransfer3ArrivalTime(String yanaTransfer3ArrivalTime) {
        this.yanaTransfer3ArrivalTime = yanaTransfer3ArrivalTime;
    }

    public String getYanaTransfer3FlightId() {
        return yanaTransfer3FlightId;
    }

    public void setYanaTransfer3FlightId(String yanaTransfer3FlightId) {
        this.yanaTransfer3FlightId = yanaTransfer3FlightId;
    }

    public String getYanaTransfer3AirbusCode() {
        return yanaTransfer3AirbusCode;
    }

    public void setYanaTransfer3AirbusCode(String yanaTransfer3AirbusCode) {
        this.yanaTransfer3AirbusCode = yanaTransfer3AirbusCode;
    }

    public String getYanaTransfer3DepartureDate() {
        return yanaTransfer3DepartureDate;
    }

    public void setYanaTransfer3DepartureDate(String yanaTransfer3DepartureDate) {
        this.yanaTransfer3DepartureDate = yanaTransfer3DepartureDate;
    }

    public String getYanaTransfer3DepartureTime() {
        return yanaTransfer3DepartureTime;
    }

    public void setYanaTransfer3DepartureTime(String yanaTransfer3DepartureTime) {
        this.yanaTransfer3DepartureTime = yanaTransfer3DepartureTime;
    }

    public String getDirectEnaArrivalDate() {
        return DirectEnaArrivalDate;
    }

    public void setDirectEnaArrivalDate(String directEnaArrivalDate) {
        DirectEnaArrivalDate = directEnaArrivalDate;
    }

    public String getDirectEnaArrivalTime() {
        return DirectEnaArrivalTime;
    }

    public void setDirectEnaArrivalTime(String directEnaArrivalTime) {
        DirectEnaArrivalTime = directEnaArrivalTime;
    }

    public String getEnaTransfer1Name() {
        return enaTransfer1Name;
    }

    public void setEnaTransfer1Name(String enaTransfer1Name) {
        this.enaTransfer1Name = enaTransfer1Name;
    }

    public String getEnaTransfer1AirportName() {
        return enaTransfer1AirportName;
    }

    public void setEnaTransfer1AirportName(String enaTransfer1AirportName) {
        this.enaTransfer1AirportName = enaTransfer1AirportName;
    }

    public String getEnaTransfer1FlightId() {
        return enaTransfer1FlightId;
    }

    public void setEnaTransfer1FlightId(String enaTransfer1FlightId) {
        this.enaTransfer1FlightId = enaTransfer1FlightId;
    }

    public String getEnaTransfer1AirbusCode() {
        return enaTransfer1AirbusCode;
    }

    public void setEnaTransfer1AirbusCode(String enaTransfer1AirbusCode) {
        this.enaTransfer1AirbusCode = enaTransfer1AirbusCode;
    }

    public String getEnaTransfer1ArrivalDate() {
        return enaTransfer1ArrivalDate;
    }

    public void setEnaTransfer1ArrivalDate(String enaTransfer1ArrivalDate) {
        this.enaTransfer1ArrivalDate = enaTransfer1ArrivalDate;
    }

    public String getEnaTransfer1ArrivalTime() {
        return enaTransfer1ArrivalTime;
    }

    public void setEnaTransfer1ArrivalTime(String enaTransfer1ArrivalTime) {
        this.enaTransfer1ArrivalTime = enaTransfer1ArrivalTime;
    }

    public String getEnaTransfer1DepartureDate() {
        return enaTransfer1DepartureDate;
    }

    public void setEnaTransfer1DepartureDate(String enaTransfer1DepartureDate) {
        this.enaTransfer1DepartureDate = enaTransfer1DepartureDate;
    }

    public String getEnaTransfer1DepartureTime() {
        return enaTransfer1DepartureTime;
    }

    public void setEnaTransfer1DepartureTime(String enaTransfer1DepartureTime) {
        this.enaTransfer1DepartureTime = enaTransfer1DepartureTime;
    }

    public String getEnaTransfer2Name() {
        return enaTransfer2Name;
    }

    public void setEnaTransfer2Name(String enaTransfer2Name) {
        this.enaTransfer2Name = enaTransfer2Name;
    }

    public String getEnaTransfer2AirportName() {
        return enaTransfer2AirportName;
    }

    public void setEnaTransfer2AirportName(String enaTransfer2AirportName) {
        this.enaTransfer2AirportName = enaTransfer2AirportName;
    }

    public String getEnaTransfer2FlightId() {
        return enaTransfer2FlightId;
    }

    public void setEnaTransfer2FlightId(String enaTransfer2FlightId) {
        this.enaTransfer2FlightId = enaTransfer2FlightId;
    }

    public String getEnaTransfer2AirbusCode() {
        return enaTransfer2AirbusCode;
    }

    public void setEnaTransfer2AirbusCode(String enaTransfer2AirbusCode) {
        this.enaTransfer2AirbusCode = enaTransfer2AirbusCode;
    }

    public String getEnaTransfer2ArrivalDate() {
        return enaTransfer2ArrivalDate;
    }

    public void setEnaTransfer2ArrivalDate(String enaTransfer2ArrivalDate) {
        this.enaTransfer2ArrivalDate = enaTransfer2ArrivalDate;
    }

    public String getEnaTransfer2ArrivalTime() {
        return enaTransfer2ArrivalTime;
    }

    public void setEnaTransfer2ArrivalTime(String enaTransfer2ArrivalTime) {
        this.enaTransfer2ArrivalTime = enaTransfer2ArrivalTime;
    }

    public String getEnaTransfer2DepartureDate() {
        return enaTransfer2DepartureDate;
    }

    public void setEnaTransfer2DepartureDate(String enaTransfer2DepartureDate) {
        this.enaTransfer2DepartureDate = enaTransfer2DepartureDate;
    }

    public String getEnaTransfer2DepartureTime() {
        return enaTransfer2DepartureTime;
    }

    public void setEnaTransfer2DepartureTime(String enaTransfer2DepartureTime) {
        this.enaTransfer2DepartureTime = enaTransfer2DepartureTime;
    }

    public String getEnaTransfer3Name() {
        return enaTransfer3Name;
    }

    public void setEnaTransfer3Name(String enaTransfer3Name) {
        this.enaTransfer3Name = enaTransfer3Name;
    }

    public String getEnaTransfer3AirportName() {
        return enaTransfer3AirportName;
    }

    public void setEnaTransfer3AirportName(String enaTransfer3AirportName) {
        this.enaTransfer3AirportName = enaTransfer3AirportName;
    }

    public String getEnaTransfer3FlightId() {
        return enaTransfer3FlightId;
    }

    public void setEnaTransfer3FlightId(String enaTransfer3FlightId) {
        this.enaTransfer3FlightId = enaTransfer3FlightId;
    }

    public String getEnaTransfer3AirbusCode() {
        return enaTransfer3AirbusCode;
    }

    public void setEnaTransfer3AirbusCode(String enaTransfer3AirbusCode) {
        this.enaTransfer3AirbusCode = enaTransfer3AirbusCode;
    }

    public String getEnaTransfer3ArrivalDate() {
        return enaTransfer3ArrivalDate;
    }

    public void setEnaTransfer3ArrivalDate(String enaTransfer3ArrivalDate) {
        this.enaTransfer3ArrivalDate = enaTransfer3ArrivalDate;
    }

    public String getEnaTransfer3ArrivalTime() {
        return enaTransfer3ArrivalTime;
    }

    public void setEnaTransfer3ArrivalTime(String enaTransfer3ArrivalTime) {
        this.enaTransfer3ArrivalTime = enaTransfer3ArrivalTime;
    }

    public String getEnaTransfer3DepartureDate() {
        return enaTransfer3DepartureDate;
    }

    public void setEnaTransfer3DepartureDate(String enaTransfer3DepartureDate) {
        this.enaTransfer3DepartureDate = enaTransfer3DepartureDate;
    }

    public String getEnaTransfer3DepartureTime() {
        return enaTransfer3DepartureTime;
    }

    public void setEnaTransfer3DepartureTime(String enaTransfer3DepartureTime) {
        this.enaTransfer3DepartureTime = enaTransfer3DepartureTime;
    }

    public String getYanaTransfer1AirlineName() {
        return yanaTransfer1AirlineName;
    }

    public void setYanaTransfer1AirlineName(String yanaTransfer1AirlineName) {
        this.yanaTransfer1AirlineName = yanaTransfer1AirlineName;
    }

    public String getYanaTransfer2AirlineName() {
        return yanaTransfer2AirlineName;
    }

    public void setYanaTransfer2AirlineName(String yanaTransfer2AirlineName) {
        this.yanaTransfer2AirlineName = yanaTransfer2AirlineName;
    }

    public String getYanaTransfer3AirlineName() {
        return yanaTransfer3AirlineName;
    }

    public void setYanaTransfer3AirlineName(String yanaTransfer3AirlineName) {
        this.yanaTransfer3AirlineName = yanaTransfer3AirlineName;
    }

    public String getEnaTransfer1AirlineName() {
        return enaTransfer1AirlineName;
    }

    public void setEnaTransfer1AirlineName(String enaTransfer1AirlineName) {
        this.enaTransfer1AirlineName = enaTransfer1AirlineName;
    }

    public String getEnaTransfer2AirlineName() {
        return enaTransfer2AirlineName;
    }

    public void setEnaTransfer2AirlineName(String enaTransfer2AirlineName) {
        this.enaTransfer2AirlineName = enaTransfer2AirlineName;
    }

    public String getEnaTransfer3AirlineName() {
        return enaTransfer3AirlineName;
    }

    public void setEnaTransfer3AirlineName(String enaTransfer3AirlineName) {
        this.enaTransfer3AirlineName = enaTransfer3AirlineName;
    }

    @Override
    public String toString() {
        return "FlightDetail{" +
                "f_Detail_Id='" + f_Detail_Id + '\'' +
                ", guidline='" + guidline + '\'' +
                ", DirectYanaArrivalDate='" + DirectYanaArrivalDate + '\'' +
                ", DirectYanaArrivalTime='" + DirectYanaArrivalTime + '\'' +
                ", yanaTransfer1Name='" + yanaTransfer1Name + '\'' +
                ", yanaTransfer1AirportName='" + yanaTransfer1AirportName + '\'' +
                ", yanaTransfer1ArrivalDate='" + yanaTransfer1ArrivalDate + '\'' +
                ", yanaTransfer1ArrivalTime='" + yanaTransfer1ArrivalTime + '\'' +
                ", yanaTransfer1FlightId='" + yanaTransfer1FlightId + '\'' +
                ", yanaTransfer1AirbusCode='" + yanaTransfer1AirbusCode + '\'' +
                ", yanaTransfer1DepartureDate='" + yanaTransfer1DepartureDate + '\'' +
                ", yanaTransfer1DepartureTime='" + yanaTransfer1DepartureTime + '\'' +
                ", yanaTransfer2Name='" + yanaTransfer2Name + '\'' +
                ", yanaTransfer2AirportName='" + yanaTransfer2AirportName + '\'' +
                ", yanaTransfer2ArrivalDate='" + yanaTransfer2ArrivalDate + '\'' +
                ", yanaTransfer2ArrivalTime='" + yanaTransfer2ArrivalTime + '\'' +
                ", yanaTransfer2FlightId='" + yanaTransfer2FlightId + '\'' +
                ", yanaTransfer2AirbusCode='" + yanaTransfer2AirbusCode + '\'' +
                ", yanaTransfer2DepartureDate='" + yanaTransfer2DepartureDate + '\'' +
                ", yanaTransfer2DepartureTime='" + yanaTransfer2DepartureTime + '\'' +
                ", yanaTransfer3Name='" + yanaTransfer3Name + '\'' +
                ", yanaTransfer3AirportName='" + yanaTransfer3AirportName + '\'' +
                ", yanaTransfer3ArrivalDate='" + yanaTransfer3ArrivalDate + '\'' +
                ", yanaTransfer3ArrivalTime='" + yanaTransfer3ArrivalTime + '\'' +
                ", yanaTransfer3FlightId='" + yanaTransfer3FlightId + '\'' +
                ", yanaTransfer3AirbusCode='" + yanaTransfer3AirbusCode + '\'' +
                ", yanaTransfer3DepartureDate='" + yanaTransfer3DepartureDate + '\'' +
                ", yanaTransfer3DepartureTime='" + yanaTransfer3DepartureTime + '\'' +
                ", DirectEnaArrivalDate='" + DirectEnaArrivalDate + '\'' +
                ", DirectEnaArrivalTime='" + DirectEnaArrivalTime + '\'' +
                ", enaTransfer1Name='" + enaTransfer1Name + '\'' +
                ", enaTransfer1AirportName='" + enaTransfer1AirportName + '\'' +
                ", enaTransfer1FlightId='" + enaTransfer1FlightId + '\'' +
                ", enaTransfer1AirbusCode='" + enaTransfer1AirbusCode + '\'' +
                ", enaTransfer1ArrivalDate='" + enaTransfer1ArrivalDate + '\'' +
                ", enaTransfer1ArrivalTime='" + enaTransfer1ArrivalTime + '\'' +
                ", enaTransfer1DepartureDate='" + enaTransfer1DepartureDate + '\'' +
                ", enaTransfer1DepartureTime='" + enaTransfer1DepartureTime + '\'' +
                ", enaTransfer2Name='" + enaTransfer2Name + '\'' +
                ", enaTransfer2AirportName='" + enaTransfer2AirportName + '\'' +
                ", enaTransfer2FlightId='" + enaTransfer2FlightId + '\'' +
                ", enaTransfer2AirbusCode='" + enaTransfer2AirbusCode + '\'' +
                ", enaTransfer2ArrivalDate='" + enaTransfer2ArrivalDate + '\'' +
                ", enaTransfer2ArrivalTime='" + enaTransfer2ArrivalTime + '\'' +
                ", enaTransfer2DepartureDate='" + enaTransfer2DepartureDate + '\'' +
                ", enaTransfer2DepartureTime='" + enaTransfer2DepartureTime + '\'' +
                ", enaTransfer3Name='" + enaTransfer3Name + '\'' +
                ", enaTransfer3AirportName='" + enaTransfer3AirportName + '\'' +
                ", enaTransfer3FlightId='" + enaTransfer3FlightId + '\'' +
                ", enaTransfer3AirbusCode='" + enaTransfer3AirbusCode + '\'' +
                ", enaTransfer3ArrivalDate='" + enaTransfer3ArrivalDate + '\'' +
                ", enaTransfer3ArrivalTime='" + enaTransfer3ArrivalTime + '\'' +
                ", enaTransfer3DepartureDate='" + enaTransfer3DepartureDate + '\'' +
                ", enaTransfer3DepartureTime='" + enaTransfer3DepartureTime + '\'' +
                ", yanaTransfer1AirlineName='" + yanaTransfer1AirlineName + '\'' +
                ", yanaTransfer2AirlineName='" + yanaTransfer2AirlineName + '\'' +
                ", yanaTransfer3AirlineName='" + yanaTransfer3AirlineName + '\'' +
                ", enaTransfer1AirlineName='" + enaTransfer1AirlineName + '\'' +
                ", enaTransfer2AirlineName='" + enaTransfer2AirlineName + '\'' +
                ", enaTransfer3AirlineName='" + enaTransfer3AirlineName + '\'' +
                '}';
    }
}
