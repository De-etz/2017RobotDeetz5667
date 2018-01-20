package org.usfirst.frc.team5667.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.Ultrasonic;

public class UltrasonicSensor {
	private Ultrasonic sensor1; //Center of the robot
	private Ultrasonic sensor2; //Shooting lane
	
	private int reading1;
	private int reading2;
	private boolean inRange1;
	private boolean inRange2;
	
	public UltrasonicSensor() {
		sensor1 = new Ultrasonic(5, 4);
		reading1 = 0;
		inRange1 = false;
		
		sensor2 = new Ultrasonic(2, 1);
		sensor2.setAutomaticMode(true);
		reading2 = 0;
		inRange2 = false;
	}
	
	private void updateSensor() {
		reading1 = (int)sensor1.getRangeInches();
		reading2 = (int)sensor2.getRangeInches();
		if (reading1 > 200) {
			inRange1 = false;
		} else {
			inRange1 = true;
		}
		if (reading2 > 200) {
			inRange2 = false;
		} else {
			inRange2 = true;
		}
	}
	
	public int getReading1() {
		updateSensor();
		return reading1;
	}
	public int getReading2() {
		updateSensor();
		return reading2;
	}
	//Only call these two after the previous two
	public boolean getRange1() {
		return inRange1;
	}
	public boolean getRange2() {
		return inRange2;
	}
	
	public void displayReadings() {
		if (Math.abs((int)sensor1.getRangeInches() - reading1) > 1 || 
				Math.abs((int)sensor2.getRangeInches() - reading2) > 1) {
			System.out.printf("%-8s", "C: " + getReading1());
			System.out.printf("%-9s", " S: " + getReading2());
			System.out.println();
		}
	}
	public int getAlignment() {
		int alignment;
		int difference = getReading1() - getReading2();
		if (difference > 0) {
			alignment = -1;
		} else if (difference < 0) {
			alignment = 1;
		} else {
			alignment = 0;
		}
		return alignment;
	}
	
	public int getDefAlignment() {
		int alignment;
		double reading1 = getDefDistance1();
		double reading2 = getDefDistance2();
		double difference = reading1 - reading2;
		if (difference > .5) {
			alignment = -1;
		} else if (difference < -.5) {
			alignment = 1;
		} else {
			alignment = 0;
		}
		return alignment;
	}
	
	public double getDefDistance1() {
		HashMap<Double, Integer> readings = new HashMap<Double, Integer>(); //Distance, count
		
		Timer timer = new Timer(.1);
		//Build HashMap
		while (!timer.isDone()) {
			double distance = ((int)(sensor1.getRangeInches()*100)/100.0);
			if (readings.containsKey(distance)) {
				readings.replace(distance, readings.get(distance)+1);
			} else {
				readings.put(distance, 1);
			}
		}
		double defDistance = 0;
		int maxOccurences = 0;
		for (Double distance : readings.keySet()) {
			if (readings.get(distance) > maxOccurences) {
				defDistance = distance;
				maxOccurences = readings.get(distance);
			}
		}
		if (defDistance > 150) {
			return -1;
		}
		return defDistance;
	}
	public double getDefDistance2() {
		HashMap<Double, Integer> readings = new HashMap<Double, Integer>(); //Distance, count
		
		Timer timer = new Timer(.1);
		//Build HashMap
		while (!timer.isDone()) {
			double distance = ((int)(sensor2.getRangeInches()*100)/100.0);
			if (readings.containsKey(distance)) {
				readings.replace(distance, readings.get(distance)+1);
			} else {
				readings.put(distance, 1);
			}
		}
		double defDistance = 0;
		int maxOccurences = 0;
		for (Double distance : readings.keySet()) {
			if (readings.get(distance) > maxOccurences) {
				defDistance = distance;
				maxOccurences = readings.get(distance);
			}
		}
		if (defDistance > 200) {
			return -1;
		}
		return defDistance;
	}
}
