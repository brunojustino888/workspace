package cashflowmanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ENDERECO")
public class Endereco implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="COD")
	private Long cod;
	
	@ManyToOne
	private Cliente cliente;
	
	@Column(name="CLIENTE_COD")
	private Long clientCod;
	
	@Column(name="LOGRADOURO")
	private String logradouro;
	
	@Column(name="NUMERO")
	private String numero;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="ENDERECO_PRINCIPAL")
	private boolean isEnderoPrincipal;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="PAIS")
	private String pais;
	
	@Column(name="REFERENCIA")
	private String referencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ULTIMA_ATUALIZACAO")
	private Date atualizacao;
	
	@Column(name="USUARIO_ULTIMA_ATUALIZACAO")
	private String usuarioUltimaAtualizacao;
	
	@Column(name="USUARIO_CRIACAO")
	private String usuarioCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	public Long getCod() {
		return this.cod;
	}
	
	public void setCod(final Long cod) {
		this.cod = cod;
	}
	
	public Long getClientCod() {
		return this.clientCod;
	}

	public void setClientCod(final Long clientCod) {
		this.clientCod = clientCod;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	
	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(final String numero) {
		this.numero = numero;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public void setCep(final String cep) {
		this.cep = cep;
	}
	
	public boolean isEnderoPrincipal() {
		return this.isEnderoPrincipal;
	}
	
	public void setEnderoPrincipal(final boolean isEnderoPrincipal) {
		this.isEnderoPrincipal = isEnderoPrincipal;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setEstado(final String estado) {
		this.estado = estado;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	public void setPais(final String pais) {
		this.pais = pais;
	}
	
	public String getReferencia() {
		return this.referencia;
	}
	
	public void setReferencia(final String referencia) {
		this.referencia = referencia;
	}
	
	public Date getAtualizacao() {
		return this.atualizacao;
	}
	
	public void setAtualizacao(final Date atualizacao) {
		this.atualizacao = atualizacao;
	}
	
	public String getUsuarioUltimaAtualizacao() {
		return this.usuarioUltimaAtualizacao;
	}
	
	public void setUsuarioUltimaAtualizacao(final String usuarioUltimaAtualizacao) {
		this.usuarioUltimaAtualizacao = usuarioUltimaAtualizacao;
	}
	
	public String getUsuarioCriacao() {
		return this.usuarioCriacao;
	}
	
	public void setUsuarioCriacao(final String usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}
	
	public Date getDataCriacao() {
		return this.dataCriacao;
	}
	
	public void setDataCriacao(final Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}

}