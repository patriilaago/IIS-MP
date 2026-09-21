package uo.mp.lab03.socialnetwork.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextMessageConstructorTest {

	private String theUser;
	private String characters;
	
	@BeforeEach
	public void setUp() {
		theUser = "user8888";
		characters = "How you doin'?";
	}

	/**
	 * GIVEN: a text message with the valid parameters
	 * WHEN: new TextMessage(parameters)
	 * THEN: a new message is created with that attributes
	 */
	@Test
	public void validParameters() {
		TextMessage message = new TextMessage(theUser,characters);
		
		assertEquals("user8888",message.getUser());
		assertEquals("How you doin'?",message.getCharacters());
	}
	
	/**
	 * GIVEN: a text message with the valid parameters
	 * WHEN: run setCharacters with null
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void nullCharacters() {
		characters = null;
		try {
			new TextMessage(theUser,characters);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The filename cannot be null or blank",e.getMessage());
		}
	}

	/**
	 * GIVEN: a text message with the valid parameters
	 * WHEN: run setCharacters with blank characters
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void blankCharacters() {
		characters = "";
		try {
			new TextMessage(theUser,characters);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The filename cannot be null or blank",e.getMessage());
		}
	}
}
