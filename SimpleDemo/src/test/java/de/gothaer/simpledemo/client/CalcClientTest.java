package de.gothaer.simpledemo.client;


import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.gothaer.simpledemo.math.Calculator;

public class CalcClientTest{
	
	private CalcClient objectUnderTest;
	private Calculator calculatorMock;
	
	@BeforeEach
	void init () {
		calculatorMock = mock(Calculator.class);
		objectUnderTest = new CalcClient(calculatorMock);
	}
	
	@Test
	void run_xy() {
		
		// Arrange -> Preparation
		when(calculatorMock.add(anyDouble(), anyDouble())).thenReturn(4711.0);
		//when(calculatorMock.add(anyDouble(), anyDouble())).thenThrow(new ArrayIndexOutOfBoundsException());
		
		// Act
		objectUnderTest.run();
		
		
		// Assert
		verify(calculatorMock, times(1)).add(3.0, 4.0);
	}

	

}
