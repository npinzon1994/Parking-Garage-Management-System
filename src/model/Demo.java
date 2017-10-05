package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Demo {

	public static void main(String[] args) {
		ParkingStructure.getStructure();
		
		System.out.println(ParkingStructure.getDate());
		System.out.println(ParkingStructure.getTime());
		
	
		
	}
	public float getElapsedTime(long start, long end){
		start = System.currentTimeMillis();

	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Get elapsed time in milliseconds
	    long elapsedTimeMillis = System.currentTimeMillis() - start;
	    
	    // Get elapsed time in minutes
	    return elapsedTimeMillis/(60*1000F);
	}

}
