package readexceljpa.readexcel2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author Ing Simón Alberto Rodriguez Pacheco
 * Desarrollador Senior Java
 * simon.rodriguez@enquistech.com
 * oraclefedora@gmail.com
 * 01/04/2013
 * 08:16:06
 */ 
@XmlRootElement

@Entity
@Table(name = "PROVEEDOR", uniqueConstraints = @UniqueConstraint(columnNames = "nu_rif"))
public class Proveedores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NU_RIF")
	private String nuRif;
	
	@Column(name = "TI_PERSONA", length=1,nullable=false)
	private String tiPersona="J";
	
	@Column(name = "TX_RAZON_SOCIAL",length=300,nullable=true)
	private String txRazonSocial;
	
	@Column(name = "NB_DENOM_COMERCIAL",length=300)
	private String txDenomComercial;
	
	@Column(name = "TX_OBJETO_EMPRESA",length=5000)
	private String txObjPrinc;
	
	@Column(name = "TX_CORREOE_PROV",length=100)
	private String txCorreo;
	
	@Column(name = "TX_CONTRASENA",length=100,nullable=false)
	private String txContrasena;
	
	@Column(name = "NU_TLF1_PROV",length=100,nullable=true)
	private String txTlf1;
	

	@Column(name = "NU_TLF2_PROV",length=100)
	private String txTlf2;

	@Column(name = "NU_TLF3_PROV",length=100)
	private String txTlf3;
	
	@Column(name = "FE_REGISTRO",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date feRegistro;
	
	@Column(name = "FE_ULT_ACTIVAC")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date feUltActivac;
	
	@Column(name = "FE_ULT_INACTIVAC")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date feUltInActivac;
	
	@Column(name = "IN_SNC",length=1)
	private String inSnc;

	//-----------------------------------------------------------------------------
	//-----------------------------------------------------------------------------
	//-----------------------------------------------------------------------------
	//@Column(name = "st_proveedor")
	@Transient
	private String stProveedor;
	@Transient
	private boolean swStProveedor;
	
	@Column(name = "tx_actividad_econo")
	private String txActividadEcono;
	@Column(name = "tx_pag_web")
	private String txPagWeb;
//	@Column(name = "tx_tipo_persona")
//	private String txTipoPersona;
	
	@Transient
	private BdMaximo bdMaximo;
    @Transient
    private String sncstatusNombre;
    @Transient
    private boolean swSncstatusRegistrado;
    @Transient
    private String stDescripcionProveedor;
    @Transient
    private String maximoDireccionComercial;
    @Transient
    private String maximoObjetosocialv;
 
 

 





	//	DIRECCIOPNES
 	@OneToMany(cascade = CascadeType.ALL,mappedBy = "nu_rif")
	private Collection<Direccion> direccionList = new ArrayList<Direccion>();
 
	
	
//	PROVEEDOR AREA SPECIALIZACION
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "nu_rif")
	private Collection<ProvAreaSpecializacion> provAreaSpecializacionList = new ArrayList<ProvAreaSpecializacion>();
 

	// RECAUDO
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "nu_rif")
	private Collection<Recaudos> recaudosList = new ArrayList<Recaudos>();
	
	//CONTACTOS
		@OneToMany(cascade = CascadeType.ALL,mappedBy = "nu_rif")
		private Collection<Contactos> contactosList = new ArrayList<Contactos>();
	 
		 
		 

			//STATUS PROVE
			@OneToMany(cascade = CascadeType.ALL,mappedBy = "nuRif")
			private Collection<StatusProv> statusProvList = new ArrayList<StatusProv>();
		
		public Proveedores(){
			super();
		}
		 
 

		public String getNuRif() {
			return nuRif;
		}

		public void setNuRif(String nuRif) {
			this.nuRif = nuRif;
		}
//
//		public String getTxNombre() {
//			return txNombre;
//		}
//
//		public void setTxNombre(String txNombre) {
//			this.txNombre = txNombre;
//		}

		public String getTxRazonSocial() {
			return txRazonSocial;
		}

		public void setTxRazonSocial(String txRazonSocial) {
			this.txRazonSocial = txRazonSocial;
		}

		public String getTxObjPrinc() {
			return txObjPrinc;
		}

		public void setTxObjPrinc(String txObjPrinc) {
			this.txObjPrinc = txObjPrinc;
		}

		public String getTxContrasena() {
			return txContrasena;
		}

		public void setTxContrasena(String txContrasena) {
			this.txContrasena = txContrasena;
		}

		public String getTxActividadEcono() {
			return txActividadEcono;
		}

		public void setTxActividadEcono(String txActividadEcono) {
			this.txActividadEcono = txActividadEcono;
		}

		public String getTxPagWeb() {
			return txPagWeb;
		}

		public void setTxPagWeb(String txPagWeb) {
			this.txPagWeb = txPagWeb;
		}

		 
		 

	  

	 



		public Collection<Direccion> getDireccionList() {
			return direccionList;
		}

		public void setDireccionList(Collection<Direccion> direccionList) {
			this.direccionList = direccionList;
		}
 
 

	 
		public Collection<Recaudos> getRecaudosList() {
			return recaudosList;
		}

		public void setRecaudosList(Collection<Recaudos> recaudosList) {
			this.recaudosList = recaudosList;
		}

		public Collection<Contactos> getContactosList() {
			return contactosList;
		}

		public void setContactosList(Collection<Contactos> contactosList) {
			this.contactosList = contactosList;
		}

		public String getTxCorreo() {
			return txCorreo;
		}

		public void setTxCorreo(String txCorreo) {
			this.txCorreo = txCorreo;
		}

		public Collection<ProvAreaSpecializacion> getProvAreaSpecializacionList() {
			return provAreaSpecializacionList;
		}

		public void setProvAreaSpecializacionList(
				Collection<ProvAreaSpecializacion> provAreaSpecializacionList) {
			this.provAreaSpecializacionList = provAreaSpecializacionList;
		}

	
		public String getTxDenomComercial() {
			return txDenomComercial;
		}

		public void setTxDenomComercial(String txDenomComercial) {
			this.txDenomComercial = txDenomComercial;
		}

		 
//
//		public Collection<Cuenta> getProvCtaList() {
//			return provCtaList;
//		}
//
//		public void setProvCtaList(Collection<Cuenta> provCtaList) {
//			this.provCtaList = provCtaList;
//		}

 

		 

		public String getTxTlf1() {
			return txTlf1;
		}


		public void setTxTlf1(String txTlf1) {
			this.txTlf1 = txTlf1;
		}


		public String getTxTlf2() {
			return txTlf2;
		}


		public void setTxTlf2(String txTlf2) {
			this.txTlf2 = txTlf2;
		}


		public String getTxTlf3() {
			return txTlf3;
		}


		public void setTxTlf3(String txTlf3) {
			this.txTlf3 = txTlf3;
		}


		public String getStProveedor() {
			return stProveedor;
		}


		public void setStProveedor(String stProveedor) {
			this.stProveedor = stProveedor;
		}


		public String getTiPersona() {
			return tiPersona;
		}


		public void setTiPersona(String tiPersona) {
			this.tiPersona = tiPersona;
		}


		public java.util.Date getFeRegistro() {
			 
			return feRegistro;
		}


		public void setFeRegistro(java.util.Date feRegistro) {
			this.feRegistro = feRegistro;
		}


		public java.util.Date getFeUltActivac() {
			return feUltActivac;
		}


		public void setFeUltActivac(java.util.Date feUltActivac) {
			this.feUltActivac = feUltActivac;
		}


		public java.util.Date getFeUltInActivac() {
			return feUltInActivac;
		}


		public void setFeUltInActivac(java.util.Date feUltInActivac) {
			this.feUltInActivac = feUltInActivac;
		}


		public String getInSnc() {
			return inSnc;
		}


		public void setInSnc(String inSnc) {
			this.inSnc = inSnc;
		}


	 

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		public Collection<StatusProv> getStatusProvList() {
			return statusProvList;
		}


		public void setStatusProvList(Collection<StatusProv> statusProvList) {
			this.statusProvList = statusProvList;
		}


		public BdMaximo getBdMaximo() {
			return bdMaximo;
		}


		public void setBdMaximo(BdMaximo bdMaximo) {
			this.bdMaximo = bdMaximo;
		}


		


		public String getStDescripcionProveedor() {
			return stDescripcionProveedor;
		}


		public void setStDescripcionProveedor(String stDescripcionProveedor) {
			this.stDescripcionProveedor = stDescripcionProveedor;
		}


		public String getMaximoDireccionComercial() {
			return maximoDireccionComercial;
		}


		public void setMaximoDireccionComercial(String maximoDireccionComercial) {
			this.maximoDireccionComercial = maximoDireccionComercial;
		}


		public String getMaximoObjetosocialv() {
			return maximoObjetosocialv;
		}


		public void setMaximoObjetosocialv(String maximoObjetosocialv) {
			this.maximoObjetosocialv = maximoObjetosocialv;
		}


		public String getSncstatusNombre() {
			return sncstatusNombre;
		}


		public void setSncstatusNombre(String sncstatusNombre) {
			this.sncstatusNombre = sncstatusNombre;
		}


		public boolean isSwSncstatusRegistrado() {
			return swSncstatusRegistrado;
		}


		public void setSwSncstatusRegistrado(boolean swSncstatusRegistrado) {
			this.swSncstatusRegistrado = swSncstatusRegistrado;
		}


		public boolean isSwStProveedor() {
			return swStProveedor;
		}


		public void setSwStProveedor(boolean swStProveedor) {
			this.swStProveedor = swStProveedor;
		}


	

 

	 

	 

	
 

	

	
	
}
