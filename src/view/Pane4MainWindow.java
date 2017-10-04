package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CompactCar;
import model.CompactSpace;
import model.MidSizeCar;
import model.MidSizeSpace;
import model.Motorcycle;
import model.ParkingSpace;
import model.ParkingStructure;
import model.Truck;
import model.TruckSpace;
import model.Vehicle;

public class Pane4MainWindow extends Stage {

	private Pane4Create createPane;

	private ParkingSpace motorcycleSpace;
	private ParkingSpace compactSpace;
	private ParkingSpace midSizeSpace;
	private ParkingSpace truckSpace;
	
	private ViewParkedWindow viewParked = new ViewParkedWindow();

	private StackPane root;
	
	private VBox timeBox;

	private Label currentDate;
	private Label currentTime;

	private Button showSpacesBtn;
	private Button newEntryBtn;
	private Button viewEntriesBtn;

	private BorderPane mainPane;

	private HBox topBox;
	private Scene scene;

	private Motorcycle motorcycle;
	private CompactCar compactCar;
	private MidSizeCar midSizeCar;
	
	private Vehicle vehicle;
	
	private Truck truck;
	
	private Iterator<ParkingSpace> iterator;
	

	public Pane4MainWindow() {

		ParkingStructure.getStructure();

		createPane = new Pane4Create();

		root = new StackPane();
		mainPane = new BorderPane();
		topBox = new HBox();
		timeBox = new VBox();

		currentDate = new Label("\t\t\t\t\t\t\t\t\t\t\t       " + ParkingStructure.getDate());
		currentTime = new Label("\t\t\t\t\t\t\t\t\t\t\t          " + ParkingStructure.getTime());

		newEntryBtn = new Button("New Entry");
		viewEntriesBtn = new Button("View Entries");

		showSpacesBtn = new Button("Show Parking Spots");
		showSpacesBtn.setPrefHeight(160);
		showSpacesBtn.setPrefWidth(160);

		timeBox.getChildren().addAll(currentDate, currentTime);
		topBox.getChildren().addAll(newEntryBtn, viewEntriesBtn, timeBox);
		mainPane.setTop(topBox);
		root.getChildren().add(mainPane);

		newEntryBtn.setOnAction(e -> {
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
			if (createPane.getSizeBox().getValue().equals("Motorcycle")) {
				vehicle = new Motorcycle(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				ParkingStructure.parkOnLevel1(vehicle);
				createNewSpotAlert();
				resetFields();
			} else if (createPane.getSizeBox().getValue().equals("Compact")) {
				vehicle = new CompactCar(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				compactSpace = new CompactSpace(vehicle);
				ParkingStructure.parkOnLevel1(vehicle);
				createNewSpotAlert();
				resetFields();
			} else if (createPane.getSizeBox().getValue().equals("Mid Size")) {
				vehicle = new MidSizeCar(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				midSizeSpace = new MidSizeSpace(vehicle);
				ParkingStructure.parkOnLevel1(vehicle);
				createNewSpotAlert();
				resetFields();
			} else if (createPane.getSizeBox().getValue().equals("Truck/Van/SUV")) {
				vehicle = new Truck(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				truckSpace = new TruckSpace(vehicle);
				ParkingStructure.parkOnLevel1(vehicle);
				createNewSpotAlert();
				resetFields();
			}
		});
		

		viewEntriesBtn.setOnAction(e -> {
			if (!hasMotorcycles(ParkingStructure.getLevel1().getMotorcycleLot())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Level 1 lot is empty!");
				alert.showAndWait();
			}  else {
					ParkingStructure.getLevel1().getMotorcycleLot().entrySet().stream().forEach
					(vehicle -> {
						System.out.println(vehicle.getValue().getVehicle());
						//viewParked.displayParkedMotorcycles(motorcycleSpace);
					});
			
					ParkingStructure.getLevel1().getCompactLot().entrySet().stream().forEach
					(vehicle -> {
						System.out.println(vehicle.getValue().getVehicle());
						//viewParked.displayParkedCompactCars(compactSpace);
					});
					
					ParkingStructure.getLevel1().getMidSizeLot().entrySet().stream().forEach
					(vehicle -> {
						System.out.println(vehicle);
						//viewParked.displayParkedMotorcycles(motorcycleSpace);
					});
			
					ParkingStructure.getLevel1().getTruckLot().entrySet().stream().forEach
					(vehicle -> {
						System.out.println(vehicle);
						//viewParked.displayParkedCompactCars(compactSpace);
					});
			}
//				viewParked.displayParkedCars(midSizeSpace);
//				viewParked.displayParkedCars(truckSpace);
				
//				try {
//					viewParked.start(this);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				
				
			

		});

		scene = new Scene(root, 600, 600);
		this.setScene(scene);
		this.show();
	}
	
	public void resetFields(){
		createPane.getFNameField().clear();
		createPane.getLNameField().clear();
		createPane.getLicensePlateNoField().clear();
		createPane.getSizeBox().getSelectionModel().selectFirst();
		createPane.getTimeslotBox().getSelectionModel().selectFirst();
		createPane.getHandicappedCheckBox().setSelected(false);
	}
	
	public Alert createNewSpotAlert(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(createPane.getFNameField().getText() + " " + createPane.getLNameField().getText() + 
				"'s vehicle has been parked on level 1");
		alert.showAndWait();
		return alert;
	}
	
	public void displayParkedCompactCars(Vehicle vehicle, ParkingSpace space){
		if (vehicle != null && space != null){
			System.out.println("Vehicles currently in lot:");
			System.out.println("---------------------------------------");
			System.out.println(viewParked.getTempCompactList());
			System.out.println();
		}
		
		
	}
	
	public void displayParkedMotorcycles(Vehicle vehicle, ParkingSpace space){
		if (vehicle != null && space != null){
			System.out.println("Vehicles currently in lot:");
			System.out.println("---------------------------------------");
			System.out.println(viewParked.getTempMotorcycleList());
			System.out.println();
		}
		
		
	}

	public Pane getPane() {
		return mainPane;
	}
	
	public boolean isMotorcycle(Vehicle vehicle){
		if(vehicle instanceof Motorcycle){
			return true;
		}
		return false;
	}
	
	public boolean isCompact(Vehicle vehicle){
		if(vehicle instanceof CompactCar){
			return true;
		}
		return false;
	}

	public boolean hasMotorcycles(HashMap<String, ParkingSpace> map){
		ArrayList<ParkingSpace> tempSpaces = new ArrayList<ParkingSpace>();
		for (ParkingSpace space: map.values()) {
		    tempSpaces.add(space);
		    
		}
		for(ParkingSpace space : tempSpaces){
			if(space.getVehicle() != null){
				return true;
			}
		}
		return false;
	}
	
}
