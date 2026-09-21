package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Videogame;
import uo.mp.lab03.dome.model.Videogame.Platform;

public class MediaLibrarySearchItemTest {

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
     * GIVEN: a library with a cd and a game
     * WHEN: call searchItem() for the cd and the videogame
     * THEN: return cd and game
     */
    @Test
    public void itemFound() {
	MediaLibrary ml = new MediaLibrary();
	ml.add(aCD);
	ml.add(game);
	assertEquals(game, ml.searchItem(game));
	assertEquals(aCD, ml.searchItem(aCD));
    }

    /**
     * GIVEN: an empty library
     * WHEN: call searchItem() for the cd
     * THEN: return null
     */
    @Test
    public void itemNotFound() {
	MediaLibrary ml = new MediaLibrary();
	ml.add(aCD);
	assertEquals(null, ml.searchItem(game));
    }

    /**
     * GIVEN: an empty library
     * WHEN: call searchItem() for null
     * THEN: throws IllegalArgumentException
     */
    @Test
    public void itemNull() {
	MediaLibrary ml = new MediaLibrary();
	try {
	    ml.searchItem(null);
	    fail("Exception expected");
	} catch (Exception e) {
	    assertEquals("The item you want to search for cannot be null", e.getMessage());
	}
    }
}
