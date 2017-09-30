package model;

import java.util.HashSet;

public class ParkingLot {

	private HashSet<ParkingSpace> motorcycleLot;
	private HashSet<ParkingSpace> compactLot;
	private HashSet<ParkingSpace> midSizeLot;
	private HashSet<ParkingSpace> truckLot;

	public ParkingLot() {
		motorcycleLot = new HashSet<ParkingSpace>();
		compactLot = new HashSet<ParkingSpace>();
		midSizeLot = new HashSet<ParkingSpace>();
		truckLot = new HashSet<ParkingSpace>();
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

	@Override
	public String toString() {
		return "ParkingLot [motorcycleLot=" + motorcycleLot + ", compactLot=" + compactLot + ", midSizeLot="
				+ midSizeLot + ", truckLot=" + truckLot + "]";
	}

}
