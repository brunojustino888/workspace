package cashflowmanagement.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cashflowmanagement.dto.LancamentoDTO;
import cashflowmanagement.enums.LancamentoTipoEnum;
import cashflowmanagement.mapper.LancamentoMapper;
import cashflowmanagement.model.Lancamento;

public class LancamentoDAO implements Serializable {

	/**
	 * Serial verison ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lista de entidades de lançamentos.
	 */
	private List<Lancamento> lancamentoLista;

	/**
	 * Responsavel por realizar a consulta dos lançamentos exibidos em tela
	 * @return List<LancamentoDTO> - lista de lançamentos.
	 */
	@SuppressWarnings("unchecked")
	public List<LancamentoDTO> consultar() {
		this.lancamentoLista = mockList();
		Session session = null;
		try {
			SessionFactory sessFact = HibernateSessionConfiguration.getSessionFactory();
			session = sessFact.getCurrentSession();
			session.beginTransaction();
			this.lancamentoLista = session.createCriteria(Lancamento.class).list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return new LancamentoMapper().mapReturn(lancamentoLista);
	}

	/**
	 * Utilizado para a inclusao de um determinado lançamento.
	 * @param dto - objeto para conversao e inclusao de um determinado lançamento.
	 */
	public void incluir(LancamentoDTO dto) {
		Session session = null;
		try {
			SessionFactory sessFact = HibernateSessionConfiguration.getSessionFactory();
			session = sessFact.getCurrentSession();
			session.beginTransaction();
			session.persist(new LancamentoMapper().mapReturnEntity(dto));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	/**
	 * Exclui um determinado lançamento de acordo com o codigo.
	 * @param codigo - representa a coluna COD da entidade que deverá ser excluida.
	 */
	public void excluir(Integer codigo) {
		for (int i = 0; i < this.lancamentoLista.size(); i++) {
			if (Long.valueOf(codigo) == this.lancamentoLista.get(i).getCod()) {
				this.lancamentoLista.remove(i);
			}
		}
	}

	/**
	 * Utilizado para editar um determinado lançamento selecionado em tela.
	 * @param dto - LancamentoDTO - Objeto à ser editado no database. 
	 */
	public void editar(LancamentoDTO dto) {
		for (int i = 0; i < this.lancamentoLista.size(); i++) {
			if (dto.getCod() == this.lancamentoLista.get(i).getCod()) {
				System.out
						.println("Descrição do Lançamento Selecionado : " + this.lancamentoLista.get(i).getDescricao());
				System.out.println("\nTipo de Lançamento Selecionado : " + this.lancamentoLista.get(i).getTipo());
				System.out.println("\nCodigo do Lançamento Selecionado : " + this.lancamentoLista.get(i).getCod());
			}
		}
	}

	/**
	 * Retorna uma massa de dados ficticios sem a utilizacao de um database
	 * 
	 * @return lancamentoLista - Lista de lancamentos -> List<Lancamento>
	 */
	private List<Lancamento> mockList() {
		this.lancamentoLista = new ArrayList<Lancamento>();
		for (int i = 0; i < 25; i++) {
			Lancamento lancamento = new Lancamento();
			lancamento.setCod(1l + i);
			lancamento.setDescricao("Conta de Luz");
			lancamento.setValor(BigDecimal.valueOf(128.88 + i));
			lancamento.setTipo(LancamentoTipoEnum.DESPESA);
			lancamento.setPago(true);
			lancamento.setDataPagamento(new Date());
			lancamentoLista.add(lancamento);
			lancamento = new Lancamento();
			lancamento.setCod(1l + i);
			lancamento.setDescricao("Conta de Telefone");
			lancamento.setValor(BigDecimal.valueOf(28.88 + i));
			lancamento.setTipo(LancamentoTipoEnum.DESPESA);
			lancamento.setPago(false);
			lancamento.setVencimento(new Date());
			lancamentoLista.add(lancamento);
			lancamento = new Lancamento();
			lancamento.setCod(1l + i);
			lancamento.setDescricao("BitCoin");
			lancamento.setValor(BigDecimal.valueOf(8.88 + i));
			lancamento.setTipo(LancamentoTipoEnum.INVESTIMENTO);
			lancamentoLista.add(lancamento);
			lancamento = new Lancamento();
			lancamento.setCod(1l + i);
			lancamento.setDescricao("Mineracao de LiteCoin");
			lancamento.setValor(BigDecimal.valueOf(8.88 + i));
			lancamento.setTipo(LancamentoTipoEnum.RECEITA);
			lancamento.setDataPagamento(new Date());
			lancamentoLista.add(lancamento);
		}
		return lancamentoLista;
	}
	
}