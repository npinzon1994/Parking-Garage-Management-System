package model;

public class CompactSpace extends RegularSpace {

	private HourlyRate earlyBirdRate; // interface
	private HourlyRate regularRate; // interface

	public CompactSpace(String size, Vehicle vehicle) {
		super(size, vehicle);
		earlyBirdRate = new EarlyBirdRate(); // object containing double value
												// for early bird rate
		regularRate = new RegularRate(); // object containing double value for
											// regular hourly rate
	}

	@Override
	public String toString() {
		return "CompactSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
