package readexceljpa.readexcel2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
//@Entity
//@Table(name = "banco")
public class Banco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "nu_id_banco")
	private Long id;
	
	@Column(name = "tx_nom_banco")
	private String txNomBanco;
	@Column(name = "nu_aba")
	private String nuAba;
	@Column(name = "nu_swift")
	private String nuSwift;
	
//	CUENTA BANCARIA
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "nu_id_banco")
	private Collection<Cuenta> ctaBancariaList = new ArrayList<Cuenta>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxNomBanco() {
		return txNomBanco;
	}

	public void setTxNomBanco(String txNomBanco) {
		this.txNomBanco = txNomBanco;
	}

	public String getNuAba() {
		return nuAba;
	}

	public void setNuAba(String nuAba) {
		this.nuAba = nuAba;
	}

	public String getNuSwift() {
		return nuSwift;
	}

	public void setNuSwift(String nuSwift) {
		this.nuSwift = nuSwift;
	}

	public Collection<Cuenta> getCtaBancariaList() {
		return ctaBancariaList;
	}

	public void setCtaBancariaList(Collection<Cuenta> ctaBancariaList) {
		this.ctaBancariaList = ctaBancariaList;
	}
}
