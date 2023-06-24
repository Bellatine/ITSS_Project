package project.itss.group11.itss.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.itss.group11.itss.Until.ConnectionPool;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.service.Impl.LoginServiceImpl;
import project.itss.group11.itss.service.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private static final Logger logger = LogManager.getLogger(LoginController.class);
    private static LoginService loginService = new LoginServiceImpl();

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Thiết lập giá trị ban đầu
        //System.out.println("Load Oke");
        Constant.pool = ConnectionPool.getInstance("etc/database.config");
        logger.info("Start load all conf");
    }


    @FXML
    public void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();
        logger.info("Start login user: " + username + " , pass: " + password);
        if(loginService.checkLogin(username,password))
            logger.info("Success");
        else logger.info("Error");

        // Xử lý logic đăng nhập ở đây
        // ...
    }

}