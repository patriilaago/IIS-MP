package uo.mp.lab03.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab03.dome.model.Item;

public class MediaLibrary {

    private List<Item> catalogue = new ArrayList<>();

    /**
     * Method to add an item to the catalogue
     * 
     * @param theItem item to be added to the catalogue
     * @throws IllegalArgumentException if the item we want to add is null
     */
    public void add(Item theItem) {
	ArgumentChecks.isTrue(theItem != null, "The item you want to add to the catalogue cannot be null");
	if (!catalogue.contains(theItem)) {
	    catalogue.add(theItem);
	} else {
	}
    }

    /**
     * Method to see all the items available on the catalogue
     * 
     * @return list containing all the items from the catalogue
     */
    List<Item> getCatalogue() {
	return catalogue;
    }

    /**
     * Method that returns the number of items that are present on the catalogue and are also owned
     * 
     * @return number of items owned in the catalogue
     */
    public int numberOfItemsOwned() {
	int itemsOwned = 0;
	for (Item theItem : catalogue) {
	    if (theItem.getOwn() == true) {
		itemsOwned++;
	    }
	}
	return itemsOwned;
    }

    /**
     * Method that prints all the information about every item present on the catalogue
     * 
     * @param out a PrintStream to flush output
     */
    public void list(PrintStream out) {
	for (Item theItem : catalogue) {
	    theItem.print(out);
	    out.println();
	}
    }

    /**
     * Method to search for an item in the catalogue
     * 
     * @param theItem item we want to search for in the catalogue
     * @return Item in case it is found, null otherwise
     */
    public Item searchItem(Item theItem) {
	ArgumentChecks.isTrue(theItem != null, "The item you want to search for cannot be null");
	for (Item item : catalogue) {
	    if (item.equals(theItem)) {
		return item;
	    }
	}
	return null;
    }

    /**
     * Method that returns an String containing all the responsibles (author, director or artist) of
     * the items that are available in the catalogue, separated by commas
     * 
     * @return String containing all the responsibles of the items that are present on the catalogue
     */
    public String getResponsibles() {
	StringBuilder result = new StringBuilder();
	for (Item theItem : catalogue) {
	    result.append(theItem.getResponsible());
	    result.append(", ");
	}
	return result.toString();
    }
}
