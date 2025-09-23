package unidade03.exercicios.lista07;

import java.time.LocalDate;

/**
 *
 * @author André Felipe Bürger (andre.burger@publicatecnologia.com.br)
 *
 */
public class AtendimentoRetorno extends Atendimento {

	private Atendimento atendimentoAnterior;

	/**
	 * Cria um novo atendimento com os detalhes especificados.
	 *
	 * @param data        A data do atendimento.
	 * @param descricao   A descrição do atendimento.
	 * @param animal      O animal que está sendo atendido.
	 * @param veterinario O veterinário que realizou o atendimento.
	 */
	public AtendimentoRetorno(LocalDate data, String descricao, Animal animal, Veterinario veterinario) {
		super(data, descricao, animal, veterinario);
	}

	public void setAtendimentoAnterior(Atendimento atendimentoAnterior) {
		this.atendimentoAnterior = atendimentoAnterior;
	}

	public Atendimento getAtendimentoAnterior() {
		return atendimentoAnterior;
	}

	@Override
	public void registrar() {
		System.out.println("Consulta de retorno registrada para " + getAnimal().getNome() + ", referente à consulta anterior em " + atendimentoAnterior.getData());
	}
}
