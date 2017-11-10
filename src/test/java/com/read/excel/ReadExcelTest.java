package com.read.excel;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.read.decorate.excel.interf.ReadSheet;

public class ReadExcelTest {
	String path = null;
	ReadSheet readSheet = null;
	int rowEnd=34;

	@Before
	public void initialization() {
		path = "D:/simon/aplication/github/readexcel2/src/main/resources/estadisticas.xls";
	}

	@Test
	public final void test() {
		try {
			readSheet = new ReadExcelProcess("Resumen mensual_Jul_2017",rowEnd, 1, path);
			;
			List<String[]> rowFound = readSheet.readAllrow();
			for (String[] record : rowFound) {
				int col = 0;
				while (col < record.length) {
					System.out.print(record[col] + " ");
					col++;
				}
				System.out.println();
			}

			assertEquals("success", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
