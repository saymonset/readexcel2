package com.read.decorate.excel.main;

import com.read.decorate.excel.facade.ReadCatlg2FamiliasFacade;
import com.read.decorate.excel.facade.ReadProveedorBasicoFacade;
import com.read.decorate.excel.facade.ReadProveedorRepresentanteComercialFacade;
import com.read.decorate.excel.facade.ReadProveedorRepresentanteLegalFacade;
import com.read.decorate.excel.facade.ReadProveedorRepresentanteOtrosFacade;
import com.read.decorate.excel.facade.ReadProveedorRepresentanteTecnicoFacade;
import com.read.decorate.excel.interf.Execute;

/**
 * Llenamos nuestra bd a trraves de una plantilla de excel
 * @author Ing Simon Alberto Rodriguez Pacheco
 * 18/11/2013
 * 15:05:30
 */
public class Principal {
	static String path = "C:/workspaceIV/readexcel2/src/main/resources/com/read/excel/plantilla.xls";

	public static void main(String[] args) {
		/**  llenamos ´proveedores*/
		Execute execute = new ReadProveedorBasicoFacade("proveedor",9, 11, path);
		execute.procesar();
		/**  llenamos Representante Comercial*/
		execute = new ReadProveedorRepresentanteComercialFacade(
				"Representante Comercial",9, 5, path);
		execute.procesar();
		/**  llenamos Representante Legal*/
		execute = new ReadProveedorRepresentanteLegalFacade(
				"Representante Legal",9, 5, path);
		execute.procesar();
		/**  llenamos Representante Otros*/
		execute = new ReadProveedorRepresentanteOtrosFacade(
				"Representante Otros",9, 5, path);
		execute.procesar();
		/**  llenamos Representante  Tecnico*/
		execute = new ReadProveedorRepresentanteTecnicoFacade(
				"Representante Tecnico",9, 5, path);
		execute.procesar();
		/**  llenamos Representante  catalogo*/
		execute = new ReadCatlg2FamiliasFacade("catalogo",12, 3, path);
		execute.procesar();
	}
}
