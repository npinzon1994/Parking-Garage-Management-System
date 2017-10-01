package model;

public class EarlyBirdRate implements HourlyRate {

	private double earlyBirdRate;

	@Override
	public double getHourlyRate() {
		return earlyBirdRate;
	}

	@Override
	public void setHourlyRate(double rate) {
		this.earlyBirdRate = rate;

	}

}
