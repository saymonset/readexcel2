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
 * Leemos el segmento del servicio nacional de contratis, estos van a tener su codigo
 * de producto en menos uno (-1) por ser la raiz de la data
 * @author Ing Simon Alberto Rodriguez Pacheco
 * 19/11/2013
 * 10:31:00
 */
public class ReadCatlgProdSegmento implements ReadSheet, WriteBD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private int rowEnd;
	private String path;

	public ReadCatlgProdSegmento(String sheet,int rowEnd, int col, String path) {
		super();

		readSheet = new ReadExcelProcess(sheet,rowEnd, col, path);
	}

	/*
	 * Metodo que devolvera los registros de excel  en una lista de arreglos
	 * 
	 * @see com.read.decorate.excel.interf.ReadSheet#readAllrow()
	 */
	public List<String[]> readAllrow() throws Exception {
		// TODO Auto-generated method stub
		return readSheet.readAllrow();
	}

	public void createRecords(EntityManager manager) throws Exception {
		
		/** delete all  catalogo first*/
		ToolsBD toolsBd= new ToolsBD();
		toolsBd.deleteCatalogo( manager) ;
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
					catalogo.setCodActividad(record[col]);
					break;
				case 1:
					catalogo.setNbdescripcion(record[col]);
					break;
				 

				default:
					break;
				}
				col++;
			}
			/**
			 * 
             * El codigo del producto va ha tener valor de 
             * menos uno (-1) por ser la raiz de la data
			 * */
			catalogo.setCodProducto("-1");
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
