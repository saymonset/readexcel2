package readexceljpa.readexcel2.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "CATALOGO")
public class Catalogo implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "co_catalogo")
	private String id;
	// EL CODIGO DE LA ACTIVIDAD ES EL PADRE, PERO ESTE SE PUEDE REPETIR
	@Column(name = "co_activ_cat", length = 300, nullable = false)
	private String codActividad;
	@Column(name = "co_prod_cat", length = 300, nullable = false)
	private String codProducto;
	@Column(name = "tx_catalogo", length = 3000,nullable = false)
	private String nbdescripcion;
	
 

	@Transient
	private String txTipo;
	@Transient
	private String txExperiencia;

	@Transient
	private String txInformacion;

	@Transient
	private String txRelacion;

	@Transient
	private Map<String, Catalogo> productosMap = new HashMap<String, Catalogo>();;
	@Transient
	private List<Catalogo> productosOnlyView;
	@Transient
	private int arbolRecursivoBuscarHasta;

	public String getCodActividad() {
		return codActividad;
	}

	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNbdescripcion() {
		return nbdescripcion;
	}

	public void setNbdescripcion(String nbdescripcion) {
		this.nbdescripcion = nbdescripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Catalogo> getProductosMap() {
		return productosMap;
	}

	public void setProductosMap(Map<String, Catalogo> productosMap) {
		this.productosMap = productosMap;
	}

	public List<Catalogo> getProductosOnlyView() {
		return productosOnlyView;
	}

	public void setProductosOnlyView(List<Catalogo> productosOnlyView) {
		this.productosOnlyView = productosOnlyView;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTxTipo() {
		return txTipo;
	}

	public void setTxTipo(String txTipo) {
		this.txTipo = txTipo;
	}

	public String getTxExperiencia() {
		return txExperiencia;
	}

	public void setTxExperiencia(String txExperiencia) {
		this.txExperiencia = txExperiencia;
	}

	public String getTxInformacion() {
		return txInformacion;
	}

	public void setTxInformacion(String txInformacion) {
		this.txInformacion = txInformacion;
	}

	public String getTxRelacion() {
		return txRelacion;
	}

	public void setTxRelacion(String txRelacion) {
		this.txRelacion = txRelacion;
	}

	public int getArbolRecursivoBuscarHasta() {
		return arbolRecursivoBuscarHasta;
	}

	public void setArbolRecursivoBuscarHasta(int arbolRecursivoBuscarHasta) {
		this.arbolRecursivoBuscarHasta = arbolRecursivoBuscarHasta;
	}

}
