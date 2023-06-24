package project.itss.group11.itss.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class XemChiTietNhanVienController {
    public static LocalDate localDate;

    @FXML
    private Text username;

    @FXML
    private TableColumn<?, ?> comeLate;

    @FXML
    private Text date;

    @FXML
    private TableColumn<?, ?> machine;

    @FXML
    private TableColumn<?, ?> returnEarly;

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    private TableColumn<?, ?> type;
    public void initialize(){
        date.setText(localDate.toString());
    }




}
