package unidade03.exercicios.lista10;

public enum TipoProjeto {

	PROJETO_PUBLICO("Projeto público"),
	PROJETO_PRIVADO("Projeto privado");

	private String denominacao;

	private TipoProjeto(String denominacao) {
		this.denominacao = denominacao;
	}

	@Override
	public String toString() {
		return denominacao;
	}
}
