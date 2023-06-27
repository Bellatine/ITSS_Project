package project.itss.group11.itss.model;

import java.time.LocalDateTime;

public class LogInfor {
    private int employee_id;
    private LocalDateTime timeStamp;
    private int device;

    public int getEmployeeID() {
        return employee_id;
    }

    public void setEmployeeID(int ID) {
        this.employee_id = ID;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
    }
}
