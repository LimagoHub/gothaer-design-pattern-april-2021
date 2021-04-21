package de.gothaer.simpledemo;

import de.gothaer.simpledemo.client.CalcClient;
import de.gothaer.simpledemo.math.Calculator;
import de.gothaer.simpledemo.math.CalculatorImpl;

public class App {

	public static void main(final String[] args) {
		final Calculator calculator = new CalculatorImpl();
		new CalcClient(calculator).run();

	}

}
