package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp.util.collections.List;
import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;


/*
 * SCENARIOS
 * 	nullElement Try to add a null throws IllegalArgumentException
 * 	emptyList Add in an empty list adds the element at the end and returns true
 * 	nonEmptyList Add in a list with several elements adds the element at the last position and returns true
 * 	repeatedElement A repeated element CAN be added and returns true
 */

public class AddLastTests {

	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}

	/**
	 * GIVEN: a non empty list and a null element
	 * WHEN: trying to add the element at the end 
	 * THEN: throws an exception, the list remains unchanged
	 */
	@ParameterizedTest@MethodSource("createLists")  
	public void nullElement(List list) {
		list.add(0, "testing");
		list.add(1, "with");
		list.add(2, "JUnit");
		list.add(3, "framework");
		String s = list.toString();
		int lsize = list.size();
		IllegalArgumentException iae = assertThrows(
				IllegalArgumentException.class,
				() -> {
					list.add(null);					
				});
		assertTrue(list.size() == lsize);
		assertTrue(list.toString().equals(s));			
		assertNotNull(iae.getMessage());
		assertFalse(iae.getMessage().isBlank());
/*
 * EQUIVALENT TO
 * 		try {
 * 			list.add(null);
 * 			fail();
 * 		} catch(IllegalArgumentException ex) {
 * 			assertTrue(list.size() == lsize);
 * 			assertTrue(list.toString().equals(s));
 *
 *		}
 */

	}

	@ParameterizedTest@MethodSource("createLists") 
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	public void emptyList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists") 
	public void nonEmptyList(List list) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")  
	public void repeatedElement(List list) {		
		fail();
	}
	


}
