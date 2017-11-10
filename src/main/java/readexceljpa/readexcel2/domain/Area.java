package readexceljpa.readexcel2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
@Table(name = "area_esp")
public class Area implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "CO_AREA")
	private Long id;
	@Column(name = "NB_AREA",length=100,nullable=false)
	private String txNombre;

	 

	// proveedor area esopecializacion
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
	private Collection<ProvAreaSpecializacion> provAreaSpecializacionList = new ArrayList<ProvAreaSpecializacion>();
	
	// ESPECIALIZACIONES
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "nu_id_area")
		private Collection<Especializacion> especializacionList = new ArrayList<Especializacion>();


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

	 
	public Collection<Especializacion> getEspecializacionList() {
		return especializacionList;
	}

	public void setEspecializacionList(
			Collection<Especializacion> especializacionList) {
		this.especializacionList = especializacionList;
	}

}
