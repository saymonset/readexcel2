package readexceljpa.readexcel2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

//@Entity
//@Table(name = "cuenta")
public class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@GeneratedValue
	@Column(name = "nu_id_cuenta")
	private Long id;
	
	@Column(name = "nu_cuenta")
	private String nuCuenta;
	@Column(name = "tx_nom_benef")
	private String txNomBenef;
	@Column(name = "tx_direccion")
	private String txDireccion;
	//OBSERVACION
    @Column(name = "tx_pais")
	private String txPais;
 
	
//	PROVEEDOR
	@ManyToOne(optional = true)
	@JoinColumn(name = "nu_rif")
	private Proveedores nu_rif;
	
	
//	BANCOS
	@ManyToOne(optional = true)
	@JoinColumn(name = "nu_id_banco")
	private Banco nu_id_banco;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNuCuenta() {
		return nuCuenta;
	}


	public void setNuCuenta(String nuCuenta) {
		this.nuCuenta = nuCuenta;
	}


	public String getTxNomBenef() {
		return txNomBenef;
	}


	public void setTxNomBenef(String txNomBenef) {
		this.txNomBenef = txNomBenef;
	}


	public String getTxDireccion() {
		return txDireccion;
	}


	public void setTxDireccion(String txDireccion) {
		this.txDireccion = txDireccion;
	}


	public String getTxPais() {
		return txPais;
	}


	public void setTxPais(String txPais) {
		this.txPais = txPais;
	}


	public Proveedores getNu_rif() {
		return nu_rif;
	}


	public void setNu_rif(Proveedores nu_rif) {
		this.nu_rif = nu_rif;
	}


	public Banco getNu_id_banco() {
		return nu_id_banco;
	}


	public void setNu_id_banco(Banco nu_id_banco) {
		this.nu_id_banco = nu_id_banco;
	}


	




}
