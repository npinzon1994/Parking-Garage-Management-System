package model;

public class HandicappedSpace extends ParkingSpace {

	private double hourlyRate;

	public HandicappedSpace(String size, boolean status) {
		super(size, status);
		hourlyRate = 13.50;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String toString() {
		return "HandicappedSpace [hourlyRate=" + hourlyRate + "]";
	}

}
