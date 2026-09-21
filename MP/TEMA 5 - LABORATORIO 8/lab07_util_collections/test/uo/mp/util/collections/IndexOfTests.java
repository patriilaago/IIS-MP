package uo.mp.util.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.collections.List;
import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;


/*
 * SCENARIOS
 * emptyList 	List is empty, then indexOf any item is -1
 * repeatedItem	In a list with repeated elements the indexOf that element returns the position of the first occurrence
 * notInList	The index of an Item not existing in the list is -1
 * nullElem	The index of null is -1
 * firstItem	The index of the first item is 0
 * lastItem	The index of the last item is size - 1
 * nextItem	The index of the an item b next in the list to another item a, is one more than the index of a
 */
public class IndexOfTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}

	/**
	 * GIVEN: any list and a null element
	 * WHEN: trying to find the element in the list 
	 * THEN: returns -1 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nullElem(List list) {
		list.add("this");
		list.add("this2");
		list.add("this3");
		assertEquals(list.indexOf(null),-1);
	}
	
	/**
	 * GIVEN: an empty list and a non-null element
	 * WHEN: trying to find the element in the list 
	 * THEN: returns -1 (not found) 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List list) {
		assertEquals(-1,list.indexOf("this"));
	}
	
	/**
	 * GIVEN: an list containing a repeated item 
	 * WHEN: index of the element in the list 
	 * THEN: returns the index of the first appearance 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void repeatedItem(List list) {
		fail();
	}
	
	/**
	 * GIVEN: an list containing a several items 
	 * WHEN: index of an element not in the list 
	 * THEN: returns -1  
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void notInList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: a non empty list and a non-null element place at the head of the list
	 * WHEN: trying to find the element in the list 
	 * THEN: returns 0
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void firstInList(List list) {
		fail();
	}

	/**
	 * GIVEN: a non empty list and a non-null element place at the end of the list
	 * WHEN: trying to find the element in the list 
	 * THEN: returns size-1
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void lastInList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: a non empty list and a non-null element (a) in the list
	 * WHEN: indexof the element next to it in the list (b)
	 * THEN: returns the indexof a + 1 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nextInList(List list) {
		fail();
	}
}
