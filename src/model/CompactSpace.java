package model;

public class CompactSpace extends RegularSpace {

	private HourlyRate earlyBirdRate; // interface
	private HourlyRate regularRate; // interface

	public CompactSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
		
	}

	@Override
	public String toString() {
		return "CompactSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
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
