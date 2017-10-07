package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.Hyperlink;

public class ParkingStructure implements ParkingBehavior, Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private static ParkingStructure _structure;

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
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMotorcycleLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMotorcycleLot().get(e);
				if (tempSpace.getVehicle() == null && !spaceFound[0]) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setStartTime(System.currentTimeMillis());
					spaceFound[0] = true;
				}

			});
		} else if (vehicle instanceof CompactCar) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getCompactLot().get(e);
				if (tempSpace.getVehicle() == null && !spaceFound[0]) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setStartTime(System.currentTimeMillis());
					spaceFound[0] = true;
				}

			});
		} else if (vehicle instanceof MidSizeCar) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMidSizeLot().get(e);
				if (tempSpace.getVehicle() == null && !spaceFound[0]) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setStartTime(System.currentTimeMillis());
					spaceFound[0] = true;
				}

			});
		} else if (vehicle instanceof Truck) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getTruckLot().get(e);
				if (tempSpace.getVehicle() == null && !spaceFound[0]) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setStartTime(System.currentTimeMillis());
					spaceFound[0] = true;
				}

			});
		}
	}

	public static void unparkOnLevel1(Vehicle vehicle) {
		if (vehicle instanceof Motorcycle) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMotorcycleLot().keySet().forEach(e -> { // loops
																					// through
																					// keys
				// for each iteration, the tempSpace variable is equal to the
				// value of each key
				MotorcycleSpace tempSpace = (MotorcycleSpace) ParkingStructure.getLevel1().getMotorcycleLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					tempSpace.getVehicle().setEndTime(System.currentTimeMillis());
					tempSpace.removeVehicle(vehicle);
					spaceFound[0] = true;
				}

			});
		} else if (vehicle instanceof CompactCar) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getCompactLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					tempSpace.removeVehicle(vehicle);
					tempSpace.getVehicle().setEndTime(System.currentTimeMillis());
					spaceFound[0] = true;
				}

			});
		} else if (vehicle instanceof MidSizeCar) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMidSizeLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					tempSpace.removeVehicle(vehicle);
					tempSpace.getVehicle().setEndTime(System.currentTimeMillis());
					spaceFound[0] = true;
				}

			});
		} else if (vehicle instanceof Truck) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getTruckLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					tempSpace.removeVehicle(vehicle);
					tempSpace.getVehicle().setEndTime(System.currentTimeMillis());
					spaceFound[0] = true;
				}

			});
		}
	}

	@Override
	public String toString() {
		return "ParkingStructure []";
	}

}
