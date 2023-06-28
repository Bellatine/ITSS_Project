package project.itss.group11.itss.view;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeeView extends TemplateView{

	public EmployeeView() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeView(Stage stage) {
		this.stage = stage;
	}
	
	public void show() throws IOException {
		init();
		showHome();
		// init workspace
		mainWorkspaceAnchorPane = (AnchorPane)(scene.lookup("#mainWorkspaceAnchorPane"));
		Button importOptionButton = createOptionButton("Xem chấm công");
		importOptionButton.setOnMouseClicked(event -> {
			try {
				addToWorkspace("XemTQNV.fxml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		addOptionButton(importOptionButton);
	}
}
