package project.itss.group11.itss.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.Employee;
import project.itss.group11.itss.model.TimekeepingOverview;
import project.itss.group11.itss.service.Impl.SearchInfEmployeeUnitServiceImpl;
import project.itss.group11.itss.service.SearchInfEmployeeUnitService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SearchInfEmployeeUnitController extends WorkspaceController implements Initializable {

    private static final SearchInfEmployeeUnitService service = new SearchInfEmployeeUnitServiceImpl();

    @FXML
    private TextField ID_Employee;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private Button search;

    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, Button> view;

    ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        view.setCellFactory(createButtonCellFactory("View", "view-button"));
        employeeObservableList = service.employeeObservableList(Constant.employee.getUnit());
    }
    @FXML

    void onSearchEmplyee(ActionEvent event) {

    }

    private Callback<TableColumn<Employee, Button>, TableCell<Employee, Button>> createButtonCellFactory(String buttonText, String buttonStyleClass){
        return column -> new TableCell<Employee, Button>() {
            private final Button button = new Button(buttonText);

            {
                button.getStyleClass().add(buttonStyleClass);
                button.setOnAction(event -> {
                    // Lấy đối tượng Stage hiện tại
                        try {
                            changeWorkspace("/project/itss/group11/itss/view/XemChiTietNV.fxml");
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                });
            }
            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        };
    }


}
