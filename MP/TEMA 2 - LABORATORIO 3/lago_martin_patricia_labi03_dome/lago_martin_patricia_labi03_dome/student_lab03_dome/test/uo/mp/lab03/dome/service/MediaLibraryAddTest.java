package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Videogame;
import uo.mp.lab03.dome.model.Videogame.Platform;

public class MediaLibraryAddTest {

    private Cd aCD;
    private String theTitle;
    private String theArtist;
    private int theTime;
    private int theTracks;
    private String theAuthor;
    private String theTitle_game;
    private Platform thePlatform;
    private Videogame game;

    @BeforeEach
    public void setUp() {
	theTitle = "Come Together";
	theArtist = "Beatles";
	theTime = 70;
	theTracks = 4;
	aCD = new Cd(theTitle, theArtist, theTracks, theTime);
	theTitle_game = "Animal Crossing";
	theAuthor = "Nintendo";
	thePlatform = Platform.XBOX;
	game = new Videogame(theTitle_game, theAuthor, thePlatform);
    }

    /**
     * GIVEN: empty library
     * WHEN: call the add method with an Item
     * THEN: only item in the catalogue is shown
     */
    @Test
    public void emptyLibrary() {
	MediaLibrary library = new MediaLibrary();
	library.add(aCD);
	assertEquals(aCD, library.getCatalogue()
	    .get(0));
    }

    /**
     * GIVEN: item that is null
     * WHEN: call the add method
     * THEN: exception is thrown
     */
    @Test
    public void nullItem() {
	MediaLibrary library = new MediaLibrary();
	try {
	    library.add(null);
	    fail("Exception expected");
	} catch (Exception e) {
	    assertEquals("The item you want to add to the catalogue cannot be null", e.getMessage());
	}
    }

    /**
     * GIVEN: item that already present in the catalogue
     * WHEN: call the add method
     * THEN: item is not added to the catalogue
     */
    @Test
    public void repeatedItem() {
	MediaLibrary library = new MediaLibrary();
	library.add(aCD);
	library.add(aCD);
	assertEquals(aCD, library.getCatalogue()
	    .get(0));
    }

    /**
     * GIVEN: item that is new in the catalogue
     * WHEN: call the add method
     * THEN: item is added to the catalogue correctly
     */
    @Test
    public void newItem() {
	MediaLibrary library = new MediaLibrary();
	library.add(aCD);
	library.add(game);
	assertEquals(aCD, library.getCatalogue()
	    .get(0));
	assertEquals(game, library.getCatalogue()
	    .get(1));
    }
}
