package uo.mp.lab06.greenhouse.sensors;

import uo.mp.lab06.greenhouse.controllers.devicescanner.Checkable;
import uo.mp.util.check.ArgumentChecks;

public abstract class AbstractSensor implements Checkable{

	private String id;
	private static final double WORKING_PROBABILITY = 0.95;
	
	public AbstractSensor(String id) {
		setId(id);
	}

	public String getId() {
		return id;
	}
	
	private void setId(String id) {
		ArgumentChecks.isNotNull(id, "Trying to create new Temperature Sensor: Illegal null id");
		ArgumentChecks.isNotEmpty(id, "Trying to create new Temperature Sensor: Illegal empty id");
		ArgumentChecks.isNotBlank(id, "Trying to create new Temperature Sensor: Illegal blank id");

		this.id = id;
	}
	
	/**
	 * Simulates a sensor measurement 
	 * 
	 * @return What is measured by the sensor.
	 */
	public abstract int readValue();

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return Math.random() < WORKING_PROBABILITY;
	}
	
	
}
