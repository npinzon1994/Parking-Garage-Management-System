package model;

public class Vehicle {

	private static int idInt = 1;

	private String licensePlate;
	private String tagNumber;

	public Vehicle(String licensePlate) {
		this.tagNumber = String.valueOf(idInt);
		this.licensePlate = licensePlate;
		idInt++;
	}

	public static int getIdInt() {
		return idInt;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getTagNumber() {
		return tagNumber;
	}

	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", tagNumber=" + tagNumber + "]";
	}

}
