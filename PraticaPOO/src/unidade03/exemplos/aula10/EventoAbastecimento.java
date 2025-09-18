package unidade03.exemplos.aula10;

import java.time.LocalDate;

public class EventoAbastecimento extends Evento {

	public EventoAbastecimento(Veiculo veiculo) {
		super(veiculo);
		setDescricao("Abastecimento");
	}

	private LocalDate data;
	private long quilomtragemRodada;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public long getQuilomtragemRodada() {
		return quilomtragemRodada;
	}

	public void setQuilomtragemRodada(long quilomtragemRodada) {
		this.quilomtragemRodada = quilomtragemRodada;
	}

	@Override
	public String retornaDados() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.retornaDados())
				.append(" - ")
				.append("KM Rodada: ")
				.append(getQuilomtragemRodada());
		return sb.toString();
	}
}

