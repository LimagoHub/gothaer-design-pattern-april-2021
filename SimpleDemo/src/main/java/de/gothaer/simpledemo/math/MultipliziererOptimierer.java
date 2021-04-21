package de.gothaer.simpledemo.math;

public class MultipliziererOptimierer implements Multiplizierer{
	
	private final Multiplizierer multiplizierer;

	public MultipliziererOptimierer(final Multiplizierer multiplizierer) {
		this.multiplizierer = multiplizierer;
	}

	@Override
	public long mult(final int a, final int b) {
		if(a < b)
			return multiplizierer.mult(a, b);
		return multiplizierer.mult(b, a);
	}
	
	

}
