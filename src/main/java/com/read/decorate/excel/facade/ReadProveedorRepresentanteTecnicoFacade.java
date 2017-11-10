package com.read.decorate.excel.facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.read.decorate.excel.impl.ReadProveedorRepresentanteTecnico;
import com.read.decorate.excel.interf.Execute;
import com.read.decorate.excel.interf.ReadSheet;
import com.read.decorate.excel.interf.WriteBD;

public class ReadProveedorRepresentanteTecnicoFacade implements Execute {
 	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private int row;
	private static String path;
	private EntityManager manager;
	
	
	public static void main(String[] args) {
		path = "C:/workspaceIV/readexcel2/src/main/resources/com/read/excel/plantilla.xls";
		ReadProveedorRepresentanteTecnicoFacade readFacade = new ReadProveedorRepresentanteTecnicoFacade("Representante Tecnico",9, 5, path);
		readFacade.procesar();
	}

	public ReadProveedorRepresentanteTecnicoFacade(EntityManager manager) {
		this.manager = manager;
	}

	public ReadProveedorRepresentanteTecnicoFacade(String sheet,int row, int col, String path) {
		super();
		this.sheet = sheet;
		this.col = col;
		this.path = path;
		this.row=row;
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
			writeBD = new ReadProveedorRepresentanteTecnico(sheet,row,col,path);
			writeBD.createRecords(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		System.out.println(".. done");
	}
}
