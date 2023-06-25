package project.itss.group11.itss.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import project.itss.group11.itss.HelloApplication;

import java.io.IOException;

public class UserTemplateController {

    @FXML
    private Button timekeepingRequestBtn;

    @FXML
    private Button timekeepingViewBtn;

    @FXML
    void selectRequestingToEditTimekeepingScreen(ActionEvent event) {

    }

    @FXML
    void selectViewingTimekeepingScreen(ActionEvent event)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("XemTQNV.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error at selectViewingTimekeepingScreen function at UserTemplateController");
        }
    }

}