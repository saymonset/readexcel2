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
@Table(name = "TIPO_CONT_REPRES")
public class Representante implements Serializable{

	 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CO_TI_CONTACTO")
	private Long id;
	
	@Column(name = "NB_TI_CONTACTO",length=100,nullable=false)
	private String txTipoRep;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "nu_id_repre")
	private Collection<Contactos> contactosList = new ArrayList<Contactos>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxTipoRep() {
		return txTipoRep;
	}

	public void setTxTipoRep(String txTipoRep) {
		this.txTipoRep = txTipoRep;
	}

	public Collection<Contactos> getContactosList() {
		return contactosList;
	}

	public void setContactosList(Collection<Contactos> contactosList) {
		this.contactosList = contactosList;
	}

	

}
