package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ParkingStructure;

public class Pane4Create extends Stage {

	private Label firstName;
	private Label lastName;
	private Label licensePlateNo;

	private TextField fNameField;
	private TextField lNameField;
	private TextField licensePlateNoField;

	private Button cancelBtn;
	private Button bookSpotBtn;

	private ComboBox<String> sizeBox;
	private ComboBox<String> timeslotBox;

	private CheckBox handicappedCheckBox;

	private GridPane grid;

	public Pane4Create() {

		firstName = new Label("First Name");
		lastName = new Label("Last Name");

		licensePlateNo = new Label("License Plate No.");
		licensePlateNoField = new TextField();

		fNameField = new TextField();
		lNameField = new TextField();

		cancelBtn = new Button("Cancel");
		bookSpotBtn = new Button("Book Spot");

		handicappedCheckBox = new CheckBox("Handicapped");

		sizeBox = new ComboBox<String>();
		sizeBox.getItems().addAll("Select Space Size", "Motorcycle", "Compact", "Mid Size", "Truck/Van/SUV");
		sizeBox.getSelectionModel().selectFirst();

		timeslotBox = new ComboBox<String>();
		timeslotBox.getItems().addAll("Select Time Length", "1/2 hour", "1 Hour", "2 Hours", "To Close (8PM)");
		timeslotBox.getSelectionModel().selectFirst();

		grid = new GridPane();
		grid.setPadding(new Insets(15));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.getChildren().addAll(firstName, lastName, fNameField, lNameField, cancelBtn, bookSpotBtn, sizeBox,
				timeslotBox, licensePlateNo, licensePlateNoField, handicappedCheckBox);

		GridPane.setConstraints(firstName, 0, 0);
		GridPane.setConstraints(fNameField, 1, 0);
		GridPane.setConstraints(lastName, 0, 1);
		GridPane.setConstraints(lNameField, 1, 1);
		GridPane.setConstraints(licensePlateNo, 0, 2);
		GridPane.setConstraints(licensePlateNoField, 1, 2);
		GridPane.setConstraints(handicappedCheckBox, 2, 2);
		GridPane.setConstraints(sizeBox, 0, 3);
		GridPane.setConstraints(timeslotBox, 1, 3);
		GridPane.setConstraints(cancelBtn, 0, 9);
		GridPane.setConstraints(bookSpotBtn, 1, 9);

	}

	public Pane getPane() {
		return grid;
	}

	public Button getCancelButton() {
		return cancelBtn;
	}
	
	public Button getBookSpotButton() {
		return bookSpotBtn;
	}

	public TextField getFNameField() {
		return fNameField;
	}

	public TextField getLNameField() {
		return lNameField;
	}

	public TextField getLicensePlateNoField() {
		return licensePlateNoField;
	}

	public ComboBox<String> getSizeBox() {
		return sizeBox;
	}
	
	public ComboBox<String> getTimeslotBox() {
		return timeslotBox;
	}
	
	public CheckBox getHandicappedCheckBox(){
		return handicappedCheckBox;
	}

}
