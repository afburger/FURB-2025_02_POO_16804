package unidade03.exercicios.lista08;

import java.util.ArrayList;

/**
 * Representa um animal em uma clínica veterinária.
 * Cada animal tem um tutor e uma lista de atendimentos.
 */
public class Animal {

	private String nome;
	private String especie;
	private int idade;
	private String historico;
	private Tutor tutor;
	private ArrayList<Atendimento> atendimentos = new ArrayList<>();

	/**
	 * Cria um novo animal com o nome e tutor especificados.
	 * @param nome O nome do animal.
	 * @param tutor O tutor do animal.
	 */
	public Animal(String nome, Tutor tutor) {
		this.nome = nome;
		this.tutor = tutor;
	}

	/**
	 * Cria um novo animal com os detalhes especificados.
	 * @param nome O nome do animal.
	 * @param especie A espécie do animal.
	 * @param idade A idade do animal.
	 * @param historico O histórico médico do animal.
	 */
	public Animal(String nome, String especie, int idade, String historico) {
		this.nome = nome;
		this.especie = especie;
		this.historico = historico;
		setIdade(idade);
	}

	/**
	 * Obtém o nome do animal.
	 * @return O nome do animal.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do animal.
	 * @param nome O novo nome do animal.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém a espécie do animal.
	 * @return A espécie do animal.
	 */
	public String getEspecie() {
		return especie;
	}

	/**
	 * Define a espécie do animal.
	 * @param especie A nova espécie do animal.
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	/**
	 * Obtém a idade do animal.
	 * @return A idade do animal.
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * Define a idade do animal.
	 * @param idade A nova idade do animal.
	 * @throws IllegalArgumentException se a idade for negativa.
	 */
	public void setIdade(int idade) {
		if (idade < 0) {
			throw new IllegalArgumentException("Idade não pode ser negativa");
		}
		this.idade = idade;
	}

	/**
	 * Obtém o histórico médico do animal.
	 * @return O histórico médico do animal.
	 */
	public String getHistorico() {
		return historico;
	}

	/**
	 * Define o histórico médico do animal.
	 * @param historico O novo histórico médico do animal.
	 */
	public void setHistorico(String historico) {
		this.historico = historico;
	}

	/**
	 * Adiciona uma nova entrada ao histórico médico do animal.
	 * Se já houver um histórico, a nova entrada será concatenada com uma vírgula e um espaço.
	 * @param historico A nova entrada do histórico a ser adicionada.
	 */
	public void adicionarHistorico(String historico) {
		if (this.historico == null || this.historico.isEmpty()) {
			this.historico = historico;
		} else {
			this.historico += ", " + historico;
		}
	}

	/**
	 * Obtém o tutor do animal.
	 * @return O tutor do animal.
	 */
	public Tutor getTutor() {
		return tutor;
	}

	/**
	 * Define o tutor do animal.
	 * @param tutor O novo tutor do animal.
	 */
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	/**
	 * Obtém a lista de atendimentos do animal.
	 * @return A lista de atendimentos.
	 */
	public ArrayList<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	/**
	 * Adiciona um atendimento à lista de atendimentos do animal.
	 * @param atendimento O atendimento a ser adicionado.
	 */
	public void adicionarAtendimento(Atendimento atendimento) {
		this.atendimentos.add(atendimento);
	}

	/**
	 * Remove um atendimento da lista de atendimentos do animal.
	 * @param atendimento O atendimento a ser removido.
	 */
	public void removerAtendimento(Atendimento atendimento) {
		this.atendimentos.remove(atendimento);
	}
}
