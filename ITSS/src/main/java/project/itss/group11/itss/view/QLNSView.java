package project.itss.group11.itss.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.stage.FileChooser.ExtensionFilter;
import project.itss.group11.itss.controller.QLNSController;
import project.itss.group11.itss.controller.TemplateController;
import project.itss.group11.itss.model.LogInfor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

// import for open file
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.opencsv.CSVReader;
// Tao view khac: copy y het class nay ve, chi can doc huong dan -----------huong dan----------- o duoi
import com.opencsv.exceptions.CsvException;

//------------------- sua ten class (vd OfficeView) -------------------------------
public class QLNSView extends Application implements TemplateView{
	// root node of the scene
	//private Parent root;
	// use to load fxml to root
	//private FXMLLoader rootFxmlLoader;
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
		// init workspace
		mainWorkspaceAnchorPane = (AnchorPane)(scene.lookup("#mainWorkspaceAnchorPane"));
//----------------  Add button chon chuc nang, button ten "hello world" se co id = "hello-world" --------------------
		addOptionButtons("Thông tin chấm công của tôi", "Xem thông tin chấm công chi tiết của nhân viên", "Xem thông tin chấm công tổng hợp của nhân viên", "Xem yêu cầu chỉnh sửa chấm công", "Import file chấm công");

//---------------------------- Query button de add listener ---------------------------
		Button importOptionButton = (Button)(scene.lookup("#Import-file-chấm-công"));
		importOptionButton.setOnMouseClicked(event -> showFileChooser());
		System.out.print(importOptionButton);
		
		
//---------- Add node vao workspace: mainWorkspaceAnchorPane.getChildren().add(<node muon them>); ---------------
		
	}
	
	public void init() {
		FXMLLoader rootFxmlLoader = new FXMLLoader(getClass().getResource("template.fxml"));
		rootFxmlLoader.setController(templateController);
		Parent root = null;
		try {
			root = rootFxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("template.css").toExternalForm());
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
	
	public void showFileChooser(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Chon file cham cong");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("File cham cong","*.csv"));
		File file = fileChooser.showOpenDialog(stage);
		qlnsController.handleCsvInput(file);
		showImportFileChamCongWorkspace();
	}
	
	public void showImportFileChamCongWorkspace() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("importFileChamCongWorkspace.fxml"));
		//fxmlLoader.setController(templateController);
		VBox workspaceVbox = null;
		try {
			workspaceVbox = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// init workspace
		AnchorPane.setTopAnchor(workspaceVbox, 0.0);
		AnchorPane.setBottomAnchor(workspaceVbox, 0.0);
		AnchorPane.setRightAnchor(workspaceVbox, 0.0);
		AnchorPane.setLeftAnchor(workspaceVbox, 0.0);
		mainWorkspaceAnchorPane.getChildren().add(workspaceVbox);
		System.out.println(workspaceVbox);
		
		qlnsController.handleShowTable();
		//workspaceVbox.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		//workspaceVbox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//		node.prefHeight(Control.USE_COMPUTED_SIZE);
//		node.prefWidth(Control.USE_COMPUTED_SIZE);
//		node.maxHeight(Double.MAX_VALUE);
//		node.maxWidth(Double.MAX_VALUE);
	}
	
	public void showTable(ArrayList<LogInfor> inputList, ArrayList<Boolean> isDuplicate) {
//		stage.setScene(scene);
//		stage.show();
		mainWorkspaceAnchorPane.applyCss();
		mainWorkspaceAnchorPane.layout();
		TableView<LogInfor> table = (TableView<LogInfor>)(mainWorkspaceAnchorPane.lookup("#importFileChamCongTable"));
		ObservableList<LogInfor> previewList = FXCollections.observableArrayList(inputList);
		TableColumn idColumn = table.getColumns().get(0);
		TableColumn timeColumn = table.getColumns().get(1);
		TableColumn deviceColumn = table.getColumns().get(2);
		TableColumn selectColumn = table.getColumns().get(3);
		idColumn.setCellValueFactory(new PropertyValueFactory<LogInfor, Integer>("employeeID"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<LogInfor, LocalDateTime>("timeStamp"));
		deviceColumn.setCellValueFactory(new PropertyValueFactory<LogInfor, Integer>("device"));
		//selectColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		
		//ArrayList<CheckBox> checkedList;
		
		Callback<TableColumn<LogInfor, String>, TableCell<LogInfor, String>> cellFactory
        = //
        new Callback<TableColumn<LogInfor, String>, TableCell<LogInfor, String>>() {
	    @Override
		    public TableCell call(final TableColumn<LogInfor, String> param) {
		        final TableCell<LogInfor, String> cell = new TableCell<LogInfor, String>() {
		
		            final CheckBox btn = new CheckBox();
		         
		            @Override
		            public void updateItem(String item, boolean empty) {
		                super.updateItem(item, empty);
		                if (empty) {
		                    setGraphic(null);
		                    setText(null);
		                } else {
		                	
		                    btn.setOnAction(event -> {
		                        
		                    });
		                    setGraphic(btn);
		                    setText(null);
		                }
		            }
		        };
		        return cell;
		    }
		};
		

		
		selectColumn.setCellFactory(cellFactory);
		table.setItems(previewList);
		
		Button importButton = (Button)(mainWorkspaceAnchorPane.lookup("#importButton"));
		
		ArrayList<Boolean> checkedList;
//		importButton.setOnMouseClicked(event -> {
//			for(int i=0; i<= table.getItems().size(); i++) {
//				System.out.println((((CheckBox)(selectColumn.getCellData(0))).isSelected()));
//			}
//		});
		System.out.println(selectColumn.getGraphic());
	    
	}
//	private Desktop desktop = Desktop.getDesktop();
//	private void openFile(File file) {
//		 try {
//			 desktop.open(file);
//		 } catch (IOException ex) {
//			 Logger.getLogger(
//					 getClass().getName()).log(
//			 Level.SEVERE, null, ex);
//		 }
//	 }
	
	public static void main(String [] args) {
		launch(args);
	}
}
