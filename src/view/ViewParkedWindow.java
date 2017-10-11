package view;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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

public class ViewParkedWindow extends Application implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private final double TAX_RATE = 0.18235;

	private Pane4MainWindow mainWindowPane;
	private StackPane root;
	private String[] nameTokens;
	private ObservableList<Vehicle> saveList;
	private ArrayList<Vehicle> saveVehicles;
	private Stage paymentStage;
	private Label label;

	private Button button;

	private Label amountLabel;
	private Label amountLabel2;

	private HBox mainBox;
	private VBox listBox;
	private VBox buttonBox;

	private TableView<Vehicle> tableView;
	private TableColumn<Vehicle, String> lastNameColumn;
	private TableColumn<Vehicle, String> firstNameColumn;
	private TableColumn<Vehicle, String> tagNumberColumn;
	private TableColumn<Vehicle, String> licenseColumn;
	private TableColumn<Vehicle, String> spaceColumn;
	private TableColumn<Vehicle, String> levelColumn;

	private Button cancelBtn;
	private Button removeBtn;

	private Scene scene;
	private Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		tableView = new TableView<>();
		

		tableView.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth) {
				TableHeaderRow header = (TableHeaderRow) tableView.lookup("TableHeaderRow");
				header.reorderingProperty().addListener(new ChangeListener<Boolean>() {
					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						header.setReordering(false);
					}
				});
			}
		});

		lastNameColumn = new TableColumn("Last Name");
		lastNameColumn.setPrefWidth(100);

		licenseColumn = new TableColumn("License No.");
		licenseColumn.setResizable(false);
		licenseColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));

		spaceColumn = new TableColumn("Space No.");
		spaceColumn.setResizable(false);
		spaceColumn.setMaxWidth(90);
		spaceColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("spaceNo"));

		lastNameColumn.setResizable(false);
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("lastName"));

		firstNameColumn = new TableColumn("First Name");

		firstNameColumn.setResizable(false);
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("firstName"));

		tagNumberColumn = new TableColumn("Tag No.");

		tagNumberColumn.setResizable(false);
		tagNumberColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("tagNumber"));
		tagNumberColumn.setPrefWidth(110);

		levelColumn = new TableColumn("Level");
		levelColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("levelId"));
		levelColumn.setPrefWidth(50);

		tableView.getColumns().addAll(lastNameColumn, firstNameColumn, licenseColumn, spaceColumn, levelColumn,
				tagNumberColumn);
		tableView.setItems(displayParkedCars());
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		cancelBtn = new Button("Cancel");
		removeBtn = new Button("Remove");

		cancelBtn.setOnAction(e -> {
			saveTable();
			stage.close();
		});

		removeBtn.setOnAction(e -> {

			ObservableList<Vehicle> vehiclesSelected, allVehicles;
			allVehicles = tableView.getItems();
			vehiclesSelected = tableView.getSelectionModel().getSelectedItems();
			LocalTime currentTime = LocalTime.now();
			LocalTime noon = LocalTime.NOON;
			LocalTime elevenFiftyNine = LocalTime.MAX;
			LocalTime midnight = LocalTime.MIDNIGHT;
			Pane4Create pfc = new Pane4Create();
			paymentStage = new Stage();
			paymentStage.setResizable(false);

			if (tableView.getSelectionModel().getSelectedItem() != null) {
				Alert alert = new Alert(AlertType.CONFIRMATION, "Ticket will now be processed", ButtonType.YES,
						ButtonType.CANCEL);
				alert.setHeaderText("Unpark " + tableView.getSelectionModel().getSelectedItem().getFirstName() + " "
						+ tableView.getSelectionModel().getSelectedItem().getLastName() + "'s car?");
				DialogPane pane = alert.getDialogPane();
				pane.getStylesheets().add(getClass().getResource("MauveStorm.css").toExternalForm());
				alert.showAndWait();
				if (alert.getResult() == ButtonType.CANCEL) {
					alert.close();
				} else if (alert.getResult() == ButtonType.YES) {
					label = new Label("Total payment due: ");
					button = new Button("Back");
					for (Vehicle vehicle : vehiclesSelected) {
						if ((vehicle.equals(tableView.getSelectionModel().getSelectedItem())
								&& vehicle instanceof Motorcycle)
								|| (vehicle.equals(tableView.getSelectionModel().getSelectedItem())
										&& vehicle instanceof CompactCar)
								|| (vehicle.equals(tableView.getSelectionModel().getSelectedItem())
										&& vehicle instanceof MidSizeCar)
								|| (vehicle.equals(tableView.getSelectionModel().getSelectedItem())
										&& vehicle instanceof Truck)) {
							if (currentTime.isAfter(midnight) && currentTime.isBefore(noon)) {
								double earlyBirdPayment;

								vehicle.setEndTime(currentTime);
								earlyBirdPayment = vehicle.calculateEarlyBirdRate(vehicle.getStartTime(),
										vehicle.getEndTime());
								vehicle.setAmountCharged(earlyBirdPayment);
								amountLabel = new Label(
										NumberFormat.getCurrencyInstance(Locale.US).format(earlyBirdPayment));
								
								if(vehicle.getLevelId() == 1){
									ParkingStructure.unparkOnLevel1(vehicle);
									allVehicles.remove(vehicle);
								} else if(vehicle.getLevelId() == 2){
									ParkingStructure.unparkOnLevel2(vehicle);
									allVehicles.remove(vehicle);
								} else if(vehicle.getLevelId() == 3){
									ParkingStructure.unparkOnLevel3(vehicle);
									allVehicles.remove(vehicle);
								}
								
								VBox box = new VBox(5);
								box.setPadding(new Insets(5));
								amountLabel.setPadding(new Insets(0, 10, 0, 0));
								box.getChildren().addAll(label, amountLabel, button);							
								paymentStage.setScene(new Scene(box));
								
								paymentStage.getScene().getStylesheets().add(getClass().getResource("MauveStorm.css").toExternalForm());
								paymentStage.show();
								

							} else if (currentTime.isAfter(noon) && currentTime.isBefore(elevenFiftyNine)) {
								double regularPayment;
								paymentStage = new Stage();

								vehicle.setEndTime(currentTime);
								regularPayment = vehicle.calculateRegularRate(vehicle.getStartTime(),
										vehicle.getEndTime());
								vehicle.setAmountCharged(regularPayment);
								amountLabel2 = new Label(
										NumberFormat.getCurrencyInstance(Locale.US).format(vehicle.getAmountCharged()));
								if(vehicle.getLevelId() == 1){
									ParkingStructure.unparkOnLevel1(vehicle);
									allVehicles.remove(vehicle);
								} else if(vehicle.getLevelId() == 2){
									ParkingStructure.unparkOnLevel2(vehicle);
									allVehicles.remove(vehicle);
								} else if(vehicle.getLevelId() == 3){
									ParkingStructure.unparkOnLevel3(vehicle);
									allVehicles.remove(vehicle);
								}
								VBox box = new VBox(5);
								box.setPadding(new Insets(5));
								amountLabel2.setPadding(new Insets(0, 10, 0, 0));
								box.getChildren().addAll(label, amountLabel2, button);
								paymentStage.setScene(new Scene(box));
								paymentStage.getScene().getStylesheets().add(getClass().getResource("MauveStorm.css").toExternalForm());
								paymentStage.show();
								
							}
							button.setOnAction(e1 -> {
								paymentStage.close();
							});
							
							
							ParkingStructure.save();
						}

					}
				} else {
					return;
				}

			}

		});

		mainBox = new HBox(10);
		mainBox.setPadding(new Insets(10));

		listBox = new VBox(10);

		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(cancelBtn, removeBtn);
		listBox.getChildren().addAll(tableView, hbox);

		buttonBox = new VBox(10);

		mainBox.getChildren().addAll(listBox, buttonBox);
		root = new StackPane(mainBox);

		scene = new Scene(root, 535, 500);
		scene.getStylesheets().add(getClass().getResource("MauveStorm.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Vehicles Currently Parked");
		stage.setResizable(false);
		stage.show();

	}

	public ObservableList<Vehicle> displayParkedCars() {
		ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
		for (ParkingSpace space : ParkingStructure.getLevel1().getMotorcycleLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel1().getCompactLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel1().getMidSizeLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel1().getTruckLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}

		for (ParkingSpace space : ParkingStructure.getLevel2().getMotorcycleLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel2().getCompactLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel2().getMidSizeLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel2().getTruckLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}

		for (ParkingSpace space : ParkingStructure.getLevel3().getMotorcycleLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel3().getCompactLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel3().getMidSizeLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}
		for (ParkingSpace space : ParkingStructure.getLevel3().getTruckLot().values()) {
			if (space.getVehicle() != null) {
				vehicles.add(space.getVehicle());
			}

		}

		return vehicles;
	}

	public Stage getStage() {
		return this.stage;
	}

	public Scene getScene() {
		return this.scene;
	}

	public VBox getListBox() {
		return listBox;
	}

	public void saveTable() {
		saveList = tableView.getItems();
		saveVehicles = new ArrayList<>(saveList);
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;

		try {
			fileOutput = new FileOutputStream("savedTable.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(saveVehicles);
			objectOutput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadTable() {
		FileInputStream fileInput = null;
		ObjectInputStream objectInput = null;

		try {
			fileInput = new FileInputStream("savedTable.dat");
			objectInput = new ObjectInputStream(fileInput);
			File file = new File("savedTable.dat");
			if (file.exists()) {
				saveVehicles = (ArrayList<Vehicle>) objectInput.readObject();
				saveList = FXCollections.observableArrayList(saveVehicles);
			}
			objectInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public double calculateRegularRate(LocalTime startTime, LocalTime endTime) {
		double rate = (14.00 / 60);
		startTime.until(endTime, SECONDS);
		long seconds = SECONDS.between(startTime, endTime);
		double subtotal = 0;
		double tax = 0;
		double total = 0;
		if (seconds <= 30) {
			tax = TAX_RATE * 30;
			subtotal = rate * 30;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (seconds > 30 && seconds < 60) {
			double newRate = rate + ((rate) * (0.1));
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		} else if (seconds <= 60) {
			tax = TAX_RATE * 60;
			subtotal = rate * 60;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (seconds > 60 && seconds < 120) {
			double newRate = rate + ((rate) * (0.1));
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		} else if (seconds <= 120) {
			tax = TAX_RATE * 120;
			subtotal = rate * 120;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (seconds > 120) {
			double newRate = rate + ((rate) * (0.2));
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		}
		return total;
	}

}
