package model;

public class HandicappedMidSizeSpace extends HandicappedSpace {

	private HourlyRate earlyBirdRate;
	private HourlyRate regularRate;

	public HandicappedMidSizeSpace(String size, boolean status) {
		super(size, status);
		earlyBirdRate = new EarlyBirdRate();
		regularRate = new RegularRate();
	}

	@Override
	public String toString() {
		return "HandicappedMidSizeSpace [earlyBirdRate=" + earlyBirdRate + ", regularRate=" + regularRate + "]";
	}

}
