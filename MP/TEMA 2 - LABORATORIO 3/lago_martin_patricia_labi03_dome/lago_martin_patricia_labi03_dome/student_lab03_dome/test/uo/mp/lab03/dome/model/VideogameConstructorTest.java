package uo.mp.lab03.dome.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Videogame.Platform;

public class VideogameConstructorTest {

    private String theTitle;
    private String theAuthor;
    private Platform thePlatform;

    @BeforeEach
    public void setUp() {
	theTitle = "Animal Crossing";
	theAuthor = "Nintendo";
	thePlatform = Platform.XBOX;
    }

    /**
     * GIVEN: valid arguments
     * WHEN: new Videogame(arguments)
     * THEN a new Videogame is created with that attributes
     */
    @Test
    public void validParameters() {
	Videogame game = new Videogame(theTitle, theAuthor, thePlatform);
	game.setComment("5/5");
	game.setOwn(true);
	assertEquals("Animal Crossing", game.getTitle());
	assertEquals("Nintendo", game.getAuthor());
	assertEquals(Platform.XBOX, game.getPlatform());
	assertEquals(true, game.getOwn());
	assertEquals("5/5", game.getComment());
    }

    /**
     * GIVEN: valid arguments, except title = null
     * WHEN: new Videogame(arguments)
     * THEN: throws IllegalArgumentException
     */
    @Test
    public void nullTitle() {
	theTitle = null;
	try {
	    new Videogame(theTitle, theAuthor, thePlatform);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except title = ""
     * WHEN new Videogame(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankTitle() {
	theTitle = "";
	try {
	    new Videogame(theTitle, theAuthor, thePlatform);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except author = null
     * WHEN new Videogame(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullAuthor() {
	theAuthor = null;
	try {
	    new Videogame(theTitle, theAuthor, thePlatform);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("The author of the game cannot be null or blank", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except author = ""
     * WHEN new Videogame(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankAuthor() {
	theAuthor = "";
	try {
	    new Videogame(theTitle, theAuthor, thePlatform);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("The author of the game cannot be null or blank", e.getMessage());
	}
    }

}
