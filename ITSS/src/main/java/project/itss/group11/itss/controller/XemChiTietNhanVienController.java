package project.itss.group11.itss.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.itss.group11.itss.HelloApplication;
import project.itss.group11.itss.Until.ConnectionPool;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.TimekeepingDetail;
import project.itss.group11.itss.model.TimekeepingOverview;
import project.itss.group11.itss.service.IEmployeeDetailTimekeeping;
import project.itss.group11.itss.service.Impl.EmployeeDetailTimekeeping;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class XemChiTietNhanVienController {

    private IEmployeeDetailTimekeeping employeeDetailTimekeeping = new EmployeeDetailTimekeeping();
    ObservableList<TimekeepingDetail> timekeepingDetails = FXCollections.observableArrayList();
    LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 8, 00, 0);
    LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 17, 30, 0);

    @FXML
    private Text username;

    @FXML
    private TableColumn<TimekeepingDetail, String> comeLate;

    @FXML
    private Text date;

    @FXML
    private TableColumn<TimekeepingDetail, Integer> machine;

    @FXML
    private TableColumn<TimekeepingDetail, String> returnEarly;

    @FXML
    private TableColumn<TimekeepingDetail, String> time;

    @FXML
    private TableColumn<TimekeepingDetail, String> type;

    @FXML
    private TableView<TimekeepingDetail> tableview;
    public void initialize(){

        Constant.pool = ConnectionPool.getInstance("etc/database.config");
        date.setText(XemTQNVController.localDate.toString());
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        machine.setCellValueFactory(new PropertyValueFactory<>("machine"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        returnEarly.setCellValueFactory(new PropertyValueFactory<>("returnEarly"));
        comeLate.setCellValueFactory(new PropertyValueFactory<>("comeLate"));

        timekeepingDetails = employeeDetailTimekeeping.getDetailTimekeepingByDay(XemTQNVController.localDate,startTime,endTime);
        tableview.setItems(timekeepingDetails);


    }
    @FXML
    void backToPrvPage(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("XemTQNV.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error at backToPrvPage function at XemChiTietNhanVienController");
        }
    }




}
