package de.gothaer.simpledemo.client;

import de.gothaer.simpledemo.math.Calculator;

/**
 * Hello world!
 *
 */
public class CalcClient 
{
	
	private final Calculator calculator;
	
	
    public CalcClient(final Calculator calculator) {
		this.calculator = calculator;
	}


	public void run( )
    {
    	final double komplizierteFormel1 = 3;
    	final double komplizierteFormel2 = 4;
    	
       
        System.out.println(calculator.add(komplizierteFormel1, komplizierteFormel2));
       
    }
}
