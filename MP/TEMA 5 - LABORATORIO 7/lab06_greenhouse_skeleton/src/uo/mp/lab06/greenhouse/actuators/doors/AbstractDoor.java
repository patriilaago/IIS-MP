package uo.mp.lab06.greenhouse.actuators.doors;

import uo.mp.util.check.ArgumentChecks;

public abstract class AbstractDoor {
	
	private String id;
	static final boolean CLOSED = false;
	static final boolean OPENED = true;

	boolean isOpened = CLOSED;

	public AbstractDoor(String id) {
		setId(id);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		ArgumentChecks.isNotNull(id, "Trying to create new Manual Door: Illegal null id");
		ArgumentChecks.isNotEmpty(id, "Trying to create new Manual Door: Illegal empty id");
		ArgumentChecks.isNotBlank(id, "Trying to create new Manual Door: Illegal blank id");
		
		this.id = id;
	}

	/**
	 * If the door is closed opens it and returns the message "Please, open the door %s.".
	 * 
	 * @return the message "Please, open the door %s." if the door was closed. Otherwise "".
	 */	
	public String open() {
		if (!isOpened()) {
			isOpened=true;
			return "  Please, open door " + getId();
		}
		return "";
	}
	
	/**
	 * If the door is opened closes it and returns the message "Please, close the door %s.".
	 * 
	 * @return the message "Please, close the door %s." if the door was opened. Otherwise "".
	 */
	public String close() {
		if (isOpened()) {
			isOpened=false;
			return "  Please, close door" + getId();
		}
		return "";
	}

	/**
	 * @returns true if the door is opened, close otherwise.
	 */
	public boolean isOpened() {
	    return this.isOpened;
	}
}
