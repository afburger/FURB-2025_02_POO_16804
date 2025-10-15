package unidade03.exercicios.lista08;

/**
 * Representa um procedimento realizado em um atendimento veterinário.
 */
public class Procedimento {

	private String nome;
	private double custo;
	private String observacoes;

	/**
	 * Cria um novo procedimento com o nome especificado.
	 * @param nome O nome do procedimento.
	 */
	public Procedimento(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém o nome do procedimento.
	 * @return O nome do procedimento.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do procedimento.
	 * @param nome O novo nome do procedimento.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém o custo do procedimento.
	 * @return O custo do procedimento.
	 */
	public double getCusto() {
		return custo;
	}

	/**
	 * Define o custo do procedimento.
	 * @param custo O novo custo do procedimento.
	 */
	public void setCusto(double custo) {
		this.custo = custo;
	}

	/**
	 * Obtém as observações sobre o procedimento.
	 * @return As observações do procedimento.
	 */
	public String getObservacoes() {
		return observacoes;
	}

	/**
	 * Define as observações sobre o procedimento.
	 * @param observacoes As novas observações do procedimento.
	 */
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	/**
	 * Retorna uma representação em string do procedimento.
	 * @return Uma string contendo o nome, custo e observações do procedimento.
	 */
	@Override
	public String toString() {
		return "Procedimento: " + nome + ", Custo: R$" + custo + ", Observações: " + (observacoes != null ? observacoes : "Nenhuma");
	}
}
