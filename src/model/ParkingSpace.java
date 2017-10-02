package model;

public abstract class ParkingSpace {

	private static int idInt = 1;

	private String size;
	private String id;
	private boolean status;
	private Vehicle vehicle;

	public ParkingSpace(String size, Vehicle vehicle) {
		super();
		this.id = String.valueOf(idInt);
		this.size = size;
		this.vehicle = vehicle;
		if (vehicle == null) {
			this.status = true; //spot is empty
		} else {
			this.status = false; //spot is taken
		}
		idInt++;
	}

	public static int getIdInt() {
		return idInt;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ParkingSpace [size=" + size + ", id=" + id + ", status=" + status + "]";
	}

}
