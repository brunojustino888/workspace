package cashflowmanagement.application;

import java.io.Serializable;
import java.util.List;

import cashflowmanagement.dao.LancamentoDAO;
import cashflowmanagement.dto.LancamentoDTO;
import cashflowmanagement.services.LancamentoService;

public class LancamentoServiceImpl implements LancamentoService , Serializable {
 
	private static final long serialVersionUID = 1L;
	LancamentoDAO lancamentoDAO = new LancamentoDAO();
	
	@Override
	public List<LancamentoDTO> consultar() {
		return lancamentoDAO.consultar();
	}

	@Override
	public void excluir(Integer codigo) {
		lancamentoDAO.excluir(codigo);
	}

	@Override
	public void editar(LancamentoDTO dto) {
		lancamentoDAO.editar(dto);
	}

	@Override
	public void incluir(LancamentoDTO dto) {
		lancamentoDAO.incluir(dto);
	}

}
