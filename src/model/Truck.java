package model;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.io.Serializable;
import java.time.LocalTime;

public class Truck extends Vehicle implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;

	private final double TAX_RATE = 0.18235;

	public Truck(String firstName, String lastName, String licensePlate, String timeSelect, double secondsParked, int levelId) {
		super(firstName, lastName, licensePlate, timeSelect, secondsParked, levelId);
	}

	@Override
	public double calculateEarlyBirdRate(LocalTime startTime, LocalTime endTime) {
		double rate = (17.00 / 60);
		startTime.until(endTime, SECONDS);
		long seconds = SECONDS.between(startTime, endTime);
		double subtotal = rate * 30;
		double tax = TAX_RATE * 30;
		double total = subtotal + tax;
		if (getTimeSelect().equals("Up to 1/2 Hour") && seconds <= 30) {
			tax = TAX_RATE * 30;
			subtotal = rate * 30;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (getTimeSelect().equals("Up to 1/2 Hour") && seconds > 30) {
			double newRate = ((rate) * (1.2));
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
			double newRate = ((rate) * (1.2));
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

	@Override
	public double calculateRegularRate(LocalTime startTime, LocalTime endTime) {
		double rate = (22.00 / 60);
		startTime.until(endTime, SECONDS);
		long seconds = SECONDS.between(startTime, endTime);
		double subtotal = rate * 30;
		double tax = TAX_RATE * 30;
		double total = subtotal + tax;
		if (getTimeSelect().equals("Up to 1/2 Hour") && seconds <= 30) {
			tax = TAX_RATE * 30;
			subtotal = rate * 30;
			total = subtotal + tax;
			return total;
			// Anybody who leaves their car longer than expected has to pay
			// additional 10%
		} else if (getTimeSelect().equals("Up to 1/2 Hour") && seconds > 30) {
			double newRate = ((rate) * (1.2));
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
			double newRate = ((rate) * (1.2));
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
