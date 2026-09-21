package uo.mp.lab06.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab06.greenhouse.actuators.doors.AbstractDoor;
import uo.mp.lab06.greenhouse.actuators.doors.ManualDoor;
import uo.mp.lab06.greenhouse.sensors.TemperatureSensor;
import uo.mp.util.check.ArgumentChecks;

/**
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class TemperatureController {
	private static final double MAX_TEMPERATURE = 22;
	private static final double MIN_TEMPERATURE = 19;
	
	private List<TemperatureSensor> sensors = new ArrayList<>(); //list es interface
	private List<AbstractDoor> doors = new ArrayList<>();
	
	
	/**
	 * Handles the doors to keep the temperature under control between 19 and 22 degrees
	 *
	 * @return A list of messages generated when monitoring
	 */
	public List<String> monitor() {
		
				
		/*
		 * Get average temperature
		 * A message showing the average temperature is always shown on the console
		 * 
		 * When temperature is greater than maxTemperature (too hot)
		 * 	- Some doors should be opened (if possible) for cooling 
		 *	- Each degree of difference 
		 *		(temperature-maxTemperature) involves opening 10% 
		 *		of the doors (if possible)
		 * 	- Show a message telling how many doors are about to 
		 * 		be opened (if possible)
		 * 
		 * When temperature is lower than minTemperature (too cold)
		 *	- Some doors should be closed (if possible) for heating 
		 *	- Each degree of difference 
		 * 		(minTemperature-temperature) involves closing 10% 
		 * 		of the doors (if possible)
		 * - Show a message telling how many doors are about to be 
		 *		closed (if possible)
		 *
		 */

		/*
		 *  Holds strings to be returned to the control panel to inform the 
		 *  gardener after each and every execution of method monitor()
		 */
		//1
	    List<String> messages = new ArrayList<>();
	    double avgTemp = calculateAverageTemperature();
	    if (isTooCold(avgTemp)) {
	      messages.addAll(warmUp(avgTemp));
	    }
	    else if (isTooHot(avgTemp)) {
	      messages.addAll(coolDown(avgTemp));
	    }
	    else {
	      messages.add(rightTemperature(avgTemp));	
	    }
	    return messages;
	}
	
	private String rightTemperature(double temp) {
		return "Average temperature " + temp + " is right";
	}
	
	private boolean isTooHot(double temp) {
		if(calculateAverageTemperature()>MAX_TEMPERATURE) {
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean isTooCold(double temp) {
		if(calculateAverageTemperature()<MIN_TEMPERATURE) {
			return true;
		}
		else{
			return false;
		}
	}
		
	/**
	 * Warms up the greenhouse
	 * @param temp the average temperature calculate
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		to warm up the greenhouse
	 */
	private List<String> warmUp(double temp) {
		List<String> messages = new ArrayList<>();
		int doorsPerDegree = doors.size() / 10;
	    double diff = MIN_TEMPERATURE - temp;
	    messages.add("Current temp is " + temp + ". It is too cold");

	    int doorsToClose = (int) Math.ceil(diff * doorsPerDegree);
	    if (doorsToClose > 0) {
	    messages.add(doorsToClose + " doors must be closed");
	    messages.addAll(closeDoors(doorsToClose));
	    }
		return messages;
	}
	
	/**
	 * Tries to close doorsToClose doors
	 * @param doorsToClose number of doors to close
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		close as many doors as the argument
	 */
	private List<String> closeDoors(int doorsToClose) {
		List<String> messages = new ArrayList<>();
		for (AbstractDoor door : doors) {
			if (doorsToClose == 0)
		        return messages;
		    if (door.isOpened()) {
		        messages.add(door.close());
		        doorsToClose--;
		      }
		    }
		    if (doorsToClose > 0) {
		      messages.add(
		          "WARNING: Can not close enough doors. " + doorsToClose + " more doors should be closed");
		    }
		    return messages;
	}
	
	/**
	 * Cools down the greenhouse
	 * @param temp the average temperature calculate
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		to cool down the greenhouse
	 */
	private List<String> coolDown(double temp) {
	    List<String> messages = new ArrayList<>();

	    int doorsPerDegree = doors.size() / 10;
	    double diff = temp - MAX_TEMPERATURE;
	    messages.add("Current temp is " + temp + ". It is too hot");

	    int doorsToOpen = (int) Math.ceil(diff * doorsPerDegree);
	    if (doorsToOpen > 0) {
	      messages.add(doorsToOpen + " doors must be opened");
	      messages.addAll(openDoors(doorsToOpen));
	    }
	    return messages;
	}

	/**
	 * Open as many doors as the value passed as argument 
	 * @param doorsToOpen number of doors to open
	 * @return a list of messages to inform the gardener, probably empty, produced while trying
	 * 		to open the doors
	 */
	private List<String> openDoors(int doorsToOpen) {		
	    List<String> messages = new ArrayList<>();

	    for (AbstractDoor door : doors) {
	      if (doorsToOpen == 0)
	        return messages;
	      if (!door.isOpened()) {
	        messages.add(door.open());
	        doorsToOpen--;
	      }
	    }
	    if (doorsToOpen > 0) {
	      messages.add(
	          "WARNING: Can not open enough doors. " + doorsToOpen + " more doors should be opened");
	    }
	    return messages;
	}
	
	private double calculateAverageTemperature() {
		double addition = 0;
		for(TemperatureSensor sensor : sensors) {
			addition += sensor.readValue();
		}
		return (addition / sensors.size()); 
	}
	
	public void addSensor(TemperatureSensor sensor) {
		ArgumentChecks.isTrue(sensor != null, "The sensor cannot be null");
		if(!sensors.contains(sensor)) {
			sensors.add(sensor);
		}
	}
	
	public void addDoor(AbstractDoor door) {
		ArgumentChecks.isTrue(door != null, "The door cannot be null");
		if(!doors.contains(door)) {
			doors.add(door);
		}
	}
	
	List<AbstractDoor>getDoors(){
		return doors;
	}
	
	List<TemperatureSensor>getSensors(){
		return sensors;
	}

	@Override
	public String toString() {
		return "TemperatureController [sensors=" + sensors + ", doors=" + doors + "]";
	}
	
	
	
}
