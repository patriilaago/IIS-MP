package uo.mp.util.collections;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;


public class IteratorTests {

	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}
	
	/**
	 * Given: an iterator from a new list
	 * When: hasNext() is called
	 * Then: returns false 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void testHasNextReturnsFalseOnEmptyList(List list) {
		fail();
	}
	
	/**
	 * Given: a new iterator with one element in the list
	 * When: hasNext() is called 
	 * Then: returns true 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void testHasNextReturnsTrueOnNewIteratorWithOneElement(List list) {
		fail();	
		
	}
	
	/**
	 * Given: a new iterator from a list with several element
	 * When: hasNext() is called 
	 * Then: returns true 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testHasNextReturnsTrueOnNewIteratorWithSeverealElements(List list) {
		fail();	
	}
	
	/**
	 * Given: a iterator over the first position of a list with two elements
	 * When: hasNext() is called
	 * Then: returns true 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testHasNextReturnsTrueOnTheFirstElementOfaList(List list) {
		fail();	
		
	}

	/**
	 * Given: a iterator over the last position of a list 
	 * When: hasNext() is called
	 * Then: returns false
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testHasNextReturnsFalseOnTheLastElementOfaList(List list) {
		fail();	
		
	}
	
	/**
	 * Given: a iterator over an empty list 
	 * When: next() is called
	 * Then: a NoSuchElementException is thrown 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testNextThrowsExceptionOnEmptyList(List list) {
		fail();	
		
	}

	/**
	 * Given: a iterator over an list with one element 
	 * When: next() is called
	 * Then: the first element is returned 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testNextWithOneElemerntOnAList(List list) {
		fail();	
		
	}

	/**
	 * Given: a iterator over an list with one element 
	 * When: next() is called twice
	 * Then: a NoSuchElementException is thrown
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testNextTwiceWithOneElementOnAList(List list) {
		fail();	
		
	}
	
	/**
	 * Given: an empty list  
	 * When: a for each loop is executed
	 * Then: the loop do not iterate
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testForEachOnEmptyList(List list) {
		fail();	
		
	}
	
	/**
	 * Call to a for loop with an list of several objects get the right ones
	 */
	/**
	 * Given: a list with several elements  
	 * When: a for each loop is executed
	 * Then: the loop return each element
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testForEachOnListWithElements(List list) {
		fail();	
		
	}
	
}