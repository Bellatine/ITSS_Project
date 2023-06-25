package project.itss.group11.itss.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import project.itss.group11.itss.view.TemplateView;

public class TemplateController {
	private TemplateView templateView = new TemplateView();
	
    @FXML
    private MenuButton notificationMenuButton;

    @FXML
    private MenuButton dropdownMenuButton;

    @FXML
    private VBox mainOptionVBox;

    @FXML
    private AnchorPane mainWorkspaceAnchorPane;

}
