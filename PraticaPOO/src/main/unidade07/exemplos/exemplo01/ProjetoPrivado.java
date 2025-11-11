package unidade07.exemplos.exemplo01;

public class ProjetoPrivado extends Projeto {

	private TipoArea tipoArea;
	private double metragem;

	public TipoArea getTipoArea() {
		return tipoArea;
	}

	public void setTipoArea(TipoArea tipoArea) {
		this.tipoArea = tipoArea;
	}

	public double getMetragem() {
		return metragem;
	}

	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}

	@Override
	public TipoProjeto getTipoProjeto() {
		return TipoProjeto.PROJETO_PRIVADO;
	}

	@Override
	public String getResumo() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTipoProjeto()).append(" Número: ").append(getNumero()).append("\n")
				.append(" Descrição: ").append(getDescricao()).append("\n")
				.append(" Localizado na :").append(getTipoArea()).append("\n")
				.append("Com uma área total de ").append(getMetragem()).append(" m²");
		return sb.toString();
	}
}
