package view;

import java.io.Serializable;
import java.util.Map;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class Pane4MainWindow extends Stage implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private Pane4Create createPane;

	private ViewParkedWindow viewParked = new ViewParkedWindow();
	private Stage freeSpaceStage;

	private MenuBar menuBar;
	private Menu fileMenu;

	private MenuItem newSpaceItem;
	private MenuItem viewSpacesItem;
	private MenuItem quitItem;
	private MenuItem freeSpaces;

	private StackPane root;

	private VBox timeBox;

	private long startTime;
	private Label currentTime;

	private Label currentDate;

	private Button showSpacesBtn;
	private Button newEntryBtn;
	private Button viewEntriesBtn;

	private Vehicle vehicle;

	private BorderPane mainPane;

	private HBox topBox;
	private Scene scene;

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

		newSpaceItem = new MenuItem("New Entry");
		viewSpacesItem = new MenuItem("View Entries");
		quitItem = new MenuItem("Quit");
		freeSpaces = new MenuItem("View Available Spaces");

		freeSpaces.setOnAction(e -> {
			TableColumn<ParkingSpace, String> spaceColumn = new TableColumn<>("Space Type");
			spaceColumn.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("spaceType"));

			TableColumn<ParkingSpace, String> numberColumn = new TableColumn<>("Space No.");
			numberColumn.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("id"));

			TableColumn<ParkingSpace, Integer> levelColumn = new TableColumn<>("Level");
			levelColumn.setCellValueFactory(new PropertyValueFactory<ParkingSpace, Integer>("level"));
			TableView<ParkingSpace> table = new TableView<>();

			VBox box = new VBox();
			table.getColumns().addAll(spaceColumn, numberColumn, levelColumn);
			table.setItems(getEmptySpaces());
			box.getChildren().add(table);
			Scene scene = new Scene(box);
			freeSpaceStage = new Stage();
			freeSpaceStage.setScene(scene);
			freeSpaceStage.setResizable(false);
			freeSpaceStage.show();

		});

		fileMenu = new Menu("File");
		menuBar = new MenuBar();

		fileMenu.getItems().addAll(newSpaceItem, viewSpacesItem, freeSpaces, quitItem);
		menuBar.getMenus().add(fileMenu);

		showSpacesBtn = new Button("Show Parking Spots");
		showSpacesBtn.setPrefHeight(160);
		showSpacesBtn.setPrefWidth(160);

		startTime = System.currentTimeMillis();

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				long elapsedMillis = System.currentTimeMillis() - startTime;
				currentTime.setText(Long.toString((elapsedMillis / 1000) / 60));
			}
		}.start();

		timeBox.getChildren().addAll(currentDate, currentTime);
		topBox.getChildren().addAll(newEntryBtn, viewEntriesBtn, timeBox);
		mainPane.setTop(menuBar);
		root.getChildren().add(mainPane);
		this.setResizable(false);

		newSpaceItem.setOnAction(e -> {
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
			if (createPane.getSizeBox().getValue().equals("Select Space Size")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Please select a size!");
				alert.showAndWait();
			} else if(createPane.getTimeslotBox().getValue().equals("Select Time Length")){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Please select a time!");
				alert.showAndWait();
			} else {
				if (createPane.getSizeBox().getValue().equals("Motorcycle")) {
					TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
					vehicle = new Motorcycle(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
							createPane.getLicensePlateNoField().getText(), createPane.getTimeslotBox().getValue(),
							timeParked.getSlotNumber());
					ParkingStructure.parkOnLevel1(vehicle);
					createNewSpotAlert();
					resetFields();
				} else if (createPane.getSizeBox().getValue().equals("Compact")) {
					TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
					vehicle = new CompactCar(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
							createPane.getLicensePlateNoField().getText(), createPane.getTimeslotBox().getValue(),
							timeParked.getSlotNumber());
					ParkingStructure.parkOnLevel1(vehicle);
					createNewSpotAlert();
					resetFields();
				} else if (createPane.getSizeBox().getValue().equals("Mid Size")) {
					TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
					vehicle = new MidSizeCar(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
							createPane.getLicensePlateNoField().getText(), createPane.getTimeslotBox().getValue(),
							timeParked.getSlotNumber());
					ParkingStructure.parkOnLevel1(vehicle);
					createNewSpotAlert();
					resetFields();
				} else if (createPane.getSizeBox().getValue().equals("Truck/Van/SUV")) {
					TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
					vehicle = new Truck(createPane.getFNameField().getText(), createPane.getLNameField().getText(),
							createPane.getLicensePlateNoField().getText(), createPane.getTimeslotBox().getValue(),
							timeParked.getSlotNumber());
					ParkingStructure.parkOnLevel1(vehicle);
					createNewSpotAlert();
					resetFields();
				}
			}
			
			ParkingStructure.getLevel1().saveLevel();
		});

		viewSpacesItem.setOnAction(e -> {
			if (!hasVehicles(ParkingStructure.getLevel1().getMotorcycleLot())
					&& !hasVehicles(ParkingStructure.getLevel1().getCompactLot())
					&& !hasVehicles(ParkingStructure.getLevel1().getMidSizeLot())
					&& !hasVehicles(ParkingStructure.getLevel1().getTruckLot())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("All lots are empty!");
				alert.showAndWait();
			} else {
				try {
					Stage stage = new Stage();
					stage.setScene(viewParked.getScene());
					stage.show();
					viewParked.start(stage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				viewParked.displayParkedCars();
			}

		});

		quitItem.setOnAction(e -> {
			Platform.exit();
		});

		scene = new Scene(root, 600, 600);
		this.setScene(scene);
		this.show();
	}

	public void resetFields() {
		createPane.getFNameField().clear();
		createPane.getLNameField().clear();
		createPane.getLicensePlateNoField().clear();
		createPane.getSizeBox().getSelectionModel().selectFirst();
		createPane.getTimeslotBox().getSelectionModel().selectFirst();
		createPane.getHandicappedCheckBox().setSelected(false);
	}

	public Alert createNewSpotAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(createPane.getFNameField().getText() + " " + createPane.getLNameField().getText()
				+ "'s vehicle has been parked on level 1");
		alert.showAndWait();
		return alert;
	}

	public Pane getPane() {
		return mainPane;
	}

	public boolean isMotorcycle(Vehicle vehicle) {
		if (vehicle instanceof Motorcycle) {
			return true;
		}
		return false;
	}

	public boolean isCompact(Vehicle vehicle) {
		if (vehicle instanceof CompactCar) {
			return true;
		}
		return false;
	}

	public boolean hasVehicles(Map<String, ParkingSpace> map) {
		for (ParkingSpace space : map.values()) {
			if (space.getVehicle() != null) {
				return true;
			}
		}
		return false;
	}

	public ObservableList<ParkingSpace> getEmptySpaces() {
		ObservableList<ParkingSpace> spaces = FXCollections.observableArrayList();
		for (ParkingSpace space : ParkingStructure.getLevel1().getMotorcycleLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel1().getCompactLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel1().getMidSizeLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel1().getTruckLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}
		return spaces;

	}

	public Stage getStage() {
		return this;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

}
