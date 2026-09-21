package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public class Videogame extends Item {

    public enum Platform {
	XBOX, PLAYSTATION, NINTENDO
    }

    private String author;
    private Platform platform;

    /**
     * Creates a new videogame with the default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theAuthor String for author
     * @param platform  platform for platform
     */
    public Videogame(String theTitle, String theAuthor, Platform platform) {
	super(theTitle);
	setAuthor(theAuthor);
	setPlatform(platform);
    }

    /**
     * 
     * @return the author of the videogame
     */
    public String getAuthor() {
	return author;
    }

    /**
     * 
     * @param author String with the new author
     * @throws IllegalArgumentException if the argument is null or in blank
     */
    public void setAuthor(String author) {
	ArgumentChecks.isTrue(author != null && !author.isBlank(), "The author of the game cannot be null or blank");
	this.author = author;
    }

    /**
     * 
     * @return the platform where you can play the videogame
     */
    public Platform getPlatform() {
	return platform;
    }

    /**
     * 
     * @param platform enum Platform with the new platform of the game
     */
    public void setPlatform(Platform platform) {
	this.platform = platform;
    }

    /**
     * Prints the information about the videogame
     * 
     * @param out a PrintStream to flush output
     */
    @Override
    public void print(PrintStream out) {
	super.print(out);
	out.println("Author: " + getAuthor() + " ");
	out.println("Platform: " + getPlatform() + " ");
    }

    @Override
    public String getResponsible() {
	return author;
    }
}
