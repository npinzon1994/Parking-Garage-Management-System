package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Pane4Create extends Stage {
	
	private Label firstName;
	private Label lastName;
	
	private TextField fNameField;
	private TextField lNameField;
	
	private Button cancelBtn;
	private Button bookSpotBtn;
	
	private ComboBox<String> sizeBox; 
	
	private GridPane grid;
	
	public Pane4Create() {
		
		firstName = new Label("First Name");
		lastName = new Label("Last Name");
		
		fNameField = new TextField();
		lNameField = new TextField();
		
		cancelBtn = new Button("Cancel");
		bookSpotBtn = new Button("Book Spot");
		
		sizeBox = new ComboBox<String>();
		sizeBox.getItems().addAll("Select Size", "Motorcycle", "Compact", "Mid Size", "Truck/Van/SUV");
		sizeBox.getSelectionModel().selectFirst();
		
		grid = new GridPane();
		grid.setPadding(new Insets(15));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.getChildren().addAll(firstName, lastName, fNameField, lNameField, cancelBtn, bookSpotBtn,
							  	  sizeBox);
		
		GridPane.setConstraints(firstName, 0, 0);
		GridPane.setConstraints(fNameField, 1, 0);
		GridPane.setConstraints(lastName, 0, 1);
		GridPane.setConstraints(lNameField, 1, 1);
		GridPane.setConstraints(sizeBox, 0, 2);
		GridPane.setConstraints(cancelBtn, 0, 9);
		GridPane.setConstraints(bookSpotBtn, 1, 9);
		
	}
	
	
	public Pane getPane(){
		return grid;
	}
	
	public Button getCancelButton(){
		return cancelBtn;
	}
	
	public TextField getFNameField(){
		return fNameField;
	}
	
	public TextField getLNameField(){
		return lNameField;
	}
	
	public ComboBox<String> getBox(){
		return sizeBox;
	}

}
