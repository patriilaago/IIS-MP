package uo.mp.lab06.greenhouse.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.lab06.greenhouse.actuators.doors.ManualDoor;

public class TemperatureControllerAddDoorTest {

	/**
	 * GIVEN: an empty temperature controller and a correct manual door
	 * WHEN: addDoor(door)
	 * THEN: the door is added correctly to the doors list in the controller
	 */
	@Test
	public void correctDoor() {
		ManualDoor door = new ManualDoor("id1");
		TemperatureController tempCtrl = new TemperatureController();

		tempCtrl.addDoor(door);

		assertEquals(tempCtrl.getDoors().contains(door),true);
	}
	
	/**
	 * GIVEN: an empty temperature controller and a null door
	 * WHEN: addDoor(null)
	 * THEN: an exception is thrown saying that we can't add a null door
	 */
	@Test
	public void nullDoor() {
		TemperatureController tempCtrl = new TemperatureController();

		try {
			tempCtrl.addDoor(null);
			fail("Exception expected");
		}
		catch(Exception e) {
			assertEquals("The door cannot be null",e.getMessage());
		}
	}
}
