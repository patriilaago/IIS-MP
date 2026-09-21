package uo.mp.util.collections;

import static org.junit.Assert.assertEquals;
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
 * 	emptyList A new list is empty
 * 	clearedList A cleared list is empty
 * 	listSizeOne A list with with one element is not empty
 * 	severalItemsList A list with more than one element is not empty
 */
public class IsEmptyTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}
	
	/**
	 * GIVEN: an empty list
	 * WHEN:  list.isEmpty()  
	 * THEN: return true because the list is empty
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List list) {
		assertEquals(true,list.isEmpty());
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void clearedList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: a list with just one element
	 * WHEN: list.isEmpty() 
	 * THEN: return false because the list is not empty
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void listSizeOne(List list) {
		list.add("test");
		assertEquals(false,list.isEmpty());
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void severalItemsList(List list) {
		fail();
	}
}
