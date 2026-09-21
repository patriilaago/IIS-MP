package uo.mp.lab06.greenhouse.actuators.doors;

import uo.mp.lab06.greenhouse.controllers.devicescanner.Checkable;

public class AutomaticDoor extends AbstractDoor implements Checkable{

	private static final double WORKING_PROBABILITY = 0.95;
	
	public AutomaticDoor(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String open() {
		// TODO Auto-generated method stub
		String result = super.open();
		result = result + " it is Automatic door <"+super.getId()+"> is opening";
		return result;
	}

	@Override
	public String close() {
		// TODO Auto-generated method stub
		String result = super.close();
		result = result + " it is Automatic door <"+super.getId()+"> is closing";
		return result;
	}

	@Override
	public boolean check() {
		// TODO Auto-generated method stub
		return Math.random() < WORKING_PROBABILITY;
	}

}
