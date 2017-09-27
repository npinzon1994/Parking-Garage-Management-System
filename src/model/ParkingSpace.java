package model;

public abstract class ParkingSpace {

	private static int idInt = 1;

	private String size;
	private String id;
	private boolean status;

	public ParkingSpace(String size, boolean status) {
		super();
		this.size = size;
		this.id = id;
		this.status = status;
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

}
