package de.gothaer.personendemo.repositories.models;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
	
	public boolean save(Person person);
	public boolean update(Person person);
	public boolean delete(Person person);
	public boolean deleteById(String id);
	public Optional<Person> findById(String id);
	public List<Person> findAll();

}
