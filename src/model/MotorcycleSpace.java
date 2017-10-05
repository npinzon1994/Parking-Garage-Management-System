package model;

public class MotorcycleSpace extends RegularSpace {

	public MotorcycleSpace(Vehicle vehicle, long startTime, long endTime, double hoursParked) {
		super(vehicle, startTime, endTime, hoursParked);
	}

	@Override
	public double calculateEarlyBirdRate(String startTime, String endTime) {
		double startTimeDouble = Double.parseDouble(startTime);
		double endTimeDouble = Double.parseDouble(endTime);
		double rate = 7.00;
		double earlyBirdRate = ((endTimeDouble - startTimeDouble)*rate);
		return earlyBirdRate;
	}

	@Override
	public double calculateRegularRate(String startTime, String endTime) {
		double startTimeDouble = Double.parseDouble(startTime);
		double endTimeDouble = Double.parseDouble(endTime);
		double rate = 14.00;
		double regularRate = ((endTimeDouble - startTimeDouble)*rate);
		return regularRate;
	}

	@Override
	public String toString() {
		return "MotorcycleSpace []";
	}

	

}
