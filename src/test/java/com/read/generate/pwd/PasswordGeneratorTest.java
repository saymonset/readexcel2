package com.read.generate.pwd;

import org.junit.Before;
import org.junit.Test;

public class PasswordGeneratorTest {

	@Before
	public void initialization() {

	}

	@Test
	public final void test() {
		PasswordGenerator passwordGenerator = new PasswordGenerator(8);
		// passwordGenerator.NUMEROS=8;

		try {
			System.out.println(passwordGenerator.getPinNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		;
	 

	}
}
