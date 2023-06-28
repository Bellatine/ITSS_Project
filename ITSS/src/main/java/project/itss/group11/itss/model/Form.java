package project.itss.group11.itss.model;

import java.time.LocalDateTime;

public class Form {
    private int idnv;
    private LocalDateTime oldT;
    private LocalDateTime newT;
    public Form() {
    }

    public Form(int idnv, LocalDateTime oldT, LocalDateTime newT) {
        this.idnv = idnv;
        this.oldT = oldT;
        this.newT = newT;
    }

    public int getIdnv() {
        return idnv;
    }
    public void setIdnv(int idnv) {
        this.idnv = idnv;
    }
    public LocalDateTime getOldT() {
        return oldT;
    }
    public void setOldT(LocalDateTime oldT) {
        this.oldT = oldT;
    }
    public LocalDateTime getNewT() {
        return newT;
    }
    public void setNewT(LocalDateTime newT) {
        this.newT = newT;
    }
}
