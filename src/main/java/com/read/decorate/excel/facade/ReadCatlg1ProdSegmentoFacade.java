package com.read.decorate.excel.facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.read.decorate.excel.impl.ReadCatlgProdSegmento;
import com.read.decorate.excel.interf.Execute;
import com.read.decorate.excel.interf.ReadSheet;
import com.read.decorate.excel.interf.WriteBD;

public class ReadCatlg1ProdSegmentoFacade implements Execute{
 	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private int rowEnd;
	private static String path;
	private EntityManager manager;
	
	
	public static void main(String[] args) {
		path = "/opt/enquistech/readexcel2/src/main/resources/com/read/excel/CoDIGOS de CCNU.xls";
		ReadCatlg1ProdSegmentoFacade readCatlgProdSegmentoFacade = new ReadCatlg1ProdSegmentoFacade("SEGMENTOS",56, 2, path);
		readCatlgProdSegmentoFacade.procesar();
	}

	public ReadCatlg1ProdSegmentoFacade(EntityManager manager) {
		this.manager = manager;
	}

	public ReadCatlg1ProdSegmentoFacade(String sheet,int rowEnd, int col, String path) {
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
			writeBD = new ReadCatlgProdSegmento(sheet,rowEnd,col,path);
			writeBD.createRecords(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		System.out.println(".. done");
	}
}
