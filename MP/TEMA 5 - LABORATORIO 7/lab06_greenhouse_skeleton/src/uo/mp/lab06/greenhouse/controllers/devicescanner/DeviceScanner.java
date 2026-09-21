package uo.mp.lab06.greenhouse.controllers.devicescanner;

import java.util.ArrayList;
import java.util.List;

public class DeviceScanner {
	  private final List<Checkable> checkables = new ArrayList<>();

	  public void add(Checkable checkable) {
	    checkables.add(checkable);
	  }
	  
	  public List<String> monitor() {
		List<String> result = new ArrayList<>();
		for (Checkable checkable : checkables) {
		   if (!checkable.check()) {
			   result.add("WARNING: " + checkable.toString() + " is not in good condition");
		   }	        
		}
		return result;
	  }
}
