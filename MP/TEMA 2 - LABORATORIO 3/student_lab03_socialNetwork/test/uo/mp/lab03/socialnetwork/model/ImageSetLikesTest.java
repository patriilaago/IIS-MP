package uo.mp.lab03.socialnetwork.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImageSetLikesTest {

	private Image image;
	private String theUser;
	private String caption;
	private String fileName;
	
	@BeforeEach
	public void setUp() {
		caption = "Summer dump :)";
		theUser = "user8888";
		fileName = "Summer post";
		image = new Image(theUser, caption, fileName);
	}

	/**
	 * GIVEN: a image with the valid parameters
	 * WHEN: run setLikes with a valid number
	 * THEN: the likes are changed correctly
	 */
	@Test
	public void validLikes() {
		image.setLikes(888);
		assertEquals(888,image.getLikes());
	}
	
	/**
	 * GIVEN: a image with a valid likes
	 * WHEN: run setLikes with a negative number
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void negativeLikes() {
		try {
			image.setLikes(-33);
			fail("Exception expected");
		}
		catch(Exception e) {
			assertEquals("The number of likes cannot be lower than 0",e.getMessage());
		}
	}
}
