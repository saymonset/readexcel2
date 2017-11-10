package com.read.decorate.excel.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import readexceljpa.readexcel2.domain.Direccion;
import readexceljpa.readexcel2.domain.Proveedores;
import readexceljpa.readexcel2.domain.StatusProv;
import readexceljpa.readexcel2.domain.TipoDireccion;

import com.read.decorate.excel.interf.ReadSheet;
import com.read.decorate.excel.interf.WriteBD;
import com.read.excel.ReadExcelProcess;
import com.read.generate.pwd.PasswordGenerator;
import com.read.util.EncryptorMD5;
import com.read.util.Tools;
import com.read.util.ToolsBD;

public class ReadProveedorBasico implements ReadSheet, WriteBD {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReadSheet readSheet = null;
	private String sheet;
	private int col;
	private String path;
	private List<String[]> rowFound;
	private int rowEnd;

	/**
	 * 
	 * Leemos la data de excel
	 * 
	 * @param sheet
	 * @param col
	 * @param path
	 */
	public ReadProveedorBasico(String sheet,int rowEnd, int col, String path) {
		super();
		/** Obtenemos todas las filas de la hoja en excel */
		readSheet = new ReadExcelProcess(sheet,rowEnd, col, path);

	}

	/*
	 * Metodo que devolvera los registros en una lista de arreglos
	 * 
	 * @see com.read.decorate.excel.interf.ReadSheet#readAllrow()
	 */
	public List<String[]> readAllrow() throws Exception {
		/** Obtenemos todas las filas de la hoja en excel */

		return readSheet.readAllrow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.read.decorate.excel.interf.ReadSheet#createRecords(java.util.List,
	 * javax.persistence.EntityManager)
	 */
	public void createRecords(EntityManager manager) throws Exception {
		/** Rutinas comunes a bd */
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
			Proveedores nu_rif = new Proveedores();
			String tlf1 = null;
			String tlf2 = null;
			String tlf3 = null;

			Direccion dirFiscal = null;
			Direccion dirComercial = null;
			while (col < record.length) {
				switch (col) {
				case 0:
					nu_rif.setNuRif(record[col]);
					break;
				case 1:
					nu_rif.setTxCorreo(record[col]);
					break;
				case 2:
					nu_rif.setTxRazonSocial(record[col]);
					break;
				case 3:
					nu_rif.setTxActividadEcono(record[col]);
					break;
				case 4:
					tlf1 = record[col];
					if (!Tools.isEmptyOrNull(tlf1)) {
						nu_rif.setTxTlf1(tlf1);
					}
					break;
				case 5:
					tlf2 = record[col];
					if (!Tools.isEmptyOrNull(tlf2)) {
						nu_rif.setTxTlf2(tlf2);
					}
					break;
				case 6:
					tlf3 = record[col];
					if (!Tools.isEmptyOrNull(tlf3)) {
						nu_rif.setTxTlf3(tlf3);
					}
					break;
				case 7:
					nu_rif.setTxPagWeb(record[col]);
					break;
				case 8:
					nu_rif.setTxObjPrinc(record[col]);
					break;
				case 9:
					//
					TipoDireccion tipoDireccion = new TipoDireccion();
					tipoDireccion.setNbTicDirecc("Dirección Fiscal");
					if (!Tools.isEmptyOrNull(record[col])) {
						dirFiscal = new Direccion();
						dirFiscal.setTipoDireccion(tipoDireccion);
						dirFiscal.setNu_rif(nu_rif);
						dirFiscal.setTxDireccion(record[col]);
					}

					break;
				case 10:
					//

					tipoDireccion = new TipoDireccion();
					tipoDireccion.setNbTicDirecc("Dirección Comercial");
					if (!Tools.isEmptyOrNull(record[col])) {
						dirComercial = new Direccion();
						dirComercial.setTipoDireccion(tipoDireccion);
						dirComercial.setNu_rif(nu_rif);
						dirComercial.setTxDireccion(record[col]);
					}
					break;

				default:
					break;
				}
				col++;
			}
			PasswordGenerator passwordGenerator = new PasswordGenerator(8);
			/**delete Contactos      before insert  */
			/**Esto se realiza en otras llamadas de componentes para insertar contactos*/
			toolsBD.deleteContactos(nu_rif.getNuRif(),manager);

			try {
				if (toolsBD.findByRif(nu_rif, manager)==null){
					
					nu_rif.setSwStProveedor(true);
					nu_rif.setFeUltActivac(new Date());
					System.out.println("passwordGenerator.getPinNumber()="
							+ passwordGenerator.getPinNumber());
					System.out.println("nu_rif=" + nu_rif.getNuRif());
					System.out.println("------------------------------");
					nu_rif.setTxContrasena(passwordGenerator.getPinNumber());
					nu_rif.setTxContrasena(EncryptorMD5.encrypt(
							EncryptorMD5.getKey(), nu_rif.getTxContrasena().trim()));
					nu_rif.setInSnc(Tools.STPROVEEDOR_ACTIVO);
					nu_rif.setFeRegistro(new Date());
					nu_rif.setSwStProveedor(true);
					manager.persist(nu_rif);
					StatusProv statusProveedorAux = new StatusProv();
					statusProveedorAux.setNuRif(nu_rif);
					statusProveedorAux.setCo_st_max(Tools.STPROVEEDOR_MAXIMO_REGISTRADO);
					statusProveedorAux.setCo_st_prov(Tools.STPROVEEDOR_ACTIVO);
					manager.persist(statusProveedorAux);

					/**delete address      before insert  */
					toolsBD.deleteDireccion(nu_rif.getNuRif(),manager);
					if (dirFiscal != null) {
						dirFiscal.setNu_rif(nu_rif);
						toolsBD.addDireccion(dirFiscal, manager);
					}
					if (dirComercial != null) {
						dirComercial.setNu_rif(nu_rif);
						toolsBD.addDireccion(dirComercial, manager);
					}

					/**
					 * boolean swActivar=true; String url = ""; StringBuilder
					 * messageBody = new StringBuilder();
					 */
					/** Mandamos correo */
					// send(nu_rif.getTxCorreo(), messageBody.toString(),
					// nu_rif.getNuRif(), url, swActivar);
					
				}else{
					System.out.println("Ya existe el rif:"+nu_rif.getNuRif());
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
