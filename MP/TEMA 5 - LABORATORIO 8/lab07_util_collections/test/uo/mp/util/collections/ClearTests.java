package uo.mp.util.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
 * emtpyList Clear an empty list has no effect
 * clearListWithOne Clear a list with one element leaves the list empty
 * clearListWithMany Clear a list with several elements leaves the list empty
 */
public class ClearTests {
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(Named.of("ArrayList", new ArrayList())),
		      Arguments.of(Named.of("LinkedList", new LinkedList()))
		  );
		}


	/**
	 * Given: an empty list
	 * When: clear() is invoked
	 * Then: the list remains empty
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList (List list) {
		list.clear();
		
		assertEquals(list.size(), 0);
	}
	
	/**
	 * Given: a list with just one element
	 * When: clear() is invoked
	 * Then: the list is empty
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void clearListWithOne(List list) {
		list.add( "testing" );
		
		list.clear();
		
		assertTrue( list.size() == 0 );
		assertFalse( list.contains( "testing" ) == false );
	}
	
	/**
	 * Given: a list with several elements
	 * When: clear() is invoked
	 * Then: the list is empty
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void testClearWithSeveral(List list) {
		list.add( "testing" );
		list.add( "with" );
		list.add( "JUnit" );
		list.add( "framework" );

		list.clear();
		
		assertTrue( list.size() == 0 );
		assertTrue( list.contains( "testing" ) == false );
	}

}
