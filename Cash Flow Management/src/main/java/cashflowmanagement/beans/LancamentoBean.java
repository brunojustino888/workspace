package cashflowmanagement.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import cashflowmanagement.application.LancamentoServiceImpl;
import cashflowmanagement.dto.LancamentoDTO;
import cashflowmanagement.enums.LancamentoTipoEnum;
import cashflowmanagement.services.LancamentoService;

@Named
@ViewScoped
public class LancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<LancamentoDTO> lancamentoLista = new ArrayList<LancamentoDTO>();
	private LancamentoService service;
	private BigDecimal totalGeral = BigDecimal.ZERO;
	private BigDecimal totalPorNcm;

	public LancamentoBean() {
		try {
			this.service = new LancamentoServiceImpl();
			this.lancamentoLista = this.service.consultar();
			System.out.println("Size da lista lancamentoLista: " + this.lancamentoLista.size());
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Um erro ocorreu!", "Por favor contate o administrador do sistema."));
			e.printStackTrace();
		}

	}

	public void excluir(Integer codigo) {
		for (int i = 0; i < this.lancamentoLista.size(); i++) {
			if (Long.valueOf(codigo) == this.lancamentoLista.get(i).getCod()) {
				this.service.excluir(codigo);
				this.lancamentoLista.remove(i);
			}
		}
	}

	public void detalhes(Integer codigo) {
		LancamentoDTO dto = new LancamentoDTO();
		dto.setCod(Long.valueOf(codigo));
		this.service.editar(dto);
	}

	public void editar(Integer codigo) {
		LancamentoDTO dto = new LancamentoDTO();
		dto.setCod(Long.valueOf(codigo));
		this.service.editar(dto);
	}

	public BigDecimal summary() {
		totalGeral = BigDecimal.ZERO;
		for (LancamentoDTO trial : this.lancamentoLista) {
			if (trial.getTipo().equals(LancamentoTipoEnum.RECEITA.getDescricao())) {
				totalGeral = totalGeral.add(trial.getValor());
			} else {
				totalGeral = totalGeral.subtract(trial.getValor());
			}
		}
		return totalGeral;
	}
	
	public void resume(LancamentoDTO item) {
		totalPorNcm = BigDecimal.ZERO;
        for (LancamentoDTO trial : lancamentoLista) {
            if (item.getTipo().equals(trial.getTipo())) {
                totalPorNcm = totalPorNcm.add(trial.getValor());
            }
        }
	}
	
	public List<LancamentoDTO> getLancamentoLista() {
		return lancamentoLista;
	}

	public void setLancamentoLista(final List<LancamentoDTO> lancamentoLista) {
		this.lancamentoLista = lancamentoLista;
	}

	public BigDecimal getTotalGeral() {
		return this.totalGeral;
	}

	public void setTotalGeral(final BigDecimal totalGeral) {
		this.totalGeral = totalGeral;
	}

	public BigDecimal getTotalPorNcm() {
		return this.totalPorNcm;
	}

	public void setTotalPorNcm(final BigDecimal totalPorNcm) {
		this.totalPorNcm = totalPorNcm;
	}
	
}