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
@XmlRootElement

@Entity
@Table(name = "CONTACTO")
public class Contactos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	@Column(name = "NU_CI_CONTACTO")
	private Long id;
	
	@Column(name = "NB_NOMBRE1",length=100,nullable = false)
	private String txNombre;
	
	@Column(name = "NB_APELLIDO1",length=100,nullable = false)
	private String txApellido;
	
	@Column(name = "TX_CORREOE_CONT",length=100)
	private String txCorreo;
	
	@Column(name = "NU_TLF_CONTACTO",length=100)
	private String txTlf1;
//	PROVEEDOR
	@ManyToOne(optional = true)
	@JoinColumn(name = "nu_rif",nullable = false)
	private Proveedores nu_rif;
 
	
//	REPRESENTANTES
	@ManyToOne(optional = true)
	@JoinColumn(name = "co_ti_contacto",nullable = false)
	private Representante nu_id_repre;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTxNombre() {
		return txNombre;
	}


	public void setTxNombre(String txNombre) {
		this.txNombre = txNombre;
	}


	public String getTxCorreo() {
		return txCorreo;
	}


	public void setTxCorreo(String txCorreo) {
		this.txCorreo = txCorreo;
	}


	public String getTxApellido() {
		return txApellido;
	}


	public void setTxApellido(String txApellido) {
		this.txApellido = txApellido;
	}


	public Proveedores getNu_rif() {
		return nu_rif;
	}


	public void setNu_rif(Proveedores nu_rif) {
		this.nu_rif = nu_rif;
	}


	public Representante getNu_id_repre() {
		return nu_id_repre;
	}


	public void setNu_id_repre(Representante nu_id_repre) {
		this.nu_id_repre = nu_id_repre;
	}


	public String getTxTlf1() {
		return txTlf1;
	}


	public void setTxTlf1(String txTlf1) {
		this.txTlf1 = txTlf1;
	}
	

}

