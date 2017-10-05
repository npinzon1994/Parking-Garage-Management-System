package model;

public abstract class RegularSpace extends ParkingSpace {

	public RegularSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegularSpace [getId()=" + getId() 
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public abstract double calculateEarlyBirdRate(String startTime, String endTime);
	public abstract double calculateRegularRate(String startTime, String endTime);

}
