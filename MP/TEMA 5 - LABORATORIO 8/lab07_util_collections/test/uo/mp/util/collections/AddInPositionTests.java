package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
 * 	SCENARIOS
 * 	addFirstEmptyList Add at position 0 in an empty list -> adds the element
 * 	addFirstNonEmptyList Add at position 0 in a list with several elements -> adds the element and moves the rest one position to the right
 * 	addMiddle Add on an intermediate position in a list -> adds the element and moves the rest on position to the right
 * 	addLast Add at the last position in a list with elements -> adds the element
 *  addAfterLast	Add in the position after the last in a list with elements -> adds the element
 * 	addRepeated A repeated element CAN be added 
 * 	addNegativeIndex Try to add at a negative position throws IndexOutOfBoundsException
 * 	addFurtherThanUpperBound Try to add at a position > size() throws IndexOutOfBoundsException
 * 	addNull Try to add a null throws IllegalArgumentException
 */
public class AddInPositionTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}

	/**
	 * GIVEN: empty list
	 * WHEN: adding item on the first position
	 * THEN: list contains item, item is the only item in the list
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addFirstEmptyList(List list) {
		
	}

	/**
	 * GIVEN: non empty list
	 * WHEN: adding item on the first position
	 * THEN: list contains item, item is the first item in the list, size increases one
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addFirstNonEmptyList(List list) {
		list.add("with");
		list.add("JUnit");
		list.add("framework");
		int before = list.size();
		
		list.add(0, "testing");
		
		assertEquals(list.size(), before + 1);
		assertEquals(list.indexOf("testing"), 0);
		
	}

	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addMiddle(List list) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addLast(List list) {
		fail();
	}

	

	/**
	 * SCENARIO 5
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addAfterLast(List list) {
		fail();
	}
	

	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addRepeated(List list) {
		fail();
	}	
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void addNegativeIndex(List list) {
		try {
			list.add(-3, "testing");
		}
		catch(Exception e) {
			assertEquals("The index of the element you want to add is out of the limits",e.getMessage());
		}
	}

	
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void addFurtherThanUpperBound(List list) {
		try {
			list.add(50, "hello");
		}
		catch(Exception e) {
			assertEquals("The index of the element you want to add is out of the limits",e.getMessage());
		}
	}
	

	/**
	 * GIVEN: any list
	 * WHEN: trying to add a null element
	 * THEN: throws an IllegalArgumentException, the list remains unchanged 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addNull(List list) {
		try {
			list.add(4, null);
		}
		catch(Exception e) {
			assertEquals("The object you want to add cannot be null",e.getMessage());
		}
	}

}
