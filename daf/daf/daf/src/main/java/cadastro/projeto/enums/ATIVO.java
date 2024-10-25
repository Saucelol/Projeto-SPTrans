package cadastro.projeto.enums;

public enum ATIVO {
	
	ATIVADO("ATIVADO"),
	DESATIVADO("DESATIVADO");

	@SuppressWarnings("unused")
	private String ATIVO;
	
	private ATIVO(String ATIVO) {
			this.ATIVO = ATIVO;
	}
}
