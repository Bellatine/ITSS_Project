package project.itss.group11.itss.model;
import java.time.LocalDateTime;
public class FormDatabase {
    private int idnhanvien;
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
