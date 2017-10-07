package model;

import java.io.Serializable;

public class CompactCar extends Vehicle implements Serializable {
	
	private static final long serialVersionUID = 844618332991485586L;
	
	public CompactCar(String firstName, String lastName, String licensePlate, long startTime, long endTime, double amountCharged) {
		super(firstName, lastName, licensePlate, startTime, endTime, amountCharged);
	}

	@Override
	public double calculateEarlyBirdRate(long startTime, long endTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateRegularRate(long startTime, long endTime) {
		// TODO Auto-generated method stub
		return 0;
	}

}
