package model;

import java.io.Serializable;
import java.time.LocalTime;

import javafx.scene.control.ComboBox;

/**
 * This class can be used to instantiate Vehicle objects to be parked in a
 * parking garage. There are four subclasses: Motorcycle, CompactCar,
 * MidSizeCar, and Truck.
 * 
 * @author nickpinzon
 *
 */

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
	private String spaceNo;
	private double amountCharged;
	private double secondsParked;
	
	private String spaceType;

	private int levelId;

	/**
	 * 
	 * Constructs a vehicle object that can be parked and removed from parking
	 * spaces.
	 * 
	 * @param firstName
	 *            The customer's first name.
	 * @param lastName
	 *            The customer's last name.
	 * @param licensePlate
	 *            The customer's license plate number.
	 * @param timeSelect
	 *            The minimum amount of time for which the customer is charged
	 * @param secondsParked
	 *            The number of seconds the vehicle is parked
	 */

	public Vehicle(String firstName, String lastName, String licensePlate, String timeSelect, double secondsParked,
			int levelId) {
		this.tagNumber = String.valueOf(idInt);
		this.licensePlate = licensePlate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startTime = LocalTime.now();
		this.secondsParked = secondsParked;
		this.timeSelect = timeSelect;
		this.levelId = levelId;
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

	public String getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(String spaceNo) {
		this.spaceNo = spaceNo;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	public void setSpaceType(String type){
		this.spaceType = type;
	}
	
	public String getSpaceType(){
		return spaceType;
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

	/**
	 * 
	 * This method calculates the hourly parking rate from 12AM to 7AM.
	 * 
	 * @param startTime
	 *            The time the vehicle parks and starts getting charged.
	 * @param endTime
	 *            The time the vehicle leaves and then pays.
	 * @return The amount to be paid in USD.
	 */

	public abstract double calculateEarlyBirdRate(LocalTime startTime, LocalTime endTime);

	/**
	 * 
	 * @param startTime
	 *            The time the vehicle parks and starts getting charged.
	 * @param endTime
	 *            The time the vehicle leaves and then pays.
	 * @return The amount to be paid in USD.
	 */

	public abstract double calculateRegularRate(LocalTime startTime, LocalTime endTime);

	/**
	 * Standard toString() method for the Vehicle class.
	 */
	
	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", tagNumber=" + tagNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", timeSelect=" + timeSelect + ", startTime=" + startTime + ", endTime="
				+ endTime + ", spaceNo=" + spaceNo + ", amountCharged=" + amountCharged + ", secondsParked="
				+ secondsParked + ", levelId=" + levelId + "]";
	}


}
