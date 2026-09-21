package uo.mp.lab06.greenhouse.sensors;

import java.util.Random;

import uo.mp.lab06.greenhouse.controllers.devicescanner.Checkable;

public class MoistureSensor extends AbstractSensor implements Checkable {
	
	private static final int MIN = 41;
	private static final int INCREASE = 60;
	
	public MoistureSensor(String id) {
		super(id);
	}

	@Override
	public int readValue() {
		return new Random().nextInt(INCREASE) + MIN;
	}
		
	@Override
	public String toString() {
	    return String.format("HumiditySensor [id=%s]", super.getId());
	}

}
