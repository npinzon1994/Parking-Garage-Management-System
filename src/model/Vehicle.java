package model;

import java.io.Serializable;
import java.time.LocalTime;

import javafx.scene.control.ComboBox;

public abstract class Vehicle implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private static int idInt = 1;

	private String licensePlate;
	private String tagNumber;

	private String firstName;
	private String lastName;
	private String timeSelect;

	private LocalTime startTime;
	private LocalTime endTime;
	private double amountCharged;
	private double secondsParked;

	public Vehicle(String firstName, String lastName, String licensePlate, String timeSelect, double secondsParked) {
		this.tagNumber = String.valueOf(idInt);
		this.licensePlate = licensePlate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startTime = LocalTime.now();
		this.secondsParked = secondsParked;
		this.timeSelect = timeSelect;
		idInt++;
	}

	public static int getIdInt() {
		return idInt;
	}

	public static void setIdInt(int idCount) {
		idInt = idCount;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getTimeSelect() {
		return timeSelect;
	}

	public void setTimeSelect(String timeSelect) {
		this.timeSelect = timeSelect;
	}

	public String getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String first) {
		this.firstName = first;
	}

	public void setLastName(String last) {
		this.lastName = last;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public double getAmountCharged() {
		return amountCharged;
	}

	public void setAmountCharged(double amountCharged) {
		this.amountCharged = amountCharged;
	}

	public double getSecondsParked() {
		return secondsParked;
	}

	public void setSecondsParked(double secondsParked) {
		this.secondsParked = secondsParked;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((tagNumber == null) ? 0 : tagNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		if (tagNumber == null) {
			if (other.tagNumber != null)
				return false;
		} else if (!tagNumber.equals(other.tagNumber))
			return false;
		return true;
	}

	public abstract double calculateEarlyBirdRate(LocalTime startTime, LocalTime endTime);

	public abstract double calculateRegularRate(LocalTime startTime, LocalTime endTime);

	public abstract double FlatRateTilClose();

	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", tagNumber=" + tagNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
