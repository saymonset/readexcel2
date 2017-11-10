package com.read.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import readexceljpa.readexcel2.domain.Direccion;
import readexceljpa.readexcel2.domain.Proveedores;
import readexceljpa.readexcel2.domain.Representante;
import readexceljpa.readexcel2.domain.TipoDireccion;

import com.read.send.mail.ExceptionSendMail;
import com.read.send.mail.MyHiloEnvioMails;

/**
 * Realizamos operaciones basicas   a  bd
 * @author Ing Simon Alberto Rodriguez Pacheco
 * 18/11/2013
 * 14:50:20
 */
public class ToolsBD {
	/**
	 * @param dir
	 *            , grabamos el tipo de direccion con su rif
	 * @param em
	 * @return
	 */
	public  Direccion addDireccion(Direccion dir, EntityManager em) {
		Proveedores nu_rif = null;

		nu_rif = findByRif(dir.getNu_rif(), em);
		dir.setNu_rif(nu_rif);

		TipoDireccion tipoDireccion = new TipoDireccion();
		tipoDireccion.setNbTicDirecc(dir.getTipoDireccion().getNbTicDirecc());
		tipoDireccion = findByFiltro(tipoDireccion, em);
		dir.setTipoDireccion(tipoDireccion);

		em.persist(dir);

		return dir;
	}

	public Proveedores findByRif(Proveedores filtro, EntityManager em) {
		Proveedores prov = new Proveedores();

		StringBuilder str = new StringBuilder(
				"select object(o) from Proveedores as o where ");
		str.append(" lower(o.nuRif)=:nuRif");

		Query query = em.createQuery(str.toString());
		query.setParameter("nuRif", filtro.getNuRif().toLowerCase().trim());
		@SuppressWarnings("unchecked")
		List<Proveedores> lista = query.getResultList();
		if (lista == null || lista.isEmpty() || lista.size() == 0) {

			prov = null;
		} else {
			prov = lista.get(0);

		}

		return prov;
	}
	
	
	/**
	 * Delete las direcciones de un rif
	 * @param nuRif
	 * @param em
	 */
	public void deleteDireccion(String nuRif, EntityManager em) {
		if (!Tools.isEmptyOrNull(nuRif)){
			StringBuilder str = new StringBuilder(
					"delete  from Direccion as o where ");
			str.append(" lower(o.nu_rif.nuRif)='").append(nuRif.toLowerCase().trim()).append("'");
			Query query = em.createQuery(str.toString());
			query.executeUpdate();	
		}
	
	}
	/**
	 * Delete las direcciones de un rif
	 * @param nuRif
	 * @param em
	 */
	public void deleteCatalogo( EntityManager em) {
		 
			StringBuilder str = new StringBuilder(
					"delete  from Catalogo as o   ");
			Query query = em.createQuery(str.toString());
			query.executeUpdate();	
		 
	
	}
	/**
	 * Delete las Contactos de un rif
	 * @param nuRif
	 * @param em
	 */
	public void deleteContactos(String nuRif, EntityManager em) {
		if (!Tools.isEmptyOrNull(nuRif)){
			StringBuilder str = new StringBuilder(
					"delete  from Contactos as o where ");
			str.append(" lower(o.nu_rif.nuRif)='").append(nuRif.toLowerCase().trim()).append("'");
			Query query = em.createQuery(str.toString());
			query.executeUpdate();
			
		}
	
	}

	public TipoDireccion findByFiltro(TipoDireccion filtro, EntityManager em) {
		TipoDireccion objReturn = null;

		if (filtro != null && filtro.getNbTicDirecc() != null) {
			StringBuilder str = new StringBuilder(
					"select object(o) from TipoDireccion as o where ");
			str.append(" lower(o.nbTicDirecc)=:nbTicDirecc");

			Query query = em.createQuery(str.toString());
			query.setParameter("nbTicDirecc", filtro.getNbTicDirecc()
					.toLowerCase().trim());
			@SuppressWarnings("unchecked")
			List<TipoDireccion> lista = query.getResultList();
			if (lista == null || lista.isEmpty() || lista.size() == 0) {
				return objReturn;
			} else {
				objReturn = lista.get(0);
			}
		}
		return objReturn;
	}
	
	public Representante findByFiltro(Representante filtro, EntityManager em)
	{
	Representante objAux = new Representante();
	
	StringBuilder str = new StringBuilder(
			"select object(o) from Representante as o where ");
	str.append(" lower(o.txTipoRep)='").append(filtro.getTxTipoRep().toLowerCase().trim()).append("'");

	Query query = em.createQuery(str.toString());
	 
	@SuppressWarnings("unchecked")
	List<Representante> lista = query.getResultList();
	if (lista == null || lista.isEmpty() || lista.size() == 0) {

		objAux = null;
	} else {
		objAux = lista.get(0);
	 
		 

	}



	return objAux;

}

	public void send(String to, String messageBody, String rif, String url,
			boolean swActivar) throws ExceptionSendMail {

		if (!Tools.isEmptyOrNull(url)) {
			// mandamos el mail a traves de un hilo
			MyHiloEnvioMails myHiloEnvioMails = new MyHiloEnvioMails(to,
					messageBody, rif, url, swActivar);
			try {
				// myHiloEnvioMails.runSinHilo();

				myHiloEnvioMails.run();
			} catch (Exception e) {

				throw new ExceptionSendMail(e.getMessage());
			}
			if (!Tools.isEmptyOrNull(myHiloEnvioMails.getErrorMail())) {
				throw new ExceptionSendMail(myHiloEnvioMails.getErrorMail());
			}

		}
	}

	
	 
}
