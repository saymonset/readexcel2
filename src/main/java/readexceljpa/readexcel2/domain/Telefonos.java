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
// @Entity
// @Table(name = "TELEFONO")
public class Telefonos implements Serializable {

	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue
	// @Column(name = "nu_id_tlf")
	private Long id;
	// @ManyToOne(optional = true)
	// @JoinColumn(name = "nu_rif")
	// private Proveedores nu_rif;
	private String nu_telefono;

	public Telefonos(Proveedores nu_rif, String nu_telefono) {
		super();
		this.nu_telefono = nu_telefono;
		// this.nu_rif = nu_rif;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNu_telefono() {
		return nu_telefono;
	}

	public void setNu_telefono(String nu_telefono) {
		this.nu_telefono = nu_telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Telefonos() {
		super();
		// TODO Auto-generated constructor stub
	}

}
