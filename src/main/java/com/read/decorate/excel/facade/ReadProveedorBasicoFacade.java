package com.read.decorate.excel.facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.read.decorate.excel.impl.ReadProveedorBasico;
import com.read.decorate.excel.interf.Execute;
import com.read.decorate.excel.interf.ReadSheet;
import com.read.decorate.excel.interf.WriteBD;

public class ReadProveedorBasicoFacade implements Execute{
 	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private static String path;
	private EntityManager manager;
	private int row;
	
	
	public static void main(String[] args) {
		path = "C:/workspaceIV/readexcel2/src/main/resources/com/read/excel/plantilla.xls";
		ReadProveedorBasicoFacade readFacade = new ReadProveedorBasicoFacade("proveedor",9, 11, path);
		readFacade.procesar();
	}

	public ReadProveedorBasicoFacade(EntityManager manager) {
		this.manager = manager;
	}

	public ReadProveedorBasicoFacade(String sheet,int row, int col, String path) {
		super();
		this.sheet = sheet;
		this.col = col;
		this.path = path;
		this.row = row;
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
			writeBD = new ReadProveedorBasico(sheet,row,col,path);
			 
			writeBD.createRecords(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		System.out.println(".. done");
	}
}
