package cashflowmanagement.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cashflowmanagement.enums.LancamentoTipoEnum;

@Entity
@Table(name="LANCAMENTO")
public class Lancamento implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="COD")
	private Long cod;
	
	@ManyToOne
	private Cliente cliente;
	
	@Column(name="CLIENTE_COD")
	private Long clientCod;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VALOR")
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO")
	private LancamentoTipoEnum tipo;
	
	@Column(name="PAGO")
	private Boolean pago;
	
	@Temporal(TemporalType.DATE)
	@Column(name="VENCIMENTO")
	private Date vencimento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PAGAMENTO")
	private Date dataPagamento;
	
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
	  
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}
	
	public LancamentoTipoEnum getTipo() {
		return this.tipo;
	}
	
	public void setTipo(final LancamentoTipoEnum tipo) {
		this.tipo = tipo;
	}
	
	public Boolean isPago() {
		return this.pago;
	}
	
	public void setPago(final Boolean pago) {
		this.pago = pago;
	}
	
	public Date getVencimento() {
		return this.vencimento;
	}
	
	public void setVencimento(final Date vencimento) {
		this.vencimento = vencimento;
	}
	
	public Date getDataPagamento() {
		return this.dataPagamento;
	}
	
	public void setDataPagamento(final Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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

	public Long getClientCod() {
		return this.clientCod;
	}

	public void setClientCod(final Long clientCod) {
		this.clientCod = clientCod;
	}
			
}