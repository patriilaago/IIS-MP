package uo.mp.lab03.dome.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Cd;
import uo.mp.lab03.dome.model.Videogame;
import uo.mp.lab03.dome.model.Videogame.Platform;

public class MediaLibraryGetResponsiblesTest {

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
     * GIVEN: an empty library
     * WHEN: call getResponsibles()
     * THEN: empty space is returned
     */
    @Test
    public void noResponsibles() {
	MediaLibrary ml = new MediaLibrary();
	assertEquals("", ml.getResponsibles());
    }

    /**
     * GIVEN: a library with an only cd
     * WHEN: call getResponsibles()
     * THEN: returns the artist of the cd with a comma at the end
     */
    @Test
    public void oneResponsible() {
	MediaLibrary ml = new MediaLibrary();
	ml.add(aCD);
	assertEquals("Beatles, ", ml.getResponsibles());
    }

    /**
     * GIVEN: a library with a cd repeated
     * WHEN: call getResponsibles()
     * THEN: returns the artist of the cd with a comma at the end (not repeated)
     */
    @Test
    public void oneResponsibleRepeated() {
	MediaLibrary ml = new MediaLibrary();
	ml.add(aCD);
	ml.add(aCD);
	assertEquals("Beatles, ", ml.getResponsibles());
    }

    /**
     * GIVEN: a library with a cd and a game
     * WHEN: call getResponsibles()
     * THEN: returns the artist of the cd and the author of the game
     */
    @Test
    public void moreThanOneResponsible() {
	MediaLibrary ml = new MediaLibrary();
	ml.add(aCD);
	ml.add(game);
	assertEquals("Beatles, Nintendo, ", ml.getResponsibles());
    }

}
