package model;

import java.io.Serializable;

public class TruckSpace extends RegularSpace implements Serializable {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public TruckSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
	}

	@Override
	public String toString() {
		return "TruckSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

	@Override
	public double calculateEarlyBirdRate(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateRegularRate(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return 0;
	}

}
