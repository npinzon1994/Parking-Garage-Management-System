package model;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.Period;

public class Motorcycle extends Vehicle implements Serializable {

	private final double TAX_RATE = 0.18375;

	private static final long serialVersionUID = 844618332991485586L;

	public Motorcycle(String firstName, String lastName, String licensePlate, String timeSelect, double secondsParked, int levelId) {
		super(firstName, lastName, licensePlate, timeSelect, secondsParked, levelId);
	}

	/*
	 * This method calculates the minutely rate in seconds for quicker testing
	 */

	@Override
	public double calculateEarlyBirdRate(LocalTime startTime, LocalTime endTime) {

		double rate = (0.12);
		startTime.until(endTime, SECONDS);
		long seconds = SECONDS.between(startTime, endTime);
		double subtotal;
		double tax;
		double total = 0;
		if (getTimeSelect().equals("Up to 1/2 Hour") && seconds <= 30) {
			tax = TAX_RATE * 30;
			subtotal = rate * 30;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (getTimeSelect().equals("Up to 1/2 Hour") && seconds > 30) {
			System.out.println(rate);
			double newRateNum = (rate) * (1.2);
			double newRate = rate + newRateNum;
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		} else if (getTimeSelect().equals("Up to 1 Hour") && seconds <= 60) {
			tax = TAX_RATE * 60;
			subtotal = rate * 60;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (getTimeSelect().equals("Up to 1 Hour") && seconds > 60) {
			double newRate = rate + ((rate) * (1.2));
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		} else if (getTimeSelect().equals("Up to 2 Hours") && seconds <= 120) {
			tax = TAX_RATE * 120;
			subtotal = rate * 120;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (getTimeSelect().equals("Up to 2 Hours") && seconds > 120) {
			double newRate = rate + ((rate) * (1.2));
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		}
		return total;
	}

	@Override
	public double calculateRegularRate(LocalTime startTime, LocalTime endTime) {
		
		double rate = (0.23);
		startTime.until(endTime, SECONDS);
		long seconds = SECONDS.between(startTime, endTime);
		double subtotal;
		double tax;
		double total = 0;
		
		
		if (getTimeSelect().equals("Up to 1/2 Hour") && seconds <= 30) {
			tax = TAX_RATE * 30;
			subtotal = rate * 30;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 20%
		} else if (getTimeSelect().equals("Up to 1/2 Hour") && seconds > 30) {
			rate = (rate) * (1.2);
			tax = TAX_RATE * seconds;
			subtotal = rate * seconds;
			total = subtotal + tax;
			return total;

		} else if (getTimeSelect().equals("Up to 1 Hour") && seconds <= 60) {
			tax = TAX_RATE * 60;
			subtotal = rate * 60;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (getTimeSelect().equals("Up to 1 Hour") && seconds > 60) {
			double newRate = (rate) * (1.2);
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		} else if (getTimeSelect().equals("Up to 2 Hours") && seconds <= 120) {
			tax = TAX_RATE * 120;
			subtotal = rate * 120;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (getTimeSelect().equals("Up to 2 Hours") && seconds > 120) {
			double newRate = ((rate) * (1.2));
			tax = TAX_RATE * seconds;
			subtotal = newRate * seconds;
			total = subtotal + tax;
			return total;

		}
		return total;
	}

}
