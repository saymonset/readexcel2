package com.read.decorate.excel.interf;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * 
 * Interfaz serqa implementada para llevar todos los campos de sus celdas de excel , 
 * seran leidas
 * @author Simon
 *
 */
public interface ReadSheet extends Serializable{
	/**
	 * Nombre de la hoja de excel
	 * @return
	 */
	String getSheet();
	void setSheet(String sheet);
	/**
	 * cuantas columnas se leeran de la hoja de excel
	 * @return
	 */
	int getCol() ;
	void setCol(int col);
	
	/**
	 * cuantas rows se leeran de la hoja de excel
	 * @return
	 */
	int getRowEnd() ;
	void setRowEnd(int rowEnd);
	
	String getPath() ;
	void setPath(String path) ;
	
	
	/**
	 * Metodo que leera las celdas de las hojas de excel
	 * Retornaremos en una lista , todos los registros encontrados en la hoja de excel.
	 * cada registro esta representado por un arreglo, cada posicion es un campo que se lee 
	 * @return
	 */
	List<String[]> readAllrow() throws Exception;
	
 
}
