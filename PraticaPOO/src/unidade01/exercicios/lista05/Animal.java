package unidade01.exercicios.lista05;

/**
 * Representa um animal em uma clínica veterinária.
 */
public class Animal {

	private String nome;
	private String especie;
	private int idade;
	private String historico;

	/**
	 * Cria um novo animal com o nome especificado.
	 * @param nome O nome do animal.
	 */
	public Animal(String nome) {
		this.nome = nome;
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
}
