package de.gothaer.personendemo.services;

import de.gothaer.personendemo.repositories.models.Person;
import de.gothaer.personendemo.repositories.models.PersonRepository;

public class PersonServiceImpl {
	
	private final PersonRepository repo;

	public PersonServiceImpl(final PersonRepository repo) {
		this.repo = repo;
	}
	
	/*
	 * Parameter darf nicht null sein -> PSE
	 * Vorname darf nicht null sein und muss min 2. Zeichen -> PSE
	 * Nachname darf nicht null sein und muss min 2. Zeichen -> PSE
	 * 
	 * Vorname darf nicht Attila sein -> PSE
	 * 
	 * Fehler in darunter liegenden Service fangen und in PSE wandeln (ab hier wird Mock benötigt) -> PSE
	 * 
	 * Speichern der Person im Repo
	 * 
	 */
	public void speichern(final Person person) throws PersonServiceException {
		if(person == null) 
			throw new PersonServiceException("Parameter darf nicht null sein.");
	}
	
	

}
