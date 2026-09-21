package uo.mp.newsstand.ui;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.util.console.Console;

/**
 * Asks the user all the data for a new publication.
 * 
 * @version 2023
 */
public class PublicationForm {

	/**
	 * Ask the user to type information for a new publication
	 * 
	 * @return The new Publication object created. It will be of any of the child
	 *         types of Publication.
	 */
	public Publication askForPublication() {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
		case "n":
			return askForNewsPaper();
		case "m":
			return askForMagazine();
		default:
			return null;
		}

	}

	private Publication askForMagazine() {
		String name = Console.readString("name?");
		int stock = Console.readInt("stock?");
		int sales = Console.readInt("sales?");
		Frequency f = readFrequency();

		return new Magazine(name, stock, sales, f); // Frequency.valueOf(frequency.toUpperCase()));
	}

	private Frequency readFrequency() {
		String frequency = Console.readString("frequency?");
		while (!Frequency.getNames().contains(frequency.toLowerCase()))
			frequency = Console.readString("frequency?");
		return Frequency.valueOf(frequency.toUpperCase());
	}

	private Publication askForNewsPaper() {
		String name = Console.readString("name?");
		int stock = Console.readInt("stock?");
		int sales = Console.readInt("sales?");

		return new Newspaper(name, stock, sales);
	}

}
