package uo.mp.lab06.greenhouse;

import uo.mp.lab06.greenhouse.actuators.doors.AutomaticDoor;
import uo.mp.lab06.greenhouse.actuators.doors.ManualDoor;
import uo.mp.lab06.greenhouse.centralpanel.GreenhouseController;
import uo.mp.lab06.greenhouse.sensors.MoistureSensor;
import uo.mp.lab06.greenhouse.sensors.TemperatureSensor;

/**
 * <p>
 * Title: Application
 * </p>
 * <p>
 * Description: Class that executes the program.
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
public class Main {

	private GreenhouseController greenhouse;

	/**
	 * Main method that launches the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().configure().run();
	}

	/*
	 * Set doors, temperature and humidity sensors
	 */
	private Main configure() {
		greenhouse = new GreenhouseController();
		final int INITIAL_NUMBER = 10;
		for (int i = 0; i < INITIAL_NUMBER; i++) {
			greenhouse.addTemperatureSensorG(new TemperatureSensor(Integer.toString(i)));
			greenhouse.addMoistureSensorG(new MoistureSensor(Integer.toString(i)));
			greenhouse.addDoorG(new ManualDoor(Integer.toString(i)));
			greenhouse.addDoorG(new AutomaticDoor(Integer.toString(i)));
		}

		return this;
	}

	/**
	 * Method that executes the application.
	 */
	private void run() {
		greenhouse.start();
	}

}
