package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.sun.javafx.scene.control.skin.TableHeaderRow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ParkingSpace;
import model.ParkingStructure;
import model.Vehicle;

public class ViewParkedWindow extends Application implements Serializable {

	private Pane4MainWindow mainWindowPane;
	private StackPane root;
	private String[] nameTokens;
	private ObservableList<Vehicle> saveList;
	private ArrayList<Vehicle> saveVehicles;

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
		// lastNameColumn.setEditable(false);
		lastNameColumn.setResizable(false);
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("lastName"));

		firstNameColumn = new TableColumn("First Name");
		// firstNameColumn.setEditable(false);
		firstNameColumn.setResizable(false);
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("firstName"));

		tagNumberColumn = new TableColumn("Tag #");
		// tagNumberColumn.setEditable(false);
		tagNumberColumn.setResizable(false);
		tagNumberColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("tagNumber"));

		tableView.getColumns().addAll(lastNameColumn, firstNameColumn, tagNumberColumn);
		tableView.setItems(displayParkedCars());

		detailsBtn = new Button("Details");
		cancelBtn = new Button("Back");
		removeBtn = new Button("Remove");

		cancelBtn.setOnAction(e -> {
			saveTable();
			stage.close();
		});

		removeBtn.setOnAction(e -> {

			ObservableList<Vehicle> vehiclesSelected, allVehicles;
			allVehicles = tableView.getItems();
			vehiclesSelected = tableView.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION, "Ticket will now be processed" ,ButtonType.YES, ButtonType.CANCEL);
			alert.setHeaderText("Unpark " + tableView.getSelectionModel().getSelectedItem().getFirstName() + " "
					+ tableView.getSelectionModel().getSelectedItem().getLastName() + "'s car?");
			alert.showAndWait();
			if (alert.getResult() == ButtonType.CANCEL) {
				alert.close();
			} else if (alert.getResult() == ButtonType.YES) {
				for (Vehicle vehicle : vehiclesSelected) {
					if (vehicle.equals(tableView.getSelectionModel().getSelectedItem())) {
						allVehicles.remove(vehicle);
						ParkingStructure.unparkOnLevel1(vehicle);
						ParkingStructure.getLevel1().saveLevel();
					}

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

}
