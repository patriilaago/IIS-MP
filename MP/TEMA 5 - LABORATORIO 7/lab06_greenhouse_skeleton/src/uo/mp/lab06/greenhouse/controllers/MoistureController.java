package uo.mp.lab06.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab06.greenhouse.sensors.Irrigator;
import uo.mp.lab06.greenhouse.sensors.MoistureSensor;
import uo.mp.util.check.ArgumentChecks;

public class MoistureController {

	  public static final double MAX_HUMIDITY = 80;
	  public static final double MIN_HUMIDITY = 60;
	  public static final double LIMIT_MAX_HUMIDITY = 100;
	  public static final double LIMIT_MIN_HUMIDITY = 40;
	
	private final List<MoistureSensor> sensors = new ArrayList<>();
	private Irrigator irrigator;
	
	public List<String> monitor(){
		List<String> notifications = new ArrayList<>();
		irrigator = getIrrigator();
		
		double result = getAverageMoisture();
		notifications.add(printCurrentMoisture(result));
		
		if(tooHigh(result)) {
			notifications.add("It is too damp");
			notifications.add("\n");
			
			Irrigator total= getIrrigator();
			setLowest(irrigator);
			notifications.add("Irrigator system is "+total+" and is set to " +irrigator);
			notifications.add("\n");
		}
		else if(tooLow(result)) {
			notifications.add("It is too loow");
			notifications.add("\n");
			
			Irrigator total= getIrrigator();
			setHighest(irrigator);
			notifications.add("Irrigator system is "+total+" and is set to " +irrigator);
			notifications.add("\n");
		}
		else if(moistureHigherStillInLimits(result)){
			notifications.add("It is a bit too damp");
			notifications.add("\n");
			
			Irrigator total= getIrrigator();
			setOneLevelLess(irrigator);
			notifications.add("Irrigator system is "+total+" and is set to " +irrigator);
			notifications.add("\n");
		}
		else if(moistureLowerStillInLimits(result)) {
			notifications.add("It is a bit too dry");
			notifications.add("\n");
			
			Irrigator total= getIrrigator();
			setOneLevelMore(irrigator);
			notifications.add("Irrigator system is "+total+" and is set to " +irrigator);
			notifications.add("\n");
		}
		else {
			notifications.add("It is right");
			notifications.add("\n");
		}
		
		
		return notifications;
	}
	
	private String printCurrentMoisture(double moisture) {
		return "The current moisture is " +moisture+". ";
	}
	
	private boolean tooHigh(double moisture) {
		return moisture>=LIMIT_MAX_HUMIDITY;
	}
	
	private boolean tooLow(double moisture) {
		return LIMIT_MIN_HUMIDITY>=moisture;
	}
	
	private boolean moistureHigherStillInLimits(double moisture) {
		return (moisture>=MAX_HUMIDITY && moisture<=LIMIT_MAX_HUMIDITY);
	}
	
	private boolean moistureLowerStillInLimits(double moisture) {
		return (moisture<MIN_HUMIDITY && moisture>LIMIT_MIN_HUMIDITY) ;
	}
	
	private void setLowest(Irrigator irrigator) {
		setIrrigator(Irrigator.OFF);
	}
	
	private void setHighest(Irrigator irrigator) {
		setIrrigator(Irrigator.HIGH);
	}
	
	private void setOneLevelLess(Irrigator irrigator) {
		setIrrigator(Irrigator.LOW);
	}
	
	private void setOneLevelMore(Irrigator irrigator) {
		setIrrigator(Irrigator.MEDIUM);
	}
	
	public void addSensor (MoistureSensor sensor) {
		ArgumentChecks.isTrue(sensor!=null, "The moisture sensor cannot be null");
		if(!sensors.contains(sensor)) {
			this.sensors.add(sensor);
		}
	}
	
	public double getAverageMoisture() {
	    double addition = 0;
	    for (MoistureSensor sensor : sensors) {
	      addition += sensor.readValue();
	    }
	    return addition / sensors.size();
	}
	
	public void setIrrigator(Irrigator irrigator) {
		this.irrigator=irrigator;
	}
	 
	public Irrigator getIrrigator() {
		return irrigator;
	}

	List<MoistureSensor> getMoistureSensors(){
		return sensors;
	}
	
}
