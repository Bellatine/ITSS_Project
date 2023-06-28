package project.itss.group11.itss.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class WorkspaceController {
	protected AnchorPane mainWorkspaceAnchorPane;
	public void setMainWorkspaceAnchorPane(AnchorPane mainWorkspaceAnchorPane) {
		this.mainWorkspaceAnchorPane = mainWorkspaceAnchorPane;
	}
	
	public void changeWorkspace(String fxmlPath) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));		
		
		// init workspace
		Parent workspaceRoot = fxmlLoader.load();
		AnchorPane.setTopAnchor(workspaceRoot, 0.0);
		AnchorPane.setBottomAnchor(workspaceRoot, 0.0);
		AnchorPane.setRightAnchor(workspaceRoot, 0.0);
		AnchorPane.setLeftAnchor(workspaceRoot, 0.0);
		mainWorkspaceAnchorPane.getChildren().clear();
		mainWorkspaceAnchorPane.getChildren().add(workspaceRoot);
		
		WorkspaceController workspaceController = fxmlLoader.getController();
		workspaceController.setMainWorkspaceAnchorPane(mainWorkspaceAnchorPane);
	}
}
