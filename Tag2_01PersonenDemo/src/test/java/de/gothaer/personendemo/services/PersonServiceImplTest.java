package de.gothaer.personendemo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.gothaer.personendemo.repositories.models.PersonRepository;


@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {
	
	@InjectMocks private PersonServiceImpl objectUnderTest;
	@Mock private PersonRepository personRepositoryMock;
	

	@Test
	void speichern_PersonParameterIsNull_throwsPersonenServiceException() {
		final PersonServiceException e = assertThrows(PersonServiceException.class, ()->objectUnderTest.speichern(null));
		assertEquals("Parameter darf nicht null sein.", e.getMessage());
	}
}
