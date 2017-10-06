package model;

import java.io.Serializable;

public class HandicappedMotorcycleSpace extends HandicappedSpace implements Serializable {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedMotorcycleSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedMotorcycleSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
