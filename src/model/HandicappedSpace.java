package model;

import java.io.Serializable;

public class HandicappedSpace extends ParkingSpace implements Serializable {

	public HandicappedSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);

	}

	@Override
	public String toString() {
		return "HandicappedSpace []";
	}

}
