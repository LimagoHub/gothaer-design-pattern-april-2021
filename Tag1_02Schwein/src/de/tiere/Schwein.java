package de.tiere;

public class Schwein {
	public static final int INITIAL_WEIGHT = 10;
	private String name;
	private int gewicht;
	
	
	public Schwein() {
		this("nobody");
	}
	public Schwein(final String name) {
		setGewicht(INITIAL_WEIGHT);
		setName(name);
	}
	public String getName() {
		return name;
	}
	public final void setName(final String name) {
		if(name == null || "elsa".equalsIgnoreCase(name))
			throw new IllegalArgumentException("Unerlaubter Name");
		this.name = name;
	}
	public int getGewicht() {
		return gewicht;
	}
	private void setGewicht(final int gewicht) {
		this.gewicht = gewicht;
	}
	
	public void fressen() {
		setGewicht(getGewicht() + 1);
	}
	@Override
	public String toString() {
		return "Schwein [name=" + name + ", gewicht=" + gewicht + "]";
	}
	
	

}
