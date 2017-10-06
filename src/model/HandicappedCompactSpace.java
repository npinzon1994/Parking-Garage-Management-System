package model;

import java.io.Serializable;

public class HandicappedCompactSpace extends HandicappedSpace implements Serializable {

	private HourlyRate earlyBirdRate; // interface
	private HourlyRate regularRate; // interface

	public HandicappedCompactSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedCompactSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
