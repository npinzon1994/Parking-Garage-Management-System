package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pane4MainWindow extends Stage {

	private Pane4Create createPane = new Pane4Create();
	
	private Button showSpacesBtn;
	private Button newEntryBtn;
	private Button viewEntryBtn;
	
	private BorderPane mainPane;

	private HBox topBox;
	private Scene scene;
	
	public Pane4MainWindow() {
		
		newEntryBtn = new Button("New Entry");
		viewEntryBtn = new Button("View Entry");
		
		showSpacesBtn = new Button("Show Parking Spots");
		showSpacesBtn.setPrefHeight(160);
		showSpacesBtn.setPrefWidth(160);
		
		mainPane = new BorderPane();
		topBox = new HBox();
		
//		mainPane.setPadding(new Insets(15));
//		rightBox.setPadding(new Insets(15));
		
		topBox.getChildren().addAll(newEntryBtn, viewEntryBtn);
		mainPane.setTop(topBox);
		
		newEntryBtn.setOnAction( e -> {
			mainPane.getChildren().removeAll();
			mainPane.setCenter(createPane.getPane());
		});
		
		createPane.getCancelButton().setOnAction(e -> {
			mainPane.getChildren().remove(createPane.getPane());
			createPane.getFNameField().clear();
			createPane.getLNameField().clear();
			createPane.getBox().getSelectionModel().selectFirst();
		});
		
		scene = new Scene(mainPane, 600, 600);
		this.setScene(scene);
		this.show();	
	}
	
	
	
	
	public Pane getPane(){
		return mainPane;
	}

}
