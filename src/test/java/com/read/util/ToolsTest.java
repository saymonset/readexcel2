package com.read.util;

import org.junit.Before;
import org.junit.Test;

import readexceljpa.readexcel2.domain.Catalogo;

public class ToolsTest {
	@Before
	public void initialization() {
	
	}
	
	@Test
	public final void test() {
		 Tools.anlisiClass(Catalogo.class);
	}
}
