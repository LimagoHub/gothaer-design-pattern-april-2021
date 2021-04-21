package de.collections;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StapelTest {
	
	private Stapel objectUnderTest;
	
	@BeforeEach
	void init() {
		objectUnderTest = new Stapel();
	}

	// Triple A Principle
	@Test
	void isEmpty_emptyStack_returnsTrue() {
		
		// Arrange
		// Act
		final boolean empty = objectUnderTest.isEmpty();
		
		// Assertion
		assertTrue(empty);
	}

	@Test
	void isEmpty_notEmptyStack_returnsFalse() throws Exception{
		
		// Arrange
		
		objectUnderTest.push(new Object());
		// Act  & Assertion
		assertFalse(objectUnderTest.isEmpty());
	}

	@Test
	void isEmpty_EmptyAgainStack_returnsTrue() throws Exception{
		
		// Arrange
		
		objectUnderTest.push(new Object());
		objectUnderTest.pop();
		
		// Act
		final boolean empty = objectUnderTest.isEmpty();
		
		// Assertion
		assertTrue(empty);
	}
	@Test
	void push_ElementInserted_IsStoredOnTopOfStack() throws Exception{
		// Arrange
		final Object object = new Object();
		// Act
		assertDoesNotThrow(()->objectUnderTest.push(object));
		
		// Assert
		assertEquals(object, objectUnderTest.pop());
		
		
	}
	@Test
	void push_fillToUpperLimit_noExceptionIsThrown() throws Exception{
		// Arrange
		
		final Object object = new Object();
		for (int i = 0; i < 9; i++) {
			objectUnderTest.push(object);
		}
		// Act & Assert
		assertDoesNotThrow(()->objectUnderTest.push(object));
		
		
		
	}

	@Test
	void push_Overflow_throwsStapelException() throws Exception{
		// Arrange
		
		final Object object = new Object();
		for (int i = 0; i < 10; i++) {
			objectUnderTest.push(object);
		}
		// Act & Assert
		final StapelException ex = assertThrows(StapelException.class, ()->objectUnderTest.push(object));
		assertEquals("Overflow", ex.getMessage());
		
		
	}


}
