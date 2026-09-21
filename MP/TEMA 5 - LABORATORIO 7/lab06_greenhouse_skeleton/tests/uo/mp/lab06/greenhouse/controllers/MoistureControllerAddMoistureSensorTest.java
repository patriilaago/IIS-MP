package uo.mp.lab06.greenhouse.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.lab06.greenhouse.actuators.doors.ManualDoor;
import uo.mp.lab06.greenhouse.sensors.MoistureSensor;

public class MoistureControllerAddMoistureSensorTest {

	/**
	 * GIVEN: an empty moisture controller and a correct moisture sensor
	 * WHEN: addSensor(sensor)
	 * THEN: the sensor is added correctly to the sensors list in the controller
	 */
	@Test
	public void correctDoor() {
		MoistureSensor sensor = new MoistureSensor("id1");
		MoistureController moistureCtrl = new MoistureController();

		moistureCtrl.addSensor(sensor);

		assertEquals(moistureCtrl.getMoistureSensors().contains(sensor),true);
	}
	
	/**
	 * GIVEN: an empty moisture controller and a null moisture sensor
	 * WHEN: addSensor(null)
	 * THEN: an exception is thrown saying that we can't add a null moisture sensor
	 */
	@Test
	public void nullDoor() {
		MoistureController moistureCtrl = new MoistureController();

		try {
			moistureCtrl.addSensor(null);
			fail("Exception expected");
		}
		catch(Exception e) {
			assertEquals("The moisture sensor cannot be null",e.getMessage());
		}
	}
}
