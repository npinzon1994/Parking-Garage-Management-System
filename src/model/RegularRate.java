package model;

import java.io.Serializable;

public class RegularRate implements HourlyRate, Serializable {

	private static final long serialVersionUID = -1622922921952537919L;	
	private double normalRate; //daily rate between the hours of 7AM and 11:59PM

	@Override
	public double getHourlyRate() {
		return normalRate;
	}

	@Override
	public void setHourlyRate(double rate) {
		this.normalRate = rate;

	}

}
