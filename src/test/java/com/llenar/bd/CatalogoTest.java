package com.llenar.bd;

import org.junit.Before;
import org.junit.Test;

import com.read.decorate.excel.facade.ReadCatlg2FamiliasFacade;

public class CatalogoTest {
	private String sheet;
	private int col;
	private int row;
	private String path;
	@Before
	public void initialization() {
		path = "C:/workspaceIV/readexcel2/src/main/java/com/read/excel/catalogoplantilla.xls";
		sheet="catalogo";
		col=3;
		row=4;
	}
	@Test
	public final void test() {
		ReadCatlg2FamiliasFacade readCatalogoFacade = new ReadCatlg2FamiliasFacade(sheet,row, col,  path);
		readCatalogoFacade.procesar();
	}

}
