package uo.mp.lab06.greenhouse.actuators.doors;

/**
 * <p>
 * Title: Door
 * </p>
 * <p>
 * Description: Class that simulates a door.
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
public class ManualDoor extends AbstractDoor{

	/**
	 * Create new manual door
	 * @param id unique identifier
	 */
	public ManualDoor(String id) {
		super(id);
	}

	/**
	 * Simulates the gardener opening this door by changing the state of the door to open, if possible
	 * @return a message to instruct the gardener to open the door
	 */
	public String open() {
		return super.open();
	}

	/**
	 * Simulates the gardener closing this door by changing the state of the door to closed, if possible
	 * @return a message to instruct the gardener to close the door
	 */
	public String close() {
		return super.close();
	}
}
