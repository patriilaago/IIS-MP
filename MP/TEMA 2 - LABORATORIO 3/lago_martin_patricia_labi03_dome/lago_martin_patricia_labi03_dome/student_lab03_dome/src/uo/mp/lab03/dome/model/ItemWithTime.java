package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public abstract class ItemWithTime extends Item {

    private int playingTime;

    /**
     * Creates a new ItemWithTime with default values for gotIt and comment
     * 
     * @param theTitle
     * @param time
     */
    ItemWithTime(String theTitle, int time) {
	super(theTitle);
	setPlayingTime(time);
    }

    /**
     * 
     * @param arg integer with the playing time in the item
     * @throws IllegalArgumentException if the argument is lower or equal zero
     */
    private void setPlayingTime(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid playing time");
	this.playingTime = arg;
    }

    /**
     * @return playing time of the item
     */
    public int getPlayingTime() {
	return this.playingTime;
    }

    /**
     * Prints the information about the ItemWithTime
     * 
     * @param out a PrintStream to flush output
     */
    @Override
    public void print(PrintStream out) {
	super.print(out);
	out.println("Playing time: " + getPlayingTime());
    }
}
