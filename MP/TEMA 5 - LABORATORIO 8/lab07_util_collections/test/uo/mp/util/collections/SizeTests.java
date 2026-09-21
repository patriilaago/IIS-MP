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
 *  emptyList Size of an empty list is 0
 * 	nonEmptyList Size of a list with several(n) elements is n
 */
public class SizeTests {
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

}
