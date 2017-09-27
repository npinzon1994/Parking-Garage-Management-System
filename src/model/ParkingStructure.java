package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingStructure {

	private static ParkingStructure _structure;

	private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private static Date date = new Date();

	private static DateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");
	private static Date time = new Date();

	private static ParkingLot level1;
	private static ParkingLot level2;
	private static ParkingLot level3;

	private ParkingStructure() {
		level1 = new ParkingLot();
		level2 = new ParkingLot();
		level3 = new ParkingLot();
	}

	public static ParkingStructure getStructure() {
		if (_structure == null) {
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

	public static ParkingLot getLevel1() {
		return level1;
	}

	public static ParkingLot getLevel2() {
		return level2;
	}

	public static ParkingLot getLevel3() {
		return level3;
	}

}
