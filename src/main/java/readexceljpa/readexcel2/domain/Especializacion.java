package readexceljpa.readexcel2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

@Entity
@Table(name = "ESPECIALIZACION")
public class Especializacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "co_especializacion")
	private Long id;
	@Column(name = "NB_ESPECIALIZACION",length=300, nullable = false)
	private String txNombreEsp;
	
 
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "co_area",nullable=false)
	private Area nu_id_area;

//PROVEEDOR	AREA ESPECIALIZACION
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "especializacion")
		private Collection<ProvAreaSpecializacion> provAreaSpecializacionList = new ArrayList<ProvAreaSpecializacion>();
 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTxNombreEsp() {
		return txNombreEsp;
	}
	public void setTxNombreEsp(String txNombreEsp) {
		this.txNombreEsp = txNombreEsp;
	}
	 
	public Area getNu_id_area() {
		return nu_id_area;
	}
	public void setNu_id_area(Area nu_id_area) {
		this.nu_id_area = nu_id_area;
	}
 
}
