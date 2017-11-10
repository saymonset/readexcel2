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
@Table(name = "TIPO_DIRECCION")
public class TipoDireccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "CO_TI_DIRECC")
	@Id
	@GeneratedValue
	private Long id;
    @Column(name="NB_TI_DIRECC",length=100,nullable=false)
	private String nbTicDirecc;
    
 
	// TIPO_DIRECCION
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDireccion")
		private Collection<Direccion> direccionList = new ArrayList<Direccion>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNbTicDirecc() {
		return nbTicDirecc;
	}
	public void setNbTicDirecc(String nbTicDirecc) {
		this.nbTicDirecc = nbTicDirecc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Collection<Direccion> getDireccionList() {
		return direccionList;
	}
	public void setDireccionList(Collection<Direccion> direccionList) {
		this.direccionList = direccionList;
	}
 
	 
}
