package cashflowmanagement.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cashflowmanagement.dto.LancamentoDTO;
import cashflowmanagement.enums.LancamentoTipoEnum;
import cashflowmanagement.model.Lancamento;

public class LancamentoMapper {

	private List<LancamentoDTO> viewDtoList = new ArrayList<LancamentoDTO>(); 
	
	public List<LancamentoDTO> mapReturn(List<Lancamento> lancamentoList){
		for (Lancamento trial :lancamentoList) {
			LancamentoDTO dto = new LancamentoDTO();
			dto.setCod(trial.getCod());
			dto.setValor(trial.getValor());
			if (trial.getTipo() == LancamentoTipoEnum.RECEITA) {
				dto.setDescricao("Valor provido em " + new SimpleDateFormat("dd/MM/yyyy").format(trial.getDataPagamento()) + " de: " + trial.getDescricao());
				dto.setTipo("Receita");
			} else if (trial.getTipo() == LancamentoTipoEnum.INVESTIMENTO) {
				dto.setDescricao("Investimento em "+ new SimpleDateFormat("dd/MM/yyyy").format(trial.getDataPagamento()) + " de: " + trial.getDescricao());
				dto.setTipo("Investimento");
			} else {
				dto.setTipo("Despesa");
				if (trial.isPago()) {
					dto.setDescricao(trial.getDescricao() + " quitada em "
							+ new SimpleDateFormat("dd/MM/yyyy").format(trial.getDataPagamento()));
				} else {
					dto.setDescricao(trial.getDescricao() + " pendente para pagamento com vencimento em "
							+ new SimpleDateFormat("dd/MM/yyyy").format(trial.getVencimento()));
				}
			}
			this.viewDtoList.add(dto);
		}
		return this.viewDtoList;
	}

	public Lancamento mapReturnEntity(LancamentoDTO inclusaoDTO) {
		if(inclusaoDTO!=null) {
			Lancamento entity = new Lancamento();
			entity.setAtualizacao(new Date());
//			entity.se
			return entity;
		}
		return null;		
	}
	
}