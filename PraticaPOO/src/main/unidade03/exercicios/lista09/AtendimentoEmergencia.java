package unidade03.exercicios.lista09;

import java.time.LocalDate;

/**
 *
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class AtendimentoEmergencia extends Atendimento {

	private int nivelUrgencia;

	/**
	 * Cria um novo atendimento com os detalhes especificados.
	 *
	 * @param data        A data do atendimento.
	 * @param descricao   A descrição do atendimento.
	 * @param animal      O animal que está sendo atendido.
	 * @param veterinario O veterinário que realizou o atendimento.
	 */
	public AtendimentoEmergencia(LocalDate data, String descricao, Animal animal, Veterinario veterinario) {
		super(data, descricao, animal, veterinario);
	}

	public AtendimentoEmergencia(LocalDate data, String descricao, Animal animal, Veterinario veterinario, int nivelUrgencia) {
		super(data, descricao, animal, veterinario);
		this.nivelUrgencia = nivelUrgencia;
	}

	public void setNivelUrgencia(int nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}

	public int getNivelUrgencia() {
		return nivelUrgencia;
	}

	@Override
	public void registrar() {
		System.out.println("Consulta de emergência registrada para o " + getAnimal().getNome() + " (urgência: " + nivelUrgencia + ") com o veterinário " + getVeterinario().getNome());
	}

	@Override
	public double calcularValor() {
		return VALOR_BASE + 65.0;
	}

	@Override
	public double getValorTotal() {
		return calcularValor();
	}

	@Override
	public String getDescricaoPagamento() {
		return "A consulta de emrgência terá um custo de: " + getValorTotal();
	}
}
