package uo.mp.lab06.greenhouse.sensors;

import java.util.Random;

import uo.mp.lab06.greenhouse.controllers.devicescanner.Checkable;


/**
 * <p>Title: Sensor</p>
 * <p>Description: Class that simulates a temperature sensor.</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 1.0
 */
public class TemperatureSensor extends AbstractSensor implements Checkable{

	private static final int MIN = 5;
	private static final int INCREASE = 36;
	

	public TemperatureSensor(String id) {
		super(id);
		
	}

	/**
	 * Simulates a temperature measurement 
	 * 
	 * It returns a value in the range [5, 40)
	 * @return The temperature measured by the sensor.
	 */
	@Override
	public int readValue() {
		return new Random().nextInt(INCREASE) + MIN;
	}
	
	@Override
	public String toString() {
		return "[TemperatureSensor] " + super.getId() ;
	}	
}
