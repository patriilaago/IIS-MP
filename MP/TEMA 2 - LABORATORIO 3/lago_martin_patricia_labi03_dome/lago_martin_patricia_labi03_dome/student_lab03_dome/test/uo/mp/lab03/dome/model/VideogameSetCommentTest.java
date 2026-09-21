package uo.mp.lab03.dome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab03.dome.model.Videogame.Platform;

public class VideogameSetCommentTest {

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
     * GIVEN game with "No comment" comment
     * WHEN call setComment with other comment full of meaningful chars
     * THEN comment is changed to new string
     */
    @Test
    public void validComment() {
	game.setComment("Excellent");

	assertEquals("Excellent", game.getComment());
    }

    /**
     * GIVEN game with a comment
     * WHEN call setComment with null
     * THEN comment unchanged
     */
    @Test
    public void nullComment() {
	game.setComment("Excellent");
	game.setComment(null);

	assertEquals("Excellent", game.getComment());
    }

    /**
     * GIVEN game with a comment
     * WHEN call setComment with ""
     * THEN comment unchanged
     */
    @Test
    public void emptyComment() {
	game.setComment("Excellent");
	game.setComment("");

	assertEquals("Excellent", game.getComment());
    }

    /**
     * GIVEN game with a comment
     * WHEN call setComment with " "
     * THEN comment unchanged
     */
    @Test
    public void blankComment() {
	game.setComment("Excellent");
	game.setComment("      ");

	assertEquals("Excellent", game.getComment());
    }

}
