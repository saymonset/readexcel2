package readexceljpa.readexcel2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

@Entity
@Table(name = "RECAUDO")
public class Recaudos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "CO_RECAUDO")
	@Id
	@GeneratedValue
	private Long id;

	
	@Column(name = "TX_UBICA_RECAUDO",length=100,nullable=false)
	private String txLocalDoc;

	@Column(name = "NB_DOCUMENTO",length=100,nullable=false)
	private String txNombre;

	@Column(name = "FE_VENCIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date feVencimiento;
	
	
//	PROVEEDOR
	@ManyToOne(optional = true)
	@JoinColumn(name = "nu_rif",nullable=false)
	private Proveedores nu_rif;
	

 
	
//	Recaudo
	@ManyToOne(optional = true)
	@JoinColumn(name = "co_ti_recaudo",nullable=false)
	private TipoRecaudo nu_id_tipo;
	
	
	



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

	public Proveedores getNu_rif() {
		return nu_rif;
	}

	public void setNu_rif(Proveedores nu_rif) {
		this.nu_rif = nu_rif;
	}

	 
	public TipoRecaudo getNu_id_tipo() {
		return nu_id_tipo;
	}

	public void setNu_id_tipo(TipoRecaudo nu_id_tipo) {
		this.nu_id_tipo = nu_id_tipo;
	}

	public java.util.Date getFeVencimiento() {
		return feVencimiento;
	}

	public void setFeVencimiento(java.util.Date feVencimiento) {
		this.feVencimiento = feVencimiento;
	}

	public String getTxLocalDoc() {
		return txLocalDoc;
	}

	public void setTxLocalDoc(String txLocalDoc) {
		this.txLocalDoc = txLocalDoc;
	}
 
 

}
