package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/*
 * SCENARIOS
 * 	sameTypeEmpty Two empty lists the same type are equals
 *  bothTypesEmtpy Two empty lists, each of them a different type, are equals
 * 	sameTypeSameItems Two lists the same type with the same elements in the same order are equal
 *  sameTypeSameItemsDifferentOrder Two lists same type with the same elements in different positions are different
 *  sameTypeDifferentItems Two lists same type with the different elements are different
 * 	bothTypesSameItems One ArrayList and one LinkedList containing the same elements in the same order are equals
 * 	bothTypesDifferentItems One ArrayList and one LinkedList containing different elements are not equals
 */
public class EqualsTests {
	

	private static Stream<Arguments> create2ListsSameType() {
	    return Stream.of(
	    		Arguments.of(new ArrayList(), new ArrayList()),
	    		Arguments.of(new LinkedList(), new LinkedList())
	    );
	}
	
	private static Stream<Arguments> create2ListsDifferentType() {
	    return Stream.of(
	    		Arguments.of(new ArrayList(), new LinkedList()),
	    		Arguments.of(new LinkedList(), new ArrayList())
	    );
	}
	
	@ParameterizedTest@MethodSource("create2ListsSameType")
	/**
	 * GIVEN: 2 list same type
	 * WHEN: they are both empty
	 * THEN: are equal
	 */
	public void sameTypeEmtpy(List list1, List list2) {
		
		assertEquals(list1, list2);
	}

	
	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	/**
	 * GIVEN: An arrayList and a linkedList
	 * WHEN: they are both empty
	 * THEN: are equal
	 */
	public void bothEmtpy(List list1, List list2) {

		assertEquals(list1, list2);
	}

	@ParameterizedTest@MethodSource("create2ListsSameType")
	/**
	 * GIVEN: 2 same type with same items in same order
	 * WHEN: equals?
	 * THEN: true
	 */
	public void sameItemsSameType(List list1, List list2) {
		
		list1.add(0, "testing");
		list1.add(1, "with");
		list1.add(2, "JUnit");
		list1.add(3, "framework");

		list2.add(0, "testing");
		list2.add(1, "with");
		list2.add(2, "JUnit");
		list2.add(3, "framework");

		assertTrue(list1.equals(list2));
	}
	
	
	@ParameterizedTest@MethodSource("create2ListsSameType")
	/**
	 * GIVEN: 2 lists same type with same items in different order
	 * WHEN: equals?
	 * THEN: false
	 */
	public void sameTypeSameItemsDifferentOrder(List list1, List list2) {
		
		list1.add(0, "testing");
		list1.add(1, "with");
		list1.add(2, "JUnit");
		list1.add(3, "framework");

		list2.add(0, "testing");
		list2.add(1, "framework");
		list2.add(2, "with");
		list2.add(3, "JUnit");
		
		assertFalse(list1.equals(list2));
	}

	
	@ParameterizedTest@MethodSource("create2ListsDifferentType")

	/**
	 * GIVEN: 2 arraylist with different items 
	 * WHEN: equals?
	 * THEN: false
	 */
	public void sameTypeDifferentItems(List list1, List list2) {
		list1.add("testing");
		list1.add("with");
		list1.add("JUnit");
		
		list2.add("framework");
		
		assertFalse(list1.equals(list2));
	}


	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	/**
	 * GIVEN: arraylist and linkedlist with same items in same order
	 * WHEN: equals?
	 * THEN: true
	 */
	public void arrayListLinkedListSameItems(List list1, List list2) {
		
		list1.add(0, "testing");
		list1.add(1, "with");
		list1.add(2, "JUnit");
		list1.add(3, "framework");

		list2.add(0, "testing");
		list2.add(1, "with");
		list2.add(2, "JUnit");
		list2.add(3, "framework");
		
		assertTrue(list1.equals(list2));
	}

	@ParameterizedTest@MethodSource("create2ListsDifferentType")

	/**
	 * GIVEN: arraylist and linkedlist with different items or in different order
	 * WHEN: equals?
	 * THEN: false
	 */
	public void arrayListLinkedListDifferentItems(List list1, List list2) {
		
		list1.add(0, "testing");
		list1.add(1, "with");
		list1.add(2, "JUnit");
		list1.add(3, "framework");

		list2.add(0, "framework");
		list2.add(1, "JUnit");
		list2.add(2, "with");
		list2.add(3, "testing");
		
		assertFalse(list1.equals(list2));

	}

}
