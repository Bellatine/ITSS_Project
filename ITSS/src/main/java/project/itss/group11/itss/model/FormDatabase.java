package project.itss.group11.itss.model;
import java.time.LocalDateTime;
public class FormDatabase {
    private int idlog;
    private int idnhanvien;
    private LocalDateTime oldtime;

    public LocalDateTime getOldtime() {
        return oldtime;
    }

    public void setOldtime(LocalDateTime oldtime) {
        this.oldtime = oldtime;
    }

    public int getIdlog() {
        return idlog;
    }

    public void setIdlog(int idlog) {
        this.idlog = idlog;
    }

    private LocalDateTime newtime;
    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public void setNewtime(LocalDateTime newtime) {
        this.newtime = newtime;
    }
    public int getIdnhanvien() {
        return idnhanvien;
    }
    public LocalDateTime getNewtime() {
        return newtime;
    }
}
