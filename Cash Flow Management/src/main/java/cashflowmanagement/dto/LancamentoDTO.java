package cashflowmanagement.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LancamentoDTO implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private Long cod;
	private String descricao;
	private BigDecimal valor;
	private String tipo;
	private String situacao;
	
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
 
	
}