package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
 * 	setFirst Set an element in a list at first position changes the value at this position and returns the previous value 
 * 	setLast Set an element in a list at last position changes the value at this position and returns the previous value
 *  setMiddle Set an element in a list at an intermediate position changes the value at this position and returns the previous value
 *  setNull Try to set null throws NullPointerException
 *  setHeadEmptyList Try to set sth at 0 position in an empty list throws IndexOutOfBoundsException
 * 	setMinusOne Try to set at position -1 in a list with elements throws IndexOutOfBoundsException
 * 	setSize Try to set at position size() in a list with elements throws IndexOutOfBoundsException
 */
public class SetTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setFirst(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setLast(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setMiddle(List list) {
		fail();

	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setNull(List list) {
		list.add("this");
		list.add("this2");
		list.add("this3");
		try {
			list.set(1, null);
			fail("Exception expected");
		}
		catch(Exception e) {
			assertEquals("The element you want to set cannot be null",e.getMessage());
		}

	}
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setHeadEmptyList(List list) {
		fail();

	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setSize(List list) {
		fail();

		
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setMinus1(List list) {
		fail();

	}



}
