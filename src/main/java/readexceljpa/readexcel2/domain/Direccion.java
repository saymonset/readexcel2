package readexceljpa.readexcel2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ing Simón Alberto Rodriguez Pacheco
 * Desarrollador Senior Java
 * simon.rodriguez@enquistech.com
 * oraclefedora@gmail.com
 * 01/04/2013
 * 08:15:59
 */ 
@XmlRootElement

@Entity
@Table(name = "DIRECCION_PROV")
public class Direccion implements Serializable {
	

	 
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "NU_ID_DIREC")
	private Long id;
	
 
	@Column(name = "TX_DIRECCION", length=300,nullable = false)
	private String txDireccion;
	
	@Column(name = "TX_REF_DIRECC", length=200)
	private String txRefDirecc;
 
//	PROVEEDORES
	@ManyToOne(optional = true)
	@JoinColumn(name = "nu_rif",nullable = false)
	private Proveedores nu_rif;
	

	 
//		TipoDireccion
		@ManyToOne(optional = true)
		@JoinColumn(name = "co_ti_direcc",nullable = false)
		private TipoDireccion tipoDireccion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 
	public String getTxDireccion() {
		return txDireccion;
	}
	public void setTxDireccion(String txDireccion) {
		this.txDireccion = txDireccion;
	}
 
	public Proveedores getNu_rif() {
		return nu_rif;
	}
	public void setNu_rif(Proveedores nu_rif) {
		this.nu_rif = nu_rif;
	}
	public String getTxRefDirecc() {
		return txRefDirecc;
	}
	public void setTxRefDirecc(String txRefDirecc) {
		this.txRefDirecc = txRefDirecc;
	}
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	
	 


}
