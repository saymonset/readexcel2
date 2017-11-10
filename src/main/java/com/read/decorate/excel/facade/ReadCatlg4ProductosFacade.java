package com.read.decorate.excel.facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.read.decorate.excel.impl.ReadCatalogo;
import com.read.decorate.excel.interf.Execute;
import com.read.decorate.excel.interf.ReadSheet;
import com.read.decorate.excel.interf.WriteBD;

public class ReadCatlg4ProductosFacade  implements Execute{
 	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private static String path;
	private EntityManager manager;
	private int rowEnd;
	
	
	public static void main(String[] args) {
		path = "/opt/enquistech/readexcel2/src/main/resources/com/read/excel/CoDIGOS de CCNU.xls";
		ReadCatlg2FamiliasFacade readCatalogoFacade = new ReadCatlg2FamiliasFacade("PRODUCTOS",94132005, 3, path);
		readCatalogoFacade.procesar();
	}

	public ReadCatlg4ProductosFacade(EntityManager manager) {
		this.manager = manager;
	}

	public ReadCatlg4ProductosFacade(String sheet, int rowEnd,int col, String path) {
		super();
		this.sheet = sheet;
		this.col = col;
		this.path = path;
		this.rowEnd=rowEnd;
	}

	/**
	 * Llenamos nuestra tabla catalogos
	 */
	public  void procesar() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
 
			
			WriteBD writeBD = null;
			writeBD = new ReadCatalogo(sheet,rowEnd,col,path);
			writeBD.createRecords(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		System.out.println(".. done");
	}

	public int getRowEnd() {
		return rowEnd;
	}

	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}
}
