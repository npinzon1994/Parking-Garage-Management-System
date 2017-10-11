package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 * This is the parking garage class which has three levels.
 * 
 * @author Nick Pinzon
 *
 */

public class ParkingStructure implements ParkingBehavior, Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private static ParkingStructure _structure;

	private static DateFormat dateFormat = new SimpleDateFormat("MM/d/yy");
	private static Date date = new Date();

	private static DateFormat timeFormat = new SimpleDateFormat("h:mm a");
	private static Date time = new Date();

	private static ParkingLevel level1;
	private static ParkingLevel level2;
	private static ParkingLevel level3;

	private ParkingStructure() {
		level1 = new ParkingLevel(1);
		level2 = new ParkingLevel(2);
		level3 = new ParkingLevel(3);
	}

	public static ParkingStructure getStructure() {
		if (_structure == null) {
			_structure = new ParkingStructure();
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
		// for motorcycles -- motorcycle lot
		if ((vehicle instanceof Motorcycle)
				&& (!(vehicle instanceof CompactCar) && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck))
				&& !ParkingStructure.getLevel1().motorcyclesFull()) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMotorcycleLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMotorcycleLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Motorcycle");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- compact lot
		} else if ((vehicle instanceof Motorcycle && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& ParkingStructure.getLevel1().motorcyclesFull() && !ParkingStructure.getLevel1().compactsFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getCompactLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Compact");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- mid size lot
		} else if (((vehicle instanceof Motorcycle) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel1().midSizesFull() && ParkingStructure.getLevel1().compactsFull()
				&& ParkingStructure.getLevel1().motorcyclesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- truck
		} else if (((vehicle instanceof Motorcycle) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel1().trucksFull() && ParkingStructure.getLevel1().midSizesFull()
				&& ParkingStructure.getLevel1().compactsFull() && ParkingStructure.getLevel1().motorcyclesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		// for compacts
		else if (((vehicle instanceof CompactCar && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel1().compactsFull()))) {

			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getCompactLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Compact");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for compacts when lot is full -- mid size lot
		} else if (((vehicle instanceof CompactCar) && !(vehicle instanceof Truck) && !(vehicle instanceof MidSizeCar)
				&& !(vehicle instanceof Motorcycle) && ParkingStructure.getLevel1().compactsFull()
				&& !ParkingStructure.getLevel1().midSizesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for mid size when lot is full -- truck lot
		} else if (((vehicle instanceof CompactCar) && !(vehicle instanceof Motorcycle)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel1().trucksFull() && ParkingStructure.getLevel1().midSizesFull()
				&& ParkingStructure.getLevel1().compactsFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		// for mid size cars
		else if (((vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel1().midSizesFull())) {

			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for mid size cars when lot is full -- truck lot
		} else if (((vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && ParkingStructure.getLevel1().midSizesFull()
				&& !ParkingStructure.getLevel1().trucksFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		else if (((vehicle instanceof Truck) && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel1().trucksFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getTruckLot().get(e);
				if (tempSpace.getVehicle() == null && !spaceFound[0]) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());
					spaceFound[0] = true;
				}

			});
		}
	}

	public static void parkOnLevel2(Vehicle vehicle) {
		// for motorcycles -- motorcycle lot
		if ((vehicle instanceof Motorcycle)
				&& (!(vehicle instanceof CompactCar) && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck))
				&& !ParkingStructure.getLevel2().motorcyclesFull()) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getMotorcycleLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getMotorcycleLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Motorcycle");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- compact lot
		} else if ((vehicle instanceof Motorcycle && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& ParkingStructure.getLevel2().motorcyclesFull() && !ParkingStructure.getLevel2().compactsFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getCompactLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Compact");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- mid size lot
		} else if (((vehicle instanceof Motorcycle) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel2().midSizesFull() && ParkingStructure.getLevel2().compactsFull()
				&& ParkingStructure.getLevel2().motorcyclesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- truck
		} else if (((vehicle instanceof Motorcycle) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel2().trucksFull() && ParkingStructure.getLevel2().midSizesFull()
				&& ParkingStructure.getLevel2().compactsFull() && ParkingStructure.getLevel2().motorcyclesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		// for compacts
		else if (((vehicle instanceof CompactCar && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel2().compactsFull()))) {

			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getCompactLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Compact");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for compacts when lot is full -- mid size lot
		} else if (((vehicle instanceof CompactCar) && !(vehicle instanceof Truck) && !(vehicle instanceof MidSizeCar)
				&& !(vehicle instanceof Motorcycle) && ParkingStructure.getLevel2().compactsFull()
				&& !ParkingStructure.getLevel2().midSizesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for mid size when lot is full -- truck lot
		} else if (((vehicle instanceof CompactCar) && !(vehicle instanceof Motorcycle)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel2().trucksFull() && ParkingStructure.getLevel2().midSizesFull()
				&& ParkingStructure.getLevel2().compactsFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		// for mid size cars
		else if (((vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel2().midSizesFull())) {

			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for mid size cars when lot is full -- truck lot
		} else if (((vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && ParkingStructure.getLevel2().midSizesFull()
				&& !ParkingStructure.getLevel2().trucksFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		else if (((vehicle instanceof Truck) && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel2().trucksFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getTruckLot().get(e);
				if (tempSpace.getVehicle() == null && !spaceFound[0]) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());
					spaceFound[0] = true;
				}

			});
		}
	}

	public static void parkOnLevel3(Vehicle vehicle) {
		// for motorcycles -- motorcycle lot
		if ((vehicle instanceof Motorcycle)
				&& (!(vehicle instanceof CompactCar) && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck))
				&& !ParkingStructure.getLevel3().motorcyclesFull()) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getMotorcycleLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getMotorcycleLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Motorcycle");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- compact lot
		} else if ((vehicle instanceof Motorcycle && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& ParkingStructure.getLevel3().motorcyclesFull() && !ParkingStructure.getLevel3().compactsFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getCompactLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Compact");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- mid size lot
		} else if (((vehicle instanceof Motorcycle) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel3().midSizesFull() && ParkingStructure.getLevel3().compactsFull()
				&& ParkingStructure.getLevel3().motorcyclesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for motorcycles when lot is full -- truck
		} else if (((vehicle instanceof Motorcycle) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel3().trucksFull() && ParkingStructure.getLevel3().midSizesFull()
				&& ParkingStructure.getLevel3().compactsFull() && ParkingStructure.getLevel3().motorcyclesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		// for compacts
		else if (((vehicle instanceof CompactCar && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel3().compactsFull()))) {

			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getCompactLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Compact");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for compacts when lot is full -- mid size lot
		} else if (((vehicle instanceof CompactCar) && !(vehicle instanceof Truck) && !(vehicle instanceof MidSizeCar)
				&& !(vehicle instanceof Motorcycle) && ParkingStructure.getLevel3().compactsFull()
				&& !ParkingStructure.getLevel3().midSizesFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for mid size when lot is full -- truck lot
		} else if (((vehicle instanceof CompactCar) && !(vehicle instanceof Motorcycle)
				&& !(vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck)
				&& !ParkingStructure.getLevel3().trucksFull() && ParkingStructure.getLevel3().midSizesFull()
				&& ParkingStructure.getLevel3().compactsFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		// for mid size cars
		else if (((vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel3().midSizesFull())) {

			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getMidSizeLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Mid Size");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});

			// for mid size cars when lot is full -- truck lot
		} else if (((vehicle instanceof MidSizeCar) && !(vehicle instanceof Truck) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && ParkingStructure.getLevel3().midSizesFull()
				&& !ParkingStructure.getLevel3().trucksFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getTruckLot().get(e);
				if ((tempSpace.getVehicle() == null && !spaceFound[0])) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());

					spaceFound[0] = true;
				}

			});
		}

		else if (((vehicle instanceof Truck) && !(vehicle instanceof MidSizeCar) && !(vehicle instanceof CompactCar)
				&& !(vehicle instanceof Motorcycle) && !ParkingStructure.getLevel3().trucksFull())) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getTruckLot().get(e);
				if (tempSpace.getVehicle() == null && !spaceFound[0]) {
					tempSpace.setVehicle(vehicle);
					tempSpace.getVehicle().setSpaceType("Truck");
					tempSpace.getVehicle().setSpaceNo(tempSpace.getId());
					tempSpace.getVehicle().setStartTime(LocalTime.now());
					spaceFound[0] = true;
				}

			});
		}
	}

	public static void unparkOnLevel1(Vehicle vehicle) {
		if ((vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Motorcycle"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMotorcycleLot().keySet().forEach(e -> { // loops
																					// through
																					// keys
				// for each iteration, the tempSpace variable is equal to the
				// value of each key
				MotorcycleSpace tempSpace = (MotorcycleSpace) ParkingStructure.getLevel1().getMotorcycleLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Compact"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Compact"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getCompactLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof MidSizeCar && vehicle.getSpaceType().equals("Mid Size"))
				|| (vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Mid Size"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Mid Size"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getMidSizeLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof Truck && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof MidSizeCar && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Truck"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel1().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel1().getTruckLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		}
	}

	public static void unparkOnLevel2(Vehicle vehicle) {
		if ((vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Motorcycle"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getMotorcycleLot().keySet().forEach(e -> { // loops
																					// through
																					// keys
				// for each iteration, the tempSpace variable is equal to the
				// value of each key
				MotorcycleSpace tempSpace = (MotorcycleSpace) ParkingStructure.getLevel2().getMotorcycleLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Compact"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Compact"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getCompactLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof MidSizeCar && vehicle.getSpaceType().equals("Mid Size"))
				|| (vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Mid Size"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Mid Size"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getMidSizeLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof Truck && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof MidSizeCar && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Truck"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel2().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel2().getTruckLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		}
	}

	public static void unparkOnLevel3(Vehicle vehicle) {
		if ((vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Motorcycle"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getMotorcycleLot().keySet().forEach(e -> { // loops
																					// through
																					// keys
				// for each iteration, the tempSpace variable is equal to the
				// value of each key
				MotorcycleSpace tempSpace = (MotorcycleSpace) ParkingStructure.getLevel3().getMotorcycleLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Compact"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Compact"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getCompactLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getCompactLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof MidSizeCar && vehicle.getSpaceType().equals("Mid Size"))
				|| (vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Mid Size"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Mid Size"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getMidSizeLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getMidSizeLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		} else if ((vehicle instanceof Truck && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof MidSizeCar && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof CompactCar && vehicle.getSpaceType().equals("Truck"))
				|| (vehicle instanceof Motorcycle && vehicle.getSpaceType().equals("Truck"))) {
			final boolean[] spaceFound = { false };
			ParkingStructure.getLevel3().getTruckLot().keySet().forEach(e -> {
				ParkingSpace tempSpace = ParkingStructure.getLevel3().getTruckLot().get(e);
				if (tempSpace.contains(vehicle) && !spaceFound[0]) {
					spaceFound[0] = true;
					tempSpace.removeVehicle(vehicle);
				}

			});
		}
	}

	public static void save() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;
		try {
			fileOutput = new FileOutputStream("saveData26.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(getLevel1());
			objectOutput.writeObject(getLevel2());
			objectOutput.writeObject(getLevel3());
			objectOutput.writeInt(Vehicle.getIdInt());
			objectOutput.writeInt(ParkingSpace.getIdInt());

			objectOutput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void load() {
		FileInputStream fileInput = null;
		ObjectInputStream objectInput = null;

		try {
			fileInput = new FileInputStream("saveData26.dat");
			File file = new File("saveData26.dat");
			objectInput = new ObjectInputStream(fileInput);
			if (file.exists()) {
				setLevel1((ParkingLevel) objectInput.readObject());
				setLevel2((ParkingLevel) objectInput.readObject());
				setLevel3((ParkingLevel) objectInput.readObject());
				Vehicle.setIdInt(objectInput.readInt());
				ParkingSpace.setIdInt(objectInput.readInt());

			}
			objectInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setLevel1(ParkingLevel level) {
		level1 = level;

	}

	private static void setLevel2(ParkingLevel level) {
		level2 = level;

	}

	private static void setLevel3(ParkingLevel level) {
		level3 = level;

	}

	@Override
	public String toString() {
		return "ParkingStructure []";
	}

}
