package uo.mp.lab03.socialnetwork.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextMessageSetLikesTest {

	private TextMessage textMessage;
	private String theUser;
	private String characters;
	
	@BeforeEach
	public void setUp() {
		theUser = "user8888";
		characters = "How you doin'?";
		textMessage = new TextMessage(theUser, characters);}

	/**
	 * GIVEN: a text message with the valid parameters
	 * WHEN: run setLikes with a valid number
	 * THEN: the likes are changed correctly
	 */
	@Test
	public void validLikes() {
		textMessage.setLikes(888);
		assertEquals(888,textMessage.getLikes());
	}
	
	/**
	 * GIVEN: a text message with a valid likes
	 * WHEN: run setLikes with a negative number
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void negativeLikes() {
		try {
			textMessage.setLikes(-33);
			fail("Exception expected");
		}
		catch(Exception e) {
			assertEquals("The number of likes cannot be lower than 0",e.getMessage());
		}
	}

}
