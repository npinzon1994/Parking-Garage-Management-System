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

}
