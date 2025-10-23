package unidade03.exercicios.lista10;

public enum TipoArea {

	AREA_RURAL("Área Rural"),
	AREA_URBANA("Área Urbana");

	private String denominacao;

	private TipoArea(String denominacao) {
		this.denominacao = denominacao;
	}

	@Override
	public String toString() {
		return denominacao;
	}
}
