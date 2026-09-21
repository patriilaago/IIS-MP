package uo.mp.util.collections;

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
 * 	inList Get 0 returns elements at the head of a non-empty list 
 * 	getUpper Get returns last element in a non-empty list 
 * 	getIntermediate Get returns elements in the middle of a non-empty list with enough elements
 * 	emptyList Try to get element at position 0 in an empty list throws IndexOutOfBoundsException
 * 	emptyMinusOne Try to get element at position -1 in an empty list throws IndexOutOfBoundsException
 * 	emptyMinusOne Try to get element at position -1 in an list with elements throws IndexOutOfBoundsException
 * 	getSize Try to get element at position size() in an list with elements throws IndexOutOfBoundsException
 */
public class GetTests {

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
	public void inList(List list) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists") 
	public void getUpper(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists") 
	public void getIntermediate(List list) {
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
	public void emptyMinusOne(List list) {
		fail();
	}

	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nonEmptyMinusOne(List list) {
		fail();
	}
	
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void getSize(List list) {
		fail();
	}
	

}
