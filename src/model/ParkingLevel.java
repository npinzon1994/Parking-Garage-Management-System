package model;

import java.io.EOFException;
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

public class ParkingLevel implements Serializable {

	private static final long serialVersionUID = 844618332991485586L;
	private HashMap<String, ParkingSpace> motorcycleLot;
	private ParkingSpace[] motorcycleSpaces;

	private HashMap<String, ParkingSpace> compactLot;
	private ParkingSpace[] compactSpaces;

	private HashMap<String, ParkingSpace> midSizeLot;
	private ParkingSpace[] midSizeSpaces;

	private HashMap<String, ParkingSpace> truckLot;
	private ParkingSpace[] truckSpaces;

	public ParkingLevel() {
		motorcycleLot = new HashMap<String, ParkingSpace>();
		motorcycleSpaces = new MotorcycleSpace[25];
		for (int i = 0; i < motorcycleSpaces.length; i++) {
			motorcycleSpaces[i] = new MotorcycleSpace(null);
			motorcycleLot.put(motorcycleSpaces[i].getId(), motorcycleSpaces[i]);
		}

		compactLot = new HashMap<String, ParkingSpace>();
		compactSpaces = new CompactSpace[50];
		for (int i = 0; i < compactSpaces.length; i++) {
			compactSpaces[i] = new CompactSpace(null);
			compactLot.put(compactSpaces[i].getId(), compactSpaces[i]);
		}

		midSizeLot = new HashMap<String, ParkingSpace>();
		midSizeSpaces = new MidSizeSpace[50];
		for (int i = 0; i < midSizeSpaces.length; i++) {
			midSizeSpaces[i] = new MidSizeSpace(null);
			midSizeLot.put(midSizeSpaces[i].getId(), midSizeSpaces[i]);
		}

		truckLot = new HashMap<String, ParkingSpace>();
		truckSpaces = new TruckSpace[50];
		for (int i = 0; i < truckSpaces.length; i++) {
			truckSpaces[i] = new TruckSpace(null);
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

	public HashMap<String, ParkingSpace> getMotorcycleLot() {
		return motorcycleLot;
	}

	public HashMap<String, ParkingSpace> getCompactLot() {
		return compactLot;
	}

	public HashMap<String, ParkingSpace> getMidSizeLot() {
		return midSizeLot;
	}

	public HashMap<String, ParkingSpace> getTruckLot() {
		return truckLot;
	}

	public void saveLevel() {
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;
		try {
			fileOutput = new FileOutputStream("saveData.dat");
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
			fileInput = new FileInputStream("saveData.dat");
			File file = new File("saveData.dat");
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
