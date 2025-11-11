package unidade07.exemplos.exemplo01;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa um Projeto público.
 */
public class ProjetoPublico extends Projeto {

	private LocalDate dataInicio;
	private LocalDate dataFim;

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	/**
	 * Calcula a duração do projeto com base na sua data de início e fim.
	 * @return a duração do projeto em dias.
	 */
	public long getDuracao() {
		if (dataInicio != null && dataFim != null) {
			return ChronoUnit.DAYS.between(dataInicio, dataFim);
		}
		return 0;
	}

	@Override
	public TipoProjeto getTipoProjeto() {
		return TipoProjeto.PROJETO_PUBLICO;
	}

	@Override
	public String getResumo() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTipoProjeto()).append(" Número: ").append(getNumero()).append("\n")
				.append("Descrição: ").append(getDescricao()).append("\n")
				.append(" Com duração de :").append(getDuracao()).append(" dias (")
				.append(SistemaUtils.formatarData(dataInicio)).append(" - ").append(SistemaUtils.formatarData(dataFim)).append(")");
		return sb.toString();
	}
}
