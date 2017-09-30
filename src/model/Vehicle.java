package model;

public class Vehicle {

	private static int idInt = 1;

	private String size;
	private String licensePlate;
	private String id;

	public Vehicle(String size, String licensePlate) {
		this.id = String.valueOf(idInt);
		this.size = size;
		this.licensePlate = licensePlate;
		idInt++;
	}

	public static int getIdInt() {
		return idInt;
	}

	public static void setIdInt(int idInt) {
		Vehicle.idInt = idInt;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vehicle [size=" + size + ", licensePlate=" + licensePlate + ", id=" + id + "]";
	}

}
