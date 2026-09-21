package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp.util.collections.List;
import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/*
 * SCENARIOS
 * emptyList The hashCode of an empty list is 1
 * nonEmptyList The hashCode of a non empty list is the computed hashCode
 * sameTypeSameItemsLists The hashCode of two equals lists of the same type are the same
 * sameTypeDifferentItemsLists The hashCode of two equals lists of different type are the same
 * sameTypeSameItemsDifferentOrder The hashCode of two lists same type with the same elements in different positions are different
 */
public class HashCodeTests {
	
	private static Stream<Arguments> create2ListsSameType() {
	    return Stream.of(
	    		Arguments.of(Named.of("ArrayList", new ArrayList()), Named.of("ArrayList", new ArrayList())),
	    		Arguments.of(Named.of("LinkedList", new LinkedList()), Named.of("LinkedList", new LinkedList()))
	    );
	}
	
	private static Stream<Arguments> create2ListsDifferentType() {
	    return Stream.of(
	    		Arguments.of(Named.of("ArrayList", new ArrayList()), Named.of("LinkedList", new LinkedList())),
	    		Arguments.of(Named.of("LinkedList", new LinkedList()), Named.of("ArrayList", new ArrayList()))
	    );
	}
	
	public static Stream<Arguments> createOneList() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}
	
	private int val;

	@BeforeEach
	public void setUp() throws Exception {
		val = 31;
	}



	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createOneList")
	public void emptyList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createOneList")
	public void nonEmptyList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsSameType")

	public void sameTypeSameItemsLists(List list1, List list2) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsSameType")
	public void sameTypeDifferentItemsLists(List list1, List list2) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsSameType")
	public void sameTypeSameItemsDifferentOrder(List list1, List list2) {
		fail();
	}
		

	
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	public void differentTypeSameItemsLists(List list1, List list2 ) {
		fail();
	}
}
