package uo.mp.lab03.dome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Videogame.Platform;

public class VideogameSetOwnTest {

    private Videogame game;
    private String theTitle;
    private String theAuthor;
    private Platform thePlatform;

    @BeforeEach
    public void setUp() {
	theTitle = "Animal Crossing";
	theAuthor = "Nintendo";
	thePlatform = Platform.XBOX;
	game = new Videogame(theTitle, theAuthor, thePlatform);
    }

    /**
     * GIVEN game owned
     * WHEN call setOwn ( true )
     * THEN game owned not changed
     */
    @Test
    public void trueToTrue() {
	game.setOwn(true);
	game.setOwn(true);
	assertEquals(true, game.getOwn());
    }

    /**
     * GIVEN game owned
     * WHEN call setOwn ( false )
     * THEN game not owned
     */
    @Test
    public void trueToFalse() {
	game.setOwn(true);
	game.setOwn(false);
	assertEquals(false, game.getOwn());
    }

    /**
     * GIVEN game not owned
     * WHEN call setOwn ( false )
     * THEN game owned not changed
     */
    @Test
    public void falseToFalse() {
	game.setOwn(false);
	game.setOwn(false);
	assertEquals(false, game.getOwn());
    }

    /**
     * GIVEN game not owned
     * WHEN call setOwn ( true )
     * THEN game owned
     */
    @Test
    public void falseToTrue() {
	game.setOwn(false);
	game.setOwn(true);
	assertEquals(true, game.getOwn());
    }

}
