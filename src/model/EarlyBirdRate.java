package model;

import java.io.Serializable;

public class EarlyBirdRate implements HourlyRate, Serializable {
	
	private static final long serialVersionUID = -172647580859841496L;
	
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
