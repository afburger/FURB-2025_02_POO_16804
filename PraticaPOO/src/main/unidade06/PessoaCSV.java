package unidade06;

/**
 *
 * @author André Felipe Bürger (afburger@furb.com.br)
 *
 */
public class PessoaCSV {

	private int id;
	private String nome;
	private int idade;

	public PessoaCSV(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return id + "," + nome + "," + idade;
	}
}
