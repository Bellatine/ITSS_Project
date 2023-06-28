package project.itss.group11.itss.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchInfEmployeeUnitController extends WorkspaceController implements Initializable {

    @FXML
    private TextField ID_Employee;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private Button search;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> view;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML

    void onSearchEmplyee(ActionEvent event) {

    }


}
