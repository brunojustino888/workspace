package cashflowmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="cliente")
public class Cliente implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="COD")
	private Long cod;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecoLista;	
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Lancamento> lancamentoLista;	
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DOCUMENTO")
	private String documento;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="RAMO_ATIVIDADE")
	private String ramoAtividade;
	
	@Column(name="ULTIMA_ATUALIZACAO")
	private Date atualizacao;
	
	@Column(name="USUARIO_ULTIMA_ATUALIZACAO")
	private String usuarioUltimaAtualizacao;
	
	@Column(name="USUARIO_CRIACAO")
	private String usuarioCriacao;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(final String nome) {
		this.nome = nome;
	}

	public Long getCod() {
		return this.cod;
	}

	public void setCod(final Long cod) {
		this.cod = cod;
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

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(final String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getRamoAtividade() {
		return this.ramoAtividade;
	}

	public void setRamoAtividade(final String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public List<Lancamento> getLancamentoLista() {
		return this.lancamentoLista;
	}

	public void setLancamentoLista(final List<Lancamento> lancamentoLista) {
		this.lancamentoLista = lancamentoLista;
	}

	public List<Endereco> getEnderecoLista() {
		return this.enderecoLista;
	}

	public void setEnderecoLista(final List<Endereco> enderecoLista) {
		this.enderecoLista = enderecoLista;
	}
 
	
}