package br.com.harzer.nfe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EMITENTE")
public class Emitente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emitente")
	private int idEmitente;

	@NotNull
	@Size(min = 3, max = 100)
	@Column(name = "nome_razao_social", nullable = false)
	private String nomeRazaoSocial;

	@Size(min = 3, max = 80)
	@Column(name = "nome_fantasia", nullable = false)
	private String nomeFantasia;

	@NotNull
	@Size(min = 14, max = 17)
	@Column(name = "cnpj", unique = true, nullable = false)
	private String cnpj;

	@NotNull
	@Column(name = "inscricao_estadual")
	private int inscricaoEstadual;

	@Column(name = "inscricao_municipal")
	private int inscricaoMunicipal;

	@Column(name = "cnae_fiscal")
	private int cnaeFiscal;

	@NotNull
	@Size(min = 3, max = 80)
	@Column(name = "regime_tributario")
	private String regimeTributario;

	@Column(name = "logotipo")
	private int logotipo;

	public int getIdEmitente() {
		return idEmitente;
	}

	public void setIdEmitente(int idEmitente) {
		this.idEmitente = idEmitente;
	}

	public String getNomeRazaoSocial() {
		return this.nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getCnaeFiscal() {
		return cnaeFiscal;
	}

	public void setCnaeFiscal(int cnaeFiscal) {
		this.cnaeFiscal = cnaeFiscal;
	}

	public int getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(int inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public int getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(int inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getRegimeTributario() {
		return regimeTributario;
	}

	public void setRegimeTributario(String regimeTributario) {
		this.regimeTributario = regimeTributario;
	}

	public int getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(int logotipo) {
		this.logotipo = logotipo;
	}

	@Override
	public String toString() {
		return "Emitente [identificador=" + idEmitente + ", nomeFantasia=" + nomeFantasia + ", nomeRazaoSocial="
				+ nomeRazaoSocial + ", CNPJ=" + cnpj + ", inscricaoEstadual=" + inscricaoEstadual
				+ ", inscricaoMunicipal=" + inscricaoMunicipal + ", regimeTributario=" + regimeTributario
				+ ", logotipo=" + logotipo + "]";
	}

}
