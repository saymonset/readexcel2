package com.read.decorate.excel.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import readexceljpa.readexcel2.domain.Contactos;
import readexceljpa.readexcel2.domain.Proveedores;
import readexceljpa.readexcel2.domain.Representante;

import com.read.decorate.excel.interf.ReadSheet;
import com.read.decorate.excel.interf.WriteBD;
import com.read.excel.ReadExcelProcess;
import com.read.util.Tools;
import com.read.util.ToolsBD;

public class ReadProveedorRepresentanteComercial implements ReadSheet, WriteBD {

	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private String path;
	private List<String[]> rowFound;
	private int rowEnd;


	public ReadProveedorRepresentanteComercial(String sheet,int rowEnd, int col, String path) {
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

	public void createRecords( EntityManager manager) throws Exception {
		ToolsBD toolsBD = new ToolsBD();
		boolean isRowTitle = true;
		/** Obtenemos todas las filas de la hoja en excel */
		rowFound = readAllrow();
		for (String[] record : rowFound) {
			if (isRowTitle) {
				// SALTAMOS LA PRIMERA FILA
				isRowTitle = false;
				continue;
			}
			int col = 0;
			Contactos	contactos = new Contactos();
			Proveedores	proveedor = new Proveedores();
		 
			Representante	representante = new Representante();
			representante.setTxTipoRep("Representante Comercial");
			representante =toolsBD.findByFiltro(representante ,manager);
			contactos.setNu_id_repre(representante);
			while (col < record.length) {
				switch (col) {
				case 0:
					proveedor.setNuRif(record[col]);
					proveedor=toolsBD.findByRif(proveedor, manager);
					contactos.setNu_rif(proveedor);
					
					break;
				case 1:
					contactos.setTxNombre(record[col]);
					break;
				case 2:
					contactos.setTxApellido(record[col]);
					break;
				case 3:
					contactos.setTxCorreo(record[col]);
					break;
				case 4:
					
					contactos.setTxTlf1(Tools.tlf(record[col]));
					break;
				default:
					break;
				}
				col++;
			}
			
		
 try {
	 manager.persist(contactos);
} catch (Exception e) {
	System.out.println("update "+ReadProveedorRepresentanteComercial.class.getName());
	manager.merge(contactos);
}
				
				 

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
