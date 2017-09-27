package model;

public class RegularSpace extends ParkingSpace {

	private double hourlyRate;
	
	public RegularSpace(String size, boolean status) {
		super(size, status);
		hourlyRate = 18.00;
	}

	public void setHourlyRate(double hourlyRate){
		this.hourlyRate = hourlyRate;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	
}
