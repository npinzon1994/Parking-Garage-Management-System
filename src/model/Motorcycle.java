package model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Motorcycle extends Vehicle implements Serializable {

	private final double TAX_RATE = 0.18375;
	
	private static final long serialVersionUID = 844618332991485586L;	
	public Motorcycle(String firstName, String lastName, String licensePlate, long startTime, long endTime, double amountCharged) {
		super(firstName, lastName, licensePlate, startTime, endTime, amountCharged);
	}
	@Override
	public double calculateEarlyBirdRate(long startTime, long endTime) {
		double rate = 7.00;
		double subtotal = (TimeUnit.MILLISECONDS.toMinutes(endTime - startTime)*rate);
		double tax = subtotal*TAX_RATE;
		double total = subtotal + tax;
		return total;
	}
	@Override
	public double calculateRegularRate(long startTime, long endTime) {
		double rate = 14.00;
		double subtotal = (TimeUnit.MILLISECONDS.toMinutes(endTime - startTime)*rate);
		double tax = subtotal*TAX_RATE;
		double total = subtotal + tax;
		return total;
	}

	

}
