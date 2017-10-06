package model;

import java.io.Serializable;

public class HandicappedTruckSpace extends HandicappedSpace implements Serializable {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedTruckSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedTruckSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
