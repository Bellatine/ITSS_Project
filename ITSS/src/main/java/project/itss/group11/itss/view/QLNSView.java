package project.itss.group11.itss.view;
	
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import project.itss.group11.itss.controller.QLNSController;
import project.itss.group11.itss.controller.TemplateController;
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

// Tao view khac: copy y het class nay ve, chi can doc huong dan -----------huong dan----------- o duoi

//------------------- sua ten class (vd OfficeView) -------------------------------
public class QLNSView extends Application implements TemplateView{
	// root node of the scene
	private Parent root;
	// use to load fxml to root
	private FXMLLoader rootFxmlLoader;
	private Scene scene = new Scene(new Button("dummy node"));
	private Stage stage;
	
	private TemplateController templateController = new TemplateController(this);
	
//------------- Them controller cua minh -----------------	
	private QLNSController qlnsController = new QLNSController(this);
	
	//workspace (la phan pane trống ben phai)
	AnchorPane mainWorkspaceAnchorPane;
	
	
	
	public void start(Stage stage) throws IOException {
		init();
		this.stage = stage;	
		showHome();
		
//----------------  Add button chon chuc nang, button ten "hello world" se co id = "hello-world" --------------------
		addOptionButtons("Thông tin chấm công của tôi", "Xem thông tin chấm công chi tiết của nhân viên", "Xem thông tin chấm công tổng hợp của nhân viên", "Xem yêu cầu chỉnh sửa chấm công", "Import file chấm công");

//---------------------------- Query button de add listener ---------------------------
		Button importOptionButton = (Button)(scene.lookup("#Import-file-chấm-công"));
		importOptionButton.setOnMouseClicked(event -> showFileChooser());
		System.out.print(importOptionButton);
		
		
//---------- Add node vao workspace: mainWorkspaceAnchorPane.getChildren().add(<node muon them>); ---------------
		
	}
	
	public void init() {
		rootFxmlLoader = new FXMLLoader(getClass().getResource("template.fxml"));
		rootFxmlLoader.setController(templateController);
		try {
			root = rootFxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("template.css").toExternalForm());
		// init workspace
		mainWorkspaceAnchorPane = (AnchorPane)(scene.lookup("#mainWorkspaceAnchorPane"));
	}
	
	public void showHome() throws IOException{
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
	}
	
	public Button createOptionButton(String option) {
		Button btn = new Button();
		btn.setTextAlignment(TextAlignment.CENTER);
		btn.setWrapText(true);
		btn.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn.setText(option);
		option = option.replaceAll(" ", "-");   
		btn.setId(option);
		return btn;
	}
	
	public void addOptionButtons(String... btnNames) {
		VBox mainOptionVBox = (VBox)(scene.lookup("#mainOptionVBox"));
		for (String btnName : btnNames) {
			Button btn = createOptionButton(btnName);
			mainOptionVBox.getChildren().add(btn);
		}
	}
	
	public void showFileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Chon file cham cong");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("File cham cong","*.txt"));
		File selectedFile = fileChooser.showOpenDialog(stage);
	}
	
	public static void main(String [] args) {
		launch(args);
	}
}
