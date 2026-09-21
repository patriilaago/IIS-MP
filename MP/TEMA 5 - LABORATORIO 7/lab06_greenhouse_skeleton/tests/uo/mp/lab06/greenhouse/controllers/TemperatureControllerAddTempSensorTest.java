package uo.mp.lab06.greenhouse.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.lab06.greenhouse.sensors.TemperatureSensor;

public class TemperatureControllerAddTempSensorTest {

	/**
	 * GIVEN: an empty temperature controller and a correct temperature sensor
	 * WHEN: addSensor(sensor)
	 * THEN: the sensor is added correctly to the sensors list in the controller
	 */
	@Test
	void correctSensor() {
		TemperatureController tempCtrl = new TemperatureController();
		TemperatureSensor sensor = new TemperatureSensor("id1");
		
		tempCtrl.addSensor(sensor);
		
		assertEquals(tempCtrl.getSensors().contains(sensor),true);
	}
	
	/**
	 * GIVEN: an empty temperature controller and a null temperature sensor
	 * WHEN: addSensor(null)
	 * THEN: an exception is thrown saying that we can't add a null sensor
	 */
	@Test
	public void nullSensor() {
		TemperatureController tempCtrl = new TemperatureController();
		
		try {
			tempCtrl.addSensor(null);
			fail("Exception expected");
		}
		catch(Exception e) {
			assertEquals("The sensor cannot be null",e.getMessage());
		}
	}

}
