package model;

import java.util.HashMap;

public class ParkingLot {

	private HashMap<ParkingSpace, String> motorcycleLot;
	private HashMap<ParkingSpace, String> compactLot;
	private HashMap<ParkingSpace, String> midSizeLot;
	private HashMap<ParkingSpace, String> truckLot;

	public ParkingLot() {
		motorcycleLot = new HashMap<ParkingSpace, String>();
		compactLot = new HashMap<ParkingSpace, String>();
		midSizeLot = new HashMap<ParkingSpace, String>();
		truckLot = new HashMap<ParkingSpace, String>();
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

}
