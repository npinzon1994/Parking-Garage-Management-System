package view;

public class TimeslotValue {

	private String slotName = "";
	private int slotNumber;

	public TimeslotValue(String slotName) {
		this.slotName = slotName;
		if (slotName.equals("1/2 Hour")) {
			slotNumber = 30;
		} else if (slotName.equals("1 Hour")) {
			slotNumber = 60;
		} else if (slotName.equals("2 Hours")) {
			slotNumber = 120;
		}
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		if (slotName.equals("1/2 Hour")) {
			slotNumber = 30;
		} else if (slotName.equals("1 Hour")) {
			slotNumber = 60;
		} else if (slotName.equals("2 Hours")) {
			slotNumber = 120;
		} else if (slotName.equals("To Close (8PM)")){
			this.slotNumber = slotNumber;
		}
	}

	@Override
	public String toString() {
		return "TimeslotValue [slotName=" + slotName + ", slotNumber=" + slotNumber + "]";
	}

}
