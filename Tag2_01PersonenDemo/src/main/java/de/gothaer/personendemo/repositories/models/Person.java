package de.gothaer.personendemo.repositories.models;

public class Person {
	
	private String id=null;
	private String vorname;
	private String nachname;
	
	
	public Person() {
		this("John","Doe");
	}
	public Person(final String vorname, final String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public String getId() {
		return id;
	}
	public void setId(final String id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(final String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(final String nachname) {
		this.nachname = nachname;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + "]";
	}
	
	
	

}
