package uo.mp.lab03.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public abstract class Item {
    private String title;
    private boolean gotIt; // I have my own copy of the Cd
    private String comment;

    // Package protected
    /**
     * Creates a new Item
     * 
     * @param theTitle String for the title of the item
     */
    Item(String theTitle) {
	setTitle(theTitle);
	setOwn(false);
	setComment("No comment");
    }

    /**
     * 
     * @param arg String with the new title
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setTitle(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid title");

	this.title = arg;
    }

    /**
     * @return the comment (if any) or default
     */
    public String getTitle() {
	return title;
    }

    /**
     * 
     * @param boolean true means we own a copy; otherwise, false
     */
    public void setOwn(boolean ownIt) {
	gotIt = ownIt;
    }

    /**
     * @return true if we own a copy; false otherwise
     */
    public boolean getOwn() {
	return gotIt;
    }

    /**
     * 
     * @param arg String with a new comment to the element
     * @implNote If the argument is null or does not contain meaningful characters (other than blanks, new lines, etc)
     *           previous comment stays as it is
     */
    public void setComment(String arg) {
	if (arg != null && !arg.isBlank()) {
	    this.comment = arg;
	}
    }

    /**
     * @return the comment (if any) or default
     */
    public String getComment() {
	return comment;
    }

    /**
     * Prints the information about the item
     * 
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	out.println("Item: " + getTitle());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Item other = (Item) obj;
	return title == other.title && gotIt == other.gotIt && comment == other.comment;
    }

    public abstract String getResponsible();
}
