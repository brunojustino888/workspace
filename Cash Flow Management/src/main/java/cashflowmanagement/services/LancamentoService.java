package cashflowmanagement.services;

import java.util.List;

import cashflowmanagement.dto.LancamentoDTO;

public interface LancamentoService {

	List<LancamentoDTO> consultar();
	
	void excluir(Integer codigo);
	
	void editar(LancamentoDTO dto);
	
	void incluir(LancamentoDTO dto);
	
}