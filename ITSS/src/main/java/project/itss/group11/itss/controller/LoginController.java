package project.itss.group11.itss.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Thiết lập giá trị ban đầu
        System.out.println("Load Oke");
    }


    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Xử lý logic đăng nhập ở đây
        // ...
    }

}