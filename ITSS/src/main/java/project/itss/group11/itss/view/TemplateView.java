package project.itss.group11.itss.view;
	
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class TemplateView extends Application{
	private Stage stage;
	
	public void start(Stage stage) throws IOException {
		this.stage = stage;
		showHome();
	}
	
	public void showHome() throws IOException{
		// load file .fxml
		Parent root;
		root = FXMLLoader.load(getClass().getResource("template.fxml"));
		Scene scene = new Scene(root);
		
		// load file .css
		scene.getStylesheets().add(getClass().getResource("template.css").toExternalForm());

		stage.setTitle("Phần mềm chấm công 4.0");
		stage.setScene(scene);
		stage.show();
		
		// Query node de edit giao dien (optional)
//		MenuButton notification = (MenuButton)(scene.lookup("#notification"));
//		System.out.print(notification);
//		notification.setText("Hello");
//		Image bellIcon = new Image(getClass().getResourceAsStream("bell.png"));
//      ImageView bellView = new ImageView(bellIcon);
//      notification.setGraphic(bellView);
//      notification.setText("🔔");
		
		// tao va add nut bam chuc nang vao VBox chua cac nut chuc nang
		VBox mainOptionVBox = (VBox)(scene.lookup("#mainOptionVBox"));		
		Button testOption = createOptionButton("đây là 1 button có tên rất rất là dài để test giao diện");
		mainOptionVBox.getChildren().add(testOption);
		
		// them node vao workspace tai day
		AnchorPane mainWorkspaceAnchorPane = (AnchorPane)(scene.lookup("#mainWorkspaceAnchorPane"));		
//		mainWorkspaceAnchorPane.getChildren().add(...);
	}
	
	private Button createOptionButton(String option) {
		Button btn = new Button();
		btn.setTextAlignment(TextAlignment.CENTER);
		btn.setWrapText(true);
		btn.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn.setText(option);
		return btn;
	}
	
	public static void main(String [] args) {
		launch(args);
	}
}
