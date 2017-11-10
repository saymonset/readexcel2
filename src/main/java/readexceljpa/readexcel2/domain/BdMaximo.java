package readexceljpa.readexcel2.domain;

import java.io.Serializable;
import java.util.List;

 
public class BdMaximo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Proveedores proveedores;
	private List<Contactos> contactosLst;
	
	
	public Proveedores getProveedores() {
		return proveedores;
	}
	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Contactos> getContactosLst() {
		return contactosLst;
	}
	public void setContactosLst(List<Contactos> contactosLst) {
		this.contactosLst = contactosLst;
	} 
 
	
 

}
