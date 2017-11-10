package com.read.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.read.decorate.excel.interf.ReadSheet;


public class ReadExcelProcess implements ReadSheet {
	private String sheet;
	private int col;
  private String path;
  private int rowEnd;
  
	public ReadExcelProcess(String sheet,int rowEnd, int col, String path) {
		super();
		this.sheet = sheet;
		this.col = col;
		this.path = path;
		this.rowEnd=rowEnd;
	}

  /*
	 * Retornaremos en una lista , todos los registros encontrados en �la hoja
	 * de excel. cada registro esta representado por un arreglo, cada posicion
	 * es un campo que se lee
	 * 
	 * @see
	 * com.read.decorate.excel.interf.ReadSheet#readAllrow(java.lang.String)
	 */
	public List<String[]> readAllrow() throws Exception {
		FileInputStream file = null;
		String[] record = null;
		List<String[]> rowFound = new ArrayList<String[]>();
		int i=0;
		try {
			file = new FileInputStream(new File(path));
			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheet(getSheet());
			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();
			Cell cell = null;
			
		 
			while (rowIterator.hasNext() && rowEnd>0) {
				rowEnd--;
				Row row = (Row) rowIterator.next();
			 
				int col = 0;
				System.out.println("continuamos ñleyenfd0="+(++i));
				record = new String[getCol()];
				while (col < getCol()) {
					System.out.println("II continuamos leyenfd0="+(++i));
					// Update the value of cell
					cell = row.getCell(col);
					if (cell!=null){
						cell.setCellType(Cell.CELL_TYPE_STRING);
						record[col] = cell.getStringCellValue();
						System.out.println(""+cell.getStringCellValue());
						col++;
						 
					}
					System.out.println("IV continuamos leyenfd0="+(++i));
				}
				System.out.println("V continuamos leyenfd0="+(++i));
				rowFound.add(record);
			}
		} finally {
			System.out.println("VI continuamos leyenfd0="+(++i));
			if (file != null) {
				file.close();
			}
		}
		System.out.println("VII continuamos leyenfd0="+(++i));
		System.out.println("exit-ccccccccccccccc--");
		return rowFound;
	}
	public String getSheet() {
		return sheet;
	}
	public void setSheet(String sheet) {
		this.sheet = sheet;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public int getRowEnd() {
		return rowEnd;
	}

	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}

 
 

	
 
	
}
