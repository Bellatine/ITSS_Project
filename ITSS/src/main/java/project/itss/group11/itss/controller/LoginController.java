package project.itss.group11.itss.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project.itss.group11.itss.HelloApplication;
import project.itss.group11.itss.Until.ConnectionPool;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.Employee;
import project.itss.group11.itss.service.Impl.LoginServiceImpl;
import project.itss.group11.itss.view.ManagerView;
import project.itss.group11.itss.view.QLNSView;
import project.itss.group11.itss.service.LoginService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import project.itss.group11.itss.view.EmployeeView;

// no longer need to extends BaseController
public class LoginController extends BaseController implements Initializable{

    private static LoginService loginService = new LoginServiceImpl();

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    private Employee user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Thiết lập giá trị ban đầu
        //System.out.println("Load Oke");
        Constant.pool = ConnectionPool.getInstance("etc/database.config");
        //logger.info("Start load all conf");
    }


    @FXML
    public void handleLogin() throws IOException {

        String username = usernameField.getText();
        String password = passwordField.getText();

        logger.info("Start login user: " + username + " , pass: " + password);
        if(loginService.checkLogin(username,password)) {
            logger.info("Login Success");
            Constant.employee = loginService.getUserInfor(Integer.parseInt(username));
            if(Constant.employee.getRole()==3) {
                //changeScene("staff/UserTemplate.fxml");
            	EmployeeView employeeView = new EmployeeView(HelloApplication.MAIN_STAGE);
            	employeeView.show();
            }else if(Constant.employee.getRole()==1) {
            	QLNSView qlnsView = new QLNSView(HelloApplication.MAIN_STAGE);
            	qlnsView.show();
            }else if(Constant.employee.getRole()==2){
                ManagerView managerView = new ManagerView(HelloApplication.MAIN_STAGE);
                managerView.show();
            }
        }
        else logger.info("Login Fail");

        // Xử lý logic đăng nhập ở đây
        // ...
    }

}