package constructor;

public class Time {

    private String workStatus;
    private String workDate;
    private String workTime;
    private String wtFirstName;
    private String wtLastName;
    
    public Time (String workStatus, String workDate, String workTime, String wtFirstName, String wtLastName) {
        this.workStatus = workStatus;
        this.workDate = workDate;
        this.workTime = workTime;
        this.wtFirstName = wtFirstName;
        this.wtLastName = wtLastName;
    }
    
    public String getWorkStatus() {
        return workStatus;
    }
    
    public String getWorkDate() {
        return workDate;
    }
    
    public String getWorkTime() {
        return workTime;
    }
    
    public String getFirstName() {
        return wtFirstName;
    }
    
    public String getLastName() {
        return wtLastName;
    }

}
