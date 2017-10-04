package view;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.ParkingLevel;
import model.ParkingSpace;
import model.ParkingStructure;
import model.Vehicle;

public class ViewParkedWindow extends Application {

	private StackPane root;
	private GridPane grid;
	private Scene scene;

	private Label name;
	private Label level;
	private Label spaceNo;

	private Stage stage;
	
	private ArrayList<Hyperlink> motorcycleHyperLinks;
	private ArrayList<Hyperlink> compactHyperLinks;
	private ArrayList<Vehicle> motorcycleTemp;
	private ArrayList<Vehicle> compactTemp;
	

	private int i;
	private int j;
	private int k;
	private int l;

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		name = new Label("Customer:");
		level = new Label("Level");
		spaceNo = new Label("Parking Space #");

		grid = new GridPane();
		root = new StackPane(grid);

		grid.getChildren().addAll(name, level, spaceNo);

		GridPane.setConstraints(name, 0, 0);
		GridPane.setConstraints(level, 1, 0);
		GridPane.setConstraints(spaceNo, 2, 0);

		scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.show();

	}

	public int getMotorcycleSpacesTaken() {
		int motorcycleSpacesLv1 = ParkingStructure.getLevel1().getMotorcycleLot().size();
		int motorcycleSpacesLv2 = ParkingStructure.getLevel2().getMotorcycleLot().size();
		int motorcycleSpacesLv3 = ParkingStructure.getLevel3().getMotorcycleLot().size();
		return motorcycleSpacesLv1 + motorcycleSpacesLv2 + motorcycleSpacesLv3;
	}

	public int getCompactSpacesTaken() {
		int compactSpacesLv1 = ParkingStructure.getLevel1().getCompactLot().size();
		int compactSpacesLv2 = ParkingStructure.getLevel2().getCompactLot().size();
		int compactSpacesLv3 = ParkingStructure.getLevel3().getCompactLot().size();
		return compactSpacesLv1 + compactSpacesLv2 + compactSpacesLv3;
	}

	public int getMidSizeSpacesTaken() {
		int midSizeSpacesLv1 = ParkingStructure.getLevel1().getMidSizeLot().size();
		int midSizeSpacesLv2 = ParkingStructure.getLevel2().getMidSizeLot().size();
		int midSizeSpacesLv3 = ParkingStructure.getLevel3().getMidSizeLot().size();
		return midSizeSpacesLv1 + midSizeSpacesLv2 + midSizeSpacesLv3;
	}

	public int getTruckSpacesTaken() {
		int truckSpacesLv1 = ParkingStructure.getLevel1().getTruckLot().size();
		int truckSpacesLv2 = ParkingStructure.getLevel2().getTruckLot().size();
		int truckSpacesLv3 = ParkingStructure.getLevel3().getTruckLot().size();
		return truckSpacesLv1 + truckSpacesLv2 + truckSpacesLv3;
	}

	public int getTotalSpacesTaken() {
		int motorcycleSpacesLv1 = ParkingStructure.getLevel1().getMotorcycleLot().size();
		int compactSpacesLv1 = ParkingStructure.getLevel1().getCompactLot().size();
		int midSizeSpacesLv1 = ParkingStructure.getLevel1().getMidSizeLot().size();
		int truckSpacesLv1 = ParkingStructure.getLevel1().getTruckLot().size();
		int totalSpacesTakenLv1 = motorcycleSpacesLv1 + compactSpacesLv1 + midSizeSpacesLv1 + truckSpacesLv1;

		int motorcycleSpacesLv2 = ParkingStructure.getLevel2().getMotorcycleLot().size();
		int compactSpacesLv2 = ParkingStructure.getLevel2().getCompactLot().size();
		int midSizeSpacesLv2 = ParkingStructure.getLevel2().getMidSizeLot().size();
		int truckSpacesLv2 = ParkingStructure.getLevel2().getTruckLot().size();
		int totalSpacesTakenLv2 = motorcycleSpacesLv2 + compactSpacesLv2 + midSizeSpacesLv2 + truckSpacesLv2;

		int motorcycleSpacesLv3 = ParkingStructure.getLevel3().getMotorcycleLot().size();
		int compactSpacesLv3 = ParkingStructure.getLevel3().getCompactLot().size();
		int midSizeSpacesLv3 = ParkingStructure.getLevel3().getMidSizeLot().size();
		int truckSpacesLv3 = ParkingStructure.getLevel3().getTruckLot().size();
		int totalSpacesTakenLv3 = motorcycleSpacesLv3 + compactSpacesLv3 + midSizeSpacesLv3 + truckSpacesLv3;

		return totalSpacesTakenLv1 + totalSpacesTakenLv2 + totalSpacesTakenLv3;
	}

	public void displayParkedMotorcycles(ParkingLevel level, ParkingSpace space) {

		motorcycleTemp = new ArrayList<Vehicle>();
		motorcycleHyperLinks = new ArrayList<Hyperlink>();

		level = ParkingStructure.getLevel1();
		space = level.getMotorcycleSpace();
		
		
		level.getMotorcycleLot().entrySet().stream().forEach
		(level.getMotorcycleSpace() -> {
			motorcycleTemp.add(vehicle);
			
		}));
		motorcycleTemp.addAll(ParkingStructure.getLevel2().getMotorcycleLot().keySet());
		motorcycleTemp.addAll(ParkingStructure.getLevel3().getMotorcycleLot().keySet());
		
		if (space != null) {
			
			for (i = 0; i < motorcycleTemp.size(); i++) {
				Hyperlink link = new Hyperlink(motorcycleTemp.get(i).getVehicle().getLastName() + ", "
						+ motorcycleTemp.get(i).getVehicle().getFirstName());
				motorcycleHyperLinks.add(link);
				grid.getChildren().add(link);
				GridPane.setConstraints(link, 0, i + 1);

				}
			
			
		}
			
			
	}

	

	public void displayParkedCompactCars(ParkingSpace space) {
		compactTemp = new ArrayList<ParkingSpace>();
		compactHyperLinks = new ArrayList<Hyperlink>();

		compactTemp.addAll(ParkingStructure.getLevel1().getCompactLot().keySet());
		compactTemp.addAll(ParkingStructure.getLevel2().getCompactLot().keySet());
		compactTemp.addAll(ParkingStructure.getLevel3().getCompactLot().keySet());

		if (space != null) {
			
				for (int j = i; j < compactTemp.size(); j++) {

					Hyperlink link = new Hyperlink(compactTemp.get(j).getVehicle().getLastName() + ", "
							+ compactTemp.get(j).getVehicle().getFirstName());
					compactHyperLinks.add(link);
					grid.getChildren().add(link);
					GridPane.setConstraints(link, 0, j + 1);
				}
		}	
	}


	public void displayParkedMidSizeCars(ParkingSpace space) {
		ArrayList<ParkingSpace> midSizeTemp = new ArrayList<ParkingSpace>();
		midSizeTemp.addAll(ParkingStructure.getLevel1().getMidSizeLot().keySet());
		midSizeTemp.addAll(ParkingStructure.getLevel2().getMidSizeLot().keySet());
		midSizeTemp.addAll(ParkingStructure.getLevel3().getMidSizeLot().keySet());
	}

	public void displayParkedTrucks(ParkingSpace space) {
		ArrayList<ParkingSpace> truckTemp = new ArrayList<ParkingSpace>();
		truckTemp.addAll(ParkingStructure.getLevel1().getTruckLot().keySet());
		truckTemp.addAll(ParkingStructure.getLevel2().getTruckLot().keySet());
		truckTemp.addAll(ParkingStructure.getLevel3().getTruckLot().keySet());
	}

	public Stage getStage() {
		return this.stage;
	}
	
	public GridPane getGridPane(){
		return grid;
	}
	
	public ArrayList getTempMotorcycleList(){
		return motorcycleTemp;
	}
	
	public ArrayList getTempCompactList(){
		return compactTemp;
	}
	
	public ArrayList getCompactHyperLinks(){
		return compactHyperLinks;
	}

}
