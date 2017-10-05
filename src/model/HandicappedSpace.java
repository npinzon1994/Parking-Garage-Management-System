package model;

public class HandicappedSpace extends ParkingSpace {

	public HandicappedSpace(Vehicle vehicle, double hoursParked) {
		super(vehicle, hoursParked);

	}

	@Override
	public String toString() {
		return "HandicappedSpace []";
	}

}
