package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ParkingStructure implements ParkingBehavior {

	private static ParkingStructure _structure;

	private static String stringNewDate;

	private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private static Date date = new Date();

	private static DateFormat timeFormat = new SimpleDateFormat("h:mm a");
	private static Date time = new Date();

	private static ParkingLevel level1;
	private static ParkingLevel level2;
	private static ParkingLevel level3;

	private ParkingStructure() {
		level1 = new ParkingLevel();
		level2 = new ParkingLevel();
		level3 = new ParkingLevel();
	}

	public static ParkingStructure getStructure() {
		if (_structure == null) {
			_structure = new ParkingStructure();
			System.out.println("A Parking Structure has been created");
		} else {
			System.out.println("A Parking Structure already exists");
		}
		return _structure;
	}

	public static String getDate() {
		return dateFormat.format(date);
	}

	public static String getTime() {

		return timeFormat.format(time);
	}

	public static ParkingLevel getLevel1() {
		return level1;
	}

	public static ParkingLevel getLevel2() {
		return level2;
	}

	public static ParkingLevel getLevel3() {
		return level3;
	}
	

	public static void parkOnLevel1(Vehicle vehicle) {
		if (vehicle instanceof Motorcycle) {
			final boolean[] spaceFound = {false};
			ParkingStructure.getLevel1().getMotorcycleLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMotorcycleLot().get(e);
				if(tempSpace.getVehicle() == null && !spaceFound[0] ){
					tempSpace.setVehicle(vehicle);
					spaceFound[0] = true;
				} 
				
			});
		} else if (vehicle instanceof CompactCar) {
			final boolean[] spaceFound = {false};
			ParkingStructure.getLevel1().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getCompactLot().get(e);
				if(tempSpace.getVehicle() == null && !spaceFound[0] ){
					tempSpace.setVehicle(vehicle);
					spaceFound[0] = true;
				}	
				
			});
		} else if (vehicle instanceof MidSizeCar) {
			final boolean[] spaceFound = {false};
			ParkingStructure.getLevel1().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMidSizeLot().get(e);
				if(tempSpace.getVehicle() == null && !spaceFound[0] ){
					tempSpace.setVehicle(vehicle);
					spaceFound[0] = true;
				}	
				
			});
		} else if (vehicle instanceof Truck) {
			final boolean[] spaceFound = {false};
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMotorcycleLot().get(e);
				if(tempSpace.getVehicle() == null && !spaceFound[0] ){
					tempSpace.setVehicle(vehicle);
					spaceFound[0] = true;
				}	
				
			});
		}
	}
	
//	public static void parkOnLevel2(ParkingSpace space, Vehicle vehicle) {
//		if (vehicle instanceof Motorcycle && ParkingStructure.getLevel2().getMotorcycleLot().size() < 25) {
//			ParkingStructure.getLevel2().getMotorcycleSpace().setVehicle(vehicle);
//		} else if (vehicle instanceof CompactCar && ParkingStructure.getLevel2().getCompactLot().size() < 50) {
//			ParkingStructure.getLevel2().getCompactSpace().setVehicle(vehicle);
//		} if (vehicle instanceof MidSizeCar && ParkingStructure.getLevel2().getMidSizeLot().size() < 50) {
//			ParkingStructure.getLevel2().getMidSizeSpace().setVehicle(vehicle);
//		} if (vehicle instanceof Truck && ParkingStructure.getLevel2().getTruckLot().size() < 50) {
//			ParkingStructure.getLevel2().getTruckSpace().setVehicle(vehicle);
//		}
//	}
//	
//	public static void parkOnLevel3(ParkingSpace space, Vehicle vehicle) {
//		if (vehicle instanceof Motorcycle && ParkingStructure.getLevel2().getMotorcycleLot().size() < 25) {
//			ParkingStructure.getLevel3().getMotorcycleSpace().setVehicle(vehicle);
//		} else if (vehicle instanceof CompactCar && ParkingStructure.getLevel2().getCompactLot().size() < 50) {
//			ParkingStructure.getLevel3().getCompactSpace().setVehicle(vehicle);
//		} if (vehicle instanceof MidSizeCar && ParkingStructure.getLevel2().getMidSizeLot().size() < 50) {
//			ParkingStructure.getLevel3().getMidSizeSpace().setVehicle(vehicle);
//		} if (vehicle instanceof Truck && ParkingStructure.getLevel2().getTruckLot().size() < 50) {
//			ParkingStructure.getLevel3().getTruckSpace().setVehicle(vehicle);
//		}
//	}
//	
//	public static void unparkOnLevel1(ParkingSpace space, Vehicle vehicle) {
//		if (vehicle instanceof Motorcycle && ParkingStructure.getLevel1().getMotorcycleLot().size() < 25) {
//			ParkingStructure.getLevel2().getMotorcycleSpace().removeVehicle(vehicle);
//		} else if (vehicle instanceof CompactCar && ParkingStructure.getLevel1().getCompactLot().size() < 50) {
//			ParkingStructure.getLevel2().getCompactSpace().removeVehicle(vehicle);
//		} if (vehicle instanceof MidSizeCar && ParkingStructure.getLevel1().getMidSizeLot().size() < 50) {
//			ParkingStructure.getLevel2().getMidSizeSpace().removeVehicle(vehicle);
//		} if (vehicle instanceof Truck && ParkingStructure.getLevel1().getTruckLot().size() < 50) {
//			ParkingStructure.getLevel2().getTruckSpace().removeVehicle(vehicle);
//		}
//	}

	@Override
	public String toString() {
		return "ParkingStructure []";
	}

}
