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
 * 	delOnlyItem Remove element at position 0 from a list with one element returns the removed element and the list is empty
 * 	delFirst Remove element at position 0 from a non-empty list returns the element removed, size decreases and move the rest of elements one position to the left
 * 	delMiddle Remove from an existing position (in the middle of the list) returns the removed element, the element is removed, elements are shift one position to the left
 * 	delLast Remove last element returns the removed element and the element is removed, others remain at the same position
 * 	testLowerBound Try to remove element at position -1 throws IndexOutOfBoundsException
 * 	emptyList Try to remove element at position 0 in an empty list throws IndexOutOfBoundsException
 *	testUpperBound Try to remove element at position size() in a non-empty list throws IndexOutOfBoundsException
 */
public class RemoveFromPositionTests {
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
	public void delOnlyItem(List list) {
		fail();
	}


	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delFirst(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delLast(List list) {
		fail();
	}

	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delMiddle(List list) {
		fail();

	}
	
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List list) {
		fail();
	}
	

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testUpperBound(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testLowerBound(List list) {
		fail();
	}
		

}
