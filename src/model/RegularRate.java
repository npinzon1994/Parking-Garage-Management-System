package model;

public class RegularRate implements HourlyRate {

	private double normalRate;

	@Override
	public double getHourlyRate() {
		return normalRate;
	}

	@Override
	public void setHourlyRate(double rate) {
		this.normalRate = rate;

	}

}
