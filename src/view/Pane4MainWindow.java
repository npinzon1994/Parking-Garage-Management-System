package view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import model.ParkingLevel;
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

	private SimpleDateFormat sdf2;

	private VBox timeBox;

	private VBox vbox;
	private VBox vbox2;
	private VBox mainVBox;

	private Label welcomeLabel;

	private long startTime;
	private Label currentTimeLbl;

	private Label currentDateLbl;

	private Vehicle vehicle;

	private BorderPane mainPane;

	private HBox topBox;
	private Scene scene;

	public Pane4MainWindow() {

		ParkingStructure.getStructure();
		Label timeDisplay = new Label();
		Label dateDisplay = new Label(ParkingStructure.getDate());
		Task dynamicTimeTask = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
				while (true) {
					updateMessage(sdf.format(new Date()));
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						break;
					}
				}
				return null;
			}
		};
		timeDisplay.textProperty().bind(dynamicTimeTask.messageProperty());
		Thread t2 = new Thread(dynamicTimeTask);
		t2.setName("Tesk Time Updater");
		t2.setDaemon(true);
		t2.start();

		createPane = new Pane4Create();

		root = new StackPane();
		mainPane = new BorderPane();
		topBox = new HBox();
		timeBox = new VBox();
		mainVBox = new VBox();

		welcomeLabel = new Label("Welcome to GC Parking Garage version 1.0");

		vbox = new VBox();
		vbox.getChildren().addAll(timeDisplay, dateDisplay);
		welcomeLabel.setAlignment(Pos.CENTER_RIGHT);
		mainPane.setRight(vbox);

		newSpaceItem = new MenuItem("New Entry");
		viewSpacesItem = new MenuItem("View Entries");
		quitItem = new MenuItem("Quit");
		freeSpaces = new MenuItem("View Available Spaces");

		freeSpaces.setOnAction(e -> {

			Button lv1Btn = new Button("Level 1");
			Button lv2Btn = new Button("Level 2");
			Button lv3Btn = new Button("Level 3");

			Button lv1Btn2 = new Button("Level 1");
			Button lv2Btn2 = new Button("Level 2");
			Button lv3Btn2 = new Button("Level 3");

			Button lv1Btn3 = new Button("Level 1");
			Button lv2Btn3 = new Button("Level 2");
			Button lv3Btn3 = new Button("Level 3");

			Button cancelBtn = new Button("Cancel");
			Button cancelBtn2 = new Button("Cancel");
			Button cancelBtn3 = new Button("Cancel");

			HBox btnBox = new HBox(10);
			HBox btnBox2 = new HBox(10);
			HBox btnBox3 = new HBox(10);
			VBox mainbox = new VBox(10);
			VBox box = new VBox(10);
			Scene scene = null;

			btnBox.getChildren().addAll(lv1Btn, lv2Btn, lv3Btn, cancelBtn);
			btnBox2.getChildren().addAll(lv1Btn2, lv2Btn2, lv3Btn2, cancelBtn2);
			btnBox3.getChildren().addAll(lv1Btn3, lv2Btn3, lv3Btn3, cancelBtn3);

			// table to level 1 spaces
			TableColumn<ParkingSpace, String> spaceColumnLv1 = new TableColumn<>("Space Type");
			spaceColumnLv1.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("spaceType"));

			TableColumn<ParkingSpace, String> numberColumnLv1 = new TableColumn<>("Space No.");
			numberColumnLv1.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("id"));

			TableColumn<ParkingSpace, Integer> levelColumnLv1 = new TableColumn<>("Level");
			levelColumnLv1.setCellValueFactory(new PropertyValueFactory<ParkingSpace, Integer>("level"));
			TableView<ParkingSpace> table = new TableView<>();
			table.autosize();

			table.getColumns().addAll(spaceColumnLv1, numberColumnLv1, levelColumnLv1);
			table.setItems(getEmptySpacesLv1());

			cancelBtn.setOnAction(e1 -> {
				freeSpaceStage.close();
			});

			box.getChildren().addAll(table, btnBox);

			// table for level 2 spaces
			TableColumn<ParkingSpace, String> spaceColumnLv2 = new TableColumn<>("Space Type");
			spaceColumnLv2.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("spaceType"));

			TableColumn<ParkingSpace, String> numberColumnLv2 = new TableColumn<>("Space No.");
			numberColumnLv2.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("id"));

			TableColumn<ParkingSpace, Integer> levelColumnLv2 = new TableColumn<>("Level");
			levelColumnLv2.setCellValueFactory(new PropertyValueFactory<ParkingSpace, Integer>("level"));
			TableView<ParkingSpace> table2 = new TableView<>();
			table2.autosize();

			VBox box2 = new VBox(10);
			table2.getColumns().addAll(spaceColumnLv2, numberColumnLv2, levelColumnLv2);
			table2.setItems(getEmptySpacesLv2());
			box2.getChildren().addAll(table2, btnBox2);

			cancelBtn2.setOnAction(e1 -> {
				freeSpaceStage.close();
			});

			// table for level 3 spaces
			TableColumn<ParkingSpace, String> spaceColumnLv3 = new TableColumn<>("Space Type");
			spaceColumnLv3.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("spaceType"));

			TableColumn<ParkingSpace, String> numberColumnLv3 = new TableColumn<>("Space No.");
			numberColumnLv3.setCellValueFactory(new PropertyValueFactory<ParkingSpace, String>("id"));

			TableColumn<ParkingSpace, Integer> levelColumnLv3 = new TableColumn<>("Level");
			levelColumnLv3.setCellValueFactory(new PropertyValueFactory<ParkingSpace, Integer>("level"));
			TableView<ParkingSpace> table3 = new TableView<>();
			table3.autosize();

			VBox box3 = new VBox(10);
			table3.getColumns().addAll(spaceColumnLv3, numberColumnLv3, levelColumnLv3);
			table3.setItems(getEmptySpacesLv3());
			box3.getChildren().addAll(table3, btnBox3);

			cancelBtn3.setOnAction(e1 -> {
				freeSpaceStage.close();
			});
			mainbox.getChildren().add(box);

			lv1Btn.setOnAction(e1 -> {
				if (mainbox.getChildren().contains(box2) || mainbox.getChildren().contains(box3)) {
					mainbox.getChildren().remove(box2);
					mainbox.getChildren().remove(box3);
					mainbox.getChildren().add(box);
					freeSpaceStage.setTitle("Available Parking - Level 1");

				}

			});

			lv2Btn.setOnAction(e2 -> {
				if (mainbox.getChildren().contains(box) || mainbox.getChildren().contains(box3)) {
					mainbox.getChildren().remove(box);
					mainbox.getChildren().remove(box3);
					mainbox.getChildren().add(box2);
					freeSpaceStage.setTitle("Available Parking - Level 2");

				}
			});

			lv3Btn.setOnAction(e3 -> {
				if (mainbox.getChildren().contains(box) || mainbox.getChildren().contains(box2)) {
					mainbox.getChildren().remove(box);
					mainbox.getChildren().remove(box2);
					mainbox.getChildren().add(box3);
					freeSpaceStage.setTitle("Available Parking - Level 3");

				}

			});

			lv1Btn2.setOnAction(e1 -> {
				if (mainbox.getChildren().contains(box2) || mainbox.getChildren().contains(box3)) {
					mainbox.getChildren().remove(box2);
					mainbox.getChildren().remove(box3);
					mainbox.getChildren().add(box);
					freeSpaceStage.setTitle("Available Parking - Level 1");

				}

			});

			lv2Btn2.setOnAction(e2 -> {
				if (mainbox.getChildren().contains(box) || mainbox.getChildren().contains(box3)) {
					mainbox.getChildren().remove(box);
					mainbox.getChildren().remove(box3);
					mainbox.getChildren().add(box2);
					freeSpaceStage.setTitle("Available Parking - Level 2");

				}
			});

			lv3Btn2.setOnAction(e3 -> {
				if (mainbox.getChildren().contains(box) || mainbox.getChildren().contains(box2)) {
					mainbox.getChildren().remove(box);
					mainbox.getChildren().remove(box2);
					mainbox.getChildren().add(box3);
					freeSpaceStage.setTitle("Available Parking - Level 3");

				}

			});

			lv1Btn3.setOnAction(e1 -> {
				if (mainbox.getChildren().contains(box2) || mainbox.getChildren().contains(box3)) {
					mainbox.getChildren().remove(box2);
					mainbox.getChildren().remove(box3);
					mainbox.getChildren().add(box);
					freeSpaceStage.setTitle("Available Parking - Level 1");

				}

			});

			lv2Btn3.setOnAction(e2 -> {
				if (mainbox.getChildren().contains(box) || mainbox.getChildren().contains(box3)) {
					mainbox.getChildren().remove(box);
					mainbox.getChildren().remove(box3);
					mainbox.getChildren().add(box2);
					freeSpaceStage.setTitle("Available Parking - Level 2");

				}
			});

			lv3Btn3.setOnAction(e3 -> {
				if (mainbox.getChildren().contains(box) || mainbox.getChildren().contains(box2)) {
					mainbox.getChildren().remove(box);
					mainbox.getChildren().remove(box2);
					mainbox.getChildren().add(box3);
					freeSpaceStage.setTitle("Available Parking - Level 3");

				}

			});

			mainbox.setPadding(new Insets(10));

			scene = new Scene(mainbox);
			freeSpaceStage = new Stage();
			freeSpaceStage.setScene(scene);
			freeSpaceStage.setTitle("Available Parking - Level 1");
			freeSpaceStage.setResizable(false);
			freeSpaceStage.show();

		});

		fileMenu = new Menu("File");
		menuBar = new MenuBar();

		fileMenu.getItems().addAll(newSpaceItem, viewSpacesItem, freeSpaces, quitItem);
		menuBar.getMenus().add(fileMenu);

		startTime = System.currentTimeMillis();

		mainPane.setTop(menuBar);
		mainPane.setCenter(welcomeLabel);
		root.getChildren().add(mainPane);
		this.setResizable(false);

		newSpaceItem.setOnAction(e -> {
			mainPane.getChildren().removeAll();
			mainPane.setCenter(createPane.getPane());
		});

		createPane.getCancelButton().setOnAction(e -> {
			mainPane.getChildren().remove(createPane.getPane());
			mainPane.setCenter(welcomeLabel);
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
			} else if (createPane.getTimeslotBox().getValue().equals("Select Time Length")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Please select a time!");
				alert.showAndWait();
			} else {
				if (createPane.getSizeBox().getValue().equals("Motorcycle")) {

					if (!ParkingStructure.getLevel1().motorcyclesFull() || !ParkingStructure.getLevel1().compactsFull()
							||!ParkingStructure.getLevel1().midSizesFull()
							|| !ParkingStructure.getLevel1().trucksFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new Motorcycle(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 1);
						
						ParkingStructure.parkOnLevel1(vehicle);
						createNewSpotAlertLv1();
						resetFields();
					} else if ((ParkingStructure.getLevel1().motorcyclesFull())
							&& (!ParkingStructure.getLevel2().motorcyclesFull()
									|| !ParkingStructure.getLevel2().compactsFull()
									|| !ParkingStructure.getLevel2().midSizesFull()
									|| !ParkingStructure.getLevel2().trucksFull())) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new Motorcycle(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 2);
					
						ParkingStructure.parkOnLevel2(vehicle);
						createNewSpotAlertLv2();
						resetFields();
					} else if (ParkingStructure.getLevel2().motorcyclesFull()
							&& ParkingStructure.getLevel1().motorcyclesFull()
							&& (!ParkingStructure.getLevel3().motorcyclesFull()
									|| !ParkingStructure.getLevel3().compactsFull()
									|| !ParkingStructure.getLevel3().midSizesFull()
									|| !ParkingStructure.getLevel3().trucksFull())) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new Motorcycle(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 3);
						
						ParkingStructure.parkOnLevel3(vehicle);
						createNewSpotAlertLv3();
						resetFields();

					} else if (ParkingStructure.getLevel1().motorcyclesFull()
							&& ParkingStructure.getLevel2().motorcyclesFull()
							&& ParkingStructure.getLevel3().motorcyclesFull()
							&& ParkingStructure.getLevel1().compactsFull()
							&& ParkingStructure.getLevel2().compactsFull()
							&& ParkingStructure.getLevel3().compactsFull()
							&& ParkingStructure.getLevel1().midSizesFull()
							&& ParkingStructure.getLevel2().midSizesFull()
							&& ParkingStructure.getLevel3().midSizesFull()
							&& ParkingStructure.getLevel1().trucksFull()
							&& ParkingStructure.getLevel2().trucksFull()
							&& ParkingStructure.getLevel3().trucksFull()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText("Parking garage is full!");
						alert.showAndWait();
					}

				} else if (createPane.getSizeBox().getValue().equals("Compact")) {

					if (!ParkingStructure.getLevel1().compactsFull() || !ParkingStructure.getLevel1().midSizesFull()
							|| !ParkingStructure.getLevel1().trucksFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new CompactCar(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 1);
						vehicle.setLevelId(1);
						ParkingStructure.parkOnLevel1(vehicle);
						createNewSpotAlertLv1();
						resetFields();
					} else if ((ParkingStructure.getLevel1().compactsFull())
							&& (!ParkingStructure.getLevel2().compactsFull()
									|| !ParkingStructure.getLevel2().midSizesFull()
									|| !ParkingStructure.getLevel2().trucksFull())) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new CompactCar(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 2);
						vehicle.setLevelId(2);
						ParkingStructure.parkOnLevel2(vehicle);
						createNewSpotAlertLv2();
						resetFields();
					} else if (ParkingStructure.getLevel2().compactsFull()
							&& ParkingStructure.getLevel1().compactsFull()
							&& (!ParkingStructure.getLevel3().compactsFull()
									|| !ParkingStructure.getLevel3().midSizesFull()
									|| !ParkingStructure.getLevel3().trucksFull())) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new CompactCar(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 3);
						vehicle.setLevelId(3);
						ParkingStructure.parkOnLevel3(vehicle);
						createNewSpotAlertLv3();
						resetFields();

					} else if (ParkingStructure.getLevel1().compactsFull()
							&& ParkingStructure.getLevel2().compactsFull()
							&& ParkingStructure.getLevel3().compactsFull()
							&& ParkingStructure.getLevel1().midSizesFull()
							&& ParkingStructure.getLevel2().midSizesFull()
							&& ParkingStructure.getLevel3().midSizesFull()
							&& ParkingStructure.getLevel1().trucksFull()
							&& ParkingStructure.getLevel2().trucksFull()
							&& ParkingStructure.getLevel3().trucksFull()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText("Parking garage is full!");
						alert.showAndWait();
					}
				} else if (createPane.getSizeBox().getValue().equals("Mid Size")) {

					if (!ParkingStructure.getLevel1().midSizesFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new MidSizeCar(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 1);
						vehicle.setLevelId(1);
						ParkingStructure.parkOnLevel1(vehicle);
						createNewSpotAlertLv1();
						resetFields();
					} else if (ParkingStructure.getLevel1().midSizesFull()
							&& !ParkingStructure.getLevel2().midSizesFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new MidSizeCar(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 2);
						vehicle.setLevelId(2);
						ParkingStructure.parkOnLevel2(vehicle);
						createNewSpotAlertLv2();
						resetFields();
					} else if (ParkingStructure.getLevel2().midSizesFull()
							&& ParkingStructure.getLevel1().midSizesFull()
							&& !ParkingStructure.getLevel3().midSizesFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new MidSizeCar(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 3);
						vehicle.setLevelId(3);
						ParkingStructure.parkOnLevel3(vehicle);
						createNewSpotAlertLv3();
						resetFields();

					} else if (ParkingStructure.getLevel1().midSizesFull()
							&& ParkingStructure.getLevel2().midSizesFull()
							&& ParkingStructure.getLevel3().motorcyclesFull()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText("All midsize spaces are full!");
						alert.showAndWait();
					}
				} else if (createPane.getSizeBox().getValue().equals("Truck/Van/SUV")) {

					if (!ParkingStructure.getLevel1().trucksFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new Truck(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 1);
						vehicle.setLevelId(1);
						ParkingStructure.parkOnLevel1(vehicle);
						createNewSpotAlertLv1();
						resetFields();
					} else if (ParkingStructure.getLevel1().trucksFull()
							&& !ParkingStructure.getLevel2().trucksFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new Truck(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 2);
						vehicle.setLevelId(2);
						ParkingStructure.parkOnLevel2(vehicle);
						createNewSpotAlertLv2();
						resetFields();
					} else if (ParkingStructure.getLevel2().trucksFull() && ParkingStructure.getLevel1().trucksFull()
							&& !ParkingStructure.getLevel3().trucksFull()) {
						TimeslotValue timeParked = new TimeslotValue(createPane.getTimeslotBox().getValue());
						vehicle = new Truck(createPane.getFNameField().getText(),
								createPane.getLNameField().getText(), createPane.getLicensePlateNoField().getText(),
								createPane.getTimeslotBox().getValue(), timeParked.getSlotNumber(), 3);
						vehicle.setLevelId(3);
						ParkingStructure.parkOnLevel3(vehicle);
						createNewSpotAlertLv3();
						resetFields();

					} else if (ParkingStructure.getLevel1().trucksFull() && ParkingStructure.getLevel2().trucksFull()
							&& ParkingStructure.getLevel3().trucksFull()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText("All truck spaces are full!");
						alert.showAndWait();
					}
				}

			}

			ParkingStructure.save();

		});

		viewSpacesItem.setOnAction(e -> {
			if (!hasVehicles(ParkingStructure.getLevel1().getMotorcycleLot())
					&& !hasVehicles(ParkingStructure.getLevel1().getCompactLot())
					&& !hasVehicles(ParkingStructure.getLevel1().getMidSizeLot())
					&& !hasVehicles(ParkingStructure.getLevel1().getTruckLot())
					&& !hasVehicles(ParkingStructure.getLevel2().getMotorcycleLot())
					&& !hasVehicles(ParkingStructure.getLevel2().getCompactLot())
					&& !hasVehicles(ParkingStructure.getLevel2().getMidSizeLot())
					&& !hasVehicles(ParkingStructure.getLevel2().getTruckLot())
					&& !hasVehicles(ParkingStructure.getLevel3().getMotorcycleLot())
					&& !hasVehicles(ParkingStructure.getLevel3().getCompactLot())
					&& !hasVehicles(ParkingStructure.getLevel3().getMidSizeLot())
					&& !hasVehicles(ParkingStructure.getLevel3().getTruckLot())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("All lots are empty!");
				alert.showAndWait();
			} else {
				try {
					Stage stage = new Stage();
					stage.setScene(viewParked.getScene());
					stage.setX(390);
					stage.setY(100);
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

		scene = new Scene(root, 550, 350);
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

	public Alert createNewSpotAlertLv1() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(createPane.getFNameField().getText() + " " + createPane.getLNameField().getText()
				+ "'s vehicle has been parked on level 1");
		alert.showAndWait();
		return alert;
	}

	public Alert createNewSpotAlertLv2() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(createPane.getFNameField().getText() + " " + createPane.getLNameField().getText()
				+ "'s vehicle has been parked on level 2");
		alert.showAndWait();
		return alert;
	}

	public Alert createNewSpotAlertLv3() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(createPane.getFNameField().getText() + " " + createPane.getLNameField().getText()
				+ "'s vehicle has been parked on level 3");
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
		return true;
	}

	public ObservableList<ParkingSpace> getEmptySpacesLv1() {
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

	public ObservableList<ParkingSpace> getEmptySpacesLv2() {
		ObservableList<ParkingSpace> spaces = FXCollections.observableArrayList();
		for (ParkingSpace space : ParkingStructure.getLevel2().getMotorcycleLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel2().getCompactLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel2().getMidSizeLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel2().getTruckLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}
		return spaces;
	}

	public ObservableList<ParkingSpace> getEmptySpacesLv3() {
		ObservableList<ParkingSpace> spaces = FXCollections.observableArrayList();
		for (ParkingSpace space : ParkingStructure.getLevel3().getMotorcycleLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel3().getCompactLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel3().getMidSizeLot().values()) {
			if (space.getVehicle() == null) {
				spaces.add(space);
			}
		}

		for (ParkingSpace space : ParkingStructure.getLevel3().getTruckLot().values()) {
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
