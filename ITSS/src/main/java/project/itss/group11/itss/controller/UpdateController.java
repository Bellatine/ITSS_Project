package project.itss.group11.itss.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.itss.group11.itss.HelloApplication;
import project.itss.group11.itss.Until.ConnectionPool;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class UpdateController {

    @FXML
    private Label idLabel;

    @FXML
    private Label oldTimestampLabel;

    @FXML
    private TextField timestampTextField;

    @FXML
    private Button rejectButton;

    @FXML
    private Button acceptButton;

    public void initialize() {
/*      idLabel.setText(Integer.toString(form.getIdnv()));
        oldTimestampLabel.setText(form.getOldT().toString());*/
        return;
    }
    @FXML
    private void handleRejectButton() {
        return;// Xử lý sự kiện khi nhấn nút "Từ chối"
    }

    @FXML
    private void handleAcceptButton() {
        return;// Xử lý sự kiện khi nhấn nút "Đồng ý"
    }
}
