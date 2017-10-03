package model;

import java.util.HashMap;
import java.util.LinkedList;

public class ParkingLevel {

	private HashMap<ParkingSpace, String> motorcycleLot;
	private LinkedList<ParkingSpace> takenMotorcycleSpaces;
	private int motorcycleSpaceCounter;

	private HashMap<ParkingSpace, String> compactLot;
	private LinkedList<ParkingSpace> takenCompactSpaces;
	private int compactSpaceCounter;

	private HashMap<ParkingSpace, String> midSizeLot;
	private LinkedList<ParkingSpace> takenMidSizeSpaces;
	private int midSizeSpaceCounter;

	private HashMap<ParkingSpace, String> truckLot;
	private LinkedList<ParkingSpace> takenTruckSpaces;
	private int truckSpaceCounter;

	public ParkingLevel() {
		motorcycleLot = new HashMap<ParkingSpace, String>();
		takenMotorcycleSpaces = new LinkedList();
		motorcycleSpaceCounter = 0;

		compactLot = new HashMap<ParkingSpace, String>();
		takenCompactSpaces = new LinkedList();
		compactSpaceCounter = 0;

		midSizeLot = new HashMap<ParkingSpace, String>();
		takenMidSizeSpaces = new LinkedList();
		midSizeSpaceCounter = 0;

		truckLot = new HashMap<ParkingSpace, String>();
		takenTruckSpaces = new LinkedList();
		truckSpaceCounter = 0;
	}

	public HashMap<ParkingSpace, String> getMotorcycleLot() {
		return motorcycleLot;
	}

	public HashMap<ParkingSpace, String> getCompactLot() {
		return compactLot;
	}

	public HashMap<ParkingSpace, String> getMidSizeLot() {
		return midSizeLot;
	}

	public HashMap<ParkingSpace, String> getTruckLot() {
		return truckLot;
	}

	public LinkedList<ParkingSpace> getTakenMotorcycleSpaces() {
		return takenMotorcycleSpaces;
	}

	public void setTakenMotorcycleSpaces(LinkedList<ParkingSpace> takenMotorcycleSpaces) {
		this.takenMotorcycleSpaces = takenMotorcycleSpaces;
	}

	public LinkedList<ParkingSpace> getTakenCompactSpaces() {
		return takenCompactSpaces;
	}

	public void setTakenCompactSpaces(LinkedList<ParkingSpace> takenCompactSpaces) {
		this.takenCompactSpaces = takenCompactSpaces;
	}

	public LinkedList<ParkingSpace> getTakenMidSizeSpaces() {
		return takenMidSizeSpaces;
	}

	public void setTakenMidSizeSpaces(LinkedList<ParkingSpace> takenMidSizeSpaces) {
		this.takenMidSizeSpaces = takenMidSizeSpaces;
	}

	public LinkedList<ParkingSpace> getTakenTruckSpaces() {
		return takenTruckSpaces;
	}

	public void setTakenTruckSpaces(LinkedList<ParkingSpace> takenTruckSpaces) {
		this.takenTruckSpaces = takenTruckSpaces;
	}

	@Override
	public String toString() {
		return "ParkingLevel [motorcycleLot=" + motorcycleLot + ", takenMotorcycleSpaces=" + takenMotorcycleSpaces
				+ ", motorcycleSpaceCounter=" + motorcycleSpaceCounter + ", compactLot=" + compactLot
				+ ", takenCompactSpaces=" + takenCompactSpaces + ", compactSpaceCounter=" + compactSpaceCounter
				+ ", midSizeLot=" + midSizeLot + ", takenMidSizeSpaces=" + takenMidSizeSpaces + ", midSizeSpaceCounter="
				+ midSizeSpaceCounter + ", truckLot=" + truckLot + ", takenTruckSpaces=" + takenTruckSpaces
				+ ", truckSpaceCounter=" + truckSpaceCounter + "]";
	}

}
