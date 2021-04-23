package de.gothaer.personendemo.services;

import java.util.List;
import java.util.UUID;

import de.gothaer.personendemo.repositories.models.Person;
import de.gothaer.personendemo.repositories.models.PersonRepository;

public class PersonServiceImpl {

	private final PersonRepository repo;
	private final List<String> antipathen;

	

	public PersonServiceImpl(final PersonRepository repo, final List<String> antipathen) {
		
		this.repo = repo;
		this.antipathen = antipathen;
	}
	
	/*
	 * John Doe
	 * John Wayne
	 * John McClaine
	 * John Rambo
	 * John Wick
	 *  
	 * John Boy Walton
	 * 
	 * Max Mustermann
	 * 
	 * 
	 */
	public List<Person> findeAlleJohns() throws PersonServiceException {
		
		try {
			repo.findAll();
			return null;
		} catch (final RuntimeException e) {
			throw new PersonServiceException("Upps",e);
		}
	}

	/*
	 * Parameter darf nicht null sein -> PSE Vorname darf nicht null sein und muss
	 * min 2. Zeichen -> PSE Nachname darf nicht null sein und muss min 2. Zeichen
	 * -> PSE
	 * 
	 * Vorname darf nicht Attila sein -> PSE
	 * 
	 * Fehler in darunter liegenden Service fangen und in PSE wandeln (ab hier wird
	 * Mock benötigt) -> PSE
	 * 
	 * Speichern der Person im Repo
	 * 
	 */
	public void speichern(final Person person) throws PersonServiceException {
		try {
			speichernImpl(person);

		} catch (final RuntimeException e) {
			throw new PersonServiceException("Unerwarteter Fehler in der Datenbank.");
		}

	}
	
	
	public void speichern(final String vorname, final String nachname) throws PersonServiceException {
	
			speichern(new Person(vorname, nachname));

	}
	


	private void speichernImpl(final Person person) throws PersonServiceException {
		checkPerson(person);
		person.setId(UUID.randomUUID().toString());
		repo.save(person);
	}

	private void checkPerson(final Person person) throws PersonServiceException {
		validatePerson(person);
		businessCheck(person);
	}

	private void businessCheck(final Person person) throws PersonServiceException {
		if (antipathen.contains(person.getVorname()))
			throw new PersonServiceException("Antipath.");
	}

	private void validatePerson(final Person person) throws PersonServiceException {
		if (person == null)
			throw new PersonServiceException("Parameter darf nicht null sein.");

		if (person.getVorname() == null || person.getVorname().length() < 2)
			throw new PersonServiceException("Vorname muss min. 2 Zeichen enthalten.");
		if (person.getNachname() == null || person.getNachname().length() < 2)
			throw new PersonServiceException("Nachname muss min. 2 Zeichen enthalten.");
	}

}
