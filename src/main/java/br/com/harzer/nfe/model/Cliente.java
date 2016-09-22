package br.com.harzer.nfe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.com.harzer.nfe.enuns.TipoDocumento;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	public int idCliente;

	@NotNull
	@Size(min = 3, max = 100)
	@Column(name = "nome_razao_social")
	public String nomeRazaoSocial;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_documento")
	private TipoDocumento TipoDocumento;

	@NotNull
	@Size(min = 14, max = 17)
	@Column(name = "cnpj")
	public String cnpj;

	@NotNull
	@Size(min = 14, max = 17)
	@Column(name = "cpf")
	public String cpf;

	@Column(name = "inscricao_estadual")
	public int inscricaoEstadual;

	@Column(name = "isento_icms")
	public boolean isentoIcms;

	@Column(name = "inscricao_suframa")
	public int inscricaoSuframa;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public TipoDocumento getTipoDocumento() {
		return TipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(int inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public int getInscricaoSuframa() {
		return inscricaoSuframa;
	}

	public void setInscricaoSuframa(int inscricaoSuframa) {
		this.inscricaoSuframa = inscricaoSuframa;
	}

	public boolean isIsentoIcms() {
		return isentoIcms;
	}

	public void setIsentoIcms(boolean isentoIcms) {
		this.isentoIcms = isentoIcms;
	}

}
