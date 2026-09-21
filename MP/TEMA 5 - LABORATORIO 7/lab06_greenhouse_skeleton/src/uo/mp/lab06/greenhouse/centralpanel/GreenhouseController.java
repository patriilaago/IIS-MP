package uo.mp.lab06.greenhouse.centralpanel;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab06.greenhouse.actuators.doors.AbstractDoor;
import uo.mp.lab06.greenhouse.actuators.doors.ManualDoor;
import uo.mp.lab06.greenhouse.controllers.MoistureController;
import uo.mp.lab06.greenhouse.controllers.TemperatureController;
import uo.mp.lab06.greenhouse.sensors.MoistureSensor;
import uo.mp.lab06.greenhouse.sensors.TemperatureSensor;
import uo.mp.util.check.ArgumentChecks;

/**
 * <p>
 * Title: GreenHouse
 * </p>
 * <p>
 * Description: Class that simulates a greenhouse.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2022
 * </p>
 * <p>
 * Computer Science Engineering School
 * </p>
 * <p>
 * Programming Methodology
 * </p>
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class GreenhouseController {

	private TemperatureController tempCtrl = new TemperatureController();
	private MoistureController moistureCtrl = new MoistureController();
	
	/**
	 * Adds temperature sensors to temperature controller
	 * 
	 * @param sensor
	 * @throws IllegalArgumentException
	 */
	public void addTemperatureSensorG(TemperatureSensor sensor) {
		ArgumentChecks.isNotNull(sensor, "Trying to add a sensor: Illegal null sensor");
		tempCtrl.addSensor(sensor);
	}
	
	/**
	 * Adds moisture sensors to moisture controller
	 * 
	 * @param sensor
	 * @throws IllegalArgumentException
	 */
	public void addMoistureSensorG(MoistureSensor sensor) {
		ArgumentChecks.isNotNull(sensor, "Trying to add a sensor: Illegal null sensor");
		moistureCtrl.addSensor(sensor);
	}

	/**
	 * Adds doors operated by gardener to temperature controller to simulate
	 * gardener operation
	 * 
	 * @param door
	 * @throws IllegalArgumentException
	 */
	public void addDoorG(AbstractDoor door) {
		ArgumentChecks.isNotNull(door, "Trying to add a door: Illegal null door");
		tempCtrl.addDoor(door);
	}

	/**
	 * Starts each and every control operation Displays messages returned by them
	 */
	public void start() {
		final int FRECUENCY = 2000;
		while (true) {
			/*
			 * Run temperature controller and diplays messages returned to command the
			 * gardener
			 */
			display(tempCtrl.monitor());

			sleep(FRECUENCY);
		}
	}

	private void display(List<String> arg) {
		for (String message : arg) {
			System.out.println(message);
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.err.println("Thread interrupted while sleeping "
				+ "before frequency time reached");
		}
	}

}
