package de.gothaer.personendemo.services;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.dependency.Dependency;

@ExtendWith(MockitoExtension.class)
public class MyServiceUsingDependencyTest {

	@InjectMocks private MyServiceUsingDependency objectUnderTest;
	@Mock private Dependency dependencyMock;
	
	
	
//	@Test
//	void test_ding() {
//		// Recordmode
//		when(dependencyMock.foo(anyInt())).thenReturn(112);
//		
//		final int ergebnis = objectUnderTest.exampleMethod("");
//		
//		assertEquals(120, ergebnis);
//		verify(dependencyMock).foo(5);
//		
//	}
	
//	@Test
//	void test_ding() {
//		final String demo = "Hallo";
//		
//		// Nur bei void Methoden
//		doNothing().when(dependencyMock).bar(anyString());
//		
//		final int ergebnis = objectUnderTest.exampleMethod(demo);
//		
//		assertEquals(5, ergebnis);
//		verify(dependencyMock).bar("HALLO");
//	}

	@Test
	void test_ding() {
		final String demo = "Hallo";
		
		// Nur bei void Methoden
		doThrow(new RuntimeException()).when(dependencyMock).bar(anyString());
		
		final ArithmeticException e = assertThrows(ArithmeticException.class, ()->objectUnderTest.exampleMethod(demo));
		
		
	}

}
