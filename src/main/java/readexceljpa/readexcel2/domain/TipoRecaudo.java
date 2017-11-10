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
@Table(name = "TIPO_RECAUDO")
public class TipoRecaudo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "CO_TI_RECAUDO")
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "NB_TI_RECAUDO", length = 100,nullable=false)
	private String txNombreTipo;
	
	/**
	 * -- st_tiporecaudo = 1  SE PIDE FECHA, PERO NO ES OBLIGATORIO SUBIR EL DOCUMENTO
       -- st_tiporecaudo = 2  SE PIDE FECHA, Y ES OBLIGATORIO SUBIR EL DOCUMENTO
       -- st_tiporecaudo = 3  NO SE PIDE FECHA, Y ES OBLIGATORIO SUBIR EL DOCUMENTO
	 * */
	@Column(name = "CO_ST_TI_RECAUDO", length = 2,nullable=false)
	private String stTipoRecaudo;

	// RECAUDOS
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nu_id_tipo")
	private Collection<Recaudos> recaudosList = new ArrayList<Recaudos>();

	public String getTxNombreTipo() {
		return txNombreTipo;
	}

	public void setTxNombreTipo(String txNombreTipo) {
		this.txNombreTipo = txNombreTipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Recaudos> getRecaudosList() {
		return recaudosList;
	}

	public void setRecaudosList(Collection<Recaudos> recaudosList) {
		this.recaudosList = recaudosList;
	}

	public String getStTipoRecaudo() {
		return stTipoRecaudo;
	}

	public void setStTipoRecaudo(String stTipoRecaudo) {
		this.stTipoRecaudo = stTipoRecaudo;
	}

}
