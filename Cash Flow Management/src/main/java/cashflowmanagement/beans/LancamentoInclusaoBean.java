package cashflowmanagement.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import cashflowmanagement.dao.GetAllData;
import cashflowmanagement.enums.LancamentoTipoEnum;
import cashflowmanagement.model.Cliente;
import cashflowmanagement.model.Lancamento;
 
@Named
@ViewScoped
public class LancamentoInclusaoBean implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private Lancamento lancamento = new Lancamento();
	private boolean depesaPagaSelecionada;
	
	public void cadastrar() {
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!", "Cadastro realizado com sucesso!"));
		System.out.println("Tipo: " + this.lancamento.getTipo());
		System.out.println("Descrição: " + this.lancamento.getDescricao());
		System.out.println("Valor: " + this.lancamento.getValor());
		System.out.println("Data vencimento: " + this.lancamento.getVencimento());
		System.out.println("Conta paga: " + this.lancamento.isPago());
		System.out.println("Data pagamento: " + this.lancamento.getDataPagamento());
		this.lancamento = new Lancamento();
		try {
			new GetAllData();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro não realizado!", "Um problema ocorreu no sistema!"));
			e.printStackTrace();
		}
	}
	
	public boolean isDepesaPagaSelecionada() {
		return this.depesaPagaSelecionada;
	}

	public void setDepesaPagaSelecionada(final boolean depesaPagaSelecionada) {
		this.depesaPagaSelecionada = depesaPagaSelecionada;
	}

	private List<Cliente> listaClientes;

	public LancamentoTipoEnum[] getTiposLancamentos() {
		return LancamentoTipoEnum.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
}