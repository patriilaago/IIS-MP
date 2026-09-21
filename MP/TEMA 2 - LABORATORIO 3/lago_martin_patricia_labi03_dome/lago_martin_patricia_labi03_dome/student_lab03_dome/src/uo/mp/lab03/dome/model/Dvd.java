package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public class Dvd extends ItemWithTime {

    private String director;

    /**
     * Creates a new Dvd with default values for gotIt and comment
     * 
     * @param theTitle    String for title
     * @param theDirector String for director
     * @param time        integer for time
     */
    public Dvd(String theTitle, String theDirector, int time) {
	super(theTitle, time);
	setDirector(theDirector);
    }

    /**
     * 
     * @param arg String with the new director
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setDirector(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid director");
	this.director = arg;
    }

    /**
     * @return the director of the dvd
     */
    public String getDirector() {
	return this.director;
    }

    /**
     * Prints the information about the dvd
     * 
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	super.print(out);
	out.println("Director: " + getDirector());
    }

    @Override
    public String getResponsible() {
	return director;
    }

}
