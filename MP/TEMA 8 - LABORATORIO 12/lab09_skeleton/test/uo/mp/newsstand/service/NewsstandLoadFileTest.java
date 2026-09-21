package uo.mp.newsstand.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import uo.mp.util.exceptions.InvalidNameException;

public class NewsstandLoadFileTest {

	private Newsstand ns = new Newsstand();
			
	@Test
	public void loadFileOk() throws InvalidNameException, IOException{
		ns.loadFile("publications.txt");
		assertEquals(8, ns.getPublications().size());
	}
	
	@Test
	public void loadFileLess5Characters() throws InvalidNameException, IOException{
		try {
			ns.loadFile("hhh");
			fail("Exception expected");
		}
		catch(InvalidNameException e) {
			assertEquals("The name of the file cannot have less than 5 letters", e.getMessage());
		}
		
	}

}
