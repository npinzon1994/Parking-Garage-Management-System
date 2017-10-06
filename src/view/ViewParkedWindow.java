package view;

import com.sun.javafx.scene.control.skin.TableHeaderRow;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ParkingSpace;
import model.ParkingStructure;
import model.Vehicle;

public class ViewParkedWindow extends Application {

	private Pane4MainWindow mainWindowPane;
	private StackPane root;
	private String[] nameTokens;

	private HBox mainBox;
	private VBox listBox;
	private VBox buttonBox;
	private ListView<String> listView;
	
	private TableView<Vehicle> tableView;
	private TableColumn<Vehicle, String> lastNameColumn;
	private TableColumn<Vehicle, String> firstNameColumn;
	private TableColumn<Vehicle, String> tagNumberColumn;

	private Button detailsBtn;
	private Button cancelBtn;
	private Button removeBtn;

	private Scene scene;
	private Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		listView = new ListView<>();
		tableView = new TableView<>();
		
		
		tableView.widthProperty().addListener(new ChangeListener<Number>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth)
		    {
		        TableHeaderRow header = (TableHeaderRow) tableView.lookup("TableHeaderRow");
		        header.reorderingProperty().addListener(new ChangeListener<Boolean>() {
		            @Override
		            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		                header.setReordering(false);
		            }
		        });
		    }
		});
		
		lastNameColumn = new TableColumn("Last Name");
		lastNameColumn.setPrefWidth(100);
		//lastNameColumn.setEditable(false);
		lastNameColumn.setResizable(false);
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("lastName"));
	
		firstNameColumn = new TableColumn("First Name");
		//firstNameColumn.setEditable(false);
		firstNameColumn.setResizable(false);
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("firstName"));
		
		tagNumberColumn = new TableColumn("Tag #");
		//tagNumberColumn.setEditable(false);
		tagNumberColumn.setResizable(false);
		tagNumberColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("tagNumber"));
		
		tableView.getColumns().addAll(lastNameColumn, firstNameColumn, tagNumberColumn);
		tableView.setItems(displayParkedCars());

		detailsBtn = new Button("Details");
		cancelBtn = new Button("Back");
		removeBtn = new Button("Remove");

		cancelBtn.setOnAction(e -> {
			stage.close();
		});

		removeBtn.setOnAction(e -> {
			
			
				ObservableList<Vehicle> vehiclesSelected, allVehicles;
				allVehicles = tableView.getItems();
				vehiclesSelected = tableView.getSelectionModel().getSelectedItems();
				for(Vehicle vehicle : vehiclesSelected){
					if(vehicle.equals(tableView.getSelectionModel().getSelectedItem())){
						allVehicles.remove(vehicle);
						ParkingStructure.unparkOnLevel1(vehicle);
					}
					
					
				}
		});

		mainBox = new HBox(10);
		mainBox.setPadding(new Insets(10));

		listBox = new VBox(5);
		
		listBox.getChildren().add(tableView);

		buttonBox = new VBox(10);
		buttonBox.getChildren().addAll(detailsBtn, removeBtn, cancelBtn);

		mainBox.getChildren().addAll(listBox, buttonBox);
		root = new StackPane(mainBox);

		scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.show();

	}

//	public void displayParkedMotorcycles() {
//		for (ParkingSpace space : ParkingStructure.getLevel1().getMotorcycleLot().values()) {
//			Vehicle vehicle = space.getVehicle();
//			if (vehicle != null) {
//				tableView.setItems(getMotorcycles());
//			}
//		}
//
//	}
//
//	public void displayParkedCompactCars() {
//		for (ParkingSpace space : ParkingStructure.getLevel1().getCompactLot().values()) {
//			Vehicle vehicle = space.getVehicle();
//			if (vehicle != null) {
//				tableView.setItems(getCompactCars());			}
//		}
//
//	}
//
//	public void displayParkedMidSizeCars() {
//		for (ParkingSpace space : ParkingStructure.getLevel1().getMidSizeLot().values()) {
//			Vehicle vehicle = space.getVehicle();
//			if (vehicle != null) {
//				tableView.setItems(getMidSizeCars());			}
//		}
//
//	}
//
//	public void displayParkedTrucks() {
//		for (ParkingSpace space : ParkingStructure.getLevel1().getTruckLot().values()) {
//			Vehicle vehicle = space.getVehicle();
//			if (vehicle != null) {
//				tableView.setItems(getTrucks());			}
//		}
//
//	}
	
	public ObservableList<Vehicle> displayParkedCars(){
		ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
		for(ParkingSpace space : ParkingStructure.getLevel1().getMotorcycleLot().values()){
			if(space.getVehicle() != null){
				vehicles.add(space.getVehicle());
			}
			
		}
		for(ParkingSpace space : ParkingStructure.getLevel1().getCompactLot().values()){
			if(space.getVehicle() != null){
				vehicles.add(space.getVehicle());
			}
			
		}
		for(ParkingSpace space : ParkingStructure.getLevel1().getMidSizeLot().values()){
			if(space.getVehicle() != null){
				vehicles.add(space.getVehicle());
			}
			
		}
		for(ParkingSpace space : ParkingStructure.getLevel1().getTruckLot().values()){
			if(space.getVehicle() != null){
				vehicles.add(space.getVehicle());
			}
			
		}
		return vehicles;
	}
	
//	public ObservableList<Vehicle> displayParkedCompactCars(){
//		ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
//		for(ParkingSpace space : ParkingStructure.getLevel1().getCompactLot().values()){
//			if(space.getVehicle() != null){
//				vehicles.add(space.getVehicle());
//				tableView.setItems(vehicles);
//			}
//			
//		}
//		return vehicles;
//	}
//	
//	public ObservableList<Vehicle> displayParkedMidSizeCars(){
//		ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
//		for(ParkingSpace space : ParkingStructure.getLevel1().getMidSizeLot().values()){
//			if(space.getVehicle() != null){
//				vehicles.add(space.getVehicle());
//				tableView.setItems(vehicles);
//			}
//			
//		}
//		return vehicles;
//	}
//	
//	public ObservableList<Vehicle> displayParkedTrucks(){
//		ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
//		for(ParkingSpace space : ParkingStructure.getLevel1().getTruckLot().values()){
//			if(space.getVehicle() != null){
//				vehicles.add(space.getVehicle());
//				tableView.setItems(vehicles);
//			}
//			
//		}
//		return vehicles;
//	}

	public Stage getStage() {
		return this.stage;
	}
	
	public Scene getScene(){
		return this.scene;
	}

	public VBox getListBox() {
		return listBox;
	}
	

}
