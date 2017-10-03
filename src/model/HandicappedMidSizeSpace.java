package model;

public class HandicappedMidSizeSpace extends HandicappedSpace {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedMidSizeSpace(Vehicle vehicle) {
		super(vehicle);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedMidSizeSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}