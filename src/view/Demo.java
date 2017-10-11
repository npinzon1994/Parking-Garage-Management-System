package view;

import model.ParkingSpace;
import model.ParkingStructure;

/**
 * 
 * This is a simple application designed to be used by employees in a parking
 * garage. This parking maintenance system was designed to be expandable; The garage currently
 * has three levels, and can park Motorcycles, Compact cars, Mid size cars, and Vans/Trucks/SUVs.
 * 
 * The original idea was to have levels which included handicapped spaces but due
 * to time constraints, it will have to be implemented for the final project.
 * 
 * THE PARKING SPACES ARE TIMED BY THE SECOND. This is so anyone wanting to see the calculations don't
 * have to wait hours or minutes in real-time.
 * 
 * The person choosing the amount of time they want to park is bound to that time. i.e. if you choose "up to 1/2 hour,
 * the person still pays the full price for the 1/2 hour even if they were only parked 10 minutes. If they 
 * go over the time, they are charged an extra 20% per second.
 * 
 * @author Nick Pinzon
 * 
 * @version 1.0
 *
 */
public class Demo {

	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		window.launch(MainWindow.class);

	}

}
