package model;

public class HandicappedCompactSpace extends HandicappedSpace {

	private HourlyRate earlyBirdRate; // interface
	private HourlyRate regularRate; // interface

	public HandicappedCompactSpace(Vehicle vehicle) {
		super(vehicle);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedCompactSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
