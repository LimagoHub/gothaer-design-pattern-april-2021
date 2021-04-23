package de.gothaer.personendemo.services;

import de.dependency.Dependency;

public class MyServiceUsingDependency {
	
	private final Dependency dependency;

	public MyServiceUsingDependency(final Dependency dependency) {
		this.dependency = dependency;
	}
	
	
	
	public int exampleMethod(final String a) {
		try {
			dependency.bar(a.toUpperCase());
			return a.length();
		} catch (final Exception e) {
			throw new ArithmeticException();
		}
	}
	

}
