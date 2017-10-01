package model;

public class MidSizeSpace extends RegularSpace {

	private HourlyRate earlyBirdRate; // interface
	private HourlyRate regularRate; // interface

	public MidSizeSpace(String size, boolean status) {
		super(size, status);
		earlyBirdRate = new EarlyBirdRate(); // object containing double value
												// for early bird rate
		regularRate = new RegularRate(); // object containing double value for
										// regular hourly rate
	}

	@Override
	public String toString() {
		return "MidSizeSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
