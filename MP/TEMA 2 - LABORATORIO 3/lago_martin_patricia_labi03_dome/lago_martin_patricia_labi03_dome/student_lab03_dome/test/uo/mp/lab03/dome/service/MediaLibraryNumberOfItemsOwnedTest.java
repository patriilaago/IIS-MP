package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Videogame;
import uo.mp.lab03.dome.model.Videogame.Platform;

public class MediaLibraryNumberOfItemsOwnedTest {

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
     * GIVEN: a library with a cd and a videogame that are both owned
     * WHEN: call numberOfItemsOwned()
     * THEN: returns 2
     */
    @Test
    public void allItemsOwned() {
	MediaLibrary ml = new MediaLibrary();
	aCD.setOwn(true);
	game.setOwn(true);
	ml.add(aCD);
	ml.add(game);
	assertEquals(2, ml.numberOfItemsOwned());
    }

    /**
     * GIVEN: a library with a cd owned and a videogame that is not owned
     * WHEN: call numberOfItemsOwned()
     * THEN: returns 1
     */
    @Test
    public void oneItemOwned() {
	MediaLibrary ml = new MediaLibrary();
	aCD.setOwn(true);
	ml.add(aCD);
	ml.add(game);
	assertEquals(1, ml.numberOfItemsOwned());
    }

    /**
     * GIVEN: a library with a cd and a videogame that are both not owned
     * WHEN: call numberOfItemsOwned()
     * THEN: returns 0
     */
    @Test
    public void noItemsOwned() {
	MediaLibrary ml = new MediaLibrary();
	ml.add(aCD);
	ml.add(game);
	assertEquals(0, ml.numberOfItemsOwned());
    }
}
