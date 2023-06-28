package project.itss.group11.itss.view;

import project.itss.group11.itss.controller.ImportFileChamCongController;
import project.itss.group11.itss.controller.WorkspaceController;
import project.itss.group11.itss.controller.TemplateController;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

//public class TemplateView extends Application{
//	// root node of the scene
//	private Parent root;
//	// use to load fxml to root
//	private FXMLLoader rootFxmlLoader;
//	private Scene scene = new Scene(new Button("dummy node"));
//	private Stage stage;
//	
//	// workspace
//	AnchorPane mainWorkspaceAnchorPane;
//	
//	public void start(Stage stage) throws IOException {
//		init(new QLNSController());
//		this.stage = stage;
//		
//		
//		showHome();
//	}
//	
//	public void init(TemplateController myController) {
//		rootFxmlLoader = new FXMLLoader(getClass().getResource("template.fxml"));
//		rootFxmlLoader.setController(myController);
//		try {
//			root = rootFxmlLoader.load();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("template.css").toExternalForm());
//		// init workspace
//		mainWorkspaceAnchorPane = (AnchorPane)(scene.lookup("#mainWorkspaceAnchorPane"));
//	}
//	
//	public void showHome() throws IOException{
//		stage.setTitle("Phần mềm chấm công 4.0");
//		stage.setScene(scene);
//		stage.show();		
//		// Query node de edit giao dien (optional)
////		MenuButton notification = (MenuButton)(scene.lookup("#notification"));
////		System.out.print(notification);
////		notification.setText("Hello");
////		Image bellIcon = new Image(getClass().getResourceAsStream("bell.png"));
////      ImageView bellView = new ImageView(bellIcon);
////      notification.setGraphic(bellView);
////      notification.setText("🔔");
//	}
//	
//	public void addOptionButtons(String... btnNames) {
//		VBox mainOptionVBox = (VBox)(scene.lookup("#mainOptionVBox"));
//		for (String btnName : btnNames) {
//			Button btn = createOptionButton(btnName);
//			mainOptionVBox.getChildren().add(btn);
//		}
//	}
//	
//	public Button createOptionButton(String option) {
//		Button btn = new Button();
//		btn.setTextAlignment(TextAlignment.CENTER);
//		btn.setWrapText(true);
//		btn.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
//		btn.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
//		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//		btn.setText(option);
//		return btn;
//	}
//	
//	public static void main(String [] args) {
//		launch(args);
//	}
//}

// Tat ca cac view can implement TemplateView
// Implement nhu nao thi xem QLNSView
public class TemplateView {
	protected Scene scene = new Scene(new Button("dummy node"));
	protected Stage stage;
	
	protected TemplateController templateController = new TemplateController(this);
	
	//workspace (la phan pane trống ben phai)
	protected AnchorPane mainWorkspaceAnchorPane;
	
	public void init() {
		FXMLLoader rootFxmlLoader = new FXMLLoader(getClass().getResource("template.fxml"));
		rootFxmlLoader.setController(templateController);
		Parent root = null;
		try {
			root = rootFxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("template.css").toExternalForm());
	}
	
	public void showHome() throws IOException{
		stage.setTitle("Phần mềm chấm công 4.0");
		stage.setScene(scene);
		stage.show();		
	}
	
	public Button createOptionButton(String option) {
		Button btn = new Button();
		btn.setTextAlignment(TextAlignment.CENTER);
		btn.setWrapText(true);
		btn.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setMaxSize(Double.MAX_VALUE, 130);
		btn.setText(option);
		option = option.replaceAll(" ", "-");   
		btn.setId(option);
		return btn;
	}
	
	public void addOptionButton(Button btn) {
		VBox mainOptionVBox = (VBox)(scene.lookup("#mainOptionVBox"));
		VBox.setVgrow(btn, Priority.ALWAYS);
		mainOptionVBox.getChildren().add(btn);
	}
	
	public void addToWorkspace(String fxmlPath) throws IOException {
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
	
	public TemplateView(Stage stage) {
		this.stage = stage;
	}
	
	public TemplateView(){
	}
	
	// Can them cac method xu li logout, setting va notification
}