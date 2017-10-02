package model;

public class EarlyBirdRate implements HourlyRate {

	private double earlyBirdRate; // Should be from 12AM to 7AM (cheapest rate)
									//

	@Override
	public double getHourlyRate() {
		return earlyBirdRate;
	}

	@Override
	public void setHourlyRate(double rate) {
		this.earlyBirdRate = rate;

	}

}
