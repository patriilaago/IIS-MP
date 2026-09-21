package uo.mp.util.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
 * 	emptyList Remove an object from an empty list returns false
 * 	oneItemList Remove an object from a list containing just this object returns true an the list is empty
 * 	firstInList Remove object from a list with several elements returns true an the element is removed (first)
 * 	lastInList Remove object from a list with several elements returns true an the element is removed (last)
 * 	middleInList Remove object from a list with several elements returns true an the element is removed (middle)
 * 	notInList Remove a non existing object from a list with elements returns false and the list is not changed
 * 	repeatedItem Remove an element from a list with that element repeated returns true and just the first occurrence of the element is removed
 *  nullItem Remove null returns false and the list does not change
 */
public class RemoveObjectTests {

	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}
	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyList(List list) {
		assertEquals(false,list.remove("this"));
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void oneItemList(List list) {
		fail();
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void notInList(List list) {
		fail();
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void firstInList(List list) {
		fail();

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void lastIntList(List list) {
		fail();

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void middleInList(List list) {
		fail();

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void repeatedItem(List list) {
		fail();
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void nullItem(List list) {
		assertEquals(false,list.remove(null));
	}
}
