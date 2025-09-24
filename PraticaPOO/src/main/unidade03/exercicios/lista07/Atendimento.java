package unidade03.exercicios.lista07;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa um atendimento realizado em um animal.
 */
public class Atendimento {

	private LocalDate data;
	private String descricao;
	private Veterinario veterinario;
	private Animal animal;
	private ArrayList<Procedimento> procedimentos;

	/**
	 * Cria um novo atendimento com os detalhes especificados.
	 * @param data A data do atendimento.
	 * @param descricao A descrição do atendimento.
	 * @param animal O animal que está sendo atendido.
	 * @param veterinario O veterinário que realizou o atendimento.
	 */
	public Atendimento(LocalDate data, String descricao, Animal animal, Veterinario veterinario) {
		this.data = data;
		this.descricao = descricao;
		this.animal = animal;
		this.veterinario = veterinario;
		this.procedimentos = new ArrayList<>();
	}

	/**
	 * Obtém a data do atendimento.
	 * @return A data do atendimento.
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * Define a data do atendimento.
	 * @param data A nova data do atendimento.
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}

	/**
	 * Obtém a descrição do atendimento.
	 * @return A descrição do atendimento.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Define a descrição do atendimento.
	 * @param descricao A nova descrição do atendimento.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Obtém o veterinário que realizou o atendimento.
	 * @return O veterinário do atendimento.
	 */
	public Veterinario getVeterinario() {
		return veterinario;
	}

	/**
	 * Define o veterinário que realizou o atendimento.
	 * @param veterinario O novo veterinário do atendimento.
	 */
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	/**
	 * Obtém a lista de procedimentos realizados no atendimento.
	 * @return A lista de procedimentos.
	 */
	public ArrayList<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	/**
	 * Adiciona um procedimento à lista de procedimentos do atendimento.
	 * @param procedimento O procedimento a ser adicionado.
	 */
	public void adicionarProcedimento(Procedimento procedimento) {
		procedimentos.add(procedimento);
	}

	/**
	 * Remove um procedimento da lista de procedimentos do atendimento.
	 * @param procedimento O procedimento a ser removido.
	 */
	public void removerProcedimento(Procedimento procedimento) {
		procedimentos.remove(procedimento);
	}

	/**
	 * Obtém o animal atendido.
	 * @return O animal do atendimento.
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * Define o animal que está sendo atendido.
	 * @param animal O novo animal do atendimento.
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	/**
	 * Retorna uma string com os dados completos do atendimento.
	 * Inclui data, descrição, informações do animal, dados do veterinário e a lista de procedimentos.
	 * @return Uma string formatada com todos os dados do atendimento.
	 */
	public String exibirDados() {
		StringBuilder dados = new StringBuilder();
		dados.append("Data: ").append(data).append("\n");
		dados.append("Descrição: ").append(descricao).append("\n");
		dados.append("Animal: ").append(animal.getNome()).append("\n");
		dados.append("Veterinário: ").append(veterinario.retornaDados()).append("\n");
		dados.append("Procedimentos:\n");

		if (procedimentos != null && !procedimentos.isEmpty()) {
			for (Procedimento procedimento : procedimentos) {
				dados.append("- ").append(procedimento.toString()).append("\n");
			}
		} else {
			dados.append("- Nenhum procedimento realizado.\n");
		}

		return dados.toString();
	}

	public void registrar() {
		System.out.println("Consulta registrada para o " + animal.getNome() + " com o veterinário " + veterinario.getNome());
	}
}
