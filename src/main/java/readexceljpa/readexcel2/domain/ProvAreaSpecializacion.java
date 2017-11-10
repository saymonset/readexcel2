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
@Table(name = "area_espec_prov")
public class ProvAreaSpecializacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "nu_id_provAreaSpeci")
	private Long id;

	// PROVEEDOR
	@ManyToOne(optional = true)
	@JoinColumn(name = "nu_rif",nullable=false)
	private Proveedores nu_rif;

	// AREA
	@ManyToOne(optional = true)
	@JoinColumn(name = "co_area", nullable = false)
	private Area area;
	


	// Especializacion
	@ManyToOne(optional = true)
	@JoinColumn(name = "co_especializacion",nullable=false)
	private Especializacion especializacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Proveedores getNu_rif() {
		return nu_rif;
	}

	public void setNu_rif(Proveedores nu_rif) {
		this.nu_rif = nu_rif;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Especializacion getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(Especializacion especializacion) {
		this.especializacion = especializacion;
	}

	public ProvAreaSpecializacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvAreaSpecializacion(Proveedores nu_rif, Area area,
			Especializacion especializacion) {
		super();
		this.nu_rif = nu_rif;
		this.area = area;
		this.especializacion = especializacion;
	}

}
