package com.read.decorate.excel.impl;

import java.util.List;

import javax.persistence.EntityManager;

import readexceljpa.readexcel2.domain.Catalogo;

import com.read.decorate.excel.interf.ReadSheet;
import com.read.decorate.excel.interf.WriteBD;
import com.read.excel.ReadExcelProcess;
import com.read.util.ToolsBD;

/**
 * 
 * Sirve como fachada para tratar de lo posible de evitar modificaciones en el
 * principal programa. y tener lo mas desacoplado posible la clase
 * ReadExcelProcess
 * 
 * @author Simon Roriguez
 * 
 */
public class ReadCatalogo implements ReadSheet, WriteBD {

	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private String path;
	private int rowEnd;

	public ReadCatalogo(String sheet,int rowEnd, int col, String path) {
		super();

		readSheet = new ReadExcelProcess(sheet,rowEnd, col, path);
	}

	/*
	 * Metodo que devolvera los registros en una lista de arreglos
	 * 
	 * @see com.read.decorate.excel.interf.ReadSheet#readAllrow()
	 */
	public List<String[]> readAllrow() throws Exception {
		// TODO Auto-generated method stub
		return readSheet.readAllrow();
	}

	public void createRecords(EntityManager manager) throws Exception {
		
 
		List<String[]> rowFound = readAllrow();
		boolean isRowTitle = true;
		for (String[] record : rowFound) {
			if (isRowTitle) {
				// SALTAMOS LA PRIMERA FILA
				isRowTitle = false;
				continue;
			}
			int col = 0;
			Catalogo catalogo = new Catalogo();
			while (col < record.length) {
				switch (col) {
				case 0:
					/**Seria el codigo padre, es decir, el anterior a la hoja que se leyo*/
					catalogo.setCodProducto(record[col]);
					break;
				case 1:
					/**Seria el codigo como tal de lo ue se esta leyendo*/
					catalogo.setCodActividad(record[col]);		
					break;
				case 2:
					/**Descripcion del catalogo*/
					catalogo.setNbdescripcion(record[col]);
					break;

				default:
					break;
				}
				col++;
			}
			manager.persist(catalogo);
		}
	}

	public ReadSheet getReadSheet() {
		return readSheet;
	}

	public void setReadSheet(ReadSheet readSheet) {
		this.readSheet = readSheet;
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
