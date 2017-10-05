package model;

public class MidSizeSpace extends RegularSpace {

	private HourlyRate earlyBirdRate; // interface
	private HourlyRate regularRate; // interface

	public MidSizeSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
		earlyBirdRate = new EarlyBirdRate(); // object containing double value
		// for early bird rate
		regularRate = new RegularRate(); // object containing double value for
		// regular hourly rate
	}

	@Override
	public String toString() {
		return "MidSizeSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
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
