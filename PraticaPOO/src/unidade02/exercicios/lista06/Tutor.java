package unidade02.exercicios.lista06;

import java.util.ArrayList;

/**
 * Representa o tutor de um ou mais animais.
 */
public class Tutor {

	private String nome;
	private String telefone;
	private String endereço;
	private ArrayList<Animal> animais = new ArrayList<>();

	/**
	 * Cria um novo tutor com o nome especificado.
	 * @param nome O nome do tutor.
	 */
	public Tutor(String nome) {
		this.nome = nome;
	}

	/**
	 * Cria um novo tutor com os detalhes especificados.
	 * @param nome O nome do tutor.
	 * @param telefone O telefone do tutor.
	 * @param endereço O endereço do tutor.
	 */
	public Tutor(String nome, String telefone, String endereço) {
		this.nome = nome;
		this.endereço = endereço;
		setTelefone(telefone);
	}

	/**
	 * Obtém o endereço do tutor.
	 * @return O endereço do tutor.
	 */
	public String getEndereço() {
		return endereço;
	}

	/**
	 * Define o endereço do tutor.
	 * @param endereço O novo endereço do tutor.
	 */
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	/**
	 * Obtém o telefone do tutor.
	 * @return O telefone do tutor.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Define o telefone do tutor.
	 * @param telefone O novo telefone do tutor.
	 * @throws IllegalArgumentException se o telefone for nulo ou vazio.
	 */
	public void setTelefone(String telefone) {
		if (telefone == null || telefone.isEmpty()) {
			throw new IllegalArgumentException("Telefone é obrigatório");
		}
		this.telefone = telefone;
	}

	/**
	 * Obtém o nome do tutor.
	 * @return O nome do tutor.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do tutor.
	 * @param nome O novo nome do tutor.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém a lista de animais do tutor.
	 * @return A lista de animais.
	 */
	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	/**
	 * Adiciona um animal à lista de animais do tutor.
	 * @param animal O animal a ser adicionado.
	 */
	public void adicionarAnimal(Animal animal) {
		this.animais.add(animal);
	}

	/**
	 * Remove um animal da lista de animais do tutor.
	 * @param animal O animal a ser removido.
	 */
	public void removerAnimal(Animal animal) {
		this.animais.remove(animal);
	}
}
