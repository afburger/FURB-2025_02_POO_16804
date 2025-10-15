package unidade03.exercicios.lista09;

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

	public AtendimentoRetorno(LocalDate data, String descricao, Animal animal, Veterinario veterinario, Atendimento atendimentoAnterior) {
		super(data, descricao, animal, veterinario);
		this.atendimentoAnterior = atendimentoAnterior;
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

	@Override
	public double calcularValor() {
		return VALOR_BASE / 2;
	}

	@Override
	public double getValorTotal() {
		return calcularValor();
	}

	@Override
	public String getDescricaoPagamento() {
		return "O valor da consulta de retorno é: " + getValorTotal();
	}
}
