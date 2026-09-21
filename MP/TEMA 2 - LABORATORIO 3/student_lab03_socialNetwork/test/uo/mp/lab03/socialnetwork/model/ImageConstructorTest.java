package uo.mp.lab03.socialnetwork.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImageConstructorTest {

	private String theUser;
	private String caption;
	private String fileName;
	
	@BeforeEach
	public void setUp() {
		caption = "Summer dump :)";
		theUser = "user8888";
		fileName = "Summer post";
	}

	/**
	 * GIVEN: a image with the valid parameters
	 * WHEN: new Image(parameters)
	 * THEN: a new image is created with that attributes
	 */
	@Test
	public void validParameters() {
		Image image = new Image(theUser, caption, fileName);
		
		assertEquals("user8888",image.getUser());
		assertEquals("Summer dump :)",image.getCaption());
		assertEquals("Summer post",image.getFileName() );
	}
	
	/**
	 * GIVEN: a image with the valid parameters
	 * WHEN: run setUser with a null
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void nullUser() {
		theUser = null;
		try {
			new Image(theUser,caption,fileName);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The user cannot be null or blank",e.getMessage());
		}
	}
	
	/**
	 * GIVEN: a image with the valid parameters
	 * WHEN: run setUser with a blank space
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void emptyUser() {
		theUser = "";
		try {
			new Image(theUser,caption,fileName);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The user cannot be null or blank",e.getMessage());
		}
	}
		
	/**
	 * GIVEN: a image with a valid caption
	 * WHEN: run setCaption with null
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void nullCaption() {
		caption = null;
		try {
			new Image(theUser,caption,fileName);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The caption cannot be null or blank",e.getMessage());
		}
	}

	/**
	 * GIVEN: a image with a valid caption
	 * WHEN: run setCaption with a blank caption
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void blankCaption() {
		caption = "";
		try {
			new Image(theUser,caption,fileName);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The caption cannot be null or blank",e.getMessage());
		}
	}
	
	/**
	 * GIVEN: a image with the valid parameters
	 * WHEN: run setFileName with null
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void nullFileName() {
		fileName = null;
		try {
			new Image(theUser,caption,fileName);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The filename cannot be null or blank",e.getMessage());
		}
	}

	/**
	 * GIVEN: a image with the valid parameters
	 * WHEN: run setFileName with a blank filename
	 * THEN: an IllegalArgumentException is thrown
	 */
	@Test
	public void blankFileName() {
		fileName = "";
		try {
			new Image(theUser,caption,fileName);
			fail("Exception expected");
		}
		catch(IllegalArgumentException e) {
			assertEquals("The filename cannot be null or blank",e.getMessage());
		}
	}
}
