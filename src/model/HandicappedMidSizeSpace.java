package model;

import java.io.Serializable;

public class HandicappedMidSizeSpace extends HandicappedSpace implements Serializable {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedMidSizeSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedMidSizeSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
