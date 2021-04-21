package de.gothaer.simpledemo.math;

public class MultipliziererImpl implements Multiplizierer {
	
	@Override
	public long mult(final int a, final int b) {
		
		long retval = 0;
		
		for (int i = 0; i < a; i++) {
			retval += b;
		}
		
		return retval;
		
	}

}
