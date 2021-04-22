package de.gothaer.personendemo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import de.gothaer.personendemo.repositories.models.Person;
import de.gothaer.personendemo.repositories.models.PersonRepository;


@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {
	
	@Mock private PersonRepository repoMock;
	@Mock private List<String> antipathenMock;
	@InjectMocks private PersonServiceImpl objectUnderTest;
	
	
	private final Person validPerson = new Person("John", "Doe");
	
	
		
	@Test
	void speichern_PersonParameterIsNull_throwsPersonenServiceException() throws Exception{
		final PersonServiceException ex = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(null));
		assertEquals("Parameter darf nicht null sein.", ex.getMessage());
	} 

	@Test
	void speichern_PersonVornameIsNull_throwsPersonenServiceException() throws Exception{
		final Person person = new Person(null, "Doe");
		final PersonServiceException ex = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(person));
		assertEquals("Vorname muss min. 2 Zeichen enthalten.", ex.getMessage());
	}
	@Test
	void speichern_PersonVornameIsTooShort_throwsPersonenServiceException() throws Exception{
		final Person person = new Person("J", "Doe");
		final PersonServiceException ex = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(person));
		assertEquals("Vorname muss min. 2 Zeichen enthalten.", ex.getMessage());
	}

	@Test
	void speichern_PersonNachnameIsNull_throwsPersonenServiceException() throws Exception{
		final Person person = new Person("John", null);
		final PersonServiceException ex = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(person));
		assertEquals("Nachname muss min. 2 Zeichen enthalten.", ex.getMessage());
	}
	@Test
	void speichern_PersonNachnameIsTooShort_throwsPersonenServiceException() throws Exception{
		final Person person = new Person("John", "D");
		final PersonServiceException ex = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(person));
		assertEquals("Nachname muss min. 2 Zeichen enthalten.", ex.getMessage());
		Mockito.verify(repoMock, Mockito.never()).save(Mockito.any(Person.class));
	}

	@Test
	void speichern_Antipath_throwsPersonenServiceException() throws Exception{
		when(antipathenMock.contains(Mockito.anyString())).thenReturn(true);
		final PersonServiceException ex = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(new Person("Attila","Doe")));
		assertEquals("Antipath.", ex.getMessage());
	}

	@Test
	void speichern_UnexpectedRuntimeExceptionInUnderlyingService_throwsPersonenServiceException() throws Exception{
		
		when(antipathenMock.contains(Mockito.anyString())).thenReturn(false);
		when(repoMock.save(any(Person.class))).thenThrow(new ArithmeticException());
				
		final PersonServiceException ex = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(validPerson));
		assertEquals("Unerwarteter Fehler in der Datenbank.", ex.getMessage());
	}

	@Test
	void speichern_HappyDay_PersonIsPassedToRepo() throws Exception{
		when(antipathenMock.contains(Mockito.anyString())).thenReturn(false);
		objectUnderTest.speichern(validPerson);
		
		final InOrder inOrder = Mockito.inOrder(antipathenMock, repoMock);
		
		inOrder.verify(antipathenMock,Mockito.times(1)).contains(Mockito.anyString());
		inOrder.verify(repoMock, Mockito.times(1)).save(validPerson);
		
	}

	
}
