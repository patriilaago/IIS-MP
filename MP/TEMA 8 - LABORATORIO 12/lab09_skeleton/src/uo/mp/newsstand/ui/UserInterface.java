package uo.mp.newsstand.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import uo.mp.newsstand.comparator.PublicationComparator;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.exception.NewsStandException;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.util.console.Console;
import uo.mp.util.exceptions.InvalidNameException;
import uo.mp.util.log.Logger;

/**
 * It is in charge of interacting with the user:
 * 	- Shows the menu of options
 *  - Process the option chosen by the user
 *  	- For that it asks the user the necessary data to fulfill the request
 *  	- Shows the result of the request
 *  - In case of error shows an explaining message
 *  
 *  Note: This is the unique class allowed to show information to the user
 *  @version 2023
 */
public class UserInterface {
	private static final int EXIT = 0;

	private Menu menu = new Menu();
	private Newsstand newsStand = new Newsstand();
	public final static String LOG_FILE = "files/log.txt";
	private Logger logger = new Logger(LOG_FILE);
	
	public void show()  {
		int option = EXIT;
		do {
			menu.show();
			option = Console.readInt("Option  ");		
			try {
				processOption(option);
			} catch (NewsStandException |FileNotFoundException| InvalidNameException e) {//(|InvalidNameException)
				// TODO Auto-generated catch block
				logger.log(e.getMessage());
			} catch (RuntimeException |IOException e) {
				// TODO Auto-generated catch block
				logger.log(e.getMessage());
				System.exit(0);
			}
		} while (option != EXIT);
	}

	private void processOption(int option) throws NewsStandException, InvalidNameException, IOException {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: showPublications(); break;				
			case 3: addPublication(); break;
			case 4: removePublication(); break;				
			case 5: createOrders(); break; 				
			case 6: saveOrdersToFile(); break;
			case 7: importFromZip(); break;
			case 8: exportToZip(); break;
		}
	}

	private void loadFile() throws InvalidNameException, IOException {
		String fileName = Console.readString("File name?");
		newsStand.loadFile( fileName );
	}
	
	private void addPublication() throws NewsStandException {
		Publication p = new PublicationForm().askForPublication();
		newsStand.addPublication( p );
	}

	private void removePublication() throws NewsStandException {
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	private void showPublications() {
		List<Publication> publications = newsStand.getPublications();
		listPublications( publications );
	}

	private void createOrders() {
		newsStand.createOrders();
	}

	private void listPublications(List<Publication> publications) {
		Console.print("\nList of publications\n");
		Console.print("------------------\n");
		Collections.sort(publications, new PublicationComparator());
		for(Publication p : publications) {
			Console.print(String.format("%s\n", p));
		}
		Console.print("------------------\n");
   }	
	
	private void saveOrdersToFile() throws IOException, InvalidNameException {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	private void importFromZip() throws NewsStandException, InvalidNameException, IOException {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	private void exportToZip() throws IOException {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}

}
