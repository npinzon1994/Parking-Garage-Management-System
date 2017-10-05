package view;

import java.util.HashMap;

import javafx.animation.AnimationTimer;
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
import model.MidSizeCar;
import model.Motorcycle;
import model.ParkingSpace;
import model.ParkingStructure;
import model.Truck;
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

	private long startTime;
	private Label currentTime;
	
	private Label currentDate;

	private Button showSpacesBtn;
	private Button newEntryBtn;
	private Button viewEntriesBtn;

	private BorderPane mainPane;

	private HBox topBox;
	private Scene scene;

	private Motorcycle motorcycle;
	private CompactCar compactCar;
	private MidSizeCar midSizeCar;
	
	private Truck truck;
	

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
		
		startTime = System.currentTimeMillis();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedMillis = System.currentTimeMillis() - startTime ;
                currentTime.setText(Long.toString((elapsedMillis/1000)/60));
            }
        }.start();

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
				Vehicle vehicle = new Motorcycle(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				ParkingStructure.parkOnLevel1(vehicle);
				//ParkingStructure.getLevel1().getMotorcycleSpace().setStartTime(System.currentTimeMillis());
				createNewSpotAlert();
				resetFields();
			} else if (createPane.getSizeBox().getValue().equals("Compact")) {
				Vehicle vehicle = new CompactCar(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				ParkingStructure.parkOnLevel1(vehicle);
				//ParkingStructure.getLevel1().getCompactSpace().setStartTime(System.currentTimeMillis());
				createNewSpotAlert();
				resetFields();
			} else if (createPane.getSizeBox().getValue().equals("Mid Size")) {
				Vehicle vehicle = new MidSizeCar(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				ParkingStructure.parkOnLevel1(vehicle);
				//ParkingStructure.getLevel1().getMidSizeSpace().setStartTime(System.currentTimeMillis());
				createNewSpotAlert();
				resetFields();
			} else if (createPane.getSizeBox().getValue().equals("Truck/Van/SUV")) {
				Vehicle vehicle = new Truck(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
						createPane.getLicensePlateNoField().getText());
				ParkingStructure.parkOnLevel1(vehicle);
				//ParkingStructure.getLevel1().getTruckSpace().setStartTime(System.currentTimeMillis());
				createNewSpotAlert();
				resetFields();
			}
		});
		

		viewEntriesBtn.setOnAction(e -> {
			if (!hasVehicles(ParkingStructure.getLevel1().getMotorcycleLot()) && 
					!hasVehicles(ParkingStructure.getLevel1().getCompactLot()) &&
					!hasVehicles(ParkingStructure.getLevel1().getMidSizeLot()) &&
					!hasVehicles(ParkingStructure.getLevel1().getTruckLot())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Level 1 lot is empty!");
				alert.showAndWait();
			}  else {
				
				
						try {
							viewParked.start(this);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						viewParked.displayParkedMotorcycles();
						viewParked.displayParkedCompactCars();
						viewParked.displayParkedMidSizeCars();
						viewParked.displayParkedTrucks();
					
			
			
//					for(ParkingSpace space: ParkingStructure.getLevel1().getCompactLot().values()){
//						if (space.hasVehicle()) {
//							System.out.println(space.getVehicle());
//							//viewParked.displayParkedMotorcycles(motorcycleSpace);
//						}
//					}
//					
//					for(ParkingSpace space: ParkingStructure.getLevel1().getMidSizeLot().values()){
//						if (space.hasVehicle()) {
//							System.out.println(space.getVehicle());
//							//viewParked.displayParkedMotorcycles(motorcycleSpace);
//						}
//					}
//					
//					for(ParkingSpace space: ParkingStructure.getLevel1().getTruckLot().values()){
//						if (space.hasVehicle()) {
//							System.out.println(space.getVehicle());
//							//viewParked.displayParkedMotorcycles(motorcycleSpace);
//						}
//					}
				
			}
	
//				viewParked.displayParkedCars(midSizeSpace);
//				viewParked.displayParkedCars(truckSpace);
				
				
				
				
				
			

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

	public boolean hasVehicles(HashMap<String, ParkingSpace> map){
		for (ParkingSpace space: map.values()) {
		    if(space.getVehicle() != null){
				return true;
			}
		}
		return false;
	}
	
}
