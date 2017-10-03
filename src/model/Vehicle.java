package model;

public class Vehicle {

	private static int idInt = 1;

	private String licensePlate;
	private String tagNumber;

	private String firstName;
	private String lastName;

	public Vehicle(String firstName, String lastName, String licensePlate) {
		this.tagNumber = String.valueOf(idInt);
		this.licensePlate = licensePlate;
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setFirstName(String first){
		this.firstName = first;
	}
	
	public void setLastName(String last){
		this.lastName = last;
	}

	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", tagNumber=" + tagNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
