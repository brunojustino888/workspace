package cashflowmanagement.enums;
public enum LancamentoTipoEnum {

	RECEITA("Receita"),
	INVESTIMENTO("Investimento"),
	DESPESA("Despesa");
	
	private String descricao;
	
	LancamentoTipoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}