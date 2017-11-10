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
@Table(name = "STATUS_PROV")

public class StatusProv implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	//CODIGO DE MAXIMO
	@Column(name = "CO_ST_MAX",length=2,nullable=false)
	private String co_st_max;
	//CODIGO DEL PROVEEDOR
	@Column(name = "CO_ST_PROV",length=2,nullable=true)
	private String co_st_prov;
	
//	PROVEEDOR
	@ManyToOne(optional = true)
	@JoinColumn(name = "nuRif")
	private Proveedores nuRif;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Proveedores getNuRif() {
		return nuRif;
	}

	public void setNuRif(Proveedores nuRif) {
		this.nuRif = nuRif;
	}

	public String getCo_st_max() {
		return co_st_max;
	}

	public void setCo_st_max(String co_st_max) {
		this.co_st_max = co_st_max;
	}

	public String getCo_st_prov() {
		return co_st_prov;
	}

	public void setCo_st_prov(String co_st_prov) {
		this.co_st_prov = co_st_prov;
	}

 

}
