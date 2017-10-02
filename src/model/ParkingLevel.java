package model;

import java.util.HashSet;
import java.util.LinkedList;

public class ParkingLevel {

	private HashSet<ParkingSpace> motorcycleLot;
	private LinkedList<ParkingSpace> takenMotorcycleSpaces;
	private int motorcycleSpaceCounter;

	private HashSet<ParkingSpace> compactLot;
	private LinkedList<ParkingSpace> takenCompactSpaces;
	private int compactSpaceCounter;

	private HashSet<ParkingSpace> midSizeLot;
	private LinkedList<ParkingSpace> takenMidSizeSpaces;
	private int midSizeSpaceCounter;

	private HashSet<ParkingSpace> truckLot;
	private LinkedList<ParkingSpace> takenTruckSpaces;
	private int truckSpaceCounter;

	public ParkingLevel() {
		motorcycleLot = new HashSet<ParkingSpace>();
		takenMotorcycleSpaces = new LinkedList();
		motorcycleSpaceCounter = 0;

		compactLot = new HashSet<ParkingSpace>();
		takenCompactSpaces = new LinkedList();
		compactSpaceCounter = 0;

		midSizeLot = new HashSet<ParkingSpace>();
		takenMidSizeSpaces = new LinkedList();
		midSizeSpaceCounter = 0;

		truckLot = new HashSet<ParkingSpace>();
		takenTruckSpaces = new LinkedList();
		truckSpaceCounter = 0;
	}

	public HashSet<ParkingSpace> getMotorcycleLot() {
		return motorcycleLot;
	}

	public HashSet<ParkingSpace> getCompactLot() {
		return compactLot;
	}

	public HashSet<ParkingSpace> getMidSizeLot() {
		return midSizeLot;
	}

	public HashSet<ParkingSpace> getTruckLot() {
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
		return "ParkingLevel [motorcycleLot=" + motorcycleLot + ", compactLot=" + compactLot + ", midSizeLot="
				+ midSizeLot + ", truckLot=" + truckLot + "]";
	}

}
