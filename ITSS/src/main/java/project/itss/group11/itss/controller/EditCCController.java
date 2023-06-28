package project.itss.group11.itss.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import project.itss.group11.itss.HelloApplication;
import project.itss.group11.itss.Until.ConnectionPool;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.Form;
import project.itss.group11.itss.model.TimekeepingOverview;
import project.itss.group11.itss.service.IFormOverviewService;
import project.itss.group11.itss.service.Impl.FormOverviewServiceImpl;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EditCCController {
    IFormOverviewService formOverviewService =  new FormOverviewServiceImpl();
    ObservableList<Form> dataList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Form, Integer> idnv;
    @FXML
    private TableColumn<Form, LocalDateTime> oldT;
    @FXML
    private TableColumn<Form, LocalDateTime> newT;
    @FXML
    private TableColumn<Form, Button> updateButton;

    @FXML
    private TableView<Form> tableView;

    public void initialize()
    {
        idnv.setCellValueFactory(new PropertyValueFactory<>("idnv"));
        oldT.setCellValueFactory(new PropertyValueFactory<>("oldT"));
        newT.setCellValueFactory(new PropertyValueFactory<>("newT"));
        //updateButton.setCellFactory(createButtonCellFactory("Update", "update-button"));
        dataList = formOverviewService.getFormData();
        tableView.setItems(dataList);
    }

}
