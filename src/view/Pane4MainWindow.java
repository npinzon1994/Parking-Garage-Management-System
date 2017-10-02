package view;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Motorcycle;
import model.MotorcycleSpace;
import model.ParkingSpace;
import model.ParkingStructure;
import model.Vehicle;

public class Pane4MainWindow extends Stage {

	private Pane4Create createPane = new Pane4Create();
	
	private VBox timeBox;
	
	private Label currentDate;
	private Label currentTime;
	
	private Button showSpacesBtn;
	private Button newEntryBtn;
	private Button viewEntryBtn;
	
	private BorderPane mainPane;

	private HBox topBox;
	private Scene scene;
	
	public Pane4MainWindow() {
		
		ParkingStructure.getStructure();
		
		mainPane = new BorderPane();
		topBox = new HBox();
		timeBox = new VBox();
		
		
		currentDate = new Label("\t\t\t\t\t\t\t\t\t\t\t\t   " + ParkingStructure.getDate());
		currentTime = new Label("\t\t\t\t\t\t\t\t\t\t\t\t     " + ParkingStructure.getTime());
		
		newEntryBtn = new Button("New Entry");
		viewEntryBtn = new Button("View Entry");
		
		showSpacesBtn = new Button("Show Parking Spots");
		showSpacesBtn.setPrefHeight(160);
		showSpacesBtn.setPrefWidth(160);
		
		timeBox.getChildren().addAll(currentDate, currentTime);
		topBox.getChildren().addAll(newEntryBtn, viewEntryBtn, timeBox);
		mainPane.setTop(topBox);
		
		newEntryBtn.setOnAction( e -> {
			mainPane.getChildren().removeAll();
			mainPane.setCenter(createPane.getPane());
		});
		
		createPane.getCancelButton().setOnAction(e -> {
			mainPane.getChildren().remove(createPane.getPane());
			createPane.getFNameField().clear();
			createPane.getLNameField().clear();
			createPane.getLicensePlateNoField().clear();
			createPane.getSizeBox().getSelectionModel().selectFirst();
			createPane.getTimeslotBox().getSelectionModel().selectFirst();
			createPane.getHandicappedCheckBox().setSelected(false);
		});
		
		createPane.getBookSpotButton().setOnAction(e -> {
			if(createPane.getSizeBox().getValue().equals("Motorcycle")){
				Motorcycle motorcycle = new Motorcycle(createPane.getFNameField().getText(), 
										 createPane.getLNameField().getText(), 
										 createPane.getLicensePlateNoField().getText());
				ParkingSpace motorcycleSpace = new MotorcycleSpace(createPane.getSizeBox().getValue(), motorcycle);
				ParkingStructure.getLevel1().getMotorcycleLot().add(motorcycleSpace);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(createPane.getSizeBox().getValue() + " successfully added to "
									+ "lot on Level 1");
				alert.showAndWait();
				createPane.getFNameField().clear();
				createPane.getLNameField().clear();
				createPane.getLicensePlateNoField().clear();
				createPane.getSizeBox().getSelectionModel().selectFirst();
				createPane.getTimeslotBox().getSelectionModel().selectFirst();
				createPane.getHandicappedCheckBox().setSelected(false);	
			} 
		});
		
		scene = new Scene(mainPane, 600, 600);
		this.setScene(scene);
		this.show();	
	}
	
	
	
	
	public Pane getPane(){
		return mainPane;
	}

}
