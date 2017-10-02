package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ParkingStructure {

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

	@Override
	public String toString() {
		return "ParkingStructure []";
	}

}
