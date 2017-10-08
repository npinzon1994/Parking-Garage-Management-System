package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ParkingLevel implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private Map<String, ParkingSpace> motorcycleLot;
	private ParkingSpace[] motorcycleSpaces;

	private Map<String, ParkingSpace> compactLot;
	private ParkingSpace[] compactSpaces;

	private Map<String, ParkingSpace> midSizeLot;
	private ParkingSpace[] midSizeSpaces;

	private Map<String, ParkingSpace> truckLot;
	private ParkingSpace[] truckSpaces;

	public ParkingLevel() {
		motorcycleLot = new HashMap<String, ParkingSpace>();
		motorcycleSpaces = new MotorcycleSpace[25];
		for (int i = 0; i < motorcycleSpaces.length; i++) {
			motorcycleSpaces[i] = new MotorcycleSpace(null, 1);
			motorcycleLot.put(motorcycleSpaces[i].getId(), motorcycleSpaces[i]);
			
		}
		
		compactLot = new HashMap<String, ParkingSpace>();
		compactSpaces = new CompactSpace[50];
		for (int i = 0; i < compactSpaces.length; i++) {
			compactSpaces[i] = new CompactSpace(null, 1);
			compactSpaces[i].setSpaceType("Compact");
			compactSpaces[i].setLevel(1);
			compactLot.put(compactSpaces[i].getId(), compactSpaces[i]);

		}

		midSizeLot = new HashMap<String, ParkingSpace>();
		midSizeSpaces = new MidSizeSpace[50];
		for (int i = 0; i < midSizeSpaces.length; i++) {
			midSizeSpaces[i] = new MidSizeSpace(null, 1);
			midSizeSpaces[i].setSpaceType("Mid Size");
			midSizeSpaces[i].setLevel(1);
			midSizeLot.put(midSizeSpaces[i].getId(), midSizeSpaces[i]);

		}

		truckLot = new HashMap<String, ParkingSpace>();
		truckSpaces = new TruckSpace[50];
		for (int i = 0; i < truckSpaces.length; i++) {
			truckSpaces[i] = new TruckSpace(null, 1);
			truckSpaces[i].setSpaceType("Truck");
			truckSpaces[i].setLevel(1);
			truckLot.put(truckSpaces[i].getId(), truckSpaces[i]);

		}

	}

	public ParkingSpace[] getMotorcycleSpaces() {
		return motorcycleSpaces;
	}

	public ParkingSpace[] getCompactSpace() {
		return compactSpaces;
	}

	public ParkingSpace[] getMidSizeSpace() {
		return midSizeSpaces;
	}

	public ParkingSpace[] getTruckSpace() {
		return truckSpaces;
	}

	public Map<String, ParkingSpace> getMotorcycleLot() {
		return motorcycleLot;
	}

	public Map<String, ParkingSpace> getCompactLot() {
		return compactLot;
	}

	public Map<String, ParkingSpace> getMidSizeLot() {
		return midSizeLot;
	}

	public Map<String, ParkingSpace> getTruckLot() {
		return truckLot;
	}

	public void saveLevel() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;
		try {
			fileOutput = new FileOutputStream("saveData4.dat");
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(motorcycleLot);
			objectOutput.writeObject(motorcycleSpaces);
			objectOutput.writeInt(Vehicle.getIdInt());

			objectOutput.writeObject(compactLot);
			objectOutput.writeObject(compactSpaces);
			objectOutput.writeObject(midSizeLot);
			objectOutput.writeObject(midSizeSpaces);
			objectOutput.writeObject(truckLot);
			objectOutput.writeObject(truckSpaces);
			objectOutput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadLevel() {
		FileInputStream fileInput = null;
		ObjectInputStream objectInput = null;

		try {
			fileInput = new FileInputStream("saveData4.dat");
			File file = new File("saveData4.dat");
			objectInput = new ObjectInputStream(fileInput);
			if (file.exists()) {
				motorcycleLot = (HashMap<String, ParkingSpace>) objectInput.readObject();
				motorcycleSpaces = (ParkingSpace[]) objectInput.readObject();
				Vehicle.setIdInt(objectInput.readInt());
				compactLot = (HashMap<String, ParkingSpace>) objectInput.readObject();
				compactSpaces = (ParkingSpace[]) objectInput.readObject();
				midSizeLot = (HashMap<String, ParkingSpace>) objectInput.readObject();
				midSizeSpaces = (ParkingSpace[]) objectInput.readObject();
				truckLot = (HashMap<String, ParkingSpace>) objectInput.readObject();
				truckSpaces = (ParkingSpace[]) objectInput.readObject();

			}
			objectInput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ParkingLevel [motorcycleLot=" + motorcycleLot + ", motorcycleSpaces="
				+ Arrays.toString(motorcycleSpaces) + ", compactLot=" + compactLot + ", compactSpaces="
				+ Arrays.toString(compactSpaces) + ", midSizeLot=" + midSizeLot + ", midSizeSpaces="
				+ Arrays.toString(midSizeSpaces) + ", truckLot=" + truckLot + ", truckSpaces="
				+ Arrays.toString(truckSpaces) + "]";
	}

}
