package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

	public static void parkOnLevel1(ParkingSpace space, Vehicle vehicle) {
		if (vehicle instanceof Motorcycle && ParkingStructure.getLevel1().getMotorcycleLot().size() < 25) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel1().getMotorcycleLot().put(space, vehicle.getTagNumber());
		} else if (vehicle instanceof CompactCar && ParkingStructure.getLevel1().getCompactLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel1().getCompactLot().put(space, vehicle.getTagNumber());
		} if (vehicle instanceof MidSizeCar && ParkingStructure.getLevel1().getMidSizeLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel1().getMidSizeLot().put(space, vehicle.getTagNumber());
		} if (vehicle instanceof Truck && ParkingStructure.getLevel1().getTruckLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel1().getTruckLot().put(space, vehicle.getTagNumber());
		}
	}
	
	public static void parkOnLevel2(ParkingSpace space, Vehicle vehicle) {
		if (vehicle instanceof Motorcycle && ParkingStructure.getLevel2().getMotorcycleLot().size() < 25) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel2().getMotorcycleLot().put(space, vehicle.getTagNumber());
		} else if (vehicle instanceof CompactCar && ParkingStructure.getLevel2().getCompactLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel2().getCompactLot().put(space, vehicle.getTagNumber());
		} if (vehicle instanceof MidSizeCar && ParkingStructure.getLevel2().getMidSizeLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel2().getMidSizeLot().put(space, vehicle.getTagNumber());
		} if (vehicle instanceof Truck && ParkingStructure.getLevel2().getTruckLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel2().getTruckLot().put(space, vehicle.getTagNumber());
		}
	}
	
	public static void parkOnLevel3(ParkingSpace space, Vehicle vehicle) {
		if (vehicle instanceof Motorcycle && ParkingStructure.getLevel3().getMotorcycleLot().size() < 25) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel3().getMotorcycleLot().put(space, vehicle.getTagNumber());
		} else if (vehicle instanceof CompactCar && ParkingStructure.getLevel3().getCompactLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel3().getCompactLot().put(space, vehicle.getTagNumber());
		} if (vehicle instanceof MidSizeCar && ParkingStructure.getLevel3().getMidSizeLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel3().getMidSizeLot().put(space, vehicle.getTagNumber());
		} if (vehicle instanceof Truck && ParkingStructure.getLevel3().getTruckLot().size() < 50) {
			space.setVehicle(vehicle);
			ParkingStructure.getLevel3().getTruckLot().put(space, vehicle.getTagNumber());
		}
	}

	@Override
	public String toString() {
		return "ParkingStructure []";
	}

}
